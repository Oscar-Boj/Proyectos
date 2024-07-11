package alpha.v1;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
//Libreria de Swing
import javax.swing.*;
//Libreria de SQL
import java.text.DateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.util.regex.Pattern;


public class admin extends JFrame{
   private JTable tablaUsuarios;
   private JLabel imglogin, imgproll, imgusu, imgTcuenta, imgcuenta, imgtransaccion;
    private DefaultTableModel modeloTabla;
    private JTextField txtCdes,ttxcorr,txttell,txtcontra,txtpinl, txtDPIdep,txtDPIdep1,txtncuenta,txtTcuenta,txtFechadep,txtmontodep,txtDPIsaldo,txtnoCs,txtsaldo,txtDPIcuenta,txtnoC,txtTC,txtDPIusu,txtusuario,txtRoll,txtdpiinfo,txtdpi,txtpin,txtpass,txtnombre,txtapellido,txtCorreo,txttelefono;
    private Font font1 = new Font("Arial", Font.BOLD, 16);
    private Font font2 = new Font("Arial", Font.BOLD, 14);
    private Font font3 = new Font("Arial", Font.BOLD, 18);
    private Font font4 = new Font("Arial", Font.BOLD, 46);
    private Font font5 = new Font("Arial", Font.BOLD, 20);
    private Font font6 = new Font("Arial", Font.BOLD, 25);
    
