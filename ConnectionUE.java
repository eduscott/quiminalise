package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUE {
    
    private static final String URL = "jdbc:mysql://localhost:3306/usuarios_funcionarios";
    private static final Properties PROPERTIES = new Properties();
    private static Connection CONNECTION = null;
    
     //getters
    public static Connection getConnection(){
        return ConnectionUE.CONNECTION;
    }
    
    //setters
    private static void setProperties (String property, String value){
        ConnectionUE.PROPERTIES.put(property, value);
    }
    
    //execute connection
    private static void loadProperties () throws SQLException{
        ConnectionUE.CONNECTION = DriverManager.getConnection(ConnectionUE.URL, PROPERTIES);
    }
    
    //connect, disconnect and status methods
    public static boolean connect (){
        boolean status = true;
        ConnectionUE.setProperties ("user", "root");
        ConnectionUE.setProperties("pass", "");
        try {
            ConnectionUE.loadProperties();
        } catch (SQLException ex) {
            status = false;
        }
        return status;
    }
    public static boolean disconnect (){
        boolean status = true;
        try {
            ConnectionUE.getConnection().close();
        } catch (SQLException ex) {
            status = false;
        }
        return status;
    }
    public static boolean status () throws SQLException{
        return !ConnectionUE.getConnection().isClosed();
    }
    
    //main
    /*public static void main(String[] args) {
        try {
            System.out.println(ConnectionUE.getConnection());
            System.out.println(ConnectionUE.connect());
            System.out.println(ConnectionUE.status());
            System.out.println(ConnectionUE.disconnect());
            System.out.println(ConnectionUE.status());
            System.out.println(ConnectionUE.connect());
            System.out.println(ConnectionUE.disconnect());
            System.out.println(ConnectionUE.status());
            
        } catch (SQLException ex) {
            System.out.println("error!");
        }
    }*/
}
