Imports MySql.Data.MySqlClient
Public Class Form5
    Private con As New MySqlConnection("server=localhost;database=IES_PF1;user=root;password=compu")
    Dim mensaje, sentencia As String

    Sub ejecutarsql(ByVal sql As String, ByVal msg As String)
        Try
            Dim cmd As New MySqlCommand(sql, con)
            con.open()
            cmd.ExecuteNonQuery()
            con.close()
            MsgBox(msg)
        Catch ex As Exception
            MsgBox(ex.Message)
        End Try
    End Sub

    Private Sub btn_insertar_Click(sender As Object, e As EventArgs) Handles btn_insertar.Click
        sentencia = "insert into Empleado values('" + txt_id.Text + "','" + txt_nombre.Text + "','" + txt_apellido.Text + "','" + txt_edad.Text + "','" + txt_fecha.Text + "','" + txt_salario.Text + "')"
        mensaje = "Datos Insertados Correctamente"
        ejecutarsql(sentencia, mensaje)
        Try
            Dim da As New MySqlDataAdapter("select * from Empleado", con)
            Dim ds As New DataSet
            da.fill(ds)
            Me.DataGridView1.DataSource = ds.Tables(0)
        Catch ex As Exception
            MsgBox(ex.Message)
        End Try
    End Sub

    Private Sub btn_actualizar_Click(sender As Object, e As EventArgs) Handles btn_actualizar.Click
        sentencia = "update Empleado set Nombre = '" + txt_nombre.Text + "', Apellido = '" + txt_apellido.Text + "', Edad = '" + txt_edad.Text + "', Fecha_ingreso = '" + txt_fecha.Text + "', Salario_mensual = '" + txt_salario.Text + "'where id_empleado = '" + txt_id.Text + "'"
        mensaje = "Datos Actualizados Correctamente"
        ejecutarsql(sentencia, mensaje)
        Try
            Dim da As New MySqlDataAdapter("select * from Empleado", con)
            Dim ds As New DataSet
            da.fill(ds)
            Me.DataGridView1.DataSource = ds.Tables(0)
        Catch ex As Exception
            MsgBox(ex.Message)
        End Try
    End Sub

    Private Sub btn_eliminar_Click(sender As Object, e As EventArgs) Handles btn_eliminar.Click
        sentencia = "delete from Empleado where id_empleado = '" + txt_id.Text + "'"
        mensaje = "Datos Eliminados Correctamente"
        ejecutarsql(sentencia, mensaje)
        Try
            Dim da As New MySqlDataAdapter("select * from Empleado", con)
            Dim ds As New DataSet
            da.fill(ds)
            Me.DataGridView1.DataSource = ds.Tables(0)
        Catch ex As Exception
            MsgBox(ex.Message)
        End Try
    End Sub

    Private Sub btn_mostrar_Click(sender As Object, e As EventArgs) Handles btn_mostrar.Click
        Try
            Dim da As New MySqlDataAdapter("select * from Empleado", con)
            Dim ds As New DataSet
            da.fill(ds)
            Me.DataGridView1.DataSource = ds.Tables(0)
        Catch ex As Exception
            MsgBox(ex.Message)
        End Try
    End Sub

    Private Sub btn_limpiar_Click(sender As Object, e As EventArgs) Handles btn_limpiar.Click
        txt_id.Text = ""
        txt_nombre.Text = ""
        txt_apellido.Text = ""
        txt_edad.Text = ""
        txt_fecha.Text = ""
        txt_salario.Text = ""
    End Sub

    Private Sub btn_menu_Click(sender As Object, e As EventArgs) Handles btn_menu.Click
        Me.Close()
        Form2.Show()
    End Sub
End Class