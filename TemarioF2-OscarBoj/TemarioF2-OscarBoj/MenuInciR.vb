Public Class MenuInciR
    Private Sub btn_menuT_Click(sender As Object, e As EventArgs) Handles btn_menuT.Click
        Me.Hide()
        menuR.Show()
    End Sub

    Private Sub btn_estadis_Click(sender As Object, e As EventArgs) Handles btn_estadis.Click
        Me.Hide()
        Estadisticas.Show()
    End Sub

    Private Sub btn_newinci_Click(sender As Object, e As EventArgs) Handles btn_newinci.Click
        Me.Hide()
        InicCrearR.Show()
    End Sub

    Private Sub Button1_Click(sender As Object, e As EventArgs) Handles Button1.Click
        Me.Hide()
        InicAbiertaR.Show()
    End Sub

    Private Sub Button2_Click(sender As Object, e As EventArgs) Handles Button2.Click
        Me.Hide()
        IncidenciasR.Show()
    End Sub
End Class