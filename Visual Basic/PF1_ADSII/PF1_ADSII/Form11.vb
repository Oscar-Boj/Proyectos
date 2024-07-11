Imports MySql.Data.MySqlClient
Public Class Form11
    Private con As New MySqlConnection("server=localhost;database=IES_PF1;user=root;password=compu")
    Dim mensaje, sentencia As String

    Sub ejecutarsql(ByVal sql As String, ByVal msg As String)
        Try
            Dim cmd As New MySqlCommand(sql, con)
            con.Open()
            cmd.ExecuteNonQuery()
            con.Close()
            MsgBox(msg)
        Catch ex As Exception
            MsgBox(ex.Message)
        End Try
    End Sub

    Private Sub btn_insertar_Click(sender As Object, e As EventArgs) Handles btn_insertar.Click
        sentencia = "insert into Factura values('" + txt_idfac.Text + "','" + txt_idcli.Text + "','" + txt_nombre.Text + "','" + txt_monto.Text + "','" + txt_iva.Text + "')"
        mensaje = "Datos Insertados Correctamente"
        ejecutarsql(sentencia, mensaje)
        Try
            Dim da As New MySqlDataAdapter("select * from Factura", con)
            Dim ds As New DataSet
            da.Fill(ds)
            Me.DataGridView1.DataSource = ds.Tables(0)
        Catch ex As Exception
            MsgBox(ex.Message)
        End Try
    End Sub

    Private Sub btn_calcular_Click(sender As Object, e As EventArgs) Handles btn_calcular.Click
        Dim iva As Double
        Dim monto = txt_monto.Text
        iva = monto * 1.12
        txt_iva.Text = iva
    End Sub

    Private Sub btn_actualizar_Click(sender As Object, e As EventArgs) Handles btn_actualizar.Click
        sentencia = "update Factura set id_cliente = '" + txt_idcli.Text + "', Nombre = '" + txt_nombre.Text + "', Monto = '" + txt_monto.Text + "', IVA = '" + txt_iva.Text + "'where id_factura = '" + txt_idfac.Text + "'"
        mensaje = "Datos Actualizados Correctamente"
        ejecutarsql(sentencia, mensaje)
        Try
            Dim da As New MySqlDataAdapter("select * from Factura", con)
            Dim ds As New DataSet
            da.Fill(ds)
            Me.DataGridView1.DataSource = ds.Tables(0)
        Catch ex As Exception
            MsgBox(ex.Message)
        End Try
    End Sub

    Private Sub btn_eliminar_Click(sender As Object, e As EventArgs) Handles btn_eliminar.Click
        sentencia = "delete from Factura where id_factura = '" + txt_idfac.Text + "'"
        mensaje = "Datos Eliminados Correctamente"
        ejecutarsql(sentencia, mensaje)
        Try
            Dim da As New MySqlDataAdapter("select * from Factura", con)
            Dim ds As New DataSet
            da.Fill(ds)
            Me.DataGridView1.DataSource = ds.Tables(0)
        Catch ex As Exception
            MsgBox(ex.Message)
        End Try
    End Sub

    Private Sub btn_mostrar_Click(sender As Object, e As EventArgs) Handles btn_mostrar.Click
        Try
            Dim da As New MySqlDataAdapter("select * from Factura", con)
            Dim ds As New DataSet
            da.Fill(ds)
            Me.DataGridView1.DataSource = ds.Tables(0)
        Catch ex As Exception
            MsgBox(ex.Message)
        End Try
    End Sub

    Private Sub btn_limpiar_Click(sender As Object, e As EventArgs) Handles btn_limpiar.Click
        txt_idfac.Text = ""
        txt_idcli.Text = ""
        txt_nombre.Text = ""
        txt_monto.Text = ""
        txt_iva.Text = ""
    End Sub
    Private Sub btn_menu_Click(sender As Object, e As EventArgs) Handles btn_menu.Click
        Me.Close()
        Form3.Show()
    End Sub
End Class