Public Class Form2
    Private Sub btn_salir_Click(sender As Object, e As EventArgs) Handles btn_salir.Click
        Me.Close()
        Form1.Show()
    End Sub

    Private Sub btn_empleados_Click(sender As Object, e As EventArgs) Handles btn_empleados.Click
        Me.Hide()
        Form5.Show()
    End Sub

    Private Sub btn_clientes_Click(sender As Object, e As EventArgs) Handles btn_clientes.Click
        Me.Hide()
        Form6.Show()
    End Sub

    Private Sub btn_productos_Click(sender As Object, e As EventArgs) Handles btn_productos.Click
        Me.Hide()
        Form7.Show()
    End Sub

    Private Sub btn_facturas_Click(sender As Object, e As EventArgs) Handles btn_facturas.Click
        Me.Hide()
        Form8.Show()
    End Sub
End Class