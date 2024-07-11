<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()>
Partial Class ClientesR
    Inherits System.Windows.Forms.Form

    'Form reemplaza a Dispose para limpiar la lista de componentes.
    <System.Diagnostics.DebuggerNonUserCode()>
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
    <System.Diagnostics.DebuggerStepThrough()>
    Private Sub InitializeComponent()
        Dim resources As System.ComponentModel.ComponentResourceManager = New System.ComponentModel.ComponentResourceManager(GetType(ClientesR))
        Me.btn_modificarC = New System.Windows.Forms.Button()
        Me.Label4 = New System.Windows.Forms.Label()
        Me.txt_nombreC = New System.Windows.Forms.TextBox()
        Me.Label3 = New System.Windows.Forms.Label()
        Me.txt_idcliente = New System.Windows.Forms.TextBox()
        Me.PictureBox1 = New System.Windows.Forms.PictureBox()
        Me.btn_menuT = New System.Windows.Forms.Button()
        Me.Label2 = New System.Windows.Forms.Label()
        Me.btn_borrarC = New System.Windows.Forms.Button()
        Me.btn_crearC = New System.Windows.Forms.Button()
        Me.DataGridView1 = New System.Windows.Forms.DataGridView()
        Me.Label1 = New System.Windows.Forms.Label()
        Me.Label5 = New System.Windows.Forms.Label()
        Me.txt_telC = New System.Windows.Forms.TextBox()
        Me.txt_correoC = New System.Windows.Forms.TextBox()
        CType(Me.PictureBox1, System.ComponentModel.ISupportInitialize).BeginInit()
        CType(Me.DataGridView1, System.ComponentModel.ISupportInitialize).BeginInit()
        Me.SuspendLayout()
        '
        'btn_modificarC
        '
        Me.btn_modificarC.BackColor = System.Drawing.Color.FromArgb(CType(CType(93, Byte), Integer), CType(CType(109, Byte), Integer), CType(CType(126, Byte), Integer))
        Me.btn_modificarC.FlatStyle = System.Windows.Forms.FlatStyle.Popup
        Me.btn_modificarC.Font = New System.Drawing.Font("Verdana", 12.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.btn_modificarC.ForeColor = System.Drawing.Color.White
        Me.btn_modificarC.Location = New System.Drawing.Point(591, 324)
        Me.btn_modificarC.Name = "btn_modificarC"
        Me.btn_modificarC.Size = New System.Drawing.Size(133, 48)
        Me.btn_modificarC.TabIndex = 55
        Me.btn_modificarC.Text = "MODIFICAR CLIENTE"
        Me.btn_modificarC.UseVisualStyleBackColor = False
        '
        'Label4
        '
        Me.Label4.AutoSize = True
        Me.Label4.BackColor = System.Drawing.Color.Transparent
        Me.Label4.Font = New System.Drawing.Font("Verdana", 12.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Label4.Location = New System.Drawing.Point(400, 173)
        Me.Label4.Name = "Label4"
        Me.Label4.Size = New System.Drawing.Size(78, 18)
        Me.Label4.TabIndex = 54
        Me.Label4.Text = "Nombre"
        '
        'txt_nombreC
        '
        Me.txt_nombreC.Font = New System.Drawing.Font("Verdana", 12.0!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.txt_nombreC.Location = New System.Drawing.Point(505, 170)
        Me.txt_nombreC.Name = "txt_nombreC"
        Me.txt_nombreC.Size = New System.Drawing.Size(219, 27)
        Me.txt_nombreC.TabIndex = 53
        '
        'Label3
        '
        Me.Label3.AutoSize = True
        Me.Label3.BackColor = System.Drawing.Color.Transparent
        Me.Label3.Font = New System.Drawing.Font("Verdana", 12.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Label3.Location = New System.Drawing.Point(400, 120)
        Me.Label3.Name = "Label3"
        Me.Label3.Size = New System.Drawing.Size(92, 18)
        Me.Label3.TabIndex = 52
        Me.Label3.Text = "Id Cliente"
        '
        'txt_idcliente
        '
        Me.txt_idcliente.Font = New System.Drawing.Font("Verdana", 12.0!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.txt_idcliente.Location = New System.Drawing.Point(505, 117)
        Me.txt_idcliente.Name = "txt_idcliente"
        Me.txt_idcliente.Size = New System.Drawing.Size(219, 27)
        Me.txt_idcliente.TabIndex = 51
        '
        'PictureBox1
        '
        Me.PictureBox1.BackColor = System.Drawing.Color.Transparent
        Me.PictureBox1.BackgroundImage = CType(resources.GetObject("PictureBox1.BackgroundImage"), System.Drawing.Image)
        Me.PictureBox1.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch
        Me.PictureBox1.Location = New System.Drawing.Point(8, 13)
        Me.PictureBox1.Name = "PictureBox1"
        Me.PictureBox1.Size = New System.Drawing.Size(79, 73)
        Me.PictureBox1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.CenterImage
        Me.PictureBox1.TabIndex = 50
        Me.PictureBox1.TabStop = False
        '
        'btn_menuT
        '
        Me.btn_menuT.BackColor = System.Drawing.Color.Red
        Me.btn_menuT.Cursor = System.Windows.Forms.Cursors.Hand
        Me.btn_menuT.FlatStyle = System.Windows.Forms.FlatStyle.Popup
        Me.btn_menuT.Font = New System.Drawing.Font("Verdana", 9.75!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.btn_menuT.Location = New System.Drawing.Point(639, 8)
        Me.btn_menuT.Name = "btn_menuT"
        Me.btn_menuT.Size = New System.Drawing.Size(114, 25)
        Me.btn_menuT.TabIndex = 49
        Me.btn_menuT.Text = "Menu"
        Me.btn_menuT.UseVisualStyleBackColor = False
        '
        'Label2
        '
        Me.Label2.AutoSize = True
        Me.Label2.BackColor = System.Drawing.Color.Transparent
        Me.Label2.Font = New System.Drawing.Font("Verdana", 12.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Label2.Location = New System.Drawing.Point(400, 221)
        Me.Label2.Name = "Label2"
        Me.Label2.Size = New System.Drawing.Size(86, 18)
        Me.Label2.TabIndex = 47
        Me.Label2.Text = "Telefono"
        '
        'btn_borrarC
        '
        Me.btn_borrarC.BackColor = System.Drawing.Color.FromArgb(CType(CType(93, Byte), Integer), CType(CType(109, Byte), Integer), CType(CType(126, Byte), Integer))
        Me.btn_borrarC.FlatStyle = System.Windows.Forms.FlatStyle.Popup
        Me.btn_borrarC.Font = New System.Drawing.Font("Verdana", 12.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.btn_borrarC.ForeColor = System.Drawing.Color.White
        Me.btn_borrarC.Location = New System.Drawing.Point(404, 378)
        Me.btn_borrarC.Name = "btn_borrarC"
        Me.btn_borrarC.Size = New System.Drawing.Size(133, 48)
        Me.btn_borrarC.TabIndex = 46
        Me.btn_borrarC.Text = "ELIMINAR CLIENTE"
        Me.btn_borrarC.UseVisualStyleBackColor = False
        '
        'btn_crearC
        '
        Me.btn_crearC.BackColor = System.Drawing.Color.FromArgb(CType(CType(93, Byte), Integer), CType(CType(109, Byte), Integer), CType(CType(126, Byte), Integer))
        Me.btn_crearC.FlatStyle = System.Windows.Forms.FlatStyle.Popup
        Me.btn_crearC.Font = New System.Drawing.Font("Verdana", 12.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.btn_crearC.ForeColor = System.Drawing.Color.White
        Me.btn_crearC.Location = New System.Drawing.Point(404, 324)
        Me.btn_crearC.Name = "btn_crearC"
        Me.btn_crearC.Size = New System.Drawing.Size(133, 48)
        Me.btn_crearC.TabIndex = 45
        Me.btn_crearC.Text = "AGREGAR CLIENTE"
        Me.btn_crearC.UseVisualStyleBackColor = False
        '
        'DataGridView1
        '
        Me.DataGridView1.AutoSizeColumnsMode = System.Windows.Forms.DataGridViewAutoSizeColumnsMode.AllCells
        Me.DataGridView1.BackgroundColor = System.Drawing.Color.White
        Me.DataGridView1.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize
        Me.DataGridView1.Location = New System.Drawing.Point(8, 118)
        Me.DataGridView1.Name = "DataGridView1"
        Me.DataGridView1.Size = New System.Drawing.Size(360, 324)
        Me.DataGridView1.TabIndex = 44
        '
        'Label1
        '
        Me.Label1.AutoSize = True
        Me.Label1.BackColor = System.Drawing.Color.Transparent
        Me.Label1.Font = New System.Drawing.Font("Verdana", 26.25!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Label1.Location = New System.Drawing.Point(93, 13)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(175, 42)
        Me.Label1.TabIndex = 43
        Me.Label1.Text = "Clientes"
        '
        'Label5
        '
        Me.Label5.AutoSize = True
        Me.Label5.BackColor = System.Drawing.Color.Transparent
        Me.Label5.Font = New System.Drawing.Font("Verdana", 12.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Label5.Location = New System.Drawing.Point(400, 272)
        Me.Label5.Name = "Label5"
        Me.Label5.Size = New System.Drawing.Size(69, 18)
        Me.Label5.TabIndex = 56
        Me.Label5.Text = "Correo"
        '
        'txt_telC
        '
        Me.txt_telC.Font = New System.Drawing.Font("Verdana", 12.0!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.txt_telC.Location = New System.Drawing.Point(505, 218)
        Me.txt_telC.Name = "txt_telC"
        Me.txt_telC.Size = New System.Drawing.Size(219, 27)
        Me.txt_telC.TabIndex = 57
        '
        'txt_correoC
        '
        Me.txt_correoC.Font = New System.Drawing.Font("Verdana", 12.0!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.txt_correoC.Location = New System.Drawing.Point(505, 269)
        Me.txt_correoC.Name = "txt_correoC"
        Me.txt_correoC.Size = New System.Drawing.Size(219, 27)
        Me.txt_correoC.TabIndex = 58
        '
        'ClientesR
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(761, 450)
        Me.Controls.Add(Me.txt_correoC)
        Me.Controls.Add(Me.txt_telC)
        Me.Controls.Add(Me.Label5)
        Me.Controls.Add(Me.btn_modificarC)
        Me.Controls.Add(Me.Label4)
        Me.Controls.Add(Me.txt_nombreC)
        Me.Controls.Add(Me.Label3)
        Me.Controls.Add(Me.txt_idcliente)
        Me.Controls.Add(Me.PictureBox1)
        Me.Controls.Add(Me.btn_menuT)
        Me.Controls.Add(Me.Label2)
        Me.Controls.Add(Me.btn_borrarC)
        Me.Controls.Add(Me.btn_crearC)
        Me.Controls.Add(Me.DataGridView1)
        Me.Controls.Add(Me.Label1)
        Me.Name = "ClientesR"
        Me.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen
        Me.Text = "ClientesR"
        CType(Me.PictureBox1, System.ComponentModel.ISupportInitialize).EndInit()
        CType(Me.DataGridView1, System.ComponentModel.ISupportInitialize).EndInit()
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub

    Friend WithEvents btn_modificarC As Button
    Friend WithEvents Label4 As Label
    Friend WithEvents txt_nombreC As TextBox
    Friend WithEvents Label3 As Label
    Friend WithEvents txt_idcliente As TextBox
    Friend WithEvents PictureBox1 As PictureBox
    Friend WithEvents btn_menuT As Button
    Friend WithEvents Label2 As Label
    Friend WithEvents btn_borrarC As Button
    Friend WithEvents btn_crearC As Button
    Friend WithEvents DataGridView1 As DataGridView
    Friend WithEvents Label1 As Label
    Friend WithEvents Label5 As Label
    Friend WithEvents txt_telC As TextBox
    Friend WithEvents txt_correoC As TextBox
End Class
