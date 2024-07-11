Imports System.Data.Sql
Imports System.Data.SqlClient
Public Class Administrador
    Public con As New SqlConnection(My.Settings.Conexion)
    Public sen As String
    Public mensaje As String
    Private Sub btn_iniciar_Click(sender As Object, e As EventArgs) Handles btn_iniciar.Click
        Dim Usuario = txt_Usuario.Text
        Dim Contra = txt_contra.Text
        If Usuario = "" And Contra = "" Then
            MsgBox("Coloque los datos solicitados")
        Else
            If Usuario = "Oscar" And Contra = "123456789" Then
                Form1.Hide()
                Form2.Show()
            End If
        End If
    End Sub
End Class
