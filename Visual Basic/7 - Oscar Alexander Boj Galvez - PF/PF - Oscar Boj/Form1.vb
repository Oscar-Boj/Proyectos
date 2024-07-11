Public Class Form1
    Private Sub Form1_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        Administrador1.Hide()
        Estudiante1.Hide()
    End Sub

    Private Sub btn_admin_Click(sender As Object, e As EventArgs) Handles btn_admin.Click
        Administrador1.Show()
        Administrador1.BringToFront()
    End Sub

    Private Sub btn_estu_Click(sender As Object, e As EventArgs) Handles btn_estu.Click
        Estudiante1.Show()
        Estudiante1.BringToFront()
    End Sub
End Class
