Public Class MenuT
    Private Sub btn_cerrarA_Click(sender As Object, e As EventArgs) Handles btn_cerrarT.Click
        Me.Hide()
        Form1.Show()
    End Sub

    Private Sub btn_inicidenT_Click(sender As Object, e As EventArgs) Handles btn_inicidenT.Click
        Me.Hide()
        MenuInciT.Show()
    End Sub

    Private Sub PictureBox1_Click(sender As Object, e As EventArgs) Handles PictureBox1.Click

    End Sub

    Private Sub btn_tareasT_Click(sender As Object, e As EventArgs) Handles btn_tareasT.Click
        Me.Hide()
        TareasT.Show()
    End Sub

    Private Sub btn_equiposE_Click(sender As Object, e As EventArgs) Handles btn_equiposE.Click
        Me.Hide()
        EquiposT.Show()
    End Sub

    Private Sub btn_asistenciasT_Click(sender As Object, e As EventArgs) Handles btn_asistenciasT.Click
        Me.Hide()
        AsistenciasT.Show()
    End Sub
End Class