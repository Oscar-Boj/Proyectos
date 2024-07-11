package alpha.v1;

import org.apache.commons.mail.*;

public class EnviarCorreo {

    public static void enviarCorreo(String destinatario, String asunto, String cuerpo) {

        try {
            // Configuración del servidor SMTP
            Email email = new SimpleEmail();
            email.setHostName("mail.smtp2go.com"); // Reemplaza "smtp.example.com" con el servidor SMTP adecuado
            email.setSmtpPort(465); // Reemplaza "587" con el puerto SMTP adecuado
            email.setAuthenticator(new DefaultAuthenticator("emilianisomascos.edu.gt", "yC2ypmyJ0HAqe8Ql")); // Reemplaza con tu dirección de correo y contraseña
            email.setSSLOnConnect(true); // Si el servidor SMTP requiere inicio de sesión seguro (SSL/TLS)

            // Configuración del remitente, destinatario, asunto y cuerpo del correo
            email.setFrom("fastbanksa@gmail.com"); // Reemplaza con tu dirección de correo
            email.addTo(destinatario); // Dirección de correo del destinatario
            email.setSubject(asunto); // Asunto del correo
            email.setMsg(cuerpo); // Cuerpo del correo

            // Envío del correo
            email.send();

            System.out.println("Correo enviado correctamente.");
        } catch (EmailException e) {
            System.out.println("Error al enviar el correo: " + e.getMessage());
        }

        
    }
}
