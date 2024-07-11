package alpha.v1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class BDConsultas {

    public static void registrarUsuario(Cliente cliente) {
        
        cliente.setContraseña(generarContraseña());
        cliente.setPin(generarPIN());

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Banco2", "root", "compu");
            String query = "INSERT INTO usuario (dpi, nombre, apellido, correo, telefono, pass, pin) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, cliente.getDpi());
            stmt.setString(2, cliente.getNombre());
            stmt.setString(3, cliente.getApellido());
            stmt.setString(4, cliente.getCorreo());
            stmt.setString(5, cliente.getTelefono());
            stmt.setString(6, cliente.getContraseña());
            stmt.setString(7, cliente.getPin());
            stmt.executeUpdate();
            
            String query2 = "INSERT INTO usuario_rol (dpi, id_rol) VALUES (?, 1);";
            PreparedStatement stmt2 = con.prepareStatement(query2);
            stmt2.setString(1, cliente.getDpi());
            stmt2.executeUpdate();
            
            stmt.close();
            con.close();
            
            String asunto = "Credenciales de Usuario - Fast Bank";
            String mensaje = "DPI: " + cliente.getDpi() + "\n"
                    + "Nombre: " + cliente.getNombre() + "\n"
                    + "Apellido: " + cliente.getApellido() + "\n"
                    + "Telefono: " + cliente.getTelefono() + "\n"
                    + "PIN: " + cliente.getPin() + "\n"
                    + "Contraseña es: " + cliente.getContraseña();
            
            EnviarCorreo.enviarCorreo(cliente.getCorreo(), asunto, mensaje);
            
            JOptionPane.showMessageDialog(null, "Usuario Registrado"); 
            
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al crear usuario"); 
        }
    }
    
    public static String generarNumeroCuenta(String tipo) {
        Random random = new Random();
        int nCuenta = 0; 
        if (tipo.equals("M")){
           nCuenta = random.nextInt(900000000) + 1000000000; 
        } else if(tipo.equals("A")){
           nCuenta = random.nextInt(900000) + 1000000;  
        }
        return String.valueOf(nCuenta);
    }

    public static String generarPIN() {
        Random random = new Random();
        int pin = random.nextInt(90000) + 10000; // Generar un número aleatorio entre 10000 y 99999
        return String.valueOf(pin);
    }

    public static String generarContraseña() {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder contraseña = new StringBuilder();

        Random random = new Random();
        int longitud = 8;

        for (int i = 0; i < longitud; i++) {
            int indice = random.nextInt(caracteres.length());
            contraseña.append(caracteres.charAt(indice));
        }

        return contraseña.toString();
    }

}
