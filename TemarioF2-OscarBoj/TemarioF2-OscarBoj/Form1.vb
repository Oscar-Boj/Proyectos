Imports MySql.Data.MySqlClient

Public Class Form1
    Private con As New MySqlConnection("server=localhost;database=TemarioF2;user=root;password=compu123")
    Public id_usuario_sesion As Integer

    Private Sub btn_iniciar_Click(sender As Object, e As EventArgs) Handles btn_iniciar.Click
        Try
            If con.State = ConnectionState.Closed Then
                con.Open()
            End If
            Dim query As String = String.Empty
            Dim command As MySqlCommand
            Dim tabla As MySqlDataReader
            Dim can As Integer = 0

            query = "SELECT id_usuario, usuario, contraseña, rol_usuario FROM usuarios WHERE Usuario = '" + txt_user.Text + "' AND Contraseña = '" + txt_contra.Text + "'"
            command = New MySqlCommand(query, con)
            tabla = command.ExecuteReader
            While tabla.Read
                can += 1
                id_usuario_sesion = tabla.GetInt32("id_usuario")
            End While
            If can = 1 Then
                If txt_contra.Text <> "" And txt_user.Text <> "" Then
                    Dim dt As New DataTable
                    Dim rol As String = tabla("rol_usuario").ToString()
                    Select Case rol
                        Case "administrador"
                            MessageBox.Show("Bienvenido " + txt_user.Text)
                            Me.Hide()
                            MenuA.Show()
                        Case "responsable"
                            MessageBox.Show("Bienvenido " + txt_user.Text)
                            Me.Hide()
                            menuR.Show()
                        Case "tecnico"
                            MessageBox.Show("Bienvenido " + txt_user.Text)
                            Me.Hide()
                            MenuT.Show()
                        Case Else
                            MsgBox("ERROR: Rol no válido")
                    End Select
                    txt_contra.Text = ""
                    txt_user.Text = ""
                End If
            ElseIf can > 1 Then
                MsgBox("ERROR: Hay datos duplicados")
            ElseIf txt_user.Text = "" Or txt_contra.Text = "" Then
                MsgBox("Los campos no pueden estar vacios")
            Else
                MsgBox("ERROR: Usuario y/o contraseña no válidos")
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
End Class
