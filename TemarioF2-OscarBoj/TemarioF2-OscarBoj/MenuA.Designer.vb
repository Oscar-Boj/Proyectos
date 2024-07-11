<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class MenuA
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
        Dim resources As System.ComponentModel.ComponentResourceManager = New System.ComponentModel.ComponentResourceManager(GetType(MenuA))
        Me.btn_cerrarA = New System.Windows.Forms.Button()
        Me.Label1 = New System.Windows.Forms.Label()
        Me.btn_inicidenA = New System.Windows.Forms.Button()
        Me.btn_tareasA = New System.Windows.Forms.Button()
        Me.btn_equiposA = New System.Windows.Forms.Button()
        Me.btn_clientesA = New System.Windows.Forms.Button()
        Me.btn_usuariosA = New System.Windows.Forms.Button()
        Me.Panel1 = New System.Windows.Forms.Panel()
        Me.Label2 = New System.Windows.Forms.Label()
        Me.PictureBox1 = New System.Windows.Forms.PictureBox()
        Me.Panel1.SuspendLayout()
        CType(Me.PictureBox1, System.ComponentModel.ISupportInitialize).BeginInit()
        Me.SuspendLayout()
        '
        'btn_cerrarA
        '
        Me.btn_cerrarA.BackColor = System.Drawing.Color.Red
        Me.btn_cerrarA.Cursor = System.Windows.Forms.Cursors.Hand
        Me.btn_cerrarA.FlatStyle = System.Windows.Forms.FlatStyle.Popup
        Me.btn_cerrarA.Font = New System.Drawing.Font("Verdana", 9.75!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.btn_cerrarA.Location = New System.Drawing.Point(417, 3)
        Me.btn_cerrarA.Name = "btn_cerrarA"
        Me.btn_cerrarA.Size = New System.Drawing.Size(114, 25)
        Me.btn_cerrarA.TabIndex = 0
        Me.btn_cerrarA.Text = "Cerrar sesion"
        Me.btn_cerrarA.UseVisualStyleBackColor = False
        '
        'Label1
        '
        Me.Label1.AutoSize = True
        Me.Label1.BackColor = System.Drawing.Color.Transparent
        Me.Label1.Font = New System.Drawing.Font("Verdana", 26.25!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Label1.Location = New System.Drawing.Point(106, 14)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(297, 42)
        Me.Label1.TabIndex = 1
        Me.Label1.Text = "Administrador"
        '
        'btn_inicidenA
        '
        Me.btn_inicidenA.BackColor = System.Drawing.Color.FromArgb(CType(CType(93, Byte), Integer), CType(CType(109, Byte), Integer), CType(CType(126, Byte), Integer))
        Me.btn_inicidenA.Cursor = System.Windows.Forms.Cursors.Hand
        Me.btn_inicidenA.FlatStyle = System.Windows.Forms.FlatStyle.Popup
        Me.btn_inicidenA.Font = New System.Drawing.Font("Verdana", 12.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.btn_inicidenA.ForeColor = System.Drawing.Color.White
        Me.btn_inicidenA.Location = New System.Drawing.Point(41, 114)
        Me.btn_inicidenA.Name = "btn_inicidenA"
        Me.btn_inicidenA.Size = New System.Drawing.Size(162, 39)
        Me.btn_inicidenA.TabIndex = 2
        Me.btn_inicidenA.Text = "INCIDENCIAS"
        Me.btn_inicidenA.UseVisualStyleBackColor = False
        '
        'btn_tareasA
        '
        Me.btn_tareasA.BackColor = System.Drawing.Color.FromArgb(CType(CType(93, Byte), Integer), CType(CType(109, Byte), Integer), CType(CType(126, Byte), Integer))
        Me.btn_tareasA.Cursor = System.Windows.Forms.Cursors.Hand
        Me.btn_tareasA.FlatStyle = System.Windows.Forms.FlatStyle.Popup
        Me.btn_tareasA.Font = New System.Drawing.Font("Verdana", 12.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.btn_tareasA.ForeColor = System.Drawing.Color.White
        Me.btn_tareasA.Location = New System.Drawing.Point(41, 172)
        Me.btn_tareasA.Name = "btn_tareasA"
        Me.btn_tareasA.Size = New System.Drawing.Size(162, 39)
        Me.btn_tareasA.TabIndex = 3
        Me.btn_tareasA.Text = "TAREAS"
        Me.btn_tareasA.UseVisualStyleBackColor = False
        '
        'btn_equiposA
        '
        Me.btn_equiposA.BackColor = System.Drawing.Color.FromArgb(CType(CType(93, Byte), Integer), CType(CType(109, Byte), Integer), CType(CType(126, Byte), Integer))
        Me.btn_equiposA.Cursor = System.Windows.Forms.Cursors.Hand
        Me.btn_equiposA.FlatStyle = System.Windows.Forms.FlatStyle.Popup
        Me.btn_equiposA.Font = New System.Drawing.Font("Verdana", 12.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.btn_equiposA.ForeColor = System.Drawing.Color.White
        Me.btn_equiposA.Location = New System.Drawing.Point(338, 114)
        Me.btn_equiposA.Name = "btn_equiposA"
        Me.btn_equiposA.Size = New System.Drawing.Size(162, 39)
        Me.btn_equiposA.TabIndex = 4
        Me.btn_equiposA.Text = "EQUIPOS"
        Me.btn_equiposA.UseVisualStyleBackColor = False
        '
        'btn_clientesA
        '
        Me.btn_clientesA.BackColor = System.Drawing.Color.FromArgb(CType(CType(93, Byte), Integer), CType(CType(109, Byte), Integer), CType(CType(126, Byte), Integer))
        Me.btn_clientesA.Cursor = System.Windows.Forms.Cursors.Hand
        Me.btn_clientesA.FlatStyle = System.Windows.Forms.FlatStyle.Popup
        Me.btn_clientesA.Font = New System.Drawing.Font("Verdana", 12.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.btn_clientesA.ForeColor = System.Drawing.Color.White
        Me.btn_clientesA.Location = New System.Drawing.Point(338, 172)
        Me.btn_clientesA.Name = "btn_clientesA"
        Me.btn_clientesA.Size = New System.Drawing.Size(162, 39)
        Me.btn_clientesA.TabIndex = 5
        Me.btn_clientesA.Text = "CLIENTES"
        Me.btn_clientesA.UseVisualStyleBackColor = False
        '
        'btn_usuariosA
        '
        Me.btn_usuariosA.BackColor = System.Drawing.Color.FromArgb(CType(CType(93, Byte), Integer), CType(CType(109, Byte), Integer), CType(CType(126, Byte), Integer))
        Me.btn_usuariosA.Cursor = System.Windows.Forms.Cursors.Hand
        Me.btn_usuariosA.FlatStyle = System.Windows.Forms.FlatStyle.Popup
        Me.btn_usuariosA.Font = New System.Drawing.Font("Verdana", 12.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.btn_usuariosA.ForeColor = System.Drawing.Color.White
        Me.btn_usuariosA.Location = New System.Drawing.Point(189, 233)
        Me.btn_usuariosA.Name = "btn_usuariosA"
        Me.btn_usuariosA.Size = New System.Drawing.Size(162, 39)
        Me.btn_usuariosA.TabIndex = 6
        Me.btn_usuariosA.Text = "USUARIOS"
        Me.btn_usuariosA.UseVisualStyleBackColor = False
        '
        'Panel1
        '
        Me.Panel1.BackColor = System.Drawing.Color.FromArgb(CType(CType(84, Byte), Integer), CType(CType(153, Byte), Integer), CType(CType(199, Byte), Integer))
        Me.Panel1.Controls.Add(Me.Label2)
        Me.Panel1.Controls.Add(Me.PictureBox1)
        Me.Panel1.Controls.Add(Me.Label1)
        Me.Panel1.Controls.Add(Me.btn_cerrarA)
        Me.Panel1.Location = New System.Drawing.Point(0, 0)
        Me.Panel1.Name = "Panel1"
        Me.Panel1.Size = New System.Drawing.Size(534, 100)
        Me.Panel1.TabIndex = 13
        '
        'Label2
        '
        Me.Label2.AutoSize = True
        Me.Label2.Font = New System.Drawing.Font("Verdana", 12.0!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Label2.Location = New System.Drawing.Point(110, 63)
        Me.Label2.Name = "Label2"
        Me.Label2.Size = New System.Drawing.Size(104, 18)
        Me.Label2.TabIndex = 10
        Me.Label2.Text = "Bienvenido!"
        '
        'PictureBox1
        '
        Me.PictureBox1.BackgroundImage = CType(resources.GetObject("PictureBox1.BackgroundImage"), System.Drawing.Image)
        Me.PictureBox1.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch
        Me.PictureBox1.Location = New System.Drawing.Point(12, 14)
        Me.PictureBox1.Name = "PictureBox1"
        Me.PictureBox1.Size = New System.Drawing.Size(79, 73)
        Me.PictureBox1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.CenterImage
        Me.PictureBox1.TabIndex = 9
        Me.PictureBox1.TabStop = False
        '
        'MenuA
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch
        Me.ClientSize = New System.Drawing.Size(534, 311)
        Me.Controls.Add(Me.Panel1)
        Me.Controls.Add(Me.btn_usuariosA)
        Me.Controls.Add(Me.btn_clientesA)
        Me.Controls.Add(Me.btn_equiposA)
        Me.Controls.Add(Me.btn_tareasA)
        Me.Controls.Add(Me.btn_inicidenA)
        Me.Name = "MenuA"
        Me.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen
        Me.Text = "MenuA"
        Me.Panel1.ResumeLayout(False)
        Me.Panel1.PerformLayout()
        CType(Me.PictureBox1, System.ComponentModel.ISupportInitialize).EndInit()
        Me.ResumeLayout(False)

    End Sub

    Friend WithEvents btn_cerrarA As Button
    Friend WithEvents Label1 As Label
    Friend WithEvents btn_inicidenA As Button
    Friend WithEvents btn_tareasA As Button
    Friend WithEvents btn_equiposA As Button
    Friend WithEvents btn_clientesA As Button
    Friend WithEvents btn_usuariosA As Button
    Friend WithEvents Panel1 As Panel
    Friend WithEvents Label2 As Label
    Friend WithEvents PictureBox1 As PictureBox
End Class