    public admin(){
        this.setLayout(null);
        this.setTitle("ADMINISTRADOR");
        this.setSize(1000, 700);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.decode("#121212"));
        this.inicializar();
    }
    public void panel(){
        //Panel Login
        JPanel Plogin = new JPanel();
        Plogin.setLayout(null);
        Plogin.setBackground(Color.white);
        add(Plogin);
        //Login guardar datos
        JLabel titulo = new JLabel("USUARIO");
        titulo.setFont(font6);
        titulo.setBounds(200, 15, 160, 30);
        JLabel lbldpi = new JLabel("DPI:");
        lbldpi.setFont(font1);
        lbldpi.setBounds(50, 65, 100, 30);
        JLabel lblpin = new JLabel("Nombre:");
        lblpin.setFont(font1);
        lblpin.setBounds(50, 100, 100, 30);
        JLabel lblpass = new JLabel("Apellido:");
        lblpass.setFont(font1);
        lblpass.setBounds(50, 135, 100, 30);
        JLabel lblcorr = new JLabel("Correo:");
        lblcorr.setFont(font1);
        lblcorr.setBounds(50, 170, 100, 30);
        ttxcorr = new JTextField();
        ttxcorr.setDocument(new CustomDoc(13));
        ttxcorr.setBounds(150, 170, 250, 30);
        Plogin.add(ttxcorr);
        Plogin.add(lblcorr);
        JLabel lbltel = new JLabel("Telefono:");
        lbltel.setFont(font1);
        
        lbltel.setBounds(50, 205, 100, 30);
        txttell = new JTextField();
        txttell.setBounds(150, 205, 250, 30);
        Plogin.add(txttell);
        Plogin.add(lbltel);
        JLabel lblcontra = new JLabel("Contraseña:");
        lblcontra.setFont(font1);
        lblcontra.setBounds(50, 240, 100, 30);
        txtcontra = new JTextField();
        txtcontra.setBounds(150, 240, 250, 30);
        Plogin.add(txtcontra);
        Plogin.add(lblcontra);
        JLabel lblpin1 = new JLabel("PIN:");
        lblpin1.setFont(font1);
        lblpin1.setBounds(50, 275, 100, 30);
        txtpinl = new JTextField();
        txtpinl.setBounds(150, 275, 250, 30);
        Plogin.add(txtpinl);
        Plogin.add(lblpin1);
       
        txtdpi = new JTextField();
        txtdpi.setBounds(150, 65, 250, 30);
        txtpin = new JTextField();
        txtpin.setBounds(150, 100, 250, 30);
        txtpass = new JTextField();
        txtpass.setBounds(150, 135, 250, 30);
        //funciones
        JButton btneliminarL = new JButton("Eliminar");
        btneliminarL.setBackground(Color.decode("#121212"));
        btneliminarL.setFont(font2);
        btneliminarL.setForeground(Color.WHITE);
        btneliminarL.setBorder(null);
        btneliminarL.setFocusable(false);
        btneliminarL.setBounds(50, 320, 100, 30);
        btneliminarL.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {     
                eliminarlogin();
                cargarDatos();
            }
        }); 
        JButton btnactualizarL = new JButton("Actualizar");
        btnactualizarL.setBackground(Color.decode("#121212"));
        btnactualizarL.setFont(font2);
        btnactualizarL.setForeground(Color.WHITE);
        btnactualizarL.setBorder(null);
        btnactualizarL.setFocusable(false);
        btnactualizarL.setBounds(185, 320, 100, 30);
        btneliminarL.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {     
                actualizarlogin();
                cargarDatos();
            }
        }); 
        JButton btningresarL = new JButton("Insertar");
        btningresarL.setBackground(Color.decode("#121212"));
        btningresarL.setFont(font2);
        btningresarL.setForeground(Color.WHITE);
        btningresarL.setBorder(null);
        btningresarL.setFocusable(false);
        btningresarL.setBounds(320, 320, 100, 30);
        btningresarL.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {     
                ingresarlogin();
                cargarDatos();
            }
        }); 
        Plogin.setLayout(null);
        Plogin.setBounds(380,300,490,420);     
        // Plogin.setBackground(Color.white);      
        Plogin.setBackground(new Color(255, 255, 255, 160));     
        Plogin.setOpaque(true);
        Plogin.add(titulo);
        Plogin.add(txtpin);
        Plogin.add(txtdpi);
        Plogin.add(txtpass);
        Plogin.add(txtdpi);
        Plogin.add(lbldpi);
        Plogin.add(lblpin);
        Plogin.add(lblpass);
        Plogin.add(btneliminarL);
        Plogin.add(btnactualizarL);
        Plogin.add(btningresarL);
        Plogin.setVisible(false);
        this.add(Plogin);
        //panel roles
        JButton btneliminarinfo = new JButton("Eliminar");
        btneliminarinfo.setBackground(Color.decode("#121212"));
        btneliminarinfo.setFont(font2);
        btneliminarinfo.setForeground(Color.WHITE);
        btneliminarinfo.setBorder(null);
        btneliminarinfo.setFocusable(false);
        btneliminarinfo.setBounds(50, 300, 100, 30);
        btneliminarinfo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {     
                eliminarinfo();
                cargarDatos2();
            }
        }); 
        JButton btnactualizarinfo = new JButton("Actualizar");
        btnactualizarinfo.setBackground(Color.decode("#121212"));
        btnactualizarinfo.setFont(font2);
        btnactualizarinfo.setForeground(Color.WHITE);
        btnactualizarinfo.setBorder(null);
        btnactualizarinfo.setFocusable(false);
        btnactualizarinfo.setBounds(185, 300, 100, 30);
         btnactualizarinfo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {     
                actualizarinfo();
                cargarDatos2();
            }
        }); 
        JButton ingresarinfo = new JButton("Insertar");
        ingresarinfo.setBackground(Color.decode("#121212"));
        ingresarinfo.setFont(font2);
        ingresarinfo.setForeground(Color.WHITE);
        ingresarinfo.setBorder(null);
        ingresarinfo.setFocusable(false);
        ingresarinfo.setBounds(320, 300, 100, 30);
         ingresarinfo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {     
                ingresarinfo();
                cargarDatos2();
            }
        }); 
        txtnombre = new JTextField();
        txtnombre.setBounds(150, 60, 250, 30);
        txtapellido = new JTextField();
        txtapellido.setBounds(150, 100, 250, 30);
        txtdpiinfo = new JTextField();
        txtdpiinfo.setBounds(150, 140, 250, 30);
        txtCorreo = new JTextField();
        txtCorreo.setBounds(150, 180, 250, 30);
        txttelefono = new JTextField();
        txttelefono.setBounds(150, 230, 250, 30);
        JPanel paninfol = new JPanel();
        paninfol.setBackground(new Color(255, 255, 255, 160));     
        paninfol.setOpaque(true);
        paninfol.setBounds(380,300,490,420);     
        paninfol.setLayout(null);
        
        JLabel nombrei = new JLabel("Id Rol:");
        nombrei.setFont(font1);
        nombrei.setBounds(50, 100, 100, 30);
        JLabel teli = new JLabel("Nombre:");
        teli.setFont(font1);
        teli.setBounds(50, 140, 100, 30);
        JLabel lblinfo = new JLabel("ROLES");
        lblinfo.setFont(font6);
        lblinfo.setBounds(210, 15, 190, 30);       
        paninfol.add(btneliminarinfo);
        paninfol.add(btnactualizarinfo);
        paninfol.add(ingresarinfo);
        paninfol.add(lblinfo);
        paninfol.add(txtapellido);
        paninfol.add(txtdpiinfo);
        paninfol.add(nombrei);
        paninfol.add(teli);
        add(paninfol);
        paninfol.setVisible(false);
        //Panel usuarios
        JPanel panusuarios = new JPanel();
        panusuarios.setBackground(new Color(255, 255, 255, 160));     
        panusuarios.setOpaque(true);
        panusuarios.setBounds(380,300,490,420);     
        panusuarios.setLayout(null);
        panusuarios.setVisible(true);
        //labels
        JLabel lblDPIusuarios = new JLabel("DPI:");
        lblDPIusuarios.setFont(font1);
        lblDPIusuarios.setBounds(50, 100, 100, 30);
        JLabel lblusuariost = new JLabel("Id Rol:");
        lblusuariost.setFont(font1);
        lblusuariost.setBounds(50, 140, 100, 30);
        JLabel lblusuarios = new JLabel("ROLES DE USUARIO");
        lblusuarios.setFont(font6);
        lblusuarios.setBounds(115, 15, 300, 30);
        txtDPIusu = new JTextField();
        txtDPIusu.setBounds(150, 100, 250, 30);
        txtusuario = new JTextField();
        txtusuario.setBounds(150, 140, 250, 30);
        //bototnes usuarios
        JButton btneliminarusuario = new JButton("Eliminar");
        btneliminarusuario.setBackground(Color.decode("#121212"));
        btneliminarusuario.setFont(font2);
        btneliminarusuario.setForeground(Color.WHITE);
        btneliminarusuario.setBorder(null);
        btneliminarusuario.setFocusable(false);
        btneliminarusuario.setBounds(50, 300, 100, 30);
        btneliminarusuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {     
                eliminarusuarios();
                cargarDatos3();
            }
        }); 
        
        JButton btnactualizarusuario= new JButton("Actualizar");
        btnactualizarusuario.setBackground(Color.decode("#121212"));
        btnactualizarusuario.setFont(font2);
        btnactualizarusuario.setForeground(Color.WHITE);
        btnactualizarusuario.setBorder(null);
        btnactualizarusuario.setFocusable(false);
        btnactualizarusuario.setBounds(185, 300, 100, 30);
        btnactualizarusuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {     
                actualizarusuarios();
                cargarDatos3();
            }
        }); 
        JButton ingresarusuario = new JButton("Insertar");
        ingresarusuario.setBackground(Color.decode("#121212"));
        ingresarusuario.setFont(font2);
        ingresarusuario.setForeground(Color.WHITE);
        ingresarusuario.setBorder(null);
        ingresarusuario.setFocusable(false);
        ingresarusuario.setBounds(320, 300, 100, 30);
        ingresarusuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {     
                ingresarusuarios();
                cargarDatos3();
            }
        }); 
        //panel rollusuario
        JPanel Pcuentas = new JPanel();
        Pcuentas.setBackground(new Color(255, 255, 255, 160));     
        Pcuentas.setOpaque(true);
        Pcuentas.setBounds(380,300,490,420);     
        Pcuentas.setLayout(null);
        Pcuentas.setVisible(false);
        JLabel Cuentas = new JLabel("TIPOS DE CUENTA");
        Cuentas.setFont(font6);
        Cuentas.setBounds(130, 15, 300, 30);
        JLabel lbldpicuenta = new JLabel("Id Cuenta:");
        lbldpicuenta.setFont(font1);
        lbldpicuenta.setBounds(50, 100, 190, 30);
        JLabel lblbuncuenta = new JLabel("Nombre:");
        lblbuncuenta.setFont(font1);
        lblbuncuenta.setBounds(50, 140, 120, 30);
        txtDPIcuenta = new JTextField();
        txtDPIcuenta.setBounds(150, 100, 250, 30);
        txtnoC = new JTextField();
        txtnoC.setBounds(150, 140, 250, 30);
         JButton btneliminarcuenta = new JButton("Eliminar");
        btneliminarcuenta.setBackground(Color.decode("#121212"));
        btneliminarcuenta.setFont(font2);
        btneliminarcuenta.setForeground(Color.WHITE);
        btneliminarcuenta.setBorder(null);
        btneliminarcuenta.setFocusable(false);
        btneliminarcuenta.setBounds(50, 300, 100, 30);
        btneliminarcuenta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {     
                eliminarcuentas1();
                cargarDatos4();
            }
        }); 
        
        JButton btnactualizarcuenta= new JButton("Actualizar");
        btnactualizarcuenta.setBackground(Color.decode("#121212"));
        btnactualizarcuenta.setFont(font2);
        btnactualizarcuenta.setForeground(Color.WHITE);
        btnactualizarcuenta.setBorder(null);
        btnactualizarcuenta.setFocusable(false);
        btnactualizarcuenta.setBounds(185, 300, 100, 30);
        btnactualizarcuenta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {     
                actualizarcuentas1();
                cargarDatos4();
            }
        }); 
        JButton ingresarcuenta= new JButton("Insertar");
        ingresarcuenta.setBackground(Color.decode("#121212"));
        ingresarcuenta.setFont(font2);
        ingresarcuenta.setForeground(Color.WHITE);
        ingresarcuenta.setBorder(null);
        ingresarcuenta.setFocusable(false);
        ingresarcuenta.setBounds(320, 300, 100, 30);
        ingresarcuenta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {     
                ingresarcuentas1();
                cargarDatos4();
            }
        }); 
       
        Pcuentas.add(Cuentas);
        Pcuentas.add(lbldpicuenta);
        Pcuentas.add(lblbuncuenta);
        Pcuentas.add(txtDPIcuenta);
        Pcuentas.add(txtnoC);
        Pcuentas.add(ingresarcuenta);
        Pcuentas.add(btnactualizarcuenta);
        Pcuentas.add(btneliminarcuenta);
        add(Pcuentas);
        //Panel saldos
        JPanel Psaldos = new JPanel();
        Psaldos.setBackground(new Color(255, 255, 255, 160));     
        Psaldos.setOpaque(true);
        Psaldos.setBounds(380,300,490,420);     
        Psaldos.setLayout(null);
        Psaldos.setVisible(false);
        JLabel saldos = new JLabel("CUENTAS");
        saldos.setFont(font6);
        saldos.setBounds(190, 15, 160, 30);
        JLabel lbldpiS = new JLabel("No. Cuenta:");
        lbldpiS.setFont(font1);
        lbldpiS.setBounds(50, 80, 120, 30);
        JLabel lblNC1 = new JLabel("DPI:");
        lblNC1.setFont(font1);
        lblNC1.setBounds(50, 130, 120, 30);
        JLabel lblsaldo = new JLabel("Id T. Cuenta:");
        lblsaldo.setFont(font1);
        lblsaldo.setBounds(50, 180, 120, 30);
        //txtDPIsaldo,txtnoCs,txtsaldo
        txtDPIsaldo = new JTextField();
        txtDPIsaldo.setBounds(150, 80, 250, 30);
        txtnoCs = new JTextField();
        txtnoCs.setBounds(150, 130, 250, 30);
        txtsaldo = new JTextField();
        txtsaldo.setBounds(150, 180, 250, 30);
        JButton btneliminarsaldo = new JButton("Eliminar");
        btneliminarsaldo.setBackground(Color.decode("#121212"));
        btneliminarsaldo.setFont(font2);
        btneliminarsaldo.setForeground(Color.WHITE);
        btneliminarsaldo.setBorder(null);
        btneliminarsaldo.setFocusable(false);
        btneliminarsaldo.setBounds(50, 300, 100, 30);
        btneliminarsaldo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {     
                eliminarsaldo1();
                cargarDatos5();
            }
        }); 
        
        JButton btnactualizarsaldo = new JButton("Actualizar");
        btnactualizarsaldo.setBackground(Color.decode("#121212"));
        btnactualizarsaldo.setFont(font2);
        btnactualizarsaldo.setForeground(Color.WHITE);
        btnactualizarsaldo.setBorder(null);
        btnactualizarsaldo.setFocusable(false);
        btnactualizarsaldo.setBounds(185, 300, 100, 30);
        btnactualizarsaldo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {     
                actualizarsaldo1();
                cargarDatos5();
            }
        }); 
        JButton ingresarsaldo = new JButton("Insertar");
        ingresarsaldo.setBackground(Color.decode("#121212"));
        ingresarsaldo.setFont(font2);
        ingresarsaldo.setForeground(Color.WHITE);
        ingresarsaldo.setBorder(null);
        ingresarsaldo.setFocusable(false);
        ingresarsaldo.setBounds(320, 300, 100, 30);
        ingresarsaldo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {     
                ingresarsaldo1();
                cargarDatos5();
            }
        }); 
        Psaldos.add(saldos);
        Psaldos.add(lbldpiS);
        Psaldos.add(lblNC1);
        Psaldos.add(lblsaldo);
        Psaldos.add(txtDPIsaldo);
        Psaldos.add(txtnoCs);
        Psaldos.add(txtsaldo);
        Psaldos.add(btneliminarsaldo);
        Psaldos.add(btnactualizarsaldo);
        Psaldos.add(ingresarsaldo);
        add(Psaldos);
        //panel deposito
        JButton btneliminardeposito = new JButton("Eliminar");
        btneliminardeposito.setBackground(Color.decode("#121212"));
        btneliminardeposito.setFont(font2);
        btneliminardeposito.setForeground(Color.WHITE);
        btneliminardeposito.setBorder(null);
        btneliminardeposito.setFocusable(false);
        btneliminardeposito.setBounds(50, 320, 100, 30);
        btneliminardeposito.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {     
                eliminardep();
                cargarDatos6();
            }
        }); 
        JButton btnactualizardeposito = new JButton("Actualizar");
        btnactualizardeposito.setBackground(Color.decode("#121212"));
        btnactualizardeposito.setFont(font2);
        btnactualizardeposito.setForeground(Color.WHITE);
        btnactualizardeposito.setBorder(null);
        btnactualizardeposito.setFocusable(false);
        btnactualizardeposito.setBounds(185, 320, 100, 30);
         btnactualizardeposito.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {     
                actualizardep();
                cargarDatos6();
            }
        }); 
        JButton ingresardeposito = new JButton("Insertar");
        ingresardeposito.setBackground(Color.decode("#121212"));
        ingresardeposito.setFont(font2);
        ingresardeposito.setForeground(Color.WHITE);
        ingresardeposito.setBorder(null);
        ingresardeposito.setFocusable(false);
        ingresardeposito.setBounds(320, 320, 100, 30);
         ingresardeposito.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {     
                ingresardep();
                cargarDatos6();
            }
        }); 
        txtDPIdep = new JTextField();
        txtDPIdep.setBounds(195, 60, 250, 30);
        txtncuenta = new JTextField();
        txtncuenta.setBounds(195, 100, 250, 30);
        txtTcuenta = new JTextField();
        txtTcuenta.setBounds(195, 140, 250, 30);
        txtFechadep = new JTextField();
        txtFechadep.setBounds(195, 180, 250, 30);
        txtmontodep = new JTextField();
        txtmontodep.setBounds(195, 225, 250, 30);
        txtCdes = new JTextField();
        txtCdes.setBounds(195, 270, 250, 30);
        JPanel Pdeposito = new JPanel();
        Pdeposito.setBackground(new Color(255, 255, 255, 160));     
        Pdeposito.setOpaque(true);
        Pdeposito.setBounds(380,300,490,420);     
        Pdeposito.setLayout(null);
        JLabel lbldpidep = new JLabel("Id Transaccion:");
        lbldpidep.setFont(font1);
        lbldpidep.setBounds(50, 60, 150, 30);
        JLabel lblncuenta = new JLabel("No. Cuenta:");
        lblncuenta.setFont(font1);
        lblncuenta.setBounds(50, 100, 150, 30);
        JLabel lblncuentad = new JLabel("Monto:");
        lblncuentad.setFont(font1);
        lblncuentad.setBounds(50, 140, 100, 30);
        JLabel lblfdep = new JLabel("Tipo Transaccion:");
        lblfdep.setFont(font1);
        lblfdep.setBounds(50, 185, 150, 30);
        JLabel lblmontodep = new JLabel("Fecha T:");
        lblmontodep.setFont(font1);
        lblmontodep.setBounds(50, 225, 150, 30);
        JLabel lblCdest = new JLabel("Cuenta Destino:");
        lblCdest.setFont(font1);
        lblCdest.setBounds(50, 270, 150, 30);
        Pdeposito.add(lblCdest);
        JLabel lbldeposito = new JLabel("TRANSACCION");
        lbldeposito.setFont(font6);
        lbldeposito.setBounds(160, 15, 190, 30);
        Pdeposito.add(btneliminardeposito);
        Pdeposito.add(btnactualizardeposito);
        Pdeposito.add(ingresardeposito);
        Pdeposito.add(lbldpidep);
        Pdeposito.add(txtCdes);
        Pdeposito.add(txtDPIdep);
        Pdeposito.add(txtncuenta);
        Pdeposito.add(txtTcuenta);
        Pdeposito.add(txtFechadep);
        Pdeposito.add(txtmontodep);
        Pdeposito.add(lblncuenta);
        Pdeposito.add(lblncuentad);
        Pdeposito.add(lblfdep);
        Pdeposito.add(lblmontodep);
        Pdeposito.add(lbldeposito);
        Pdeposito.setVisible(false);
        add(Pdeposito);
        
        //agregar usuarios
       add(panusuarios);
       panusuarios.add(btneliminarusuario);
       panusuarios.add(btnactualizarusuario);
       panusuarios.add(ingresarusuario);
       panusuarios.add(lblDPIusuarios);
       panusuarios.add(lblusuariost);
       panusuarios.add(txtDPIusu);
       panusuarios.add(txtusuario);
       panusuarios.add(lblusuarios);
       panusuarios.setVisible(false);
        //BOTONES
        //LABEL
        // Botón "info"
        JButton btnlogin = new JButton("Usuario");
        btnlogin.setBackground(Color.decode("#C48300"));
        btnlogin.setFont(font1);
        btnlogin.setForeground(Color.WHITE);
        btnlogin.setBorder(null);
        btnlogin.setFocusable(false);
        btnlogin.setBounds(50, 210, 150, 40);
       btnlogin.addActionListener(new ActionListener() {       
            public void actionPerformed(ActionEvent e) {
                 tablaUsuarios.setVisible(true);
                cargarDatos();  
                Plogin.setVisible(true);         
                paninfol.setVisible(false);
                panusuarios.setVisible(false);
                Pcuentas.setVisible(false);
                Psaldos.setVisible(false);
                Pdeposito.setVisible(false);
                imglogin.setVisible(true);
                imgproll.setVisible(false);
                imgusu.setVisible(false);
                imgTcuenta.setVisible(false);
                imgcuenta.setVisible(false);
                imgtransaccion.setVisible(false);
               // panrole.setVisible(false);
            }
        });
        add(btnlogin);
        //Boton "informacion"
        JButton btninformacion = new JButton("Roles");
        btninformacion.setBackground(Color.decode("#C48300"));
        btninformacion.setFont(font1);
        btninformacion.setForeground(Color.WHITE);
        btninformacion.setBorder(null);
        btninformacion.setFocusable(false);
        btninformacion.setBounds(50, 270, 150, 40);
        add(btninformacion);    
        btninformacion.addActionListener(new ActionListener() {       
            public void actionPerformed(ActionEvent e) {
                tablaUsuarios.setVisible(true);
                cargarDatos2();  
                Plogin.setVisible(false);         
                paninfol.setVisible(true);
                panusuarios.setVisible(false);
                Pcuentas.setVisible(false);
                Psaldos.setVisible(false);
                Pdeposito.setVisible(false);
                imglogin.setVisible(false);
                imgproll.setVisible(true);
                imgusu.setVisible(false);
                imgTcuenta.setVisible(false);
                imgcuenta.setVisible(false);
                imgtransaccion.setVisible(false);
               // panrole.setVisible(false);
            }
        });
        // Botón "Usuarios"
        JButton btnUsuarios = new JButton("Roles Usuarios");
        btnUsuarios.setBackground(Color.decode("#C48300"));
        btnUsuarios.setFont(font1);
        btnUsuarios.setForeground(Color.WHITE);
        btnUsuarios.setBorder(null);
        btnUsuarios.setFocusable(false);
        btnUsuarios.setBounds(50, 330, 150, 40);
        add(btnUsuarios);
         btnUsuarios.addActionListener(new ActionListener() {       
            public void actionPerformed(ActionEvent e) {
                 tablaUsuarios.setVisible(true);
                cargarDatos3();  
                Plogin.setVisible(false);         
                paninfol.setVisible(false);
                panusuarios.setVisible(true);
                Pcuentas.setVisible(false);
                 Psaldos.setVisible(false);
                 Pdeposito.setVisible(false);
                 imglogin.setVisible(false);
                imgproll.setVisible(false);
                imgusu.setVisible(true);
                imgTcuenta.setVisible(false);
                imgcuenta.setVisible(false);
                imgtransaccion.setVisible(false);
            }
        });
        //Boton "Cuentas"
        JButton btnCuentas = new JButton("Tipo cuenta");
        btnCuentas.setBackground(Color.decode("#C48300"));
        btnCuentas.setFont(font1);
        btnCuentas.setForeground(Color.WHITE);
        btnCuentas.setBorder(null);
        btnCuentas.setFocusable(false);
        btnCuentas.setBounds(50, 390, 150, 40);
        add(btnCuentas);
        btnCuentas.addActionListener(new ActionListener() {       
            public void actionPerformed(ActionEvent e) {
                tablaUsuarios.setVisible(true);
                cargarDatos4();  
                Plogin.setVisible(false);         
                paninfol.setVisible(false);
                panusuarios.setVisible(false);
                Pcuentas.setVisible(true);
                Psaldos.setVisible(false);
                Pdeposito.setVisible(false);
                imglogin.setVisible(false);
                imgproll.setVisible(false);
                imgusu.setVisible(false);
                imgTcuenta.setVisible(true);
                imgcuenta.setVisible(false);
                imgtransaccion.setVisible(false);
               // panrole.setVisible(false);
            }
        });
        // Botón "Saldos"
        JButton btnSaldos = new JButton("Cuenta");
        btnSaldos.setBackground(Color.decode("#C48300"));
        btnSaldos.setFont(font1);
        btnSaldos.setForeground(Color.WHITE);
        btnSaldos.setBorder(null);
        btnSaldos.setFocusable(false);
        btnSaldos.setBounds(50, 450, 150, 40);
        add(btnSaldos);   
        btnSaldos.addActionListener(new ActionListener() {       
            public void actionPerformed(ActionEvent e) {
                 tablaUsuarios.setVisible(true);
                cargarDatos5();  
                Plogin.setVisible(false);         
                paninfol.setVisible(false);
                panusuarios.setVisible(false);
                Pcuentas.setVisible(false);
                Psaldos.setVisible(true);
                Pdeposito.setVisible(false);
                imglogin.setVisible(false);
                imgproll.setVisible(false);
                imgusu.setVisible(false);
                imgTcuenta.setVisible(false);
                imgcuenta.setVisible(true);
                imgtransaccion.setVisible(false);
               // panrole.setVisible(false);
            }
        });
        // Botón "Deposito"
        JButton btndeposito = new JButton("Transaccion");
        btndeposito.setBackground(Color.decode("#C48300"));
        btndeposito.setFont(font1);
        btndeposito.setForeground(Color.WHITE);
        btndeposito.setBorder(null);
        btndeposito.setFocusable(false);
        btndeposito.setBounds(50, 510, 150, 40);
        add(btndeposito);      
        btndeposito.addActionListener(new ActionListener() {       
            public void actionPerformed(ActionEvent e) {
                tablaUsuarios.setVisible(true);
                cargarDatos6();  
                Plogin.setVisible(false);         
                paninfol.setVisible(false);
                panusuarios.setVisible(false);
                Pcuentas.setVisible(false);
                Psaldos.setVisible(false);
                Pdeposito.setVisible(true);
                imglogin.setVisible(false);
                imgproll.setVisible(false);
                imgusu.setVisible(false);
                imgTcuenta.setVisible(false);
                imgcuenta.setVisible(false);
                imgtransaccion.setVisible(true);
               // panrole.setVisible(false);
            }
        });
        JButton btnvolver = new JButton("Volver");
        btnvolver.setBackground(Color.decode("#C48300"));
        btnvolver.setFont(font1);
        btnvolver.setForeground(Color.WHITE);
        btnvolver.setBorder(null);
        btnvolver.setFocusable(false);
        btnvolver.setBounds(50, 580, 150, 40);
        add(btnvolver);      
        btnvolver.addActionListener(new ActionListener() {       
            public void actionPerformed(ActionEvent e) {
             NOSE l1 = new NOSE();
            l1.setVisible(true);
            dispose();          
            }
        });
        // Contenedor "JTable"
        tablaUsuarios = new JTable();
        tablaUsuarios.setBounds(274,80,690,210);
        tablaUsuarios.setGridColor(Color.white);
        tablaUsuarios.setRowHeight(30);
        tablaUsuarios.setEnabled(false);
        tablaUsuarios.setFont(font3);
        tablaUsuarios.setForeground(Color.white);
        tablaUsuarios.setBackground(Color.black);
        tablaUsuarios.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tablaUsuarios.setVisible(false);
        add(tablaUsuarios);
        // Columnas de la tablas
        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("Usuario");
        modeloTabla.addColumn("Contraseña");
        tablaUsuarios.setModel(modeloTabla);
        
        //imagenes
        imglogin = new JLabel(new ImageIcon("img/ploginl.PNG"));
        imglogin.setBounds(274, -60, 690, 210);
        imglogin.setVisible(false);
        add(imglogin);
        imgproll = new JLabel(new ImageIcon("img/proll.PNG"));
        imgproll.setBounds(274, -60, 690, 210);
        imgproll.setVisible(false);
        add(imgproll);
        imgusu = new JLabel(new ImageIcon("img/pusuario.PNG"));
        imgusu.setBounds(274, -60, 690, 210);
        imgusu.setVisible(false);
        add(imgusu);
        imgTcuenta = new JLabel(new ImageIcon("img/Tcuenta.PNG"));
        imgTcuenta.setBounds(274, -60, 690, 210);
        imgTcuenta.setVisible(false);
        add(imgTcuenta);
        imgcuenta = new JLabel(new ImageIcon("img/cuentas.PNG"));
        imgcuenta.setBounds(274, -60, 690, 210);
        imgcuenta.setVisible(false);
        add(imgcuenta);
        imgtransaccion = new JLabel(new ImageIcon("img/ptransaccion.PNG"));
        imgtransaccion.setBounds(274, -60, 690, 210);
        imgtransaccion.setVisible(false);
        add(imgtransaccion);
        
        //TablaLogin.setFillsViewportHeight(true);
    }
    
    //Documentos Anti-Errores
    private static class CustomDoc extends PlainDocument {

        private int limit;

        public CustomDoc(int limit) {
            this.limit = limit;
        }

        @Override
        public void insertString(int offset, String s, AttributeSet attributeSet) throws BadLocationException {
            if (s == null) {
                return;
            }
            StringBuilder builder = new StringBuilder(getText(0, getLength()));
            builder.insert(offset, s);
            if (!isValidInput(builder.toString())) {
                return;
            }
            if ((getLength() + s.length()) <= limit) {
                super.insertString(offset, s, attributeSet);
            }
        }

        private boolean isValidInput(String text) {
            if (text.isEmpty()) {
                return true;
            }
            for (char c : text.toCharArray()) {
                if (!Character.isDigit(c)) {
                    return false;
                }
            }
            return true;
        }
    }

    //Documento para el ingreso de nombre/apellido
    private static class CustomDoc1 extends PlainDocument {

        @Override
        public void insertString(int offset, String s, AttributeSet attributeSet) throws BadLocationException {
            if (s == null) {
                return;
            }
            StringBuilder builder = new StringBuilder();
            for (char c : s.toCharArray()) {
                if (Character.isLetter(c) && !Character.isWhitespace(c)) {
                    builder.append(c);
                }
            }
            // Validar que el primer carácter sea mayúscula
            if (offset == 0 && builder.length() > 0) {
                char firstChar = builder.charAt(0);
                if (!Character.isUpperCase(firstChar)) {
                    return;
                }
            }
            super.insertString(offset, builder.toString(), attributeSet);
        }
    }

    /*Validar Email*/
    private static boolean Email(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+.[a-zA-Z]{2,4}+$";
        return Pattern.matches(emailRegex, email);
    }

    private static boolean setFecha(String email) {
        String setFecha = "[0-9]{4}+-[0-9]{2}+-[0-9]{2}";
        return Pattern.matches(setFecha, email);
    }
    
    //funciones CRUD
    //deposito
     private void ingresardep() {
        String dpi = txtDPIdep.getText();
        String pin = txtncuenta.getText();
        String pass = txtTcuenta.getText();
        String fech = txtFechadep.getText();
        String monto = txtmontodep.getText();
        String cdes = txtCdes.getText();
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Banco2", "root", "compu");
            String query = "INSERT INTO transaccion VALUES (?, ?, ?, ?, ?, ?);";
            PreparedStatement stmt = con.prepareStatement(query);    
            stmt.setString(1, dpi);
            stmt.setString(2, pin);
            stmt.setString(3, pass);      
            stmt.setString(4, fech);
            stmt.setString(5, monto);  
            stmt.setString(6, cdes);  
            stmt.executeUpdate(); 
            stmt.close();
            con.close();
             txtDPIdep.setText("");
            txtncuenta.setText("");
            txtTcuenta.setText("");
            txtFechadep.setText("");
            txtmontodep.setText("");
            txtCdes.setText("");
            JOptionPane.showMessageDialog(admin.this, "Datos guardados correctamente");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(admin.this, "Error al guardar los datos");
        }
    }
      private void eliminardep() {
         String ncuenta = txtDPIdep.getText();
         Conexion conectar = new Conexion();
        try {
            Connection con = conectar.getConnection();
            String query = "DELETE  FROM transaccion WHERE id_transaccion = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, ncuenta);
            stmt.executeUpdate();
            stmt.close();
            con.close();
            JOptionPane.showMessageDialog(admin.this, "Datos eliminados correctamente");
            txtDPIdep.setText("");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(admin.this, "Error al eliminar los datos");
        }
     }
      
      private void actualizardep() {
       String dpi = txtDPIdep.getText();
        String pin = txtncuenta.getText();
        String pass = txtTcuenta.getText();
        String fech = txtFechadep.getText();
        String monto = txtmontodep.getText();
        String cuenta = txtmontodep.getText();
         String cde = txtCdes.getText();
        Conexion conectar = new Conexion();
        try {
            Connection con = conectar.getConnection();
            String query = "UPDATE transaccion SET  numero_cuenta = ?, monto = ?,tipo_transaccion = ?, fecha_transaccion = ?,cuenta_destino = ? WHERE DPI = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(7, dpi);
            stmt.setString(1, pin);
            stmt.setString(2, pass);      
            stmt.setString(3, fech);
            stmt.setString(4, monto); 
            stmt.setString(5, cuenta); 
            stmt.setString(6, cde); 
            stmt.executeUpdate();
            stmt.close();
            con.close();
            JOptionPane.showMessageDialog(admin.this, "Datos actualizados correctamente");
            txtDPIdep.setText("");
            txtncuenta.setText("");
            txtTcuenta.setText("");
            txtFechadep.setText("");
            txtmontodep.setText("");
            txtCdes.setText("");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(admin.this, "Error al actualizar los datos");
        }
    }
    //saldos
    private void ingresarsaldo1() {
        String dpi = txtDPIsaldo.getText();
        String pin = txtnoCs.getText();
        String pass = txtsaldo.getText();
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Banco2", "root", "compu");
            String query = "INSERT INTO cuenta VALUES (?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(query);         
            stmt.setString(1, dpi);
            stmt.setString(2, pin);
            stmt.setString(3, pass);          
            stmt.executeUpdate(); 
            stmt.close();
            con.close();
             txtDPIsaldo.setText("");
            txtnoCs.setText("");
            txtsaldo.setText("");
            JOptionPane.showMessageDialog(admin.this, "Datos guardados correctamente");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(admin.this, "Error al guardar los datos");
        }
    }
      private void eliminarsaldo1() {
         String ncuenta = txtDPIsaldo.getText();
         Conexion conectar = new Conexion();
        try {
            Connection con = conectar.getConnection();
            String query = "DELETE  FROM cuenta WHERE numero_cuenta = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, ncuenta);
            stmt.executeUpdate();
            stmt.close();
            con.close();
            JOptionPane.showMessageDialog(admin.this, "Datos eliminados correctamente");
            txtdpi.setText("");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(admin.this, "Error al eliminar los datos");
        }
     }
      private void actualizarsaldo1() {
        String dpi = txtDPIsaldo.getText();
        String pin = txtnoCs.getText();
        String pass = txtsaldo.getText();
        Conexion conectar = new Conexion();
        try {
            Connection con = conectar.getConnection();
            String query = "UPDATE cuenta SET  dpi = ?, id_tipo_cuenta = ? WHERE numero_cuenta = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(3, dpi);
            stmt.setString(1, pin);
            stmt.setString(2, pass);
            stmt.executeUpdate();
            stmt.close();
            con.close();
            JOptionPane.showMessageDialog(admin.this, "Datos actualizados correctamente");
            txtDPIsaldo.setText("");
            txtnoCs.setText("");
            txtsaldo.setText("");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(admin.this, "Error al actualizar los datos");
        }
    }
    //cuentas
     private void ingresarcuentas1() {
        String usu = txtnoC.getText();
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Banco2", "root", "compu");
            String query = "insert into tipo_cuenta (nombre) VALUES (?)";
            PreparedStatement stmt = con.prepareStatement(query);         
            stmt.setString(1, usu);           
            stmt.executeUpdate(); 
            stmt.close();
            con.close();
            txtnoC.setText("");
            JOptionPane.showMessageDialog(admin.this, "Datos guardados correctamente");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(admin.this, "Error al guardar los datos");
        }
    }
      private void eliminarcuentas1() {
         String ncuenta = txtDPIcuenta.getText();
         Conexion conectar = new Conexion();
        try {
            Connection con = conectar.getConnection();
            String query = "DELETE  FROM tipo_cuenta WHERE id_tipo_cuenta = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, ncuenta);
            stmt.executeUpdate();
            stmt.close();
            con.close();
            JOptionPane.showMessageDialog(admin.this, "Datos eliminados correctamente");
            txtDPIcuenta.setText("");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(admin.this, "Error al eliminar los datos");
        }
     }
      private void actualizarcuentas1() {
        String dpi = txtDPIcuenta.getText();
        String usu = txtnoC.getText();
        Conexion conectar = new Conexion();
        try {
            Connection con = conectar.getConnection();
            String query = "UPDATE tipo_cuenta SET  nombre = ?  WHERE id_tipo_cuenta = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(3, dpi);
            stmt.setString(1, usu);
            stmt.executeUpdate();
            stmt.close();
            con.close();
            JOptionPane.showMessageDialog(admin.this, "Datos actualizados correctamente");
             txtDPIcuenta.setText("");
            txtnoC.setText("");
            txtTC.setText("");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(admin.this, "Error al actualizar los datos");
        }
    }
    //usuarios
    private void ingresarusuarios() {
        String dpi = txtDPIusu.getText();
        String usu = txtusuario.getText();
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Banco2", "root", "compu");
            String query = "INSERT INTO usuario_rol VALUES (?, ?)";
            PreparedStatement stmt = con.prepareStatement(query);         
            stmt.setString(1, dpi);
            stmt.setString(2, usu);   
            stmt.executeUpdate(); 
            stmt.close();
            con.close();
            txtDPIusu.setText("");
            txtusuario.setText("");
            JOptionPane.showMessageDialog(admin.this, "Datos guardados correctamente");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(admin.this, "Error al guardar los datos");
        }
    }
      private void eliminarusuarios() {
         String ncuenta = txtDPIusu.getText();
         Conexion conectar = new Conexion();
        try {
            Connection con = conectar.getConnection();
            String query = "DELETE  FROM usuario_rol WHERE dpi = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, ncuenta);
            stmt.executeUpdate();
            stmt.close();
            con.close();
            JOptionPane.showMessageDialog(admin.this, "Datos eliminados correctamente");
            txtDPIusu.setText("");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(admin.this, "Error al eliminar los datos");
        }
     }
      private void actualizarusuarios() {
        String dpi = txtDPIusu.getText();
        String usu = txtusuario.getText();
        String roll = txtRoll.getText();
        Conexion conectar = new Conexion();
        try {
            Connection con = conectar.getConnection();
            String query = "UPDATE usuario_rol SET  id_rol = ?  WHERE dpi = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, dpi);
            stmt.setString(2, roll);
            stmt.executeUpdate();
            stmt.close();
            con.close();
            JOptionPane.showMessageDialog(admin.this, "Datos actualizados correctamente");
            txtDPIusu.setText("");
            txtusuario.setText("");
            txtRoll.setText("");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(admin.this, "Error al actualizar los datos");
        }
    }
    //Informacion
    private void ingresarinfo(){
        //txtapellido,txtdpiinfo
        String nombre = txtdpiinfo.getText();
        String apellido = txtapellido.getText();
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Banco2", "root", "compu");
            String query = "INSERT INTO rol (nombre) VALUES (?)";
            PreparedStatement stmt = con.prepareStatement(query);          
            stmt.setString(1, nombre);
            stmt.executeUpdate(); 
            stmt.close();
            con.close();
            txtdpiinfo.setText("");
            JOptionPane.showMessageDialog(admin.this, "Datos guardados correctamente");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(admin.this, "Error al guardar los datos");
        }
    }
      private void eliminarinfo(){
         String apellido = txtapellido.getText();
         Conexion conectar = new Conexion();
        try {
            Connection con = conectar.getConnection();
            String query = "DELETE  FROM rol WHERE id_rol = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, apellido);
            stmt.executeUpdate();
            stmt.close();
            con.close();
            JOptionPane.showMessageDialog(admin.this, "Datos eliminados correctamente");
            txtapellido.setText("");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(admin.this, "Error al eliminar los datos");
        }
     }
      private void actualizarinfo() {
        String nombre = txtdpiinfo.getText();
        String apellido = txtapellido.getText();
        Conexion conectar = new Conexion();
        try {
            Connection con = conectar.getConnection();
            String query = "UPDATE rol SET  nombre = ? WHERE id_rol = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, nombre);
            stmt.setString(2, apellido);
            stmt.executeUpdate();
            stmt.close();
            con.close();
            JOptionPane.showMessageDialog(admin.this, "Datos actualizados correctamente");
            txtnombre.setText("");
            txtapellido.setText("");
            txtdpiinfo.setText("");
            txtCorreo.setText("");
            txttelefono.setText("");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(admin.this, "Error al actualizar los datos");
        }
    }
    //Login
     private void ingresarlogin() {
         //txtdpi,txtpin,txtpass,ttxcorr,txttell,txtcontra,txtpinl
        String dpi = txtdpi.getText();
        String pin = txtpin.getText();
        String pass = txtpass.getText();
         String corr = ttxcorr.getText();
        String tell = txttell.getText();
        String contra = txtcontra.getText();
         String pinl = txtpinl.getText();

        Conexion conectar = new Conexion();
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Banco2", "root", "compu");
            String query = "INSERT INTO usuario VALUES (?, ?, ?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(query);
            
            stmt.setString(1, dpi);
            stmt.setString(2, pin);
            stmt.setString(3, pass);
             stmt.setString(4, corr);
            stmt.setString(5, tell);
            stmt.setString(6, contra);
             stmt.setString(7, pinl);
            
            stmt.executeUpdate(); 
            stmt.close();
            con.close();
             txtdpi.setText("");
            txtpin.setText("");
            txtpass.setText("");
            ttxcorr.setText("");
            txttell.setText("");
            txtcontra.setText("");
            txtpinl.setText("");
            JOptionPane.showMessageDialog(admin.this, "Datos guardados correctamente");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(admin.this, "Error al guardar los datos");
        }
    }
      private void eliminarlogin() {
         String ncuenta = txtdpi.getText();
         Conexion conectar = new Conexion();
        try {
            Connection con = conectar.getConnection();
            String query = "DELETE  FROM usuario WHERE dpi = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, ncuenta);
            stmt.executeUpdate();
            stmt.close();
            con.close();
            JOptionPane.showMessageDialog(admin.this, "Datos eliminados correctamente");
            txtdpi.setText("");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(admin.this, "Error al eliminar los datos");
        }
     }
      private void actualizarlogin() {
        String dpi = txtdpi.getText();
        String pin = txtpin.getText();
        String pass = txtpass.getText();
        String corr = ttxcorr.getText();
        String tell = txttell.getText();
        String contra = txtcontra.getText();
        String pinl = txtpinl.getText();
        Conexion conectar = new Conexion();
        try {
            Connection con = conectar.getConnection();
            String query = "UPDATE usuario SET  nombre = ?, apellido = ?, correo = ?, telefono = ?, pass = ?, pin = ? WHERE dpi = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(7, dpi);
            stmt.setString(1, pin);
            stmt.setString(2, pass);
            stmt.setString(3, corr);
            stmt.setString(4, tell);
            stmt.setString(5, contra);
             stmt.setString(6, pinl);
            stmt.executeUpdate();
            stmt.close();
            con.close();
            JOptionPane.showMessageDialog(admin.this, "Datos actualizados correctamente");
            txtdpi.setText("");
            txtpin.setText("");
            txtpass.setText("");
            ttxcorr.setText("");
            txttell.setText("");
            txtcontra.setText("");
            txtpinl.setText("");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(admin.this, "Error al actualizar los datos");
        }
    }
     
    //Cargar Datos
    private void cargarDatos() {
           modeloTabla.setRowCount(0);
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/banco2", "root", "compu");
            String query = "SELECT * FROM usuario";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();
        String[] columnNames = new String[columnCount];    
        for (int i = 1; i <= columnCount; i++) {
            columnNames[i - 1] = rsmd.getColumnName(i);
        }
        modeloTabla.setColumnIdentifiers(columnNames);       
            while (rs.next()) {
                String id = rs.getString("dpi");
                String usuario = rs.getString("nombre");
                String contraseña = rs.getString("apellido");
                String correo = rs.getString("correo");
                String tel = rs.getString("telefono");
                String pass = rs.getString("pass");
                String pin = rs.getString("pin");
                Object[] fila = { id, usuario, contraseña,correo,tel,pass,pin};
                modeloTabla.addRow(fila);              
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(admin.this, "Error al cargar los datos");
        }
    }
     private void cargarDatos2() {
           modeloTabla.setRowCount(0);
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/banco2", "root", "compu");
            String query = "SELECT * FROM rol";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();
        String[] columnNames = new String[columnCount];    
        for (int i = 1; i <= columnCount; i++) {
            columnNames[i - 1] = rsmd.getColumnName(i);
        }
        modeloTabla.setColumnIdentifiers(columnNames);       
            while (rs.next()) {
                String nombre = rs.getString("id_rol");
                String apellido = rs.getString("nombre");
                Object[] fila = { nombre, apellido};
                modeloTabla.addRow(fila);              
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(admin.this, "Error al cargar los datos");
        }
    }
     private void cargarDatos3() {
           modeloTabla.setRowCount(0);
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/banco2", "root", "compu");
            String query = "SELECT * FROM usuario_rol";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();
        String[] columnNames = new String[columnCount];    
        for (int i = 1; i <= columnCount; i++) {
            columnNames[i - 1] = rsmd.getColumnName(i);
        }
        modeloTabla.setColumnIdentifiers(columnNames);       
            while (rs.next()) {
                String DPI = rs.getString("DPI");
                String usuario = rs.getString("id_rol");
                Object[] fila = {DPI,usuario};
                modeloTabla.addRow(fila);              
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(admin.this, "Error al cargar los datos");
        }
    }
       private void cargarDatos4() {
           modeloTabla.setRowCount(0);
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/banco2", "root", "compu");
            String query = "SELECT * FROM tipo_cuenta";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();
        String[] columnNames = new String[columnCount];    
        for (int i = 1; i <= columnCount; i++) {
            columnNames[i - 1] = rsmd.getColumnName(i);
        }
        modeloTabla.setColumnIdentifiers(columnNames);       
            while (rs.next()) {
                String DPI = rs.getString("id_tipo_cuenta");
                String usuario = rs.getString("nombre");
                Object[] fila = {DPI,usuario};
                modeloTabla.addRow(fila);              
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(admin.this, "Error al cargar los datos");
        }
    }
       private void cargarDatos5() {
           modeloTabla.setRowCount(0);
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/banco2", "root", "compu");
            String query = "SELECT * FROM cuenta";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();
        String[] columnNames = new String[columnCount];    
        for (int i = 1; i <= columnCount; i++) {
            columnNames[i - 1] = rsmd.getColumnName(i);
        }
        modeloTabla.setColumnIdentifiers(columnNames);       
            while (rs.next()) {
                String id = rs.getString("numero_cuenta");
                String usuario = rs.getString("dpi");
                String contraseña = rs.getString("id_tipo_cuenta");
                Object[] fila = { id, usuario, contraseña};
                modeloTabla.addRow(fila);              
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(admin.this, "Error al cargar los datos");
        }
    }
       private void cargarDatos6() {
           modeloTabla.setRowCount(0);
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/banco2", "root", "compu");
            String query = "SELECT * FROM transaccion";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();
        String[] columnNames = new String[columnCount];    
        for (int i = 1; i <= columnCount; i++) {
            columnNames[i - 1] = rsmd.getColumnName(i);
        }
        modeloTabla.setColumnIdentifiers(columnNames);       
            while (rs.next()) {
                String id = rs.getString("id_transaccion");
                String usuario = rs.getString("numero_cuenta");
                String contraseña = rs.getString("monto");
                String fdep = rs.getString("tipo_transaccion");
                String monto = rs.getString("fecha_transaccion");
                String cuena = rs.getString("cuenta_destino");
                Object[] fila = { id, usuario, contraseña,fdep,monto,cuena};
                modeloTabla.addRow(fila);              
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(admin.this, "Error al cargar los datos");
        }
    }
    //Llamar metodo
    public void imagen() {
        JLabel botones = new JLabel(new ImageIcon("img/FAdmin.PNG"));
        botones.setBounds(0, 0, 1000, 700);
        this.add(botones);
    }
    public void inicializar(){    
        this.panel();
        this.imagen();
    }    
}