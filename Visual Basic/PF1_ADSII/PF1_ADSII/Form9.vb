Imports MySql.Data.MySqlClient
Public Class Form9

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
        sentencia = "insert into Login values('" + txt_nombre.Text + "','" + txt_apellido.Text + "','" + txt_usuario.Text + "','" + txt_contra.Text + "','" + cmb_rol.Text + "')"
        mensaje = "Datos Registrados Correctamente"
        ejecutarsql(sentencia, mensaje)
    End Sub

    Private Sub btn_regresar_Click(sender As Object, e As EventArgs) Handles btn_regresar.Click
        Me.Close()
        Form1.Show()
    End Sub
End Class