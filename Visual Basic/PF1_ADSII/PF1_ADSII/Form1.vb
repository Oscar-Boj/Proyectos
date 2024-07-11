Imports MySql.Data.MySqlClient
Public Class Form1
    Private con As New MySqlConnection("server=localhost;database=IES_PF1;user=root;password=compu")
    Private Sub btn_iniciar_Click(sender As Object, e As EventArgs) Handles btn_iniciar.Click
        Try
            If con.State = ConnectionState.Closed Then
                con.Open()
            End If

            Dim query As String = String.Empty
            Dim command As MySqlCommand
            Dim tabla As MySqlDataReader
            Dim can As Integer = 0

            query = "select * from Login where Usuario = '" + txt_usuario.Text + "' and contraseña = '" + txt_contra.Text + "'"
            command = New MySqlCommand(query, con)
            tabla = command.ExecuteReader
            While tabla.Read
                can += 1
            End While
            If txt_contra.Text = txt_confirmacion.Text Then
                If can = 1 Then
                    If txt_rol.Text = "Administrador" Then
                        MsgBox("Usuario y contraseña correcta")
                        Me.Hide()
                        Form2.Show()
                        txt_usuario.Text = ""
                        txt_contra.Text = ""
                        txt_rol.Text = ""
                        txt_confirmacion.Text = ""
                    ElseIf txt_rol.Text = "Empleado" Then
                        MsgBox("Usuario y contraseña correcta")
                        Me.Hide()
                        Form3.Show()
                        txt_usuario.Text = ""
                        txt_contra.Text = ""
                        txt_rol.Text = ""
                        txt_confirmacion.Text = ""
                    ElseIf txt_rol.Text = "Cliente" Then
                        MsgBox("Usuario y contraseña correcta")
                        Me.Hide()
                        Form4.Show()
                        txt_usuario.Text = ""
                        txt_contra.Text = ""
                        txt_rol.Text = ""
                        txt_confirmacion.Text = ""
                    End If
                ElseIf can > 1 Then
                    MsgBox("ERROR: Hay datos duplicados")
                ElseIf txt_usuario.Text = "" Or txt_contra.Text = "" Then
                    MsgBox("Los campos no pueden estar vacios")
                Else
                    MsgBox("ERROR: Usuario y/o contraseña no validos")
                End If
            Else
                MsgBox("Las constraseñas no coinciden")
            End If
            con.Close()
        Catch ex As Exception
            MsgBox(ex.Message)
        Finally
            If con.State = ConnectionState.Open Then
                con.Close()
            End If
        End Try

    End Sub

    Private Sub btn_registro_Click(sender As Object, e As EventArgs) Handles btn_registro.Click
        Me.Hide()
        Form9.Show()
        txt_usuario.Text = ""
        txt_contra.Text = ""
        txt_rol.Text = ""
        txt_confirmacion.Text = ""
    End Sub
End Class