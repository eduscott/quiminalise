package systemDAO.usersEmployees;

import DAO.DAO;
import connection.ConnectionUE;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import system.usersEmployees.User;

public class UserDAO extends User implements DAO{
    
    private static final String SAVE = "INSERT INTO usuario (cpf, id_usuario)"
            + "VALUES (?,?)";
    private static PreparedStatement stmtSave;
    private static final String DELETE = "DELETE FROM usuario "
            + "WHERE id_usuario = ?";
    private static PreparedStatement stmtDelete;
    private static final String UPDATE = "UPDATE usuario "
            + "SET cpf = ?, id_usuario = ?"
            + "WHERE cpf = ?";
    private static PreparedStatement stmtUpdate;
    private static final String FIND = "SELECT * FROM usuario "
            + "WHERE id_usuario = ?";
    private static PreparedStatement stmtFind;
    private static final String FINDALL = "SELECT * FROM usuario "
            + "ORDER BY id_usuario ASC";
    private static Statement stmtFindAll;
    
    public UserDAO (){
        
    }
    
    public UserDAO (String cpf, int idUser){
        super(cpf, idUser);
    }
    
    public UserDAO (String cpf, String name, String lastName, String email, Date birthDate, String sex, int idUser) {
        super(cpf, name, lastName, email, birthDate, sex, idUser);
    }

   @Override
    public boolean save() {
        boolean status = false;
        ConnectionUE.connect();
        try {
            UserDAO.stmtSave = ConnectionUE.getConnection().prepareStatement(UserDAO.SAVE);
            UserDAO.stmtSave.clearParameters();
            UserDAO.stmtSave.setString(1, this.getCpf());
            UserDAO.stmtSave.setInt(2, this.getIdUser());
            UserDAO.stmtSave.executeUpdate();
            status = true;
        } catch (SQLException ex) {
            Logger.getLogger(PersonDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionUE.disconnect();
        }
        return status;
    }

    @Override
    public boolean delete() {
        boolean status = false;
        ConnectionUE.connect();
        try {
            UserDAO.stmtDelete = ConnectionUE.getConnection().prepareStatement(UserDAO.DELETE);
            UserDAO.stmtDelete.clearParameters();
            UserDAO.stmtDelete.setString(1, this.getCpf());
            UserDAO.stmtDelete.executeUpdate();
            status = true;
        } catch (SQLException ex) {
            Logger.getLogger(PersonDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionUE.disconnect();
        }
        return status;      
    }

    @Override
    public boolean update() {
        boolean status = false;
        if (this.find());
            ConnectionUE.connect();
            try {
                UserDAO p = (UserDAO) this.getOne();
                UserDAO.stmtSave = ConnectionUE.getConnection().prepareStatement(UserDAO.UPDATE);
                UserDAO.stmtSave.clearParameters();
                if (p.getCpf().equals(this.getCpf())){
                    UserDAO.stmtSave.setString(1, p.getCpf());
                }
                if (p.getName().equals(this.getIdUser())){
                    UserDAO.stmtSave.setInt(2, this.getIdUser());
                }
                UserDAO.stmtSave.executeUpdate();
                status = true;
            } catch (SQLException ex) {
                Logger.getLogger(PersonDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectionUE.disconnect();
            }
        return status;
    }

    @Override
    public boolean find() {
        boolean status = false;
        ConnectionUE.connect();
        try {
            UserDAO.stmtFind = ConnectionUE.getConnection().prepareStatement(UserDAO.FIND);
            UserDAO.stmtFind.clearParameters();
            UserDAO.stmtFind.setString(1, this.getCpf());
            ResultSet result = UserDAO.stmtFind.executeQuery();
            if (result.next()){
                status = true;
            }    
        } catch (SQLException ex) {
            Logger.getLogger(PersonDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionUE.disconnect();
        }
        return status;
    }
    
    @Override
    public Object getOne() {
        UserDAO u = null;
        if (this.find()){
            ConnectionUE.connect();
            try {
                UserDAO.stmtFind = ConnectionUE.getConnection().prepareStatement(UserDAO.FIND);
                UserDAO.stmtFind.clearParameters();
                UserDAO.stmtFind.setString(1, this.getCpf());
                ResultSet result = UserDAO.stmtFind.executeQuery();
                if (result.next()){
                    u = new UserDAO ();
                    u.setCpf(result.getString("cpf"));
                    u.setIdUser(result.getInt("id_usuario"));
                }    
            } catch (SQLException ex) {
                Logger.getLogger(PersonDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectionUE.disconnect();
            }  
        }
        return u;
    }

    @Override
    public ArrayList <Object> getAll() {
        ArrayList <Object> persons =  new ArrayList <> ();
        ConnectionUE.connect();
        try {
            UserDAO.stmtFindAll = ConnectionUE.getConnection().createStatement();
            ResultSet results = UserDAO.stmtFindAll.executeQuery(UserDAO.FINDALL);
            while (results.next()){
                UserDAO u = new UserDAO ();
                u.setCpf(results.getString("cpf"));
                u.setIdUser(results.getInt("id_usuario"));
                persons.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionUE.disconnect();
        }
        return persons;
    }

}