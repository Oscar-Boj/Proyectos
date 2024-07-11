Public Class Form3
    Private Sub btn_productos_Click(sender As Object, e As EventArgs) Handles btn_productos.Click
        Me.Hide()
        Form10.Show()
    End Sub

    Private Sub btn_salir_Click(sender As Object, e As EventArgs) Handles btn_salir.Click
        Me.Close()
        Form1.Show()
    End Sub

    Private Sub btn_facturas_Click(sender As Object, e As EventArgs) Handles btn_facturas.Click
        Me.Hide()
        Form11.Show()
    End Sub

    Private Sub btn_cliente_Click(sender As Object, e As EventArgs) Handles btn_cliente.Click
        Me.Hide()
        Form12.Show()
    End Sub
End Class