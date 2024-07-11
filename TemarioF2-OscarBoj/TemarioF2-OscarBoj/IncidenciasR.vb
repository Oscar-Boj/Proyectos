Imports MySql.Data.MySqlClient

Public Class IncidenciasR
    Private con As New MySqlConnection("server=localhost;database=TemarioF2;user=root;password=compu123")
    Dim mensaje, sentencia As String

    Sub ejecutarsql(ByVal sql As String, ByVal msg As String)
        Try
            Dim cmd As New MySqlCommand(sql, con)
            con.Open()
            cmd.ExecuteNonQuery()
            con.Close()
            MsgBox(msg)
        Catch ex As Exception
            MsgBox(ex.Message)
        End Try
    End Sub

    Private Sub IncidenciasR_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        Try
            Dim da As New MySqlDataAdapter("select * from incidencias", con)
            Dim ds As New DataSet
            da.Fill(ds)
            Me.DataGridView1.DataSource = ds.Tables(0)
        Catch ex As Exception
            MsgBox(ex.Message)
        End Try
    End Sub

    Private Sub btn_buscar_Click(sender As Object, e As EventArgs) Handles btn_buscar.Click
        Dim query As String

        If txt_idinci.Text <> "" Then
            ' Si se ha proporcionado un ID de incidencia, buscar por ese ID
            query = "SELECT * FROM incidencias WHERE id_incidencia = '" + txt_idinci.Text + "'"
        Else
            ' Si no se proporciona ningún ID de incidencia, seleccionar todas las incidencias
            query = "SELECT * FROM incidencias"
        End If

        Try
            Dim da As New MySqlDataAdapter(query, con)
            Dim ds As New DataSet
            da.Fill(ds)
            Me.DataGridView1.DataSource = ds.Tables(0)
        Catch ex As Exception
            MsgBox(ex.Message)
        End Try
    End Sub

    Private Sub btn_menuT_Click(sender As Object, e As EventArgs) Handles btn_menuT.Click
        Me.Hide()
        MenuInciR.Show()
    End Sub
End Class