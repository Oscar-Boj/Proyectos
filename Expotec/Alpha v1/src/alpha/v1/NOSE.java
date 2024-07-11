package alpha.v1;

import static alpha.v1.BDConsultas.generarContraseña;
import static alpha.v1.BDConsultas.generarNumeroCuenta;
import static alpha.v1.BDConsultas.generarPIN;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;
import java.awt.Color;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.net.PasswordAuthentication;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;

public class NOSE extends JFrame {

    public String dpiLogin = "";
    private JLabel sTipo;
    private JLabel sNumCuenta;
    private JLabel sMonto;
    private JLabel usDpi;
    private JLabel usNombre;
    private JLabel usApellido;
    private JLabel usCorreo;
    private JLabel usTelefono;
    private String numero;
    private JTextField user;
    private JTextField Ldpi;
    private JPasswordField password;
    private JTextField Rdpi;
    private JTextField nombre;
    private JTextField apellido;
    private JTextField telefono;
    private JTextField correo;
    private JTextField txt1;
    private JComboBox noC;
    private JComboBox infoCt;
    private JTextField cueDes;
    private JComboBox tCuent;
    private JComboBox hisCuen;
    private JFrame msgusuario;
    private JLabel msgtra;
    private JLabel msgcue;
    private JTextField txtFechadret, txtDPIret, txtncuentaret, txtTcuentaret, txtFecharet, txtmontoret, txtDPIdep, txtncuenta, txtTcuenta, txtFechadep, txtmontodep, txtDPIsaldo, txtnoCs, txtsaldo, txtDPIcuenta, txtnoC, txtTC, txtDPIusu, txtusuario, txtRoll, txtdpiinfo, txtdpi, txtpin, txtpass, txtnombre, txtapellido, txtCorreo, txttelefono;
    private DefaultTableModel modeloTabla1, modeloTabla;
    private JTable tablaUsuarios;
    private Font font1 = new Font("Arial", Font.BOLD, 16);
    private Font font2 = new Font("Arial", Font.BOLD, 14);
    private Font font3 = new Font("Arial", Font.BOLD, 18);
    private Font font4 = new Font("Arial", Font.BOLD, 46);
    private Font font5 = new Font("Arial", Font.BOLD, 20);
    private Font font6 = new Font("Arial", Font.BOLD, 25);
    private Font font7 = new Font("Arial", Font.BOLD, 36);
    public int altura = 0;
    // public JButton iniciar = new JButton("Iniciar Sesion");

