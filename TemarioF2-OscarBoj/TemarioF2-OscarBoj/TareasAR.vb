Imports MySql.Data.MySqlClient

Public Class TareasAR
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

    Private Sub TareasAR_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        Try
            Dim da As New MySqlDataAdapter("select * from tareas", con)
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
                Dim da As New MySqlDataAdapter("select * from tareas", con)
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
        If txt_idtecnico.Text <> "" And txt_tarea.Text <> "" Then
            Dim tecnicoExiste As Boolean = False
            Dim queryCliente As String = "SELECT COUNT(*) FROM usuarios WHERE id_usuario = '" & txt_idtecnico.Text & "' AND rol_usuario = 'tecnico'"
            Dim cmdCliente As New MySqlCommand(queryCliente, con)

            Dim fechaActual As String = DateTime.Now.ToString("yyyy-MM-dd")
            Dim idResponsable As Integer = Form1.id_usuario_sesion
            Dim estado As String = "Pendiente"

            con.Open()
            Dim count As Integer = Convert.ToInt32(cmdCliente.ExecuteScalar())
            con.Close()

            If count > 0 Then
                tecnicoExiste = True
            End If

            If tecnicoExiste Then
                sentencia = "INSERT INTO tareas (descripcion, fecha_asignacion, estado, id_tecnico, id_responsable) VALUES ('" & txt_tarea.Text & "', '" & fechaActual & "', '" & estado & "', '" + txt_idtecnico.Text + "', " & idResponsable & ")"
                mensaje = "Tarea creada"
                ejecutarsql(sentencia, mensaje)
                Try
                    Dim da As New MySqlDataAdapter("select * from tareas", con)
                    Dim ds As New DataSet
                    da.Fill(ds)
                    Me.DataGridView1.DataSource = ds.Tables(0)
                    txt_tarea.Text = ""
                    txt_idtecnico.Text = ""
                Catch ex As Exception
                    MsgBox(ex.Message)
                End Try
            Else
                MsgBox("El ID del técnico no existe")
            End If
        Else
            MsgBox("Por favor, ingrese tanto el ID del técnico como la descripción de la tarea.")
        End If
    End Sub

    Private Sub btn_modificar_Click(sender As Object, e As EventArgs) Handles btn_modificar.Click
        If txt_idtecnico.Text <> "" And txt_tarea.Text <> "" And txt_idtarea.Text <> "" Then
            Dim tecnicoExiste As Boolean = False
            Dim queryCliente As String = "SELECT COUNT(*) FROM usuarios WHERE id_usuario = '" & txt_idtecnico.Text & "' AND rol_usuario = 'tecnico'"
            Dim cmdCliente As New MySqlCommand(queryCliente, con)

            con.Open()
            Dim count As Integer = Convert.ToInt32(cmdCliente.ExecuteScalar())
            con.Close()

            If count > 0 Then
                tecnicoExiste = True
            End If

            If tecnicoExiste Then
                sentencia = "update tareas set descripcion = '" + txt_tarea.Text + "', id_tecnico = '" + txt_idtecnico.Text + "' where id_tarea = '" + txt_idtarea.Text + "'"
                mensaje = "Tarea modificada"
                ejecutarsql(sentencia, mensaje)
                Try
                    Dim da As New MySqlDataAdapter("select * from tareas", con)
                    Dim ds As New DataSet
                    da.Fill(ds)
                    Me.DataGridView1.DataSource = ds.Tables(0)
                Catch ex As Exception
                    MsgBox(ex.Message)
                End Try
            Else
                MsgBox("El ID del técnico no existe")
            End If
        Else
                MsgBox("Coloque los ID y la descripcion de la tarea")
        End If
    End Sub

    Private Sub btn_menuT_Click(sender As Object, e As EventArgs) Handles btn_menuT.Click
        Me.Hide()
        MenuTareaR.Show()
    End Sub
End Class