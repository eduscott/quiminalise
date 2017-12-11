package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionA {
    
    private static final String URL = "jdbc:derby://localhost:3306/enderecamento";
    private static final Properties PROPERTIES = new Properties();
    private static Connection CONNECTION = null;
        
    //getters
    public static Connection getConnection(){
        return ConnectionA.CONNECTION;
    }
    
    //setters
    private static void setProperties (String property, String value){
        ConnectionA.PROPERTIES.put(property, value);
    }
    
    //execute connection
    private static void executeConnection () throws SQLException{
        ConnectionA.CONNECTION = DriverManager.getConnection(ConnectionA.URL, ConnectionA.PROPERTIES);
    }
    
    //connect, disconnect and status methods
    public static void connect () throws SQLException{
        if (!ConnectionA.status()){
            ConnectionA.setProperties ("user", "marcosvbcosta");
            ConnectionA.setProperties("pass", "10MaR06cOs01");
            try {
                Class.forName("com.mysql.jdbc.Driver");
                ConnectionA.executeConnection();
            } catch (ClassNotFoundException ex) {
                String message = "não carrega driver";
            }
        }
    }
    public static void disconnect () throws SQLException{
        if (ConnectionA.status()){
            ConnectionA.setProperties("shotdown", "true");
            ConnectionA.executeConnection();
        }
    }
    public static boolean status () throws SQLException{
        ConnectionA.executeConnection();
        return ConnectionA.CONNECTION.isValid(0);
    }
}
