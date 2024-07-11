package alpha.v1;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class Gerente extends JFrame {

    private JTable tablaUsuarios;
    private JLabel imglogin, imgproll, imgusu, imgTcuenta, imgcuenta, imgtransaccion;
    private DefaultTableModel modeloTabla;
    private JTextField txtDPIret, txtDPIdep, txtDPIsaldo, txtDPIcuenta, txtDPIusu, txtdpiinfo, txtdpi, txtpass, txtnombre, txtapellido, txtCorreo, txttelefono;
    private Font font1 = new Font("Arial", Font.BOLD, 16);
    private Font font2 = new Font("Arial", Font.BOLD, 14);
    private Font font3 = new Font("Arial", Font.BOLD, 18);
    private Font font4 = new Font("Arial", Font.BOLD, 46);
    private Font font5 = new Font("Arial", Font.BOLD, 20);
    private Font font6 = new Font("Arial", Font.BOLD, 25);

    public Gerente() {
        this.setLayout(null);
        this.setTitle("GERENTE");
        this.setSize(1000, 700);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.decode("#121212"));
        this.inicializar();
    }

    public void panel() {
        //Panel Login
        JPanel Plogin = new JPanel();
        Plogin.setLayout(null);
        Plogin.setBackground(Color.white);
        this.add(Plogin);
        //Login guardar datos
        JLabel titulo = new JLabel("USUARIO");
        titulo.setFont(font6);
        titulo.setBounds(200, 15, 160, 30);
        JLabel lbldpi = new JLabel("DPI:");
        lbldpi.setFont(font1);
        lbldpi.setBounds(50, 80, 50, 30);
        JLabel lblpass = new JLabel("Contraseña:");
        lblpass.setFont(font1);
        lblpass.setBounds(50, 180, 100, 30);
        //textos  txtdpi,txtpin,txtpass
        txtdpi = new JTextField();
        txtdpi.setBounds(160, 80, 250, 30);
        txtdpi.setDocument(new CustomDoc(13));
        txtpass = new JTextField();
        txtpass.setBounds(160, 180, 250, 30);
        
        //funciones
        JButton btnactualizarL = new JButton("Buscar Dato");
        btnactualizarL.setBackground(Color.decode("#121212"));
        btnactualizarL.setFont(font2);
        btnactualizarL.setForeground(Color.WHITE);
        btnactualizarL.setBorder(null);
        btnactualizarL.setFocusable(false);
        btnactualizarL.setBounds(200, 200, 100, 30);
        btnactualizarL.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarUsuario();
            }
        });
        Plogin.setLayout(null);
        Plogin.setBounds(380, 400, 490, 320);
        // Plogin.setBackground(Color.white);      
        Plogin.setBackground(new Color(255, 255, 255, 160));
        Plogin.setOpaque(true);
        Plogin.add(titulo);
        Plogin.add(txtdpi);
        Plogin.add(txtdpi);
        Plogin.add(lbldpi);
        Plogin.add(btnactualizarL);
        Plogin.setVisible(false);
        add(Plogin);
        //panel Informacion
        JButton btnactualizarinfo = new JButton("Buscar Dato");
        btnactualizarinfo.setBackground(Color.decode("#121212"));
        btnactualizarinfo.setFont(font2);
        btnactualizarinfo.setForeground(Color.WHITE);
        btnactualizarinfo.setBorder(null);
        btnactualizarinfo.setFocusable(false);
        btnactualizarinfo.setBounds(200, 200, 100, 30);
        btnactualizarinfo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarRol();
            }
        });
        txtnombre = new JTextField();
        txtnombre.setBounds(160, 60, 250, 30);
        txtapellido = new JTextField();
        txtapellido.setBounds(160, 100, 250, 30);
        txtdpiinfo = new JTextField();
        txtdpiinfo.setBounds(160, 80, 250, 30);
        txtdpiinfo.setDocument(new CustomDoc(13));
        txtCorreo = new JTextField();
        txtCorreo.setBounds(160, 180, 250, 30);
        txttelefono = new JTextField();
        txttelefono.setBounds(160, 230, 250, 30);
        JPanel paninfol = new JPanel();
        paninfol.setBackground(new Color(255, 255, 255, 160));
        paninfol.setOpaque(true);
        paninfol.setBounds(380, 400, 490, 320);
        paninfol.setLayout(null);
        JLabel teli = new JLabel("Id Rol:");
        teli.setFont(font1);
        teli.setBounds(50, 80, 100, 30);
        JLabel lblinfo = new JLabel("ROLES");
        lblinfo.setFont(font6);
        lblinfo.setBounds(210, 15, 190, 30);
        paninfol.add(btnactualizarinfo);
        paninfol.add(lblinfo);
        paninfol.add(txtdpiinfo);
        paninfol.add(teli);
        add(paninfol);
        paninfol.setVisible(false);
        //Panel usuarios
        JPanel panusuarios = new JPanel();
        panusuarios.setBackground(new Color(255, 255, 255, 160));
        panusuarios.setOpaque(true);
        panusuarios.setBounds(380, 400, 490, 320);
        panusuarios.setLayout(null);
        panusuarios.setVisible(true);
        //labels
        
        
        JLabel lblDPIusuarios = new JLabel("DPI:");
        lblDPIusuarios.setFont(font1);
        lblDPIusuarios.setBounds(50, 80, 100, 30);
        JLabel lblusuarios = new JLabel("ROLES DE USUARIOS");
        lblusuarios.setFont(font6);
        lblusuarios.setBounds(115, 15, 300, 30);
        //cajas de textbox txtDPIusu,txtusuario,txtRoll
        txtDPIusu = new JTextField();
       txtDPIusu.setDocument(new CustomDoc(13));
        txtDPIusu.setBounds(160, 80, 250, 30);
        //bototnes usuarios
        JButton btnactualizarusuario = new JButton("Buscar Dato");
        btnactualizarusuario.setBackground(Color.decode("#121212"));
        btnactualizarusuario.setFont(font2);
        btnactualizarusuario.setForeground(Color.WHITE);
        btnactualizarusuario.setBorder(null);
        btnactualizarusuario.setFocusable(false);
        btnactualizarusuario.setBounds(200, 200, 100, 30);
        btnactualizarusuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarURol();

            }
        });
        //panel Cuentas
        JPanel Pcuentas = new JPanel();
        Pcuentas.setBackground(new Color(255, 255, 255, 160));
        Pcuentas.setOpaque(true);
        Pcuentas.setBounds(380, 400, 490, 320);
        Pcuentas.setLayout(null);
        Pcuentas.setVisible(false);
        JLabel Cuentas = new JLabel("TIPOS DE CUENTA");
        Cuentas.setFont(font6);
        Cuentas.setBounds(130, 15, 300, 30);
        JLabel lbldpicuenta = new JLabel("Id Cuenta:");
        lbldpicuenta.setFont(font1);
        lbldpicuenta.setBounds(50, 80, 80, 30);
        txtDPIcuenta = new JTextField();
         txtDPIcuenta.setDocument(new CustomDoc(13));
        txtDPIcuenta.setBounds(160, 80, 250, 30);
        JButton btnactualizarcuenta = new JButton("Buscar Dato");
        btnactualizarcuenta.setBackground(Color.decode("#121212"));
        btnactualizarcuenta.setFont(font2);
        btnactualizarcuenta.setForeground(Color.WHITE);
        btnactualizarcuenta.setBorder(null);
        btnactualizarcuenta.setFocusable(false);
        btnactualizarcuenta.setBounds(200, 200, 100, 30);
        btnactualizarcuenta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarTcuenta();
            }
        });
        Pcuentas.add(Cuentas);
        Pcuentas.add(lbldpicuenta);
        Pcuentas.add(txtDPIcuenta);
        Pcuentas.add(btnactualizarcuenta);
        add(Pcuentas);
        //Panel saldos
        JPanel Psaldos = new JPanel();
        Psaldos.setBackground(new Color(255, 255, 255, 160));
        Psaldos.setOpaque(true);
        Psaldos.setBounds(380, 400, 490, 320);
        Psaldos.setLayout(null);
        Psaldos.setVisible(false);
        JLabel saldos = new JLabel("CUENTAS");
        saldos.setFont(font6);
        saldos.setBounds(190, 15, 160, 30);
        JLabel lbldpiS = new JLabel("No. Cuenta:");
        lbldpiS.setFont(font1);
        lbldpiS.setBounds(50, 80, 100, 30);
        txtDPIsaldo = new JTextField();
        txtDPIsaldo.setDocument(new CustomDoc(13));
        txtDPIsaldo.setBounds(160, 80, 250, 30);

        JButton btnactualizarsaldo = new JButton("Buscar Dato");
        btnactualizarsaldo.setBackground(Color.decode("#121212"));
        btnactualizarsaldo.setFont(font2);
        btnactualizarsaldo.setForeground(Color.WHITE);
        btnactualizarsaldo.setBorder(null);
        btnactualizarsaldo.setFocusable(false);
        btnactualizarsaldo.setBounds(200, 200, 100, 30);
        btnactualizarsaldo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarcuenta();
            }
        });
        Psaldos.add(saldos);
        Psaldos.add(lbldpiS);
        Psaldos.add(txtDPIsaldo);
        Psaldos.add(btnactualizarsaldo);
        add(Psaldos);
        //panel deposito
        JButton btnactualizardeposito = new JButton("Buscar Dato");
        btnactualizardeposito.setBackground(Color.decode("#121212"));
        btnactualizardeposito.setFont(font2);
        btnactualizardeposito.setForeground(Color.WHITE);
        btnactualizardeposito.setBorder(null);
        btnactualizardeposito.setFocusable(false);
        btnactualizardeposito.setBounds(200, 200, 100, 30);
        btnactualizardeposito.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscartransaccion();
            }
        });
        txtDPIdep = new JTextField();
        txtDPIdep.setDocument(new CustomDoc(13));
        txtDPIdep.setBounds(160, 80, 250, 30);
        JPanel Pdeposito = new JPanel();
        Pdeposito.setBackground(new Color(255, 255, 255, 160));
        Pdeposito.setOpaque(true);
        Pdeposito.setBounds(380, 400, 490, 320);
        Pdeposito.setLayout(null);
        JLabel lbldpidep = new JLabel("Id Tran:");
        lbldpidep.setFont(font1);
        lbldpidep.setBounds(50, 80, 100, 30);
        JLabel lbldeposito = new JLabel("TRANSACCION");
        lbldeposito.setFont(font6);
        lbldeposito.setBounds(160, 15, 190, 30);
        Pdeposito.add(btnactualizardeposito);
        Pdeposito.add(lbldpidep);
        Pdeposito.add(txtDPIdep);
        Pdeposito.add(lbldeposito);
        Pdeposito.setVisible(false);
        add(Pdeposito);
        //Panel Retiro

        JButton btnactualizarretiro = new JButton("Buscar Datos");
        btnactualizarretiro.setBackground(Color.decode("#121212"));
        btnactualizarretiro.setFont(font2);
        btnactualizarretiro.setForeground(Color.WHITE);
        btnactualizarretiro.setBorder(null);
        btnactualizarretiro.setFocusable(false);
        btnactualizarretiro.setBounds(185, 300, 100, 30);
        btnactualizarretiro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actualizarret();
            }
        });
        txtDPIret = new JTextField();
        txtDPIret.setBounds(160, 60, 250, 30);
        JPanel Pretiro = new JPanel();
        Pretiro.setBackground(new Color(255, 255, 255, 160));
        Pretiro.setOpaque(true);
        Pretiro.setBounds(380, 300, 490, 420);
        Pretiro.setLayout(null);
        JLabel lbldpiret = new JLabel("DPI");
        lbldpiret.setFont(font1);
        lbldpiret.setBounds(50, 60, 100, 30);
        JLabel lblretiro = new JLabel("RETIRO");
        lblretiro.setFont(font6);
        Pretiro.add(lblretiro);
        lblretiro.setBounds(175, 15, 190, 30);
        Pretiro.add(btnactualizarretiro);
        Pretiro.add(lbldpiret);
        Pretiro.add(txtDPIret);
        Pretiro.setVisible(false);
        add(Pretiro);

        //agregar usuarios
        add(panusuarios);
        panusuarios.add(btnactualizarusuario);
        panusuarios.add(lblDPIusuarios);
        panusuarios.add(txtDPIusu);
        panusuarios.add(lblusuarios);
        panusuarios.setVisible(false);
        //BOTONES
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
        JButton btnCuentas = new JButton("Tipo Cuenta");
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
            }
        });

        //BOTON VOLVER
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
                Plogin.setVisible(false);
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
            }
        });
        add(btnvolver);
        // Contenedor "JTable"
        tablaUsuarios = new JTable();
        tablaUsuarios.setBounds(274, 80, 690, 210);
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

    //funciones CRUD
    //retiro
    private void actualizarret() {
        String dpi = txtDPIret.getText();
        Conexion conectar = new Conexion();
        try {
            Connection con = conectar.getConnection();
            String query = "select * from retiro where DPI = ? ";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, dpi);
            stmt.executeQuery();
            stmt.close();
            con.close();
            txtDPIret.setText("");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(Gerente.this, "Error al buscar los datos");
        }
    }

    //deposito
    private void buscartransaccion() {
        modeloTabla = new DefaultTableModel();
        modeloTabla.setColumnIdentifiers(new String[]{"id_transaccion", "numero_cuenta", "monto", "tipo_transaccion", "fecha_transaccion", "cuenta_destino"});
        tablaUsuarios.setModel(modeloTabla);
        String campo = txtDPIdep.getText();
        modeloTabla.setRowCount(0);
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/banco2", "root", "compu");
            String query = "SELECT * FROM transaccion WHERE id_transaccion = '" + campo + " ' ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String id = rs.getString("id_transaccion");
                String usuario = rs.getString("numero_cuenta");
                String contraseña = rs.getString("monto");
                String correo = rs.getString("tipo_transaccion");
                String tel = rs.getString("fecha_transaccion");
                String pass = rs.getString("cuenta_destino");
                Object[] fila = {id, usuario, contraseña, correo, tel, pass};
                modeloTabla.addRow(fila);
            }
            rs.close();
            stmt.close();
            conn.close();
            System.out.println(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(Gerente.this, "Error al cargar los datos");
        }
    }

    //saldos
    private void buscarcuenta() {
         modeloTabla = new DefaultTableModel();
        modeloTabla.setColumnIdentifiers(new String[]{"numero_cuenta", "dpi", "id_tipo_cuenta"});
        tablaUsuarios.setModel(modeloTabla);
        String campo = txtDPIsaldo.getText();
        modeloTabla.setRowCount(0);
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/banco2", "root", "compu");
            String query = "SELECT * FROM cuenta WHERE numero_cuenta = '" + campo + " ' ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String id = rs.getString("numero_cuenta");
                String usuario = rs.getString("dpi");
                String contraseña = rs.getString("id_tipo_cuenta");
                Object[] fila = {id, usuario, contraseña};
                modeloTabla.addRow(fila);
            }
            rs.close();
            stmt.close();
            conn.close();
            System.out.println(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(Gerente.this, "Error al cargar los datos");
        }
    }

    //cuentas
    private void buscarTcuenta() {
        modeloTabla = new DefaultTableModel();
        modeloTabla.setColumnIdentifiers(new String[]{"id_tipo_cuenta", "nombre"});
        tablaUsuarios.setModel(modeloTabla);
        String dpi = txtDPIcuenta.getText();
        modeloTabla.setRowCount(0);
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/banco2", "root", "compu");
            String query = "SELECT * FROM tipo_cuenta WHERE id_tipo_cuenta = '" + dpi + " ' ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String id = rs.getString("id_tipo_cuenta");
                String usuario = rs.getString("nombre");
                Object[] fila = {id, usuario};
                modeloTabla.addRow(fila);
            }
            rs.close();
            stmt.close();
            conn.close();
            System.out.println(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(Gerente.this, "Error al cargar los datos");
        }
    }

    //usuarios
    private void buscarURol() {
        modeloTabla = new DefaultTableModel();
        modeloTabla.setColumnIdentifiers(new String[]{"dpi", "id_rol"});
        tablaUsuarios.setModel(modeloTabla);
        String dpi = txtDPIusu.getText();
        modeloTabla.setRowCount(0);
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/banco2", "root", "compu");
            String query = "SELECT * FROM usuario_rol WHERE dpi = '" + dpi + " ' ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String id = rs.getString("dpi");
                String usuario = rs.getString("id_rol");
                Object[] fila = {id, usuario};
                modeloTabla.addRow(fila);
            }
            rs.close();
            stmt.close();
            conn.close();
            System.out.println(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(Gerente.this, "Error al cargar los datos");
        }
    }

    //Informacion
    private void buscarRol() {
        modeloTabla = new DefaultTableModel();
        modeloTabla.setColumnIdentifiers(new String[]{"id_rol", "nombre"});
        tablaUsuarios.setModel(modeloTabla);
        String campo = txtdpiinfo.getText();
        modeloTabla.setRowCount(0);
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/banco2", "root", "compu");
            String query = "SELECT * FROM rol WHERE id_rol = '" + campo + " ' ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String id = rs.getString("id_rol");
                String usuario = rs.getString("nombre");
                Object[] fila = {id, usuario};
                modeloTabla.addRow(fila);
            }
            rs.close();
            stmt.close();
            conn.close();
            System.out.println(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(Gerente.this, "Error al cargar los datos");
        }
    }

    //Login
    private void buscarUsuario() {
        modeloTabla = new DefaultTableModel();
        modeloTabla.setColumnIdentifiers(new String[]{"dpi", "nombre", "apellido", "correo", "teléfono", "pass", "pin"});
        tablaUsuarios.setModel(modeloTabla);
        String campo = txtdpi.getText();
        modeloTabla.setRowCount(0);
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/banco2", "root", "compu");
            String query = "SELECT * FROM usuario WHERE dpi = '" + campo + " ' ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String id = rs.getString("dpi");
                String usuario = rs.getString("nombre");
                String contraseña = rs.getString("apellido");
                String correo = rs.getString("correo");
                String tel = rs.getString("telefono");
                String pass = rs.getString("pass");
                String pin = rs.getString("pin");
                Object[] fila = {id, usuario, contraseña, correo, tel, pass, pin};
                modeloTabla.addRow(fila);
            }
            rs.close();
            stmt.close();
            conn.close();
            System.out.println(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(Gerente.this, "Error al cargar los datos");
        }

    }

    /*  public DefaultTableModel buscarusuarios1(String buscar){
        String [] nombreColumna = {"dpi","nombre","apellido","correo","telefono","pass","pin"};
        String [] registros = new String[6];
        DefaultTableModel modelo = new DefaultTableModel(null, nombreColumna);
        String sql = "select * from usuario where dpi like '&"+buscar+"&' or nombre like '&"+buscar+"&' ";
        Connection cn = null;
        PreparedStatement pst=null;
        ResultSet rs=null;
        try{
            cn = Conexion
        }
    }*/
    //Cargar Datos
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
                Object[] fila = {id, usuario, contraseña, correo, tel, pass, pin};
                modeloTabla.addRow(fila);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(Gerente.this, "Error al cargar los datos");
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
                Object[] fila = {nombre, apellido};
                modeloTabla.addRow(fila);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(Gerente.this, "Error al cargar los datos");
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
                Object[] fila = {DPI, usuario};
                modeloTabla.addRow(fila);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(Gerente.this, "Error al cargar los datos");
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
                Object[] fila = {DPI, usuario};
                modeloTabla.addRow(fila);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(Gerente.this, "Error al cargar los datos");
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
                Object[] fila = {id, usuario, contraseña};
                modeloTabla.addRow(fila);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(Gerente.this, "Error al cargar los datos");
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
                Object[] fila = {id, usuario, contraseña, fdep, monto, cuena};
                modeloTabla.addRow(fila);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(Gerente.this, "Error al cargar los datos");
        }
    }

    //Llamar metodo
    public void imagen() {
        JLabel botones = new JLabel(new ImageIcon("img/FGerente.PNG"));
        botones.setBounds(0, 0, 1000, 700);
        this.add(botones);
    }

    public void inicializar() {

        this.panel();
        this.imagen();
    }
}
