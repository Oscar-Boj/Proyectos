Imports System.Data.Sql
Imports System.Data.SqlClient
Public Class Libros
    Public con As New SqlConnection(My.Settings.Conexion)
    Public sen As String
    Public mensaje As String

    Sub ejecutarSql(ByVal sql As String, ByVal msg As String)
        Try
            Dim cmd As New SqlCommand("Select * From Libros", con)
            con.Open()
            cmd.ExecuteNonQuery()
            con.Close()
            MsgBox(msg)
        Catch ex As Exception
            MsgBox(ex.Message)
        End Try
    End Sub
    Private Sub btn_insertar_Click(sender As Object, e As EventArgs) Handles btn_insertar.Click
        sen = "Insert into Libros values('" + txt_titulo.Text + "','" + txt_categoria.Text + "','" + txt_autor.Text + "','" + txt_fecha.Text + "','" + txt_cantidad.Text + "'",con")"
        mensaje = "Datos insertados correctamente"
        ejecutarSql(sen, mensaje)
        Try
            Dim da As New SqlDataAdapter("Select * From Libros", con)
            Dim ds As New DataSet
            da.Fill(ds)
            Me.DTGV.DataSource = ds.Tables(0)
        Catch ex As Exception
            MsgBox(ex.Message)
        End Try
    End Sub

    Private Sub btn_actualizar_Click(sender As Object, e As EventArgs) Handles btn_actualizar.Click
        sen = "update Libros set Titulo='" + txt_titulo.Text + "', Categoria='" + txt_categoria.Text + "', Autor='" + txt_autor.Text + "', Fecha_Publicacion='" + txt_fecha.Text + "', Cantidad='" + txt_cantidad.Text + "'", con")"
        mensaje = "Datos actualizados correctamente"
        ejecutarSql(sen, mensaje)
        Try
            Dim da As New SqlDataAdapter("Select * From Libros", con)
            Dim ds As New DataSet
            da.Fill(ds)
            Me.DTGV.DataSource = ds.Tables(0)
        Catch ex As Exception
            MsgBox(ex.Message)
        End Try
    End Sub

    Private Sub btn_eliminar_Click(sender As Object, e As EventArgs) Handles btn_eliminar.Click
        sen = "Delete Libros WHERE Titulo='" + txt_titulo.Text + "'", con")"
        mensaje = "Datos eliminados correctamente"
        ejecutarSql(sen, mensaje)
        Try
            Dim da As New SqlDataAdapter("Select * From Libros", con)
            Dim ds As New DataSet
            da.Fill(ds)
            Me.DTGV.DataSource = ds.Tables(0)
        Catch ex As Exception
            MsgBox(ex.Message)
        End Try
    End Sub

    Private Sub btn_mostrar_Click(sender As Object, e As EventArgs) Handles btn_mostrar.Click
        Try
            Dim da As New SqlDataAdapter("Select * From Libros", con)
            Dim ds As New DataSet
            da.Fill(ds)
            Me.DTGV.DataSource = ds.Tables(0)
        Catch ex As Exception
            MsgBox(ex.Message)
        End Try
    End Sub
End Class
