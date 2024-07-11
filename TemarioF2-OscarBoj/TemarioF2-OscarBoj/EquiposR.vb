Imports MySql.Data.MySqlClient

Public Class EquiposR
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

    Private Sub EquiposR_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        Try
            Dim da As New MySqlDataAdapter("select * from equipos", con)
            Dim ds As New DataSet
            da.Fill(ds)
            Me.DataGridView1.DataSource = ds.Tables(0)
        Catch ex As Exception
            MsgBox(ex.Message)
        End Try
    End Sub

    Private Sub btn_crearE_Click(sender As Object, e As EventArgs) Handles btn_crearE.Click
        If txt_idcliente.Text <> "" And txt_equipo.Text <> "" Then
            Dim clienteExiste As Boolean = False
            Dim queryCliente As String = "SELECT COUNT(*) FROM clientes WHERE id_cliente = '" & txt_idcliente.Text & "'"
            Dim cmdCliente As New MySqlCommand(queryCliente, con)

            con.Open()
            Dim count As Integer = Convert.ToInt32(cmdCliente.ExecuteScalar())
            con.Close()

            If count > 0 Then
                clienteExiste = True
            End If

            If clienteExiste Then
                sentencia = "INSERT INTO equipos (id_cliente, descripcion) VALUES ('" & txt_idcliente.Text & "', '" & txt_equipo.Text & "')"
                mensaje = "Equipo agregado"
                ejecutarsql(sentencia, mensaje)
                Try
                    Dim da As New MySqlDataAdapter("SELECT * FROM equipos", con)
                    Dim ds As New DataSet
                    da.Fill(ds)
                    Me.DataGridView1.DataSource = ds.Tables(0)
                    txt_idcliente.Text = ""
                    txt_equipo.Text = ""
                Catch ex As Exception
                    MsgBox(ex.Message)
                End Try
            Else
                MsgBox("El ID de cliente no existe")
            End If
        Else
            MsgBox("Por favor, ingrese tanto el ID del cliente como la descripción del equipo.")
        End If
    End Sub

    Private Sub btn_menuT_Click(sender As Object, e As EventArgs) Handles btn_menuT.Click
        Me.Hide()
        menuR.Show()
    End Sub
End Class