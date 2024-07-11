Public Class menuR
    Private Sub btn_cerrarA_Click(sender As Object, e As EventArgs) Handles btn_cerrarR.Click
        Me.Hide()
        Form1.Show()
    End Sub

    Private Sub btn_inicidenR_Click(sender As Object, e As EventArgs) Handles btn_inicidenR.Click
        Me.Hide()
        MenuInciR.Show()
    End Sub

    Private Sub btn_tareasR_Click(sender As Object, e As EventArgs) Handles btn_tareasR.Click
        Me.Hide()
        MenuTareaR.Show()
    End Sub

    Private Sub btn_equiposR_Click(sender As Object, e As EventArgs) Handles btn_equiposR.Click
        Me.Hide()
        EquiposR.Show()
    End Sub

    Private Sub btn_clientesR_Click(sender As Object, e As EventArgs) Handles btn_clientesR.Click
        Me.Hide()
        ClientesR.Show()
    End Sub
End Class