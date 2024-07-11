<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()>
Partial Class MenuInciT
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
        Me.Label1 = New System.Windows.Forms.Label()
        Me.btn_menuT = New System.Windows.Forms.Button()
        Me.btn_newinci = New System.Windows.Forms.Button()
        Me.Button1 = New System.Windows.Forms.Button()
        Me.Button2 = New System.Windows.Forms.Button()
        Me.SuspendLayout()
        '
        'Label1
        '
        Me.Label1.AutoSize = True
        Me.Label1.BackColor = System.Drawing.Color.Transparent
        Me.Label1.Font = New System.Drawing.Font("Verdana", 26.25!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Label1.Location = New System.Drawing.Point(151, 34)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(256, 42)
        Me.Label1.TabIndex = 9
        Me.Label1.Text = "Inicidencias"
        '
        'btn_menuT
        '
        Me.btn_menuT.BackColor = System.Drawing.Color.Red
        Me.btn_menuT.Cursor = System.Windows.Forms.Cursors.Hand
        Me.btn_menuT.FlatStyle = System.Windows.Forms.FlatStyle.Popup
        Me.btn_menuT.Font = New System.Drawing.Font("Verdana", 9.75!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.btn_menuT.Location = New System.Drawing.Point(415, 5)
        Me.btn_menuT.Name = "btn_menuT"
        Me.btn_menuT.Size = New System.Drawing.Size(114, 25)
        Me.btn_menuT.TabIndex = 10
        Me.btn_menuT.Text = "Menu"
        Me.btn_menuT.UseVisualStyleBackColor = False
        '
        'btn_newinci
        '
        Me.btn_newinci.BackColor = System.Drawing.Color.FromArgb(CType(CType(93, Byte), Integer), CType(CType(109, Byte), Integer), CType(CType(126, Byte), Integer))
        Me.btn_newinci.Cursor = System.Windows.Forms.Cursors.Hand
        Me.btn_newinci.FlatStyle = System.Windows.Forms.FlatStyle.Popup
        Me.btn_newinci.Font = New System.Drawing.Font("Verdana", 12.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.btn_newinci.ForeColor = System.Drawing.Color.White
        Me.btn_newinci.Location = New System.Drawing.Point(60, 127)
        Me.btn_newinci.Name = "btn_newinci"
        Me.btn_newinci.Size = New System.Drawing.Size(162, 55)
        Me.btn_newinci.TabIndex = 11
        Me.btn_newinci.Text = "DAR DE ALTA INCIDENCIAS"
        Me.btn_newinci.UseVisualStyleBackColor = False
        '
        'Button1
        '
        Me.Button1.BackColor = System.Drawing.Color.FromArgb(CType(CType(93, Byte), Integer), CType(CType(109, Byte), Integer), CType(CType(126, Byte), Integer))
        Me.Button1.Cursor = System.Windows.Forms.Cursors.Hand
        Me.Button1.FlatStyle = System.Windows.Forms.FlatStyle.Popup
        Me.Button1.Font = New System.Drawing.Font("Verdana", 12.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Button1.ForeColor = System.Drawing.Color.White
        Me.Button1.Location = New System.Drawing.Point(310, 127)
        Me.Button1.Name = "Button1"
        Me.Button1.Size = New System.Drawing.Size(162, 55)
        Me.Button1.TabIndex = 12
        Me.Button1.Text = "INCIDENCIAS ABIERTAS"
        Me.Button1.UseVisualStyleBackColor = False
        '
        'Button2
        '
        Me.Button2.BackColor = System.Drawing.Color.FromArgb(CType(CType(93, Byte), Integer), CType(CType(109, Byte), Integer), CType(CType(126, Byte), Integer))
        Me.Button2.Cursor = System.Windows.Forms.Cursors.Hand
        Me.Button2.FlatStyle = System.Windows.Forms.FlatStyle.Popup
        Me.Button2.Font = New System.Drawing.Font("Verdana", 12.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Button2.ForeColor = System.Drawing.Color.White
        Me.Button2.Location = New System.Drawing.Point(183, 208)
        Me.Button2.Name = "Button2"
        Me.Button2.Size = New System.Drawing.Size(162, 55)
        Me.Button2.TabIndex = 13
        Me.Button2.Text = "INCIDENCIAS"
        Me.Button2.UseVisualStyleBackColor = False
        '
        'MenuInciT
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch
        Me.ClientSize = New System.Drawing.Size(534, 311)
        Me.Controls.Add(Me.Button2)
        Me.Controls.Add(Me.Button1)
        Me.Controls.Add(Me.btn_newinci)
        Me.Controls.Add(Me.btn_menuT)
        Me.Controls.Add(Me.Label1)
        Me.Name = "MenuInciT"
        Me.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen
        Me.Text = "MenuInciT"
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub

    Friend WithEvents Label1 As Label
    Friend WithEvents btn_menuT As Button
    Friend WithEvents btn_newinci As Button
    Friend WithEvents Button1 As Button
    Friend WithEvents Button2 As Button
End Class
