Imports MySql.Data.MySqlClient

Public Class ClientesR
    Private con As New MySqlConnection("server=localhost;database=TemarioF2;user=root;password=compu123")
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

    Private Sub ClientesR_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        Try
            Dim da As New MySqlDataAdapter("select * from clientes", con)
            Dim ds As New DataSet
            da.Fill(ds)
            Me.DataGridView1.DataSource = ds.Tables(0)
        Catch ex As Exception
            MsgBox(ex.Message)
        End Try
    End Sub

    Private Sub btn_crearC_Click(sender As Object, e As EventArgs) Handles btn_crearC.Click
        If txt_nombreC.Text <> "" And txt_telC.Text <> "" And txt_correoC.Text <> "" Then
            sentencia = "INSERT INTO clientes (nombre, telefono, correo) VALUES ('" & txt_nombreC.Text & "', '" & txt_telC.Text & "', '" & txt_correoC.Text & "')"
            mensaje = "Cliente agregado"
            ejecutarsql(sentencia, mensaje)
            Try
                Dim da As New MySqlDataAdapter("select * from clientes", con)
                Dim ds As New DataSet
                da.Fill(ds)
                Me.DataGridView1.DataSource = ds.Tables(0)
                txt_nombreC.Text = ""
                txt_telC.Text = ""
                txt_correoC.Text = ""
            Catch ex As Exception
                MsgBox(ex.Message)
            End Try
        Else
            MsgBox("Llene los campos necesarios")
        End If
    End Sub

    Private Sub btn_borrarC_Click(sender As Object, e As EventArgs) Handles btn_borrarC.Click
        If txt_idcliente.Text <> "" Then
            sentencia = "delete from clientes where id_cliente = '" + txt_idcliente.Text + "'"
            mensaje = "Cliente eliminado"
            ejecutarsql(sentencia, mensaje)
            Try
                Dim da As New MySqlDataAdapter("select * from clientes", con)
                Dim ds As New DataSet
                da.Fill(ds)
                Me.DataGridView1.DataSource = ds.Tables(0)
            Catch ex As Exception
                MsgBox(ex.Message)
            End Try
        Else
            MsgBox("Coloque un ID")
        End If
    End Sub

    Private Sub btn_modificarC_Click(sender As Object, e As EventArgs) Handles btn_modificarC.Click
        If txt_idcliente.Text <> "" Then
            sentencia = "update clientes set nombre = '" + txt_nombreC.Text + "', telefono = '" + txt_telC.Text + "', correo = '" + txt_correoC.Text + "' where id_cliente = '" + txt_idcliente.Text + "'"
            mensaje = "Cliente Modificado"
            ejecutarsql(sentencia, mensaje)
            Try
                Dim da As New MySqlDataAdapter("select * from clientes", con)
                Dim ds As New DataSet
                da.Fill(ds)
                Me.DataGridView1.DataSource = ds.Tables(0)
            Catch ex As Exception
                MsgBox(ex.Message)
            End Try
        Else
            MsgBox("Coloque un ID")
        End If
    End Sub

    Private Sub btn_menuT_Click(sender As Object, e As EventArgs) Handles btn_menuT.Click
        Me.Hide()
        menuR.Show()
    End Sub
End Class