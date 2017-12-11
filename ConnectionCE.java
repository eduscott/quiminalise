package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionCE {
    
    private static final String URL = "jdbc:derby://localhost:3306/elementos_quimicos";
    private static final Properties PROPERTIES = new Properties();
    private static Connection CONNECTION = null;
        
    //getters
    public static Connection getConnection(){
        return ConnectionCE.CONNECTION;
    }
    //setters
    private static void setProperties (String property, String value){
        ConnectionCE.PROPERTIES.put(property, value);
    }
    
    //execute connection
    private static void executeConnection () throws SQLException{
        ConnectionCE.CONNECTION = DriverManager.getConnection(ConnectionCE.URL, ConnectionCE.PROPERTIES);
    }
    
    //connect, disconnect and status methods
    public static void connect () throws SQLException{
        if (!ConnectionCE.status()){
            ConnectionCE.setProperties ("user", "marcosvbcosta");
            ConnectionCE.setProperties("pass", "10MaR06cOs01");
            try {
                Class.forName("com.mysql.jdbc.Driver");
                ConnectionCE.executeConnection();
            } catch (ClassNotFoundException ex) {
                String message = "não carrega driver";
            }
        }
    }
    public static void disconnect () throws SQLException{
        if (ConnectionCE.status()){
            ConnectionCE.setProperties("shotdown", "true");
            ConnectionCE.executeConnection();
        }
    }
    public static boolean status () throws SQLException{
        ConnectionCE.executeConnection();
        return ConnectionCE.CONNECTION.isValid(0);
    }
}