    public NOSE() {
        this.setLayout(null);
        this.setTitle("INICIO");
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        altura = screenSize.height;
        this.setSize(screenSize.width, screenSize.height);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.decode("#121212"));
        this.inicializar();
    }

    public void panel() {
        //Panel mensajes usuario
        msgusuario = new JFrame();
        msgusuario.setBackground(Color.BLACK);
        msgusuario.setSize(300, 200);
        msgusuario.setLocationRelativeTo(null);
        msgusuario.setLayout(null);
        msgusuario.setVisible(false);
        msgusuario.setUndecorated(true);

        msgtra = new JLabel(new ImageIcon("img/msgtrar.png"));
        msgtra.setBounds(0, 0, 300, 200);
        msgusuario.add(msgtra);
        msgtra.setVisible(false);

        msgcue = new JLabel(new ImageIcon("img/msgcuec.png"));
        msgcue.setBounds(0, 0, 300, 200);
        msgusuario.add(msgcue);
        msgcue.setVisible(false);

        JLabel msgusu = new JLabel(new ImageIcon("img/msgusaurio.png"));
        msgusu.setBounds(0, 0, 300, 200);
        msgusuario.add(msgusu);
        msgusu.setVisible(false);

        JLabel msgger = new JLabel(new ImageIcon("img/msgger.png"));
        msgger.setBounds(0, 0, 300, 200);
        msgusuario.add(msgger);
        msgger.setVisible(false);

        JLabel msgadm = new JLabel(new ImageIcon("img/msgad.png"));
        msgadm.setBounds(0, 0, 300, 200);
        msgusuario.add(msgadm);
        msgadm.setVisible(false);

        //Panel login
        JPanel Login = new JPanel();
        Login.setBackground(new Color(36, 36, 36, 128));
        Login.setBounds(850, 170, 350, 550);
        Login.setLayout(null);
        Login.setOpaque(true);
        Login.setVisible(false);
        this.getContentPane().add(Login);

        //Panel MenuInicio2
        JPanel PMenu2 = new JPanel();
        PMenu2.setBackground(Color.decode("#ffffff"));
        PMenu2.setBounds(60, 70, 1140, 100);
        PMenu2.setLayout(null);
        PMenu2.setVisible(false);
        this.getContentPane().add(PMenu2);

        //Panel MenuInicio
        JPanel PMenu = new JPanel();
        PMenu.setBackground(Color.decode("#ffffff"));
        PMenu.setBounds(60, 70, 1140, 100);
        PMenu.setLayout(null);
        this.getContentPane().add(PMenu);

        //Panel Registro
        JPanel Registro = new JPanel();
        Registro.setBackground(new Color(36, 36, 36, 180));
        Registro.setBounds(850, 170, 350, 650);
        Registro.setLayout(null);
        Registro.setOpaque(true);
        Registro.setVisible(false);
        this.getContentPane().add(Registro);

        //Panel Menu
        JPanel menu = new JPanel();
        menu.setBackground(new Color(36, 36, 36, 180));
        menu.setBounds(60, 175, 1140, 750);
        menu.setLayout(null);
        menu.setOpaque(true);
        menu.setVisible(true);
        menu.setVisible(false);
        this.getContentPane().add(menu);

        //Panel Main -------------------------------------------------------------------------
        JPanel mein = new JPanel();
        mein.setBackground(Color.white);
        mein.setBounds(60, 175, 790, 760);
        mein.setLayout(null);
        mein.setVisible(true);
        this.getContentPane().add(mein);

        //Imagenes de presentacion
        JLabel imagen1 = new JLabel(new ImageIcon("img/Fundadores1.GIF"));
        imagen1.setBounds(25, 50, 600, 600);
        JLabel imagen2 = new JLabel(new ImageIcon("img/f2.GIF"));
        imagen2.setBounds(25, 50, 600, 600);
        JLabel imagen3 = new JLabel(new ImageIcon("img/Fundadores3.GIF"));
        imagen3.setBounds(25, 50, 600, 600);
        JLabel imagen4 = new JLabel(new ImageIcon("img/Fundadores4.GIF"));
        imagen4.setBounds(25, 50, 600, 600);
        JLabel imagen5 = new JLabel(new ImageIcon("img/publi.GIF"));
        imagen5.setBounds(0, 0, 760, 300);
        mein.add(imagen1);
        mein.add(imagen2);
        mein.add(imagen3);
        mein.add(imagen4);
        mein.add(imagen5);
        imagen1.setVisible(false);
        imagen2.setVisible(false);
        imagen3.setVisible(false);
        imagen4.setVisible(false);
        imagen5.setVisible(true);

        //Panel Publi
        JPanel publi = new JPanel();
        JLabel publiS = new JLabel(new ImageIcon("img/gifs.GIF"));
        publiS.setBounds(0, 0, 350, 220);
        JLabel publiS1 = new JLabel(new ImageIcon("img/GIF.GIF"));
        publiS1.setBounds(0, 250, 350, 220);
        JLabel publiS2 = new JLabel(new ImageIcon("img/123.GIF"));
        publiS2.setBounds(0, 500, 350, 220);
        publi.setBackground(new Color(36, 36, 36, 180));
        publi.setBounds(850, 175, 350, 760);
        publi.setLayout(null);
        publi.setOpaque(true);
        this.getContentPane().add(publi);
        publi.add(publiS);
        publi.add(publiS1);
        publi.add(publiS2);

        //Panel Depositar
        JPanel depo = new JPanel();
        depo.setBackground(new Color(36, 36, 36, 180));
        depo.setBounds(60, 175, 1140, 750);
        depo.setLayout(null);
        depo.setOpaque(true);
        depo.setVisible(false);
        this.getContentPane().add(depo);

        //Panel Cuentas
        JPanel mCuent = new JPanel();
        mCuent.setBackground(new Color(36, 36, 36, 180));
        mCuent.setBounds(60, 180, 1140, 750);
        mCuent.setLayout(null);
        mCuent.setOpaque(true);
        mCuent.setVisible(false);
        this.getContentPane().add(mCuent);
        JLabel Retis = new JLabel(new ImageIcon("img/retiro.png"));
        Retis.setBounds(490, 50, 200, 200);
        //Panel Saldo
        JPanel psal = new JPanel();
        psal.setBackground(new Color(36, 36, 36, 180));
        psal.setBounds(60, 175, 1140, 750);
        psal.setLayout(null);
        psal.setOpaque(true);
        psal.setVisible(false);
        this.getContentPane().add(psal);

        //table saldo
        modeloTabla1 = new DefaultTableModel();
        modeloTabla1.addColumn("ID_Cuenta");
        modeloTabla1.addColumn("S_Cuenta");
        JTable v1 = new JTable();
        v1.setRowHeight(30);
        v1.setBounds(68, 150, 1000, 450);
        v1.setFont(font3);
        v1.setModel(modeloTabla1);
        v1.setEnabled(false);

        //psal.add(v1);
        //Panel Historial
        JPanel his = new JPanel();
        his.setBackground(new Color(36, 36, 36, 180));
        his.setBounds(60, 175, 1140, 750);
        his.setLayout(null);
        his.setOpaque(true);
        his.setVisible(false);
        this.getContentPane().add(his);
        //Tabla Historial
        /*  modelohistorial = new DefaultTableModel();
        modelohistorial.addColumn("ID_Cuenta");
        modelohistorial.addColumn("S_Cuenta");*/
             
        JTable v2 = new JTable();
        v2.setBounds(0, 0, 1000, 300);
        v2.setRowHeight(30);
        v2.setModel(modeloTabla1);
        v2.setFont(font3);
        v2.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 0));
        v2.setForeground(Color.white);
        v2.setBackground(Color.BLACK);
        v2.setEnabled(false);
        //his.add(v2);
        
        JScrollPane js = new JScrollPane(v2);
        js.setVisible(true);
        js.setBounds(68, 250, 1018, 300);
        his.add(js);

        //Panel Informacion
        JPanel infor1 = new JPanel();
        infor1.setBackground(new Color(36, 36, 36, 180));
        infor1.setBounds(60, 175, 1140, 750);
        infor1.setLayout(null);
        infor1.setOpaque(true);
        infor1.setVisible(false);
        this.getContentPane().add(infor1);

        //Tabla Información       
        /* modeloinformacion = new DefaultTableModel();
        modeloinformacion.addColumn("ID_Cuenta");
        modeloinformacion.addColumn("Nombre");
        modeloinformacion.addColumn("Telefono");
        modeloinformacion.addColumn("Correo");
        modeloinformacion.addColumn("Pass");*/
 /*JTable v3 = new JTable();
        v3.setBounds(68, 150, 1000, 450);
        v3.setModel(modeloTabla1);
        v3.setRowHeight(30);
        v3.setFont(font3);
        v3.setEnabled(false);
        infor1.add(v3);*/
        //CajaTexto Login
        Ldpi = new JTextField(20);
        Ldpi.setBounds(30, 225, 290, 35);
        Ldpi.setFont(font3);

        user = new JTextField(20);
        user.setBounds(30, 305, 290, 35);
        user.setFont(font3);

        password = new JPasswordField(20);
        password.setBounds(30, 385, 290, 35);
        password.setFont(font3);

        Login.add(Ldpi);
        Login.add(user);
        Login.add(password);

        //ComboBox Historial
        hisCuen = new JComboBox();
        hisCuen.setBackground(Color.WHITE);
        hisCuen.setFocusable(false);
        hisCuen.setBounds(605, 125, 200, 40);
        hisCuen.setFont(font3);
        hisCuen.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent arg0) {
                if (hisCuen.getSelectedItem() != null) {
                    cargarDatos2();
                }
            }
        });

        JLabel BHis = new JLabel(new ImageIcon("img/bHis.PNG"));
        BHis.setBounds(68, 200, 1000, 40);

        JLabel hisCue = new JLabel("NO. DE CUENTA:");
        hisCue.setBounds(370, 125, 500, 40);
        hisCue.setForeground(Color.decode("#C48300"));
        hisCue.setFont(font6);

        his.add(hisCuen);
        his.add(BHis);
        his.add(hisCue);

        //ComboBox Cuentas
        JLabel tipoCuCom = new JLabel("ELEGIR EL TIPO DE CUENTA");
        tipoCuCom.setBounds(400, 190, 500, 50);
        tipoCuCom.setForeground(Color.decode("#c48300"));
        tipoCuCom.setFont(font6);

        tCuent = new JComboBox();
        tCuent.setBackground(Color.WHITE);
        tCuent.setFocusable(false);
        tCuent.setBounds(400, 250, 350, 40);
        tCuent.setFont(font3);

        tCuent.addItem("Ahorro");
        tCuent.addItem("Monetaria");

        mCuent.add(tipoCuCom);
        mCuent.add(tCuent);

        //CajaTexto Registro
        Rdpi = new JTextField(20);
        Rdpi.setBounds(30, 220, 290, 35);
        Rdpi.setFont(font3);

        nombre = new JTextField(20);
        nombre.setBounds(30, 300, 130, 35);
        nombre.setFont(font3);

        apellido = new JTextField(20);
        apellido.setBounds(190, 300, 130, 35);
        apellido.setFont(font3);

        telefono = new JTextField(20);
        telefono.setBounds(30, 380, 290, 35);
        telefono.setFont(font3);

        correo = new JTextField(20);
        correo.setBounds(30, 460, 290, 35);
        correo.setFont(font3);

        Registro.add(Rdpi);
        Registro.add(nombre);
        Registro.add(apellido);
        Registro.add(telefono);
        Registro.add(correo);

        //cajatexto Saldo
        infoCt = new JComboBox();
        infoCt.setBounds(605, 125, 200, 40);
        infoCt.setFocusable(false);
        infoCt.setFont(font1);
        infoCt.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent arg0) {
                if (infoCt.getSelectedItem() != null) {
                    obtenerInfoCuentaPorDpi(dpiLogin, infoCt.getSelectedItem().toString());
                }
            }
        });

        psal.add(infoCt);

        //cajaTexto Deposito
        txt1 = new JTextField();
        txt1.setBounds(280, 390, 600, 40);
        txt1.setFont(font1);

        noC = new JComboBox();
        noC.setBounds(605, 125, 200, 40);
        noC.setFocusable(false);
        noC.setFont(font1);

        cueDes = new JTextField();
        cueDes.setBounds(280, 260, 600, 40);
        cueDes.setFont(font1);

        depo.add(cueDes);

        //Label Cuentas
        JLabel cuenLabel = new JLabel("CREAR CUENTA");
        cuenLabel.setBounds(400, 15, 500, 50);
        cuenLabel.setForeground(Color.decode("#ffffff"));
        cuenLabel.setFont(font4);

        JLabel cuentLinea = new JLabel(new ImageIcon("img/linea.jpg"));
        cuentLinea.setBounds(30, 75, 1075, 4);

        mCuent.add(cuentLinea);
        mCuent.add(cuenLabel);

        //Label Informacion
        JLabel inDpi = new JLabel("DPI:");
        inDpi.setBounds(345, 130, 200, 150);
        inDpi.setForeground(Color.decode("#ffffff"));
        inDpi.setFont(font7);

        JLabel inNom = new JLabel("Nombre:");
        inNom.setBounds(260, 210, 200, 150);
        inNom.setForeground(Color.decode("#ffffff"));
        inNom.setFont(font7);

        JLabel inApe = new JLabel("Apellido:");
        inApe.setBounds(260, 290, 200, 150);
        inApe.setForeground(Color.decode("#ffffff"));
        inApe.setFont(font7);

        JLabel inCor = new JLabel("Correo:");
        inCor.setBounds(280, 370, 200, 150);
        inCor.setForeground(Color.decode("#ffffff"));
        inCor.setFont(font7);

        JLabel inTel = new JLabel("Telefono:");
        inTel.setBounds(250, 450, 230, 150);
        inTel.setForeground(Color.decode("#ffffff"));
        inTel.setFont(font7);

        infor1.add(inDpi);
        infor1.add(inNom);
        infor1.add(inApe);
        infor1.add(inCor);
        infor1.add(inTel);

        //Label Menu
        JLabel tranLabel = new JLabel("TRANSFERIR");
        tranLabel.setBounds(425, 15, 500, 50);
        tranLabel.setForeground(Color.decode("#ffffff"));
        tranLabel.setFont(font4);

        JLabel tranLinea = new JLabel(new ImageIcon("img/linea.jpg"));
        tranLinea.setBounds(30, 75, 1075, 4);

        JLabel salLabel = new JLabel("SALDO");
        salLabel.setBounds(500, 15, 300, 50);
        salLabel.setForeground(Color.decode("#ffffff"));
        salLabel.setFont(font4);

        JLabel tCuentaS = new JLabel("Tipo de Cuenta:");
        tCuentaS.setBounds(240, 250, 400, 150);
        tCuentaS.setForeground(Color.decode("#ffffff"));
        tCuentaS.setFont(font7);

        JLabel noCuentaS = new JLabel("No. de Cuenta:");
        noCuentaS.setBounds(260, 330, 400, 150);
        noCuentaS.setForeground(Color.decode("#ffffff"));
        noCuentaS.setFont(font7);

        JLabel saldoS = new JLabel("Saldo:");
        saldoS.setBounds(405, 410, 300, 150);
        saldoS.setForeground(Color.decode("#ffffff"));
        saldoS.setFont(font7);

        JLabel salLinea = new JLabel(new ImageIcon("img/linea.jpg"));
        salLinea.setBounds(30, 75, 1075, 4);

        JLabel hisLabel = new JLabel("HISTORIAL");
        hisLabel.setBounds(450, 15, 300, 50);
        hisLabel.setForeground(Color.decode("#ffffff"));
        hisLabel.setFont(font4);

        JLabel hisLinea = new JLabel(new ImageIcon("img/linea.jpg"));
        hisLinea.setBounds(30, 75, 1075, 4);

        JLabel infoLabel = new JLabel("INFORMACION");
        infoLabel.setBounds(425, 15, 350, 50);
        infoLabel.setForeground(Color.decode("#ffffff"));
        infoLabel.setFont(font4);

        JLabel infoLinea = new JLabel(new ImageIcon("img/linea.jpg"));
        infoLinea.setBounds(30, 75, 1075, 4);

        depo.add(tranLabel);
        depo.add(tranLinea);
        psal.add(salLabel);
        psal.add(salLinea);
        psal.add(tCuentaS);
        psal.add(noCuentaS);
        psal.add(saldoS);
        his.add(hisLabel);
        his.add(hisLinea);
        infor1.add(infoLabel);
        infor1.add(infoLinea);

        //Label Informacion
        usDpi = new JLabel();
        usDpi.setBounds(500, 130, 600, 150);
        usDpi.setForeground(Color.WHITE);
        usDpi.setFont(font7);

        usNombre = new JLabel();
        usNombre.setBounds(500, 210, 600, 150);
        usNombre.setForeground(Color.WHITE);
        usNombre.setFont(font7);

        usApellido = new JLabel();
        usApellido.setBounds(500, 290, 600, 150);
        usApellido.setForeground(Color.WHITE);
        usApellido.setFont(font7);

        usCorreo = new JLabel();
        usCorreo.setBounds(500, 370, 600, 150);
        usCorreo.setForeground(Color.WHITE);
        usCorreo.setFont(font7);

        usTelefono = new JLabel();
        usTelefono.setBounds(500, 450, 600, 150);
        usTelefono.setForeground(Color.WHITE);
        usTelefono.setFont(font7);

        infor1.add(usDpi);
        infor1.add(usNombre);
        infor1.add(usApellido);
        infor1.add(usCorreo);
        infor1.add(usTelefono);

        //Label Saldo
        JLabel salCt = new JLabel("NO. DE CUENTA:");
        salCt.setBounds(370, 125, 500, 40);
        salCt.setForeground(Color.decode("#C48300"));
        salCt.setFont(font6);

        psal.add(salCt);

        sTipo = new JLabel();
        sTipo.setBounds(600, 250, 300, 150);
        sTipo.setForeground(Color.WHITE);
        sTipo.setFont(font4);

        sNumCuenta = new JLabel();
        sNumCuenta.setBounds(600, 330, 300, 150);
        sNumCuenta.setForeground(Color.WHITE);
        sNumCuenta.setFont(font4);

        sMonto = new JLabel();
        sMonto.setBounds(600, 410, 300, 150);
        sMonto.setForeground(Color.WHITE);
        sMonto.setFont(font4);

        psal.add(sTipo);
        psal.add(sNumCuenta);
        psal.add(sMonto);

        //Label MenuInicio
        JLabel MIsep = new JLabel(new ImageIcon("img/pariba.png"));
        MIsep.setBounds(310, 25, 1, 50);

        JLabel MIsep2 = new JLabel(new ImageIcon("img/pariba.png"));
        MIsep2.setBounds(500, 25, 1, 50);

        JLabel MIsep3 = new JLabel(new ImageIcon("img/pariba.png"));
        MIsep3.setBounds(640, 25, 1, 50);

        JLabel MIsep4 = new JLabel(new ImageIcon("img/pariba.png"));
        MIsep4.setBounds(800, 25, 1, 50);

        JLabel MIsep5 = new JLabel(new ImageIcon("img/pariba.png"));
        MIsep5.setBounds(910, 25, 1, 50);

        JLabel MIlineav = new JLabel(new ImageIcon("img/pariba.png"));
        MIlineav.setBounds(0, 0, 5, 100);

        JLabel MIlineav2 = new JLabel(new ImageIcon("img/pariba.png"));
        MIlineav2.setBounds(1135, 0, 5, 100);

        JLabel iconoP = new JLabel(new ImageIcon("img/letras3.png"));
        iconoP.setBounds(10, 5, 295, 85);

        JLabel MIlineal = new JLabel(new ImageIcon("img/linea2.JPG"));
        MIlineal.setBounds(0, 0, 2000, 5);

        JLabel MIlineal2 = new JLabel(new ImageIcon("img/linea2.JPG"));
        MIlineal2.setBounds(0, 95, 2000, 5);

        //Label MenuInicio2
        JLabel MI2sep = new JLabel(new ImageIcon("img/pariba.png"));
        MI2sep.setBounds(310, 25, 1, 50);

        JLabel MI2sep2 = new JLabel(new ImageIcon("img/pariba.png"));
        MI2sep2.setBounds(495, 25, 1, 50);

        JLabel MI2sep3 = new JLabel(new ImageIcon("img/pariba.png"));
        MI2sep3.setBounds(615, 25, 1, 50);

        JLabel MI2sep4 = new JLabel(new ImageIcon("img/pariba.png"));
        MI2sep4.setBounds(750, 25, 1, 50);

        JLabel MI2sep5 = new JLabel(new ImageIcon("img/pariba.png"));
        MI2sep5.setBounds(840, 25, 1, 50);

        JLabel MI2sep6 = new JLabel(new ImageIcon("img/pariba.png"));
        MI2sep6.setBounds(920, 25, 1, 50);

        JLabel MI2lineav = new JLabel(new ImageIcon("img/pariba.png"));
        MI2lineav.setBounds(0, 0, 5, 100);

        JLabel MI2lineav2 = new JLabel(new ImageIcon("img/pariba.png"));
        MI2lineav2.setBounds(1135, 0, 5, 100);

        JLabel iconoP2 = new JLabel(new ImageIcon("img/letras3.png"));
        iconoP2.setBounds(1, 5, 295, 85);

        JLabel MI2lineal = new JLabel(new ImageIcon("img/linea2.JPG"));
        MI2lineal.setBounds(0, 0, 2000, 5);

        JLabel MI2lineal2 = new JLabel(new ImageIcon("img/linea2.JPG"));
        MI2lineal2.setBounds(0, 95, 2000, 5);

        //Label Login
        JLabel img = new JLabel(new ImageIcon("img/icono2.png"));
        img.setBounds(110, 20, 150, 155);

        JLabel dpiLabel = new JLabel("DPI");
        dpiLabel.setBounds(30, 185, 100, 50);
        dpiLabel.setForeground(Color.WHITE);
        dpiLabel.setFont(font1);

        JLabel userLabel = new JLabel("PIN");
        userLabel.setBounds(30, 265, 100, 50);
        userLabel.setForeground(Color.WHITE);
        userLabel.setFont(font1);

        JLabel passLabel = new JLabel("Contraseña");
        passLabel.setBounds(30, 345, 100, 50);
        passLabel.setForeground(Color.WHITE);
        passLabel.setFont(font1);

        Login.add(dpiLabel);
        Login.add(userLabel);
        Login.add(passLabel);
        Login.add(img);

        //Label Registro
        JLabel img2 = new JLabel(new ImageIcon("img/registro1.png"));
        img2.setBounds(110, 15, 150, 155);

        JLabel RdpiLabel = new JLabel("DPI");
        RdpiLabel.setBounds(30, 175, 80, 50);
        RdpiLabel.setForeground(Color.WHITE);
        RdpiLabel.setFont(font1);

        JLabel nameLabel = new JLabel("Nombre");
        nameLabel.setBounds(30, 255, 80, 50);
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setFont(font1);

        JLabel apeLabel = new JLabel("Apellido");
        apeLabel.setBounds(190, 255, 80, 50);
        apeLabel.setForeground(Color.WHITE);
        apeLabel.setFont(font1);

        JLabel telLabel = new JLabel("Telefono");
        telLabel.setBounds(30, 335, 80, 50);
        telLabel.setForeground(Color.WHITE);
        telLabel.setFont(font1);

        JLabel corLabel = new JLabel("Correo Electronico");
        corLabel.setBounds(30, 415, 200, 50);
        corLabel.setForeground(Color.WHITE);
        corLabel.setFont(font1);

        Registro.add(RdpiLabel);
        Registro.add(telLabel);
        Registro.add(apeLabel);
        Registro.add(corLabel);
        Registro.add(nameLabel);
        Registro.add(img2);

        //Label Menu
        JLabel logo = new JLabel(new ImageIcon("img/logo3.png"));
        logo.setBounds(610, 180, 450, 450);

        JLabel lineaM = new JLabel(new ImageIcon("img/linea.jpg"));
        lineaM.setBounds(30, 75, 1075, 4);

        JLabel nlabelM = new JLabel("MENU");
        nlabelM.setBounds(530, 15, 200, 50);
        nlabelM.setForeground(Color.WHITE);
        nlabelM.setFont(font4);

        menu.add(logo);
        menu.add(lineaM);
        menu.add(nlabelM);

        // Label menu2
        //Label Traferecias
        JLabel ctDeslabel = new JLabel("NO. DE CUENTA:");
        ctDeslabel.setBounds(370, 125, 500, 40);
        ctDeslabel.setForeground(Color.decode("#C48300"));
        ctDeslabel.setFont(font6);

        JLabel nlabel = new JLabel("INGRESE LA CANTIDAD A TRANSFERIR");
        nlabel.setBounds(345, 280, 500, 150);
        nlabel.setForeground(Color.decode("#C48300"));
        nlabel.setFont(font6);

        JLabel NO = new JLabel("SELECCIONE EL NO. DE CUENTA A TRANFERIR");
        NO.setBounds(290, 145, 600, 150);
        NO.setForeground(Color.decode("#C48300"));
        NO.setFont(font6);

        depo.add(ctDeslabel);

        //Botones mensajes
        admin ad = new admin();
        Gerente gt = new Gerente();

        JButton acpTra = new JButton("Aceptar");
        acpTra.setBounds(100, 160, 100, 20);
        acpTra.setBackground(Color.decode("#c48300"));
        acpTra.setFocusable(false);
        acpTra.setFont(font2);
        acpTra.setForeground(Color.white);
        acpTra.setBorder(null);
        acpTra.setVisible(false);
        ActionListener acpT = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                msgusuario.setVisible(false);
                acpTra.setVisible(false);
                msgtra.setVisible(false);
                txt1.setText(null);
                cueDes.setText(null);
            }
        };

        JButton acpCu = new JButton("Aceptar");
        acpCu.setBounds(100, 160, 100, 20);
        acpCu.setBackground(Color.decode("#c48300"));
        acpCu.setFocusable(false);
        acpCu.setFont(font2);
        acpCu.setForeground(Color.white);
        acpCu.setBorder(null);
        acpCu.setVisible(false);
        ActionListener acpc = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                msgusuario.setVisible(false);
                acpCu.setVisible(false);
                msgcue.setVisible(false);
            }
        };

        JButton conUsu = new JButton("Continuar");
        conUsu.setBounds(100, 160, 100, 20);
        conUsu.setBackground(Color.decode("#c48300"));
        conUsu.setFocusable(false);
        conUsu.setFont(font2);
        conUsu.setForeground(Color.white);
        conUsu.setBorder(null);
        conUsu.setVisible(false);
        ActionListener cUsu = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                msgusuario.setVisible(false);
                PMenu2.setVisible(true);
                PMenu.setVisible(false);
                Login.setVisible(false);
                publiS.setVisible(true);
                publiS1.setVisible(true);
                publiS2.setVisible(true);
                conUsu.setVisible(false);
                msgusu.setVisible(false);
                imagen1.setVisible(false);
                imagen2.setVisible(false);
                imagen3.setVisible(false);
                imagen4.setVisible(false);
                imagen5.setVisible(true);

                user.setText(null);
                password.setText(null);
                Ldpi.setText(null);
            }
        };

        JButton conGer = new JButton("Continuar");
        conGer.setBounds(100, 160, 100, 20);
        conGer.setBackground(Color.decode("#c48300"));
        conGer.setFocusable(false);
        conGer.setFont(font2);
        conGer.setForeground(Color.white);
        conGer.setBorder(null);
        conGer.setVisible(false);
        ActionListener cGer = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                msgusuario.setVisible(false);
                ad.setVisible(true);
                gt.setVisible(false);
                conGer.setVisible(false);
                msgger.setVisible(false);
                dispose();
                user.setText(null);
                password.setText(null);
                Ldpi.setText(null);
            }
        };

        JButton conAdm = new JButton("Continuar");
        conAdm.setBounds(100, 160, 100, 20);
        conAdm.setBackground(Color.decode("#c48300"));
        conAdm.setFocusable(false);
        conAdm.setFont(font2);
        conAdm.setForeground(Color.white);
        conAdm.setBorder(null);
        conAdm.setVisible(false);
        ActionListener cAdm = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                msgusuario.setVisible(false);
                ad.setVisible(false);
                gt.setVisible(true);
                conAdm.setVisible(false);
                msgadm.setVisible(false);
                dispose();
                user.setText(null);
                password.setText(null);
                Ldpi.setText(null);
            }
        };

        msgusuario.add(conUsu);
        msgusuario.add(conGer);
        msgusuario.add(conAdm);
        msgusuario.add(acpTra);
        msgusuario.add(acpCu);

        conUsu.addActionListener(cUsu);
        conGer.addActionListener(cAdm);
        conAdm.addActionListener(cGer);
        acpTra.addActionListener(acpT);
        acpCu.addActionListener(acpc);

        //Botones Cuentas
        JButton crearCt = new JButton("CREAR");
        crearCt.setBounds(460, 440, 225, 50);
        crearCt.setBackground(Color.decode("#ffffff"));
        crearCt.setFocusable(false);
        crearCt.setFont(font5);
        crearCt.setForeground(Color.BLACK);
        crearCt.setBorder(null);
        ActionListener crearCuenta = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crearCuenta();
                acpCu.setVisible(true);
            }
        };

        //Botones MenuInicio
        JButton mInicio = new JButton();
        mInicio.setIcon(new ImageIcon("img/letras3.png"));
        mInicio.setBounds(5, 7, 295, 85);
        mInicio.setBackground(Color.WHITE);
        mInicio.setFocusable(false);
        mInicio.setBorder(null);
        ActionListener aInicio = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mein.setVisible(true);
                imagen5.setVisible(true);
                imagen4.setVisible(false);
                imagen3.setVisible(false);
                imagen2.setVisible(false);
                imagen1.setVisible(false);
            }
        };

        mInicio.addActionListener(aInicio);
        PMenu.add(mInicio);

        JButton opt = new JButton("opcion");
        opt.setBounds(650, 375, 125, 60);
        opt.setFont(font1);
        opt.setFocusable(false);
        opt.setBackground(Color.blue);
        opt.setForeground(Color.white);
        opt.setBorder(null);
        ActionListener evento10 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Registro.setVisible(true);
                Login.setVisible(false);
                publiS.setVisible(false);
                publiS1.setVisible(false);
                publiS2.setVisible(false);

            }
        };

        JButton vision = new JButton("Vision");
        vision.setBounds(825, 35, 60, 30);
        vision.setFont(font1);
        vision.setBackground(Color.decode("#ffffff"));
        vision.setForeground(Color.BLACK);
        vision.setBorder(null);
        vision.setFocusable(false);
        ActionListener evento7 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                imagen1.setVisible(false);
                imagen2.setVisible(true);
                imagen3.setVisible(false);
                imagen4.setVisible(false);
                imagen5.setVisible(false);
            }
        };

        JButton contactos = new JButton("Contactanos");
        contactos.setBounds(671, 35, 100, 30);
        contactos.setFont(font1);
        contactos.setFocusable(false);
        contactos.setBackground(Color.decode("#ffffff"));
        contactos.setForeground(Color.BLACK);
        contactos.setBorder(null);
        ActionListener evento8 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                imagen1.setVisible(false);
                imagen2.setVisible(false);
                imagen3.setVisible(false);
                imagen4.setVisible(true);
                imagen5.setVisible(false);

            }
        };

        JButton nhelp = new JButton("<html><center>¿Nesecitas<br>ayuda?</center></html>"); ///////////////
        nhelp.setBounds(520, 20, 100, 60);
        nhelp.setFont(font1);
        nhelp.setFocusable(false);
        nhelp.setBackground(Color.decode("#ffffff"));
        nhelp.setForeground(Color.BLACK);
        nhelp.setBorder(null);
        ActionListener evento11 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                imagen1.setVisible(false);
                imagen2.setVisible(false);
                imagen3.setVisible(true);
                imagen4.setVisible(false);
                imagen5.setVisible(false);

                //publi2.setVisible(false);
            }
        };

        JButton somos = new JButton("¿Quienes somos?");
        somos.setBounds(330, 35, 150, 30);
        somos.setFont(font1);
        somos.setFocusable(false);
        somos.setBackground(Color.decode("#ffffff"));
        somos.setForeground(Color.BLACK);
        somos.setBorder(null);
        ActionListener evento9 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                imagen1.setVisible(true);
                imagen2.setVisible(false);
                imagen3.setVisible(false);
                imagen4.setVisible(false);
                imagen5.setVisible(false);

            }
        };

        JButton inicia = new JButton("Iniciar Sesion");
        inicia.setBounds(950, 35, 150, 30);
        inicia.setFont(font1);
        inicia.setForeground(Color.WHITE);
        inicia.setFocusable(false);
        inicia.setBackground(Color.decode("#c48300"));

        ActionListener evento3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login.setVisible(true);
                Registro.setVisible(false);
                publiS.setVisible(false);
                publiS1.setVisible(false);
                publiS2.setVisible(false);
            }
        };

        //Botones Menu
        JButton depositar = new JButton("<html><center>TRANSFERIR</center>");
        depositar.setIcon(new ImageIcon("img/puerco.png"));
        depositar.setBounds(30, 185, 225, 100);
        depositar.setFont(font5);
        depositar.setFocusable(false);
        depositar.setForeground(Color.WHITE);
        depositar.setBackground(Color.decode("#C48300"));
        ActionListener dep = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                noC.removeAllItems();
                listaCuentas(dpiLogin);
                mein.setVisible(false);
                depo.setVisible(true);
                menu.setVisible(false);
            }
        };

        JButton saldo = new JButton("<html><center>SALDO</center>");
        saldo.setIcon(new ImageIcon("img/slado.png"));
        saldo.setBounds(320, 185, 225, 100);
        saldo.setFont(font5);
        saldo.setFocusable(false);
        saldo.setForeground(Color.WHITE);
        saldo.setBackground(Color.decode("#C48300"));
        ActionListener sald = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                infoCt.removeAllItems();
                listaCuentas(dpiLogin);
                mein.setVisible(false);
                psal.setVisible(true);
                menu.setVisible(false);
                obtenerInfoCuentaPorDpi(dpiLogin, infoCt.getSelectedItem().toString());
            }
        };

        JButton historial = new JButton("<html><center>HISTORIAL</center>");
        historial.setIcon(new ImageIcon("img/his.png"));
        historial.setBounds(30, 360, 225, 100);
        historial.setFont(font5);
        historial.setFocusable(false);
        historial.setForeground(Color.WHITE);
        historial.setBackground(Color.decode("#C48300"));
        ActionListener his1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hisCuen.removeAllItems();
                listaCuentas(dpiLogin);
                mein.setVisible(false);
                his.setVisible(true);
                menu.setVisible(false);
                cargarDatos2();
            }
        };

        JButton info = new JButton("<html><center>INFORMACION</center>");
        info.setIcon(new ImageIcon("img/informacion.png"));
        info.setBounds(320, 360, 225, 100);
        info.setFont(font5);
        info.setFocusable(false);
        info.setForeground(Color.WHITE);
        info.setBackground(Color.decode("#C48300"));
        ActionListener inf = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mein.setVisible(false);
                infor1.setVisible(true);
                menu.setVisible(false);
                //cargarDatos3();
                obtenerInfoUsuario(dpiLogin);
            }
        };

        JButton cuent = new JButton("<html><center>Cuentas</center>");
        cuent.setIcon(new ImageIcon("img/cuenta.png"));
        cuent.setBounds(30, 530, 225, 100);
        cuent.setFont(font5);
        cuent.setFocusable(false);
        cuent.setForeground(Color.WHITE);
        cuent.setBackground(Color.decode("#C48300"));

        ActionListener ct = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mein.setVisible(false);
                mCuent.setVisible(true);
                menu.setVisible(false);
            }
        };

        JButton salir = new JButton("<html><center>SALIR</center>");
        salir.setIcon(new ImageIcon("img/cerrar.png"));
        salir.setBounds(320, 530, 225, 100);
        salir.setFont(font5);
        salir.setFocusable(false);
        salir.setForeground(Color.WHITE);
        salir.setBackground(Color.decode("#C48300"));

        ActionListener sal = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu.setVisible(false);
                mein.setVisible(true);
                publi.setVisible(true);

            }
        };

        //Botones MenuInicio2
        JButton mInicio2 = new JButton();
        mInicio2.setIcon(new ImageIcon("img/letras3.png"));
        mInicio2.setBounds(5, 7, 295, 85);
        mInicio2.setBackground(Color.WHITE);
        mInicio2.setFocusable(false);
        mInicio2.setBorder(null);
        ActionListener aInicio2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mein.setVisible(true);
                menu.setVisible(false);
                imagen5.setVisible(true);
                imagen4.setVisible(false);
                imagen3.setVisible(false);
                imagen2.setVisible(false);
                imagen1.setVisible(false);
                publi.setVisible(true);
                publiS.setVisible(true);
                publiS1.setVisible(true);
                publiS2.setVisible(true);
                depo.setVisible(false);
                mCuent.setVisible(false);
                psal.setVisible(false);
                his.setVisible(false);
                infor1.setVisible(false);
            }
        };

        mInicio2.addActionListener(aInicio2);
        PMenu2.add(mInicio2);

        JButton vision2 = new JButton("Vision"); ////////////////////////////////////////////////////////
        vision2.setBounds(760, 35, 70, 30);
        vision2.setFont(font1);
        vision2.setBackground(Color.decode("#ffffff"));
        vision2.setForeground(Color.BLACK);
        vision2.setFocusable(false);
        vision2.setBorder(null);
        ActionListener visones = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                publi.setVisible(true);
                imagen1.setVisible(false);
                imagen2.setVisible(true);
                imagen3.setVisible(false);
                imagen4.setVisible(false);
                mein.setVisible(true);
                menu.setVisible(false);
                imagen5.setVisible(false);
                publi.setVisible(true);
                publiS.setVisible(true);
                publiS1.setVisible(true);
                publiS2.setVisible(true);
                depo.setVisible(false);
                mCuent.setVisible(false);
                psal.setVisible(false);
                his.setVisible(false);
                infor1.setVisible(false);
            }
        };

        JButton contactos2 = new JButton("Contactanos");
        contactos2.setBounds(630, 35, 100, 30);
        contactos2.setFont(font1);
        contactos2.setBackground(Color.decode("#ffffff"));
        contactos2.setForeground(Color.BLACK);
        contactos2.setFocusable(false);
        contactos2.setBorder(null);
        ActionListener parlamento = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                imagen1.setVisible(false);
                imagen2.setVisible(false);
                imagen3.setVisible(false);
                imagen4.setVisible(true);
                mein.setVisible(true);
                menu.setVisible(false);
                imagen5.setVisible(false);
                publi.setVisible(true);
                publiS.setVisible(true);
                publiS1.setVisible(true);
                publiS2.setVisible(true);
                depo.setVisible(false);
                mCuent.setVisible(false);
                psal.setVisible(false);
                his.setVisible(false);
                infor1.setVisible(false);
            }
        };

        JButton nhelp2 = new JButton("<html><center>¿Nesecitas<br>ayuda?</center></html>");
        nhelp2.setBounds(505, 20, 100, 60);
        nhelp2.setFont(font1);
        nhelp2.setBackground(Color.decode("#ffffff"));
        nhelp2.setForeground(Color.BLACK);
        nhelp2.setFocusable(false);
        nhelp2.setBorder(null);
        ActionListener parlamento1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                imagen1.setVisible(false);
                imagen2.setVisible(false);
                imagen3.setVisible(true);
                imagen4.setVisible(false);
                mein.setVisible(true);
                menu.setVisible(false);
                imagen5.setVisible(false);
                publi.setVisible(true);
                publiS.setVisible(true);
                publiS1.setVisible(true);
                publiS2.setVisible(true);
                depo.setVisible(false);
                mCuent.setVisible(false);
                psal.setVisible(false);
                his.setVisible(false);
                infor1.setVisible(false);
            }
        };

        JButton somos2 = new JButton("¿Quienes somos?");
        somos2.setBounds(325, 35, 150, 30);
        somos2.setFont(font1);
        somos2.setBackground(Color.decode("#ffffff"));
        somos2.setForeground(Color.BLACK);
        somos2.setFocusable(false);
        somos2.setBorder(null);
        ActionListener somosguys = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                imagen1.setVisible(true);
                imagen2.setVisible(false);
                imagen3.setVisible(false);
                imagen4.setVisible(false);
                mein.setVisible(true);
                menu.setVisible(false);
                imagen5.setVisible(false);
                publi.setVisible(true);
                publiS.setVisible(true);
                publiS1.setVisible(true);
                publiS2.setVisible(true);
                depo.setVisible(false);
                mCuent.setVisible(false);
                psal.setVisible(false);
                his.setVisible(false);
                infor1.setVisible(false);
            }
        };

        JButton menu2 = new JButton("Menú");
        menu2.setBounds(855, 35, 50, 30);
        menu2.setFont(font1);
        menu2.setBackground(Color.decode("#ffffff"));
        menu2.setForeground(Color.BLACK);
        menu2.setFocusable(false);
        menu2.setBorder(null);

        ActionListener AbrirM = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                publi.setVisible(false);
                mein.setVisible(false);
                depo.setVisible(false);
                mCuent.setVisible(false);
                menu.setVisible(true);
                infor1.setVisible(false);
                psal.setVisible(false);
                his.setVisible(false);
                txt1.setText(null);
                cueDes.setText(null);
            }
        };

        JButton cerrars = new JButton("Cerrar Sesion");
        cerrars.setBounds(950, 30, 150, 30);
        cerrars.setFont(font1);
        cerrars.setFocusable(false);
        cerrars.setForeground(Color.WHITE);
        cerrars.setBackground(Color.decode("#c48300"));

        ActionListener evento4 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txt1.setText(null);
                publi.setVisible(true);
                PMenu2.setVisible(false);
                PMenu.setVisible(true);
                menu.setVisible(false);
                mein.setVisible(true);
                depo.setVisible(false);
                infor1.setVisible(false);
                psal.setVisible(false);
                his.setVisible(false);
                imagen1.setVisible(false);
                imagen2.setVisible(false);
                imagen3.setVisible(false);
                imagen4.setVisible(false);
                imagen5.setVisible(true);
                publiS.setVisible(true);
                publiS1.setVisible(true);
                publiS2.setVisible(true);
            }
        };
        //Botones Login
        JButton iniciar = new JButton("Iniciar Sesion");
        iniciar.setBounds(110, 450, 150, 35);
        iniciar.setFont(font1);
        iniciar.setForeground(Color.WHITE);
        iniciar.setFocusable(false);
        iniciar.setBackground(Color.decode("#c48300"));
        ActionListener evento1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Conexion conectar = new Conexion();
                String dato1 = Ldpi.getText();
                String dato2 = user.getText();
                numero = Ldpi.getText();
                String dato3 = String.valueOf(password.getPassword());
                String query2 = "select * from usuario_rol where DPI ='" + dato1 + "'and id_rol ='1';";
                String query3 = "select * from usuario_rol where DPI ='" + dato1 + "'and id_rol ='2';";
                String query4 = "select * from usuario_rol where DPI ='" + dato1 + "'and id_rol ='3';";
                String query5 = "select * from usuario where pass = '" + dato3 + "' and pin = '" + dato2 + "';";
                try {
                    Statement stan2 = (Statement) conectar.getConnection().createStatement();
                    Statement stan3 = (Statement) conectar.getConnection().createStatement();
                    Statement stan4 = (Statement) conectar.getConnection().createStatement();
                    Statement stan5 = (Statement) conectar.getConnection().createStatement();
                    ResultSet rest2 = stan2.executeQuery(query2);
                    ResultSet rest3 = stan3.executeQuery(query3);
                    ResultSet rest4 = stan4.executeQuery(query4);
                    ResultSet rest5 = stan5.executeQuery(query5);
                    if (rest2.next() && rest5.next()) {
                        dpiLogin = dato1.toString();
                        conUsu.setVisible(true);
                        msgusuario.setVisible(true);
                        msgusu.setVisible(true);
                    } else if (rest3.next() && rest5.next()) {
                        conAdm.setVisible(true);
                        msgusuario.setVisible(true);
                        msgadm.setVisible(true);

                    } else if (rest4.next() && rest5.next()) {
                        conGer.setVisible(true);
                        msgusuario.setVisible(true);
                        msgger.setVisible(true);

                    } else {
                        JOptionPane.showMessageDialog(null, "El usuario no existe en la BD");
                    }

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "El usuario no existe en la BD");
                    Logger.getLogger(NOSE.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        };
        JButton registro = new JButton("<html><em>Deseas Registrarte?</em></html>");
        registro.setBounds(100, 491, 170, 35);
        registro.setFont(font1);
        registro.setBackground(Color.decode("#242424"));
        registro.setForeground(Color.white);
        registro.setBorder(null);

        ActionListener evento2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Login.setVisible(false);
                Registro.setVisible(true);

            }
        };

        JButton Lcerrar = new JButton("X");
        Lcerrar.setBounds(329, 2, 20, 20);
        Lcerrar.setFont(font3);
        Lcerrar.setBackground(Color.decode("#C82F2F"));
        Lcerrar.setForeground(Color.white);
        Lcerrar.setBorder(null);
        Lcerrar.setFocusable(false);
        ActionListener cerrar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login.setVisible(false);
                user.setText(null);
                password.setText(null);
                publiS.setVisible(true);
                publiS1.setVisible(true);
                publiS2.setVisible(true);
            }
        };

        //Botones Registro
        JButton solicitar = new JButton("Solicitar");
        solicitar.setBounds(180, 530, 120, 35);
        solicitar.setFont(font1);
        solicitar.setBackground(Color.decode("#c48300"));
        solicitar.setForeground(Color.white);
        solicitar.setBorder(null);

        String TRdpi = Rdpi.getText();
        TRdpi = TRdpi.replaceAll(" ", "");
        String Tnombre = Rdpi.getText();
        Tnombre = Tnombre.replaceAll(" ", "");
        String Tape = Rdpi.getText();
        Tape = Tape.replaceAll(" ", "");
        String Ttel = Rdpi.getText();
        Ttel = Ttel.replaceAll(" ", "");
        String Tcorreo = Rdpi.getText();
        Tcorreo = Tcorreo.replaceAll(" ", "");
        ActionListener soli = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Rdpi.getText().length() == 0 || nombre.getText().length() == 0 || apellido.getText().length() == 0 || telefono.getText().length() == 0 || correo.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "Ingrese correctamente los datos solicitados");
                    Rdpi.setFocusable(true);
                } else {
                    Registro.setVisible(false);
                    Login.setVisible(true);
                    registroUsuario();
                    Rdpi.setText(null);
                    nombre.setText(null);
                    apellido.setText(null);
                    telefono.setText(null);
                    correo.setText(null);
                }
            }

        };

        JButton volver = new JButton("Volver");
        volver.setBounds(40, 530, 120, 35);
        volver.setFont(font1);
        volver.setForeground(Color.WHITE);
        volver.setBackground(Color.decode("#c48300"));

        ActionListener vol = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nombre.setText(null);
                telefono.setText(null);
                correo.setText(null);
                Login.setVisible(true);
                Registro.setVisible(false);
            }
        };

        JButton Rcerrar = new JButton("X");
        Rcerrar.setBounds(329, 2, 20, 20);
        Rcerrar.setFont(font3);
        Rcerrar.setBackground(Color.decode("#C82F2F"));
        Rcerrar.setForeground(Color.white);
        Rcerrar.setBorder(null);
        Rcerrar.setFocusable(false);
        ActionListener cerrar2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Registro.setVisible(false);
                publiS.setVisible(true);
                publiS1.setVisible(true);
                publiS2.setVisible(true);
            }
        };
        //botones transaccion      
        JButton depositar1 = new JButton("<html><center>TRANSFERIR</center>");
        depositar1.setBounds(830, 480, 225, 50);
        depositar1.setFont(font5);
        depositar1.setForeground(Color.BLACK);
        depositar1.setBackground(Color.WHITE);
        depositar1.setFocusable(false);
        ActionListener ingresar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                solicitarTransferencia();
                acpTra.setVisible(true);
            }
        };

        // volver depositar
        JButton salir1 = new JButton("<html><center>VOLVER</center>");
        salir1.setBounds(470, 620, 225, 50);
        salir1.setFont(font5);
        salir1.setForeground(Color.WHITE);
        salir1.setBackground(Color.decode("#121212"));
        salir1.setFocusable(false);
        ActionListener vol1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txt1.setText(null);
                cueDes.setText(null);
                depo.setVisible(false);
                menu.setVisible(true);
                infor1.setVisible(false);
                psal.setVisible(false);
                his.setVisible(false);
            }
        };

        // volver historial
        JButton salir2 = new JButton("<html><center>VOLVER</center>");
        salir2.setBounds(470, 620, 225, 50);
        salir2.setFont(font5);
        salir2.setForeground(Color.WHITE);
        salir2.setBackground(Color.decode("#121212"));
        salir2.setFocusable(false);
        ActionListener vol2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                depo.setVisible(false);
                menu.setVisible(true);
                infor1.setVisible(false);
                psal.setVisible(false);
                his.setVisible(false);
            }
        };

        // volver informacion
        JButton salir3 = new JButton("<html><center>VOLVER</center>");
        salir3.setBounds(470, 620, 225, 50);
        salir3.setFont(font5);
        salir3.setForeground(Color.WHITE);
        salir3.setBackground(Color.decode("#121212"));
        salir3.setFocusable(false);
        ActionListener vol3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                depo.setVisible(false);
                menu.setVisible(true);
                infor1.setVisible(false);
                psal.setVisible(false);
                his.setVisible(false);
            }
        };

        // volver saldo
        JButton salir5 = new JButton("<html><center>VOLVER</center>");
        salir5.setBounds(470, 620, 225, 50);
        salir5.setFont(font5);
        salir5.setForeground(Color.WHITE);
        salir5.setBackground(Color.decode("#121212"));
        salir5.setFocusable(false);
        ActionListener vol5 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                depo.setVisible(false);
                menu.setVisible(true);
                infor1.setVisible(false);
                psal.setVisible(false);
                his.setVisible(false);
            }
        };

        // volver Cuenta
        JButton salir6 = new JButton("<html><center>VOLVER</center>");
        salir6.setBounds(470, 620, 225, 50);
        salir6.setFont(font5);
        salir6.setForeground(Color.WHITE);
        salir6.setBackground(Color.decode("#121212"));
        salir6.setFocusable(false);
        ActionListener vol6 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mCuent.setVisible(false);
                depo.setVisible(false);
                menu.setVisible(true);
                infor1.setVisible(false);
                psal.setVisible(false);
                his.setVisible(false);
            }
        };

        Login.add(registro);
        Login.add(iniciar);
        Login.add(Lcerrar);

        //-----------------------------------------------------------------
        iniciar.addActionListener(evento1);
        registro.addActionListener(evento2);
        inicia.addActionListener(evento3);
        Lcerrar.addActionListener(cerrar);
        Rcerrar.addActionListener(cerrar2);
        cerrars.addActionListener(evento4);
        menu2.addActionListener(AbrirM);
        volver.addActionListener(vol);
        solicitar.addActionListener(soli);
        salir.addActionListener(sal);
        vision.addActionListener(evento7);
        contactos.addActionListener(evento8);
        somos.addActionListener(evento9);
        depositar.addActionListener(dep);
        salir1.addActionListener(vol1);
        saldo.addActionListener(sald);
        historial.addActionListener(his1);
        info.addActionListener(inf);
        salir2.addActionListener(vol2);
        salir3.addActionListener(vol3);
        salir5.addActionListener(vol5);
        salir6.addActionListener(vol6);
        somos2.addActionListener(somosguys);
        vision2.addActionListener(visones);
        contactos2.addActionListener(parlamento);
        depositar1.addActionListener(ingresar);
        opt.addActionListener(evento10);
        cuent.addActionListener(ct);
        nhelp.addActionListener(evento11);
        nhelp2.addActionListener(parlamento1);
        crearCt.addActionListener(crearCuenta);

        Registro.add(solicitar);
        Registro.add(volver);
        Registro.add(Rcerrar);

        mCuent.add(crearCt);

        menu.add(depositar);
        menu.add(saldo);
        menu.add(historial);
        menu.add(info);
        menu.add(cuent);
        menu.add(salir);

        depo.add(depositar1);
        depo.add(salir1);
        depo.add(nlabel);
        depo.add(NO);
        depo.add(txt1);
        depo.add(noC);

        his.add(salir2);
        infor1.add(salir3);
        psal.add(salir5);
        mCuent.add(salir6);

        //finalimg
        PMenu.add(MIsep);
        PMenu.add(MIsep2);
        PMenu.add(MIsep3);
        PMenu.add(MIsep4);
        PMenu.add(MIsep5);
        PMenu.add(MIlineav);
        PMenu.add(inicia);
        PMenu.add(vision);
        PMenu.add(contactos);
        PMenu.add(MIlineal);
        PMenu.add(MIlineal2);
        PMenu.add(MIlineav2);
        PMenu.add(iconoP);
        PMenu.add(nhelp);
        PMenu.add(somos);

        PMenu2.add(MI2sep);
        PMenu2.add(MI2sep2);
        PMenu2.add(MI2sep3);
        PMenu2.add(MI2sep4);
        PMenu2.add(MI2sep5);
        PMenu2.add(MI2sep6);
        PMenu2.add(MI2lineav);
        PMenu2.add(MI2lineav2);
        PMenu2.add(cerrars);
        PMenu2.add(vision2);
        PMenu2.add(contactos2);
        PMenu2.add(iconoP2);
        PMenu2.add(MI2lineal);
        PMenu2.add(MI2lineal2);
        PMenu2.add(nhelp2);
        PMenu2.add(somos2);
        PMenu2.add(menu2);

    }

    //ingresar saldo
    //boton de ingreso
    private void ingresarsaldo() {
        //declara una variable para JTextFiel
        String ncuenta = noC.getSelectedItem().toString();
        String cantidad = txt1.getText();
        Conexion conectar = new Conexion();
        try {
            Connection con = conectar.getConnection();
            String query = "INSERT INTO saldos VALUES (?, ?);";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, ncuenta);
            stmt.setString(2, cantidad);
            stmt.executeUpdate();
            stmt.close();
            con.close();
            JOptionPane.showMessageDialog(NOSE.this, "Datos guardados correctamente");
            txt1.setText(null);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(NOSE.this, "Error al guardar los datos");
        }
    }

    //Cargar Tabla saldo
    public void cargarDatos() {
        modeloTabla1.setRowCount(0);
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/banco2", "root", "compu123");

            String query = "SELECT * FROM saldos WHERE DPI = '" + numero + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            String[] columnNames = new String[columnCount];

            for (int i = 1; i <= columnCount; i++) {
                columnNames[i - 1] = rsmd.getColumnName(i);
            }
            modeloTabla1.setColumnIdentifiers(columnNames);
            while (rs.next()) {
                String dpi = rs.getString("DPI");
                String ncu = rs.getString("numero_cuenta");
                String saldo = rs.getString("saldo");
                Object[] fila = {dpi, ncu, saldo};
                modeloTabla1.addRow(fila);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(NOSE.this, "Error al cargar los datos");
        }
    }

    //Cargar Tabla Historial
    private void cargarDatos2() {
        modeloTabla1.setRowCount(0);
        String numeroCuenta = hisCuen.getSelectedItem().toString();
        System.out.println("cuenta: " + numeroCuenta);
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Banco2", "root", "compu123");

            String query = "select \n"
                    + "id_transaccion, \n"
                    + "fecha_transaccion,\n"
                    + "case tipo_transaccion \n"
                    + "when 'D' \n"
                    + "then 'DEBITO'\n"
                    + "when 'C'\n"
                    + "then 'CREDITO' \n"
                    + "else tipo_transaccion \n"
                    + "end tipo_transaccion, monto, cuenta_destino from transaccion where numero_cuenta = '" + numeroCuenta + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            String[] columnNames = new String[columnCount];

            for (int i = 1; i <= columnCount; i++) {
                columnNames[i - 1] = rsmd.getColumnName(i);
            }
            modeloTabla1.setColumnIdentifiers(columnNames);
            while (rs.next()) {
                String idt = rs.getString("id_transaccion");
                String ftrans = rs.getString("fecha_transaccion");
                String ttrans = rs.getString("tipo_transaccion");
                String mont = rs.getString("monto");
                String CDes = rs.getString("cuenta_destino");
                Object[] fila = {idt, ftrans, ttrans, mont, CDes};
                modeloTabla1.addRow(fila);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(NOSE.this, "Error al cargar los datos");
        }
    }

    //Cargar informacion
    /*private void cargarDatos3() {
        modeloTabla1.setRowCount(0);
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/banco2", "root", "compu123");

            String query = "SELECT * FROM usuario WHERE DPI = '" + dpiLogin + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            String[] columnNames = new String[columnCount];

            for (int i = 1; i <= columnCount; i++) {
                columnNames[i - 1] = rsmd.getColumnName(i);
            }
            modeloTabla1.setColumnIdentifiers(columnNames);
            while (rs.next()) {
                String Ide = rs.getString("dpi");
                String name = rs.getString("nombre");
                String tel = rs.getString("apellido");
                String cor = rs.getString("Correo");
                String pass = rs.getString("telefono");
                Object[] fila = {Ide, name, tel, cor, pass};
                modeloTabla1.addRow(fila);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(NOSE.this, "Error al cargar los datos");
        }
    }*/
    public void imagen() {
        JLabel fondo = new JLabel(new ImageIcon("img/Firefly guatemala city on twilight in px 1280 1024 16096.jpg"));
        fondo.setBounds(0, 0, 1280, 1024);
        this.add(fondo);

    }

    public void inicializar() {
        this.panel();

        this.imagen();
    }

    public void registroUsuario() {
        Cliente cliente = new Cliente();
        cliente.setDpi(Rdpi.getText());
        cliente.setNombre(nombre.getText());
        cliente.setApellido(apellido.getText());
        cliente.setTelefono(telefono.getText());
        cliente.setCorreo(correo.getText());

        System.out.println(cliente.toString());

        BDConsultas.registrarUsuario(cliente);
    }

    public void solicitarTransferencia() {
        int cuentaOrigen = Integer.valueOf(noC.getSelectedItem().toString());
        int cuentaDestino = Integer.valueOf(cueDes.getText());
        double monto = Double.valueOf(txt1.getText());
            transferencia(cuentaOrigen, cuentaDestino, monto);
    }

    public void transferencia(int cuentaOrigen, int cuentaDestino, double monto) {

        try {
            double saldo = Double.valueOf(obtenerSaldo(cuentaOrigen));
            if (monto <= saldo && monto != 0) {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Banco2", "root", "compu123");
                String query = "INSERT INTO transaccion (numero_cuenta, monto, tipo_transaccion, fecha_transaccion, cuenta_destino)"
                        + " VALUES (?, ?, ?, sysdate(), ?)";
                PreparedStatement stmt = con.prepareStatement(query);
                stmt.setString(1, String.valueOf(cuentaOrigen));
                stmt.setString(2, String.valueOf(monto * -1));
                stmt.setString(3, "D");
                stmt.setString(4, String.valueOf(cuentaDestino));
                stmt.executeUpdate();

                String query2 = "INSERT INTO transaccion (numero_cuenta, monto, tipo_transaccion, fecha_transaccion, cuenta_destino)"
                        + " VALUES (?, ?, ?, sysdate(), ?)";
                PreparedStatement stmt2 = con.prepareStatement(query2);
                stmt2.setString(1, String.valueOf(cuentaDestino));
                stmt2.setString(2, String.valueOf(monto));
                stmt2.setString(3, "C");
                stmt2.setString(4, null);
                stmt2.executeUpdate();

                stmt.close();
                con.close();
                msgusuario.setVisible(true);
                msgtra.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "No cuenta con el saldo suficiente para la tranferencia");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al realizar la tranferencia");
        }
    }

    public String obtenerSaldo(int numeroCuenta) {
        String monto = "0";
        ResultSet rs;
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Banco2", "root", "compu123");
            String query3 = "select ROUND(COALESCE(sum(monto),0),2) from transaccion where numero_cuenta = ?;";
            PreparedStatement stmt2 = con.prepareStatement(query3);
            stmt2.setString(1, String.valueOf(numeroCuenta));
            rs = stmt2.executeQuery();
            while (rs.next()) {
                monto = rs.getString(1);
                System.out.println("monto: " + monto);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return monto;
    }

    public String obtenerCuentaPorDpi(String dpi) {
        String numeroCuenta = "0";
        ResultSet rs;
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Banco2", "root", "compu123");
            String query3 = "select numero_cuenta from cuenta where dpi = ?;";
            PreparedStatement stmt2 = con.prepareStatement(query3);
            stmt2.setString(1, dpi);
            rs = stmt2.executeQuery();
            while (rs.next()) {
                numeroCuenta = rs.getString(1);
                System.out.println("Numero de Cuenta: " + numeroCuenta);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error en su solicitud");
        }
        return numeroCuenta;
    }

    public void obtenerInfoCuentaPorDpi(String dpi, String numCTS) {
        String tipoCuenta = "0";
        String numeroCuenta = "0";
        String monto = "0";
        ResultSet rs;
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Banco2", "root", "compu123");
            String query = "select tc.nombre tipo_cuenta, \n"
                    + "ct.numero_cuenta,\n"
                    + "(select ROUND(COALESCE(sum(monto),0),2) from transaccion where numero_cuenta = (select numero_cuenta from cuenta where dpi = ? and numero_cuenta = ? limit 1)) saldo\n"
                    + "from cuenta ct\n"
                    + "inner join tipo_cuenta tc on tc.id_tipo_cuenta = ct.id_tipo_cuenta \n"
                    + "where ct.dpi = ? and ct.numero_cuenta = ?;";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, String.valueOf(dpi));
            stmt.setString(2, String.valueOf(numCTS));
            stmt.setString(3, String.valueOf(dpi));
            stmt.setString(4, String.valueOf(numCTS));
            rs = stmt.executeQuery();
            while (rs.next()) {
                tipoCuenta = rs.getString(1);
                numeroCuenta = rs.getString(2);
                monto = rs.getString(3);
                System.out.println("Tipo: " + tipoCuenta + "\nNo. Cuenta: " + numeroCuenta + "\nMonto: " + monto);
            }
            sTipo.setText(tipoCuenta);
            sNumCuenta.setText(numeroCuenta);
            sMonto.setText("Q." + monto);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void obtenerInfoUsuario(String dpi) {
        String usuDpi = "0";
        String usuNombre = "0";
        String usuApellido = "0";
        String usuCorreo = "0";
        String usuTelefono = "0";
        ResultSet rs;
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Banco2", "root", "compu123");
            String query = "select dpi, nombre, apellido, correo, telefono from usuario where dpi = ?;";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, String.valueOf(dpi));
            rs = stmt.executeQuery();
            while (rs.next()) {
                usuDpi = rs.getString(1);
                usuNombre = rs.getString(2);
                usuApellido = rs.getString(3);
                usuCorreo = rs.getString(4);
                usuTelefono = rs.getString(5);
                System.out.println("dpi: " + usuDpi + "\nNo. nombre: " + usuNombre + "\napellido: " + usuApellido + "\ncorreo: " + usuCorreo + "\ntelefono: " + usuTelefono);
            }
            usDpi.setText(usuDpi);
            usNombre.setText(usuNombre);
            usApellido.setText(usuApellido);
            usCorreo.setText(usuCorreo);
            usTelefono.setText(usuTelefono);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void crearCuenta() {
        String TCuen = tCuent.getSelectedItem().toString();
        System.out.println("Combobox seleccionado: " + TCuen);
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Banco2", "root", "compu123");
            String query3 = "INSERT INTO cuenta (numero_cuenta, dpi, id_tipo_cuenta) VALUES (?, ?, ?);";
            PreparedStatement stmt3 = con.prepareStatement(query3);
            stmt3.setString(1, generarNumeroCuenta(TCuen));
            stmt3.setString(2, dpiLogin);
            stmt3.setString(3, verificarTipoCuenta(TCuen));
            stmt3.executeUpdate();
            stmt3.close();
            con.close();
            msgusuario.setVisible(true);
            msgcue.setVisible(true);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(NOSE.this, "Error al crear la cuenta");
        }
    }

    public static String verificarTipoCuenta(String tipo) {
        String tipoC = "";
        ResultSet rs;
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Banco2", "root", "compu123");
            String query3 = "select nombre from tipo_cuenta;";
            PreparedStatement stmt3 = con.prepareStatement(query3);
            rs = stmt3.executeQuery();
            while (rs.next()) {
                tipoC = rs.getString(1);
                System.out.println("Tipo Cuenta: " + tipoC);
            }
            if (tipo.equals("Monetaria")) {
                tipoC = "2";
            } else if (tipo.equals("Ahorro")) {
                tipoC = "1";
            }
            stmt3.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return (tipoC);
    }

    public static String generarNumeroCuenta(String tipo) {
        Random random = new Random();
        int nCuenta = 0;
        if (tipo.equals("Monetaria")) {
            nCuenta = random.nextInt(900000000) + 1000000000;
        } else if (tipo.equals("Ahorro")) {
            nCuenta = random.nextInt(900000) + 1000000;
        }
        return String.valueOf(nCuenta);
    }

    public String listaCuentas(String dpi) {
        String numCuent = "";
        ResultSet rs;
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Banco2", "root", "compu123");
            String query3 = "select numero_cuenta from cuenta where dpi = ?;";
            PreparedStatement stmt3 = con.prepareStatement(query3);
            stmt3.setString(1, dpi);
            rs = stmt3.executeQuery();
            while (rs.next()) {
                numCuent = rs.getString(1);
                noC.addItem(numCuent);
                infoCt.addItem(numCuent);
                hisCuen.addItem(numCuent);
                System.out.println("Tipo Cuenta: " + numCuent);
            }
            stmt3.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return numCuent;
    }
}
