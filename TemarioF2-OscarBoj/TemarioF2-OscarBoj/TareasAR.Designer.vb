<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class TareasAR
    Inherits System.Windows.Forms.Form

    'Form reemplaza a Dispose para limpiar la lista de componentes.
    <System.Diagnostics.DebuggerNonUserCode()> _
    Protected Overrides Sub Dispose(ByVal disposing As Boolean)
        Try
            If disposing AndAlso components IsNot Nothing Then
                components.Dispose()
            End If
        Finally
            MyBase.Dispose(disposing)
        End Try
    End Sub

    'Requerido por el Diseñador de Windows Forms
    Private components As System.ComponentModel.IContainer

    'NOTA: el Diseñador de Windows Forms necesita el siguiente procedimiento
    'Se puede modificar usando el Diseñador de Windows Forms.  
    'No lo modifique con el editor de código.
    <System.Diagnostics.DebuggerStepThrough()> _
    Private Sub InitializeComponent()
        Dim resources As System.ComponentModel.ComponentResourceManager = New System.ComponentModel.ComponentResourceManager(GetType(TareasAR))
        Me.Label3 = New System.Windows.Forms.Label()
        Me.txt_idtarea = New System.Windows.Forms.TextBox()
        Me.PictureBox1 = New System.Windows.Forms.PictureBox()
        Me.btn_menuT = New System.Windows.Forms.Button()
        Me.txt_tarea = New System.Windows.Forms.TextBox()
        Me.Label2 = New System.Windows.Forms.Label()
        Me.btn_borrarT = New System.Windows.Forms.Button()
        Me.btn_crearT = New System.Windows.Forms.Button()
        Me.DataGridView1 = New System.Windows.Forms.DataGridView()
        Me.Label1 = New System.Windows.Forms.Label()
        Me.Label4 = New System.Windows.Forms.Label()
        Me.txt_idtecnico = New System.Windows.Forms.TextBox()
        Me.btn_modificar = New System.Windows.Forms.Button()
        CType(Me.PictureBox1, System.ComponentModel.ISupportInitialize).BeginInit()
        CType(Me.DataGridView1, System.ComponentModel.ISupportInitialize).BeginInit()
        Me.SuspendLayout()
        '
        'Label3
        '
        Me.Label3.AutoSize = True
        Me.Label3.BackColor = System.Drawing.Color.Transparent
        Me.Label3.Font = New System.Drawing.Font("Verdana", 12.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Label3.Location = New System.Drawing.Point(404, 116)
        Me.Label3.Name = "Label3"
        Me.Label3.Size = New System.Drawing.Size(85, 18)
        Me.Label3.TabIndex = 39
        Me.Label3.Text = "Id Tarea"
        '
        'txt_idtarea
        '
        Me.txt_idtarea.Font = New System.Drawing.Font("Verdana", 12.0!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.txt_idtarea.Location = New System.Drawing.Point(509, 113)
        Me.txt_idtarea.Name = "txt_idtarea"
        Me.txt_idtarea.Size = New System.Drawing.Size(219, 27)
        Me.txt_idtarea.TabIndex = 38
        '
        'PictureBox1
        '
        Me.PictureBox1.BackColor = System.Drawing.Color.Transparent
        Me.PictureBox1.BackgroundImage = CType(resources.GetObject("PictureBox1.BackgroundImage"), System.Drawing.Image)
        Me.PictureBox1.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch
        Me.PictureBox1.Location = New System.Drawing.Point(12, 9)
        Me.PictureBox1.Name = "PictureBox1"
        Me.PictureBox1.Size = New System.Drawing.Size(79, 73)
        Me.PictureBox1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.CenterImage
        Me.PictureBox1.TabIndex = 37
        Me.PictureBox1.TabStop = False
        '
        'btn_menuT
        '
        Me.btn_menuT.BackColor = System.Drawing.Color.Red
        Me.btn_menuT.Cursor = System.Windows.Forms.Cursors.Hand
        Me.btn_menuT.FlatStyle = System.Windows.Forms.FlatStyle.Popup
        Me.btn_menuT.Font = New System.Drawing.Font("Verdana", 9.75!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.btn_menuT.Location = New System.Drawing.Point(643, 4)
        Me.btn_menuT.Name = "btn_menuT"
        Me.btn_menuT.Size = New System.Drawing.Size(114, 25)
        Me.btn_menuT.TabIndex = 36
        Me.btn_menuT.Text = "Menu"
        Me.btn_menuT.UseVisualStyleBackColor = False
        '
        'txt_tarea
        '
        Me.txt_tarea.Font = New System.Drawing.Font("Verdana", 12.0!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.txt_tarea.Location = New System.Drawing.Point(407, 238)
        Me.txt_tarea.Multiline = True
        Me.txt_tarea.Name = "txt_tarea"
        Me.txt_tarea.Size = New System.Drawing.Size(321, 114)
        Me.txt_tarea.TabIndex = 35
        '
        'Label2
        '
        Me.Label2.AutoSize = True
        Me.Label2.BackColor = System.Drawing.Color.Transparent
        Me.Label2.Font = New System.Drawing.Font("Verdana", 12.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Label2.Location = New System.Drawing.Point(404, 217)
        Me.Label2.Name = "Label2"
        Me.Label2.Size = New System.Drawing.Size(61, 18)
        Me.Label2.TabIndex = 34
        Me.Label2.Text = "Tarea"
        '
        'btn_borrarT
        '
        Me.btn_borrarT.BackColor = System.Drawing.Color.FromArgb(CType(CType(93, Byte), Integer), CType(CType(109, Byte), Integer), CType(CType(126, Byte), Integer))
        Me.btn_borrarT.FlatStyle = System.Windows.Forms.FlatStyle.Popup
        Me.btn_borrarT.Font = New System.Drawing.Font("Verdana", 12.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.btn_borrarT.ForeColor = System.Drawing.Color.White
        Me.btn_borrarT.Location = New System.Drawing.Point(633, 374)
        Me.btn_borrarT.Name = "btn_borrarT"
        Me.btn_borrarT.Size = New System.Drawing.Size(95, 64)
        Me.btn_borrarT.TabIndex = 33
        Me.btn_borrarT.Text = "BORRAR TAREA"
        Me.btn_borrarT.UseVisualStyleBackColor = False
        '
        'btn_crearT
        '
        Me.btn_crearT.BackColor = System.Drawing.Color.FromArgb(CType(CType(93, Byte), Integer), CType(CType(109, Byte), Integer), CType(CType(126, Byte), Integer))
        Me.btn_crearT.FlatStyle = System.Windows.Forms.FlatStyle.Popup
        Me.btn_crearT.Font = New System.Drawing.Font("Verdana", 12.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.btn_crearT.ForeColor = System.Drawing.Color.White
        Me.btn_crearT.Location = New System.Drawing.Point(407, 374)
        Me.btn_crearT.Name = "btn_crearT"
        Me.btn_crearT.Size = New System.Drawing.Size(82, 64)
        Me.btn_crearT.TabIndex = 32
        Me.btn_crearT.Text = "CREAR TAREA"
        Me.btn_crearT.UseVisualStyleBackColor = False
        '
        'DataGridView1
        '
        Me.DataGridView1.AutoSizeColumnsMode = System.Windows.Forms.DataGridViewAutoSizeColumnsMode.AllCells
        Me.DataGridView1.BackgroundColor = System.Drawing.Color.White
        Me.DataGridView1.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize
        Me.DataGridView1.Location = New System.Drawing.Point(12, 114)
        Me.DataGridView1.Name = "DataGridView1"
        Me.DataGridView1.Size = New System.Drawing.Size(360, 324)
        Me.DataGridView1.TabIndex = 31
        '
        'Label1
        '
        Me.Label1.AutoSize = True
        Me.Label1.BackColor = System.Drawing.Color.Transparent
        Me.Label1.Font = New System.Drawing.Font("Verdana", 26.25!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Label1.Location = New System.Drawing.Point(97, 9)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(294, 42)
        Me.Label1.TabIndex = 30
        Me.Label1.Text = "Tareas Ajenas"
        '
        'Label4
        '
        Me.Label4.AutoSize = True
        Me.Label4.BackColor = System.Drawing.Color.Transparent
        Me.Label4.Font = New System.Drawing.Font("Verdana", 12.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Label4.Location = New System.Drawing.Point(404, 169)
        Me.Label4.Name = "Label4"
        Me.Label4.Size = New System.Drawing.Size(99, 18)
        Me.Label4.TabIndex = 41
        Me.Label4.Text = "Id Técnico"
        '
        'txt_idtecnico
        '
        Me.txt_idtecnico.Font = New System.Drawing.Font("Verdana", 12.0!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.txt_idtecnico.Location = New System.Drawing.Point(509, 166)
        Me.txt_idtecnico.Name = "txt_idtecnico"
        Me.txt_idtecnico.Size = New System.Drawing.Size(219, 27)
        Me.txt_idtecnico.TabIndex = 40
        '
        'btn_modificar
        '
        Me.btn_modificar.BackColor = System.Drawing.Color.FromArgb(CType(CType(93, Byte), Integer), CType(CType(109, Byte), Integer), CType(CType(126, Byte), Integer))
        Me.btn_modificar.FlatStyle = System.Windows.Forms.FlatStyle.Popup
        Me.btn_modificar.Font = New System.Drawing.Font("Verdana", 12.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.btn_modificar.ForeColor = System.Drawing.Color.White
        Me.btn_modificar.Location = New System.Drawing.Point(495, 374)
        Me.btn_modificar.Name = "btn_modificar"
        Me.btn_modificar.Size = New System.Drawing.Size(133, 64)
        Me.btn_modificar.TabIndex = 42
        Me.btn_modificar.Text = "MODIFICAR TAREA"
        Me.btn_modificar.UseVisualStyleBackColor = False
        '
        'TareasAR
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(761, 450)
        Me.Controls.Add(Me.btn_modificar)
        Me.Controls.Add(Me.Label4)
        Me.Controls.Add(Me.txt_idtecnico)
        Me.Controls.Add(Me.Label3)
        Me.Controls.Add(Me.txt_idtarea)
        Me.Controls.Add(Me.PictureBox1)
        Me.Controls.Add(Me.btn_menuT)
        Me.Controls.Add(Me.txt_tarea)
        Me.Controls.Add(Me.Label2)
        Me.Controls.Add(Me.btn_borrarT)
        Me.Controls.Add(Me.btn_crearT)
        Me.Controls.Add(Me.DataGridView1)
        Me.Controls.Add(Me.Label1)
        Me.Name = "TareasAR"
        Me.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen
        Me.Text = "TareasAR"
        CType(Me.PictureBox1, System.ComponentModel.ISupportInitialize).EndInit()
        CType(Me.DataGridView1, System.ComponentModel.ISupportInitialize).EndInit()
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub

    Friend WithEvents Label3 As Label
    Friend WithEvents txt_idtarea As TextBox
    Friend WithEvents PictureBox1 As PictureBox
    Friend WithEvents btn_menuT As Button
    Friend WithEvents txt_tarea As TextBox
    Friend WithEvents Label2 As Label
    Friend WithEvents btn_borrarT As Button
    Friend WithEvents btn_crearT As Button
    Friend WithEvents DataGridView1 As DataGridView
    Friend WithEvents Label1 As Label
    Friend WithEvents Label4 As Label
    Friend WithEvents txt_idtecnico As TextBox
    Friend WithEvents btn_modificar As Button
End Class
