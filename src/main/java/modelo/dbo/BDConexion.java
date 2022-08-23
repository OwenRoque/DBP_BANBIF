package modelo.dbo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDConexion {
    
    static String bd = "banca";
    static String login = "root";
    static String password = "";
    static String  url = "jdbc:mariadb://localhost/"+bd;
    
    Connection conn = null;
    
    public BDConexion(){
        try{
            Class.forName("org.mariadb.jdbc.Driver");
            conn = DriverManager.getConnection(url,login,password);
            if(conn != null){
                System.out.println("Connecting database [" + conn + "] OK");
            } 
        }
        catch(SQLException e){
            System.out.println("Exception conexion: " + e.getMessage());
        }
        catch(ClassNotFoundException e){
            System.out.println("Exception driver: " + e.getMessage());
        }
    }
    public Connection getConexion(){
        return conn;
    }
    public void desconectar(){  
        System.out.println("Closing database: [" + conn + "] OK");
        if(conn != null){
            try{
                conn.close();
            }
            catch(SQLException e){
                System.out.println(e);
            }
        }
    }
}
