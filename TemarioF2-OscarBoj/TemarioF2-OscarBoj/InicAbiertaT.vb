Imports MySql.Data.MySqlClient

Public Class InicAbiertaT
    Private con As New MySqlConnection("server=localhost;database=TemarioF2;user=root;password=compu123")
    Dim mensaje, sentencia As String
    Dim estadoI As String = "Abierta"

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

    Private Sub btn_menuT_Click(sender As Object, e As EventArgs) Handles btn_menuT.Click
        Me.Hide()
        MenuInciT.Show()
    End Sub

    Private Sub InicAbiertaT_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        Try
            Dim da As New MySqlDataAdapter("select * from incidencias where estado = '" + estadoI + "'", con)
            Dim ds As New DataSet
            da.Fill(ds)
            Me.DataGridView1.DataSource = ds.Tables(0)
        Catch ex As Exception
            MsgBox(ex.Message)
        End Try
    End Sub

    Private Sub btn_concluir_Click(sender As Object, e As EventArgs) Handles btn_concluir.Click
        Dim fechaActual As String = DateTime.Now.ToString("yyyy-MM-dd")
        Dim estado As String = "Concluida"

        If txt_idinci.Text <> "" Then
            sentencia = "update incidencias set fecha_finalizada = '" + fechaActual + "', estado = '" + estado + "' where id_incidencia = '" + txt_idinci.Text + "'"
            mensaje = "Incidencia concluida"
            ejecutarsql(sentencia, mensaje)
            Try
                Dim da As New MySqlDataAdapter("select * from incidencias where estado = '" + estadoI + "'", con)
                Dim ds As New DataSet
                da.Fill(ds)
                Me.DataGridView1.DataSource = ds.Tables(0)
            Catch ex As Exception
                MsgBox(ex.Message)
            End Try
        Else
            MsgBox("Coloque un ID")
        End If
    End Sub
End Class