Imports MySql.Data.MySqlClient

Public Class InicCrearR
    Private con As New MySqlConnection("server=localhost;database=TemarioF2;user=root;password=compu123")
    Dim mensaje, mensaje2, sentencia, sentencia2 As String

    Private Sub btn_crearI_Click(sender As Object, e As EventArgs) Handles btn_crearI.Click
        If txt_idcliente.Text <> "" And txt_incidencia.Text <> "" Then
            Dim clienteExiste As Boolean = False
            Dim queryCliente As String = "SELECT COUNT(*) FROM clientes WHERE id_cliente = '" & txt_idcliente.Text & "'"
            Dim cmdCliente As New MySqlCommand(queryCliente, con)

            Dim fechaActual As String = DateTime.Now.ToString("yyyy-MM-dd")
            Dim idTecnico As Integer = Form1.id_usuario_sesion
            Dim estado As String = "Abierta"

            con.Open()
            Dim count As Integer = Convert.ToInt32(cmdCliente.ExecuteScalar())
            con.Close()

            If count > 0 Then
                clienteExiste = True
            End If

            If clienteExiste Then
                sentencia = "INSERT INTO incidencias (descripcion, fecha_inicio, fecha_finalizada, estado, id_tecnico, id_cliente) VALUES ('" & txt_incidencia.Text & "', '" & fechaActual & "', NULL, '" & estado & "', " & idTecnico & ", '" & txt_idcliente.Text & "')"
                mensaje = "Incidencia creada"
                ejecutarsql(sentencia, mensaje)
                sentencia2 = "INSERT INTO asistencias (id_tecnico, id_cliente, fecha) VALUES ('" & idTecnico & "', '" & txt_idcliente.Text & "', '" & fechaActual & "')"
                mensaje2 = "Asistencia registrada"
                ejecutarsql(sentencia2, mensaje2)
                Try
                    Dim da As New MySqlDataAdapter("SELECT * FROM incidencias ORDER BY fecha_inicio DESC", con)
                    Dim ds As New DataSet
                    da.Fill(ds)
                    Me.DataGridView1.DataSource = ds.Tables(0)
                    txt_idcliente.Text = ""
                    txt_incidencia.Text = ""
                Catch ex As Exception
                    MsgBox(ex.Message)
                End Try
            Else
                MsgBox("El ID de cliente no existe")
            End If
        Else
            MsgBox("Por favor, ingrese tanto el ID como la descripción de la incidencia.")
        End If
    End Sub

    Private Sub btn_menuT_Click(sender As Object, e As EventArgs) Handles btn_menuT.Click
        Me.Hide()
        MenuInciR.Show()
    End Sub

    Private Sub InicCrearR_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        Try
            Dim da As New MySqlDataAdapter("SELECT * FROM incidencias ORDER BY fecha_inicio DESC", con)
            Dim ds As New DataSet
            da.Fill(ds)
            Me.DataGridView1.DataSource = ds.Tables(0)
        Catch ex As Exception
            MsgBox(ex.Message)
        End Try
    End Sub

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
End Class