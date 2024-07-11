<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class MenuT
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
        Dim resources As System.ComponentModel.ComponentResourceManager = New System.ComponentModel.ComponentResourceManager(GetType(MenuT))
        Me.btn_equiposE = New System.Windows.Forms.Button()
        Me.btn_tareasT = New System.Windows.Forms.Button()
        Me.btn_inicidenT = New System.Windows.Forms.Button()
        Me.Label1 = New System.Windows.Forms.Label()
        Me.btn_cerrarT = New System.Windows.Forms.Button()
        Me.Panel1 = New System.Windows.Forms.Panel()
        Me.Label2 = New System.Windows.Forms.Label()
        Me.PictureBox1 = New System.Windows.Forms.PictureBox()
        Me.btn_asistenciasT = New System.Windows.Forms.Button()
        Me.Panel1.SuspendLayout()
        CType(Me.PictureBox1, System.ComponentModel.ISupportInitialize).BeginInit()
        Me.SuspendLayout()
        '
        'btn_equiposE
        '
        Me.btn_equiposE.BackColor = System.Drawing.Color.FromArgb(CType(CType(93, Byte), Integer), CType(CType(109, Byte), Integer), CType(CType(126, Byte), Integer))
        Me.btn_equiposE.Cursor = System.Windows.Forms.Cursors.Hand
        Me.btn_equiposE.FlatStyle = System.Windows.Forms.FlatStyle.Popup
        Me.btn_equiposE.Font = New System.Drawing.Font("Verdana", 12.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.btn_equiposE.ForeColor = System.Drawing.Color.White
        Me.btn_equiposE.Location = New System.Drawing.Point(337, 139)
        Me.btn_equiposE.Name = "btn_equiposE"
        Me.btn_equiposE.Size = New System.Drawing.Size(162, 39)
        Me.btn_equiposE.TabIndex = 11
        Me.btn_equiposE.Text = "EQUIPOS"
        Me.btn_equiposE.UseVisualStyleBackColor = False
        '
        'btn_tareasT
        '
        Me.btn_tareasT.BackColor = System.Drawing.Color.FromArgb(CType(CType(93, Byte), Integer), CType(CType(109, Byte), Integer), CType(CType(126, Byte), Integer))
        Me.btn_tareasT.Cursor = System.Windows.Forms.Cursors.Hand
        Me.btn_tareasT.FlatStyle = System.Windows.Forms.FlatStyle.Popup
        Me.btn_tareasT.Font = New System.Drawing.Font("Verdana", 12.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.btn_tareasT.ForeColor = System.Drawing.Color.White
        Me.btn_tareasT.Location = New System.Drawing.Point(40, 211)
        Me.btn_tareasT.Name = "btn_tareasT"
        Me.btn_tareasT.Size = New System.Drawing.Size(162, 39)
        Me.btn_tareasT.TabIndex = 10
        Me.btn_tareasT.Text = "TAREAS"
        Me.btn_tareasT.UseVisualStyleBackColor = False
        '
        'btn_inicidenT
        '
        Me.btn_inicidenT.BackColor = System.Drawing.Color.FromArgb(CType(CType(93, Byte), Integer), CType(CType(109, Byte), Integer), CType(CType(126, Byte), Integer))
        Me.btn_inicidenT.Cursor = System.Windows.Forms.Cursors.Hand
        Me.btn_inicidenT.FlatStyle = System.Windows.Forms.FlatStyle.Popup
        Me.btn_inicidenT.Font = New System.Drawing.Font("Verdana", 12.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.btn_inicidenT.ForeColor = System.Drawing.Color.White
        Me.btn_inicidenT.Location = New System.Drawing.Point(40, 139)
        Me.btn_inicidenT.Name = "btn_inicidenT"
        Me.btn_inicidenT.Size = New System.Drawing.Size(162, 39)
        Me.btn_inicidenT.TabIndex = 9
        Me.btn_inicidenT.Text = "INCIDENCIAS"
        Me.btn_inicidenT.UseVisualStyleBackColor = False
        '
        'Label1
        '
        Me.Label1.AutoSize = True
        Me.Label1.BackColor = System.Drawing.Color.Transparent
        Me.Label1.Font = New System.Drawing.Font("Verdana", 26.25!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Label1.Location = New System.Drawing.Point(106, 14)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(168, 42)
        Me.Label1.TabIndex = 8
        Me.Label1.Text = "Técnico"
        '
        'btn_cerrarT
        '
        Me.btn_cerrarT.BackColor = System.Drawing.Color.Red
        Me.btn_cerrarT.Cursor = System.Windows.Forms.Cursors.Hand
        Me.btn_cerrarT.FlatStyle = System.Windows.Forms.FlatStyle.Popup
        Me.btn_cerrarT.Font = New System.Drawing.Font("Verdana", 9.75!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.btn_cerrarT.Location = New System.Drawing.Point(417, 3)
        Me.btn_cerrarT.Name = "btn_cerrarT"
        Me.btn_cerrarT.Size = New System.Drawing.Size(114, 25)
        Me.btn_cerrarT.TabIndex = 7
        Me.btn_cerrarT.Text = "Cerrar sesion"
        Me.btn_cerrarT.UseVisualStyleBackColor = False
        '
        'Panel1
        '
        Me.Panel1.BackColor = System.Drawing.Color.FromArgb(CType(CType(84, Byte), Integer), CType(CType(153, Byte), Integer), CType(CType(199, Byte), Integer))
        Me.Panel1.Controls.Add(Me.Label2)
        Me.Panel1.Controls.Add(Me.PictureBox1)
        Me.Panel1.Controls.Add(Me.Label1)
        Me.Panel1.Controls.Add(Me.btn_cerrarT)
        Me.Panel1.Location = New System.Drawing.Point(0, 0)
        Me.Panel1.Name = "Panel1"
        Me.Panel1.Size = New System.Drawing.Size(534, 100)
        Me.Panel1.TabIndex = 12
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
        'btn_asistenciasT
        '
        Me.btn_asistenciasT.BackColor = System.Drawing.Color.FromArgb(CType(CType(93, Byte), Integer), CType(CType(109, Byte), Integer), CType(CType(126, Byte), Integer))
        Me.btn_asistenciasT.Cursor = System.Windows.Forms.Cursors.Hand
        Me.btn_asistenciasT.FlatStyle = System.Windows.Forms.FlatStyle.Popup
        Me.btn_asistenciasT.Font = New System.Drawing.Font("Verdana", 12.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.btn_asistenciasT.ForeColor = System.Drawing.Color.White
        Me.btn_asistenciasT.Location = New System.Drawing.Point(337, 211)
        Me.btn_asistenciasT.Name = "btn_asistenciasT"
        Me.btn_asistenciasT.Size = New System.Drawing.Size(162, 39)
        Me.btn_asistenciasT.TabIndex = 13
        Me.btn_asistenciasT.Text = "ASISTENCIAS"
        Me.btn_asistenciasT.UseVisualStyleBackColor = False
        '
        'MenuT
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch
        Me.ClientSize = New System.Drawing.Size(534, 311)
        Me.Controls.Add(Me.btn_asistenciasT)
        Me.Controls.Add(Me.Panel1)
        Me.Controls.Add(Me.btn_equiposE)
        Me.Controls.Add(Me.btn_tareasT)
        Me.Controls.Add(Me.btn_inicidenT)
        Me.Name = "MenuT"
        Me.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen
        Me.Text = "MenuT"
        Me.Panel1.ResumeLayout(False)
        Me.Panel1.PerformLayout()
        CType(Me.PictureBox1, System.ComponentModel.ISupportInitialize).EndInit()
        Me.ResumeLayout(False)

    End Sub
    Friend WithEvents btn_equiposE As Button
    Friend WithEvents btn_tareasT As Button
    Friend WithEvents btn_inicidenT As Button
    Friend WithEvents Label1 As Label
    Friend WithEvents btn_cerrarT As Button
    Friend WithEvents Panel1 As Panel
    Friend WithEvents PictureBox1 As PictureBox
    Friend WithEvents Label2 As Label
    Friend WithEvents btn_asistenciasT As Button
End Class
