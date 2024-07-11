Imports MySql.Data.MySqlClient
Public Class Form6
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
        sentencia = "insert into Cliente values('" + txt_id.Text + "','" + txt_nombre.Text + "','" + txt_apellido.Text + "','" + txt_edad.Text + "')"
        mensaje = "Datos Insertados Correctamente"
        ejecutarsql(sentencia, mensaje)
        Try
            Dim da As New MySqlDataAdapter("select * from Cliente", con)
            Dim ds As New DataSet
            da.Fill(ds)
            Me.DataGridView1.DataSource = ds.Tables(0)
        Catch ex As Exception
            MsgBox(ex.Message)
        End Try
    End Sub

    Private Sub btn_actualizar_Click(sender As Object, e As EventArgs) Handles btn_actualizar.Click
        sentencia = "update Cliente set Nombre = '" + txt_nombre.Text + "', Apellido = '" + txt_apellido.Text + "', Edad = '" + txt_edad.Text + "'where id_cliente = '" + txt_id.Text + "'"
        mensaje = "Datos Actualizados Correctamente"
        ejecutarsql(sentencia, mensaje)
        Try
            Dim da As New MySqlDataAdapter("select * from Cliente", con)
            Dim ds As New DataSet
            da.Fill(ds)
            Me.DataGridView1.DataSource = ds.Tables(0)
        Catch ex As Exception
            MsgBox(ex.Message)
        End Try
    End Sub

    Private Sub btn_eliminar_Click(sender As Object, e As EventArgs) Handles btn_eliminar.Click
        sentencia = "delete from Cliente where id_cliente = '" + txt_id.Text + "'"
        mensaje = "Datos Eliminados Correctamente"
        ejecutarsql(sentencia, mensaje)
        Try
            Dim da As New MySqlDataAdapter("select * from Cliente", con)
            Dim ds As New DataSet
            da.Fill(ds)
            Me.DataGridView1.DataSource = ds.Tables(0)
        Catch ex As Exception
            MsgBox(ex.Message)
        End Try
    End Sub

    Private Sub btn_mostrar_Click(sender As Object, e As EventArgs) Handles btn_mostrar.Click
        Try
            Dim da As New MySqlDataAdapter("select * from Cliente", con)
            Dim ds As New DataSet
            da.Fill(ds)
            Me.DataGridView1.DataSource = ds.Tables(0)
        Catch ex As Exception
            MsgBox(ex.Message)
        End Try
    End Sub

    Private Sub btn_limpiar_Click(sender As Object, e As EventArgs) Handles btn_limpiar.Click
        txt_id.Text = ""
        txt_nombre.Text = ""
        txt_apellido.Text = ""
        txt_edad.Text = ""
    End Sub

    Private Sub btn_menu_Click(sender As Object, e As EventArgs) Handles btn_menu.Click
        Me.Close()
        Form2.Show()
    End Sub
End Class