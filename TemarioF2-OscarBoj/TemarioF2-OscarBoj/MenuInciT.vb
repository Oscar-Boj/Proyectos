Public Class MenuInciT
    Private Sub btn_menuT_Click(sender As Object, e As EventArgs) Handles btn_menuT.Click
        Me.Hide()
        MenuT.Show()
    End Sub

    Private Sub btn_newinci_Click(sender As Object, e As EventArgs) Handles btn_newinci.Click
        Me.Hide()
        InicCrearT.Show()
    End Sub

    Private Sub Button1_Click(sender As Object, e As EventArgs) Handles Button1.Click
        Me.Hide()
        InicAbiertaT.Show()
    End Sub

    Private Sub Button2_Click(sender As Object, e As EventArgs) Handles Button2.Click
        Me.Hide()
        IncidenciasT.Show()
    End Sub
End Class