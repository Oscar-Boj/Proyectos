﻿<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class InicCrearT
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
        Dim resources As System.ComponentModel.ComponentResourceManager = New System.ComponentModel.ComponentResourceManager(GetType(InicCrearT))
        Me.Label3 = New System.Windows.Forms.Label()
        Me.txt_idcliente = New System.Windows.Forms.TextBox()
        Me.PictureBox1 = New System.Windows.Forms.PictureBox()
        Me.btn_menuT = New System.Windows.Forms.Button()
        Me.txt_incidencia = New System.Windows.Forms.TextBox()
        Me.Label2 = New System.Windows.Forms.Label()
        Me.btn_crearI = New System.Windows.Forms.Button()
        Me.DataGridView1 = New System.Windows.Forms.DataGridView()
        Me.Label1 = New System.Windows.Forms.Label()
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
        Me.Label3.Size = New System.Drawing.Size(92, 18)
        Me.Label3.TabIndex = 38
        Me.Label3.Text = "Id Cliente"
        '
        'txt_idcliente
        '
        Me.txt_idcliente.Font = New System.Drawing.Font("Verdana", 12.0!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.txt_idcliente.Location = New System.Drawing.Point(509, 113)
        Me.txt_idcliente.Name = "txt_idcliente"
        Me.txt_idcliente.Size = New System.Drawing.Size(219, 27)
        Me.txt_idcliente.TabIndex = 37
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
        Me.PictureBox1.TabIndex = 36
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
        Me.btn_menuT.TabIndex = 35
        Me.btn_menuT.Text = "Menu"
        Me.btn_menuT.UseVisualStyleBackColor = False
        '
        'txt_incidencia
        '
        Me.txt_incidencia.Font = New System.Drawing.Font("Verdana", 12.0!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.txt_incidencia.Location = New System.Drawing.Point(407, 190)
        Me.txt_incidencia.Multiline = True
        Me.txt_incidencia.Name = "txt_incidencia"
        Me.txt_incidencia.Size = New System.Drawing.Size(321, 162)
        Me.txt_incidencia.TabIndex = 34
        '
        'Label2
        '
        Me.Label2.AutoSize = True
        Me.Label2.BackColor = System.Drawing.Color.Transparent
        Me.Label2.Font = New System.Drawing.Font("Verdana", 12.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Label2.Location = New System.Drawing.Point(404, 169)
        Me.Label2.Name = "Label2"
        Me.Label2.Size = New System.Drawing.Size(108, 18)
        Me.Label2.TabIndex = 33
        Me.Label2.Text = "Descripcion"
        '
        'btn_crearI
        '
        Me.btn_crearI.BackColor = System.Drawing.Color.FromArgb(CType(CType(93, Byte), Integer), CType(CType(109, Byte), Integer), CType(CType(126, Byte), Integer))
        Me.btn_crearI.FlatStyle = System.Windows.Forms.FlatStyle.Popup
        Me.btn_crearI.Font = New System.Drawing.Font("Verdana", 12.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.btn_crearI.ForeColor = System.Drawing.Color.White
        Me.btn_crearI.Location = New System.Drawing.Point(509, 374)
        Me.btn_crearI.Name = "btn_crearI"
        Me.btn_crearI.Size = New System.Drawing.Size(132, 64)
        Me.btn_crearI.TabIndex = 32
        Me.btn_crearI.Text = "AGREGAR INCIDENCIA"
        Me.btn_crearI.UseVisualStyleBackColor = False
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
        Me.Label1.Size = New System.Drawing.Size(401, 42)
        Me.Label1.TabIndex = 30
        Me.Label1.Text = "Incidencias Nuevas"
        '
        'InicCrearT
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(761, 450)
        Me.Controls.Add(Me.Label3)
        Me.Controls.Add(Me.txt_idcliente)
        Me.Controls.Add(Me.PictureBox1)
        Me.Controls.Add(Me.btn_menuT)
        Me.Controls.Add(Me.txt_incidencia)
        Me.Controls.Add(Me.Label2)
        Me.Controls.Add(Me.btn_crearI)
        Me.Controls.Add(Me.DataGridView1)
        Me.Controls.Add(Me.Label1)
        Me.Name = "InicCrearT"
        Me.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen
        Me.Text = "InicCrearT"
        CType(Me.PictureBox1, System.ComponentModel.ISupportInitialize).EndInit()
        CType(Me.DataGridView1, System.ComponentModel.ISupportInitialize).EndInit()
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub

    Friend WithEvents Label3 As Label
    Friend WithEvents txt_idcliente As TextBox
    Friend WithEvents PictureBox1 As PictureBox
    Friend WithEvents btn_menuT As Button
    Friend WithEvents txt_incidencia As TextBox
    Friend WithEvents Label2 As Label
    Friend WithEvents btn_crearI As Button
    Friend WithEvents DataGridView1 As DataGridView
    Friend WithEvents Label1 As Label
End Class
