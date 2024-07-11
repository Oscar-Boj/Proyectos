Imports MySql.Data.MySqlClient

Public Class VisitasCR
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
            con.Close()
            MsgBox(ex.Message)
        End Try
    End Sub

    Private Sub VisitasCR_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        Try
            Dim da As New MySqlDataAdapter("select * from visitas", con)
            Dim ds As New DataSet
            da.Fill(ds)
            Me.DataGridView1.DataSource = ds.Tables(0)
        Catch ex As Exception
            MsgBox(ex.Message)
        End Try
    End Sub

    Private Sub btn_crearT_Click(sender As Object, e As EventArgs) Handles btn_crearT.Click
        Dim fechaActual As String = DateTime.Now.ToString("yyyy-MM-dd")

        If txt_fecha.Text <> "" And txt_idtecnico.Text <> "" And txt_idcliente.Text <> "" Then
            sentencia = "INSERT INTO visitas (fecha, id_tecnico, id_cliente) VALUES ('" & txt_fecha.Text & "', '" & txt_idtecnico.Text & "', '" & txt_idcliente.Text & "')"
            mensaje = "Visita asignada"
            ejecutarsql(sentencia, mensaje)
            Try
                Dim da As New MySqlDataAdapter("select * from visitas", con)
                Dim ds As New DataSet
                da.Fill(ds)
                Me.DataGridView1.DataSource = ds.Tables(0)
                txt_fecha.Text = ""
                txt_idtecnico.Text = ""
                txt_idcliente.Text = ""
            Catch ex As Exception
                MsgBox(ex.Message)
            End Try
        Else
            MsgBox("Llene los campos necesarios")
        End If
    End Sub

    Private Sub btn_borrarT_Click(sender As Object, e As EventArgs) Handles btn_borrarT.Click
        If txt_idvisita.Text <> "" Then
            sentencia = "delete from visitas where id_visita = '" + txt_idvisita.Text + "'"
            mensaje = "Visita eliminada"
            ejecutarsql(sentencia, mensaje)
            Try
                Dim da As New MySqlDataAdapter("select * from visitas", con)
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

    Private Sub btn_menuT_Click(sender As Object, e As EventArgs) Handles btn_menuT.Click
        Me.Hide()
        MenuTareaR.Show()
    End Sub
End Class