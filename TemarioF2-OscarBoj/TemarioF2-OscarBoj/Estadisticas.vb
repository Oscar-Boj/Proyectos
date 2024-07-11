Imports MySql.Data.MySqlClient
Imports Mysqlx

Public Class Estadisticas
    Private con As New MySqlConnection("server=localhost;database=TemarioF2;user=root;password=compu123")

    Private Sub btn_menuT_Click(sender As Object, e As EventArgs) Handles btn_menuT.Click
        Me.Hide()
        MenuInciR.Show()
    End Sub

    Private Sub Estadisticas_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        CargarDatosEnGrafica()
    End Sub

    Private Sub CargarDatosEnGrafica()
        Dim query As String = "SELECT estado, COUNT(*) AS cantidad FROM incidencias GROUP BY estado"

        Try
            Dim command As New MySqlCommand(query, con)
            Dim dataTable As New DataTable()

            con.Open()
            Dim dataAdapter As New MySqlDataAdapter(command)
            dataAdapter.Fill(dataTable)

            ' Asignar los datos al control Chart
            Chart1.DataSource = dataTable
            Chart1.Series.Clear() ' Limpiar cualquier serie existente
            Chart1.Series.Add("Cantidad") ' Agregar una nueva serie
            Chart1.Series("Cantidad").XValueMember = "estado"
            Chart1.Series("Cantidad").YValueMembers = "cantidad"
            Chart1.DataBind()
            con.Close()
        Catch ex As Exception
            MsgBox("Error al cargar los datos: " & ex.Message)
        End Try
    End Sub

    Private Sub btn_refresh_Click(sender As Object, e As EventArgs) Handles btn_refresh.Click
        CargarDatosEnGrafica()
    End Sub
End Class