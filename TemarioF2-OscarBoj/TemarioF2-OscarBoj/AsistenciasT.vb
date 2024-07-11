Imports MySql.Data.MySqlClient

Public Class AsistenciasT
    Private con As New MySqlConnection("server=localhost;database=TemarioF2;user=root;password=compu123")
    Dim mensaje, sentencia As String

    Private Sub AsistenciasT_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        Try
            Dim da As New MySqlDataAdapter("select * from asistencias", con)
            Dim ds As New DataSet
            da.Fill(ds)
            Me.DataGridView1.DataSource = ds.Tables(0)
        Catch ex As Exception
            MsgBox(ex.Message)
        End Try
    End Sub

    Private Sub btn_refresh_Click(sender As Object, e As EventArgs) Handles btn_refresh.Click
        Try
            Dim da As New MySqlDataAdapter("select * from asistencias", con)
            Dim ds As New DataSet
            da.Fill(ds)
            Me.DataGridView1.DataSource = ds.Tables(0)
        Catch ex As Exception
            MsgBox(ex.Message)
        End Try
    End Sub

    Private Sub btn_menuT_Click(sender As Object, e As EventArgs) Handles btn_menuT.Click
        Me.Hide()
        MenuT.Show()
    End Sub
End Class