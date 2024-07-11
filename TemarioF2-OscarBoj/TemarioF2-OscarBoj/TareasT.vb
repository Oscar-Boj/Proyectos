Imports MySql.Data.MySqlClient

Public Class TareasT
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
    Private Sub btn_menuT_Click(sender As Object, e As EventArgs) Handles btn_menuT.Click
        Me.Hide()
        MenuT.Show()
    End Sub

    Private Sub TareasT_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        Try
            Dim da As New MySqlDataAdapter("select * from tareas where id_tecnico = '" + Form1.id_usuario_sesion.ToString + "'", con)
            Dim ds As New DataSet
            da.Fill(ds)
            Me.DataGridView1.DataSource = ds.Tables(0)
        Catch ex As Exception
            MsgBox(ex.Message)
        End Try
    End Sub

    Private Sub btn_borrarT_Click(sender As Object, e As EventArgs) Handles btn_borrarT.Click
        If txt_idtarea.Text <> "" Then
            sentencia = "delete from tareas where id_tarea = '" + txt_idtarea.Text + "'"
            mensaje = "Tarea eliminada"
            ejecutarsql(sentencia, mensaje)
            Try
                Dim da As New MySqlDataAdapter("select * from tareas where id_tecnico = '" + Form1.id_usuario_sesion.ToString + "'", con)
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

    Private Sub btn_crearT_Click(sender As Object, e As EventArgs) Handles btn_crearT.Click
        Dim fechaActual As String = DateTime.Now.ToString("yyyy-MM-dd")
        Dim idTecnico As Integer = Form1.id_usuario_sesion
        Dim estado As String = "Pendiente"

        If txt_tarea.Text <> "" Then
            sentencia = "INSERT INTO tareas (descripcion, fecha_asignacion, estado, id_tecnico, id_responsable) VALUES ('" & txt_tarea.Text & "', '" & fechaActual & "', '" & estado & "', " & idTecnico & ", NULL)"
            mensaje = "Tarea creada"
            ejecutarsql(sentencia, mensaje)
            Try
                Dim da As New MySqlDataAdapter("select * from tareas where id_tecnico = '" + Form1.id_usuario_sesion.ToString + "'", con)
                Dim ds As New DataSet
                da.Fill(ds)
                Me.DataGridView1.DataSource = ds.Tables(0)
                txt_tarea.Text = ""
            Catch ex As Exception
                MsgBox(ex.Message)
            End Try
        Else
            MsgBox("Coloque una descripcion")
        End If
    End Sub
End Class