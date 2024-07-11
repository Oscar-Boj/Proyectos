
package alpha.v1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
    private static String user = "root";
    private static String password= "compu123";
    private static String url = "jdbc:mysql://localhost:3306/Banco2";

    public Connection getConnection(){
        Connection conectar = null;
        try{
            conectar = (Connection) DriverManager.getConnection(url,user,password);
            System.out.println("Conexion Establecida");
        }catch(SQLException ex){
            ex.printStackTrace();
            System.out.println("Error en la conexion");
        }
return conectar;
}
    
}
