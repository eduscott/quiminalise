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
import system.usersEmployees.Person;

public class PersonDAO extends Person implements DAO{
    
    private static final String SAVE = "INSERT INTO pessoa (cpf, nome, sobrenome, email, data_nascimento, sexo)"
            + "VALUES (?, ?, ?, ?, ?, ?)";
    private static PreparedStatement stmtSave;
    private static final String DELETE = "DELETE FROM pessoa "
            + "WHERE cpf = ?";
    private static PreparedStatement stmtDelete;
    private static final String UPDATE = "UPDATE pessoa "
            + "SET cpf = ?, nome = ?, sobrenome = ?, email = ?, data_nascimento = ?, sexo = ?"
            + "WHERE cpf = ?";
    private static PreparedStatement stmtUpdate;
    private static final String FIND = "SELECT * FROM pessoa "
            + "WHERE cpf = ?";
    private static PreparedStatement stmtFind;
    private static final String FINDALL = "SELECT * FROM pessoa "
            + "ORDER BY nome ASC";
    private static Statement stmtFindAll;
    
    public PersonDAO() {

    }
    
    public PersonDAO (String cpf){
        super(cpf);
    }
    
    public PersonDAO (String cpf, String name, String lastName, String email, Date birthDate, String sex) {
        super(cpf, name, lastName, email, birthDate, sex);
    }

    @Override
    public boolean save() {
        boolean status = false;
        ConnectionUE.connect();
        try {
            PersonDAO.stmtSave = ConnectionUE.getConnection().prepareStatement(PersonDAO.SAVE);
            PersonDAO.stmtSave.clearParameters();
            PersonDAO.stmtSave.setString(1, this.getCpf());
            PersonDAO.stmtSave.setString(2, this.getName());
            PersonDAO.stmtSave.setString(3, this.getLastName());
            PersonDAO.stmtSave.setString(4, this.getEmail());
            PersonDAO.stmtSave.setDate(5, this.getBirthDate());
            PersonDAO.stmtSave.setString(6, this.getSex());
            PersonDAO.stmtSave.executeUpdate();
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
            PersonDAO.stmtDelete = ConnectionUE.getConnection().prepareStatement(PersonDAO.DELETE);
            PersonDAO.stmtDelete.clearParameters();
            PersonDAO.stmtDelete.setString(1, this.getCpf());
            PersonDAO.stmtDelete.executeUpdate();
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
                PersonDAO p = (PersonDAO) this.getOne();
                PersonDAO.stmtSave = ConnectionUE.getConnection().prepareStatement(PersonDAO.UPDATE);
                PersonDAO.stmtSave.clearParameters();
                if (p.getCpf().equals(this.getCpf())){
                    PersonDAO.stmtSave.setString(1, p.getCpf());
                }
                if (p.getName().equals(this.getName())){
                    PersonDAO.stmtSave.setString(2, this.getName());
                }
                if (p.getLastName().equals(this.getLastName())){
                    PersonDAO.stmtSave.setString(3, this.getLastName());
                }
                if (p.getEmail().equals(this.getEmail())){
                    PersonDAO.stmtSave.setString(4, this.getEmail());
                }
                if (p.getBirthDate().equals(this.getBirthDate())){
                    PersonDAO.stmtSave.setDate(5, this.getBirthDate());
                }
                if (p.getSex().equals(this.getSex())){
                    PersonDAO.stmtSave.setString(6, this.getSex());
                }
                PersonDAO.stmtSave.executeUpdate();
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
            PersonDAO.stmtFind = ConnectionUE.getConnection().prepareStatement(PersonDAO.FIND);
            PersonDAO.stmtFind.clearParameters();
            PersonDAO.stmtFind.setString(1, this.getCpf());
            ResultSet result = PersonDAO.stmtFind.executeQuery();
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
        PersonDAO p = null;
        if (this.find()){
            ConnectionUE.connect();
            try {
                PersonDAO.stmtFind = ConnectionUE.getConnection().prepareStatement(PersonDAO.FIND);
                PersonDAO.stmtFind.clearParameters();
                PersonDAO.stmtFind.setString(1, this.getCpf());
                ResultSet result = PersonDAO.stmtFind.executeQuery();
                if (result.next()){
                    p = new PersonDAO();
                    p.setCpf(result.getString("cpf"));
                    p.setName(result.getString("nome"));
                    p.setLastName(result.getString("sobrenome"));
                    p.setEmail(result.getString("email"));
                    p.setBirthDate(result.getDate("data_nascimento"));
                    p.setSex(result.getString("sexo"));
                }    
            } catch (SQLException ex) {
                Logger.getLogger(PersonDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectionUE.disconnect();
            }  
        }
        return p;
    }

    @Override
    public ArrayList <Object> getAll() {
        ArrayList <Object> persons =  new ArrayList <> ();
        ConnectionUE.connect();
        try {
            PersonDAO.stmtFindAll = ConnectionUE.getConnection().createStatement();
            ResultSet results = PersonDAO.stmtFindAll.executeQuery(PersonDAO.FINDALL);
            while (results.next()){
                PersonDAO p = new PersonDAO();
                p.setCpf(results.getString("cpf"));
                p.setName(results.getString("nome"));
                p.setLastName(results.getString("sobrenome"));
                p.setEmail(results.getString("email"));
                p.setBirthDate(results.getDate("data_nascimento"));
                p.setSex(results.getString("sexo"));
                persons.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionUE.disconnect();
        }
        return persons;
    }
    
    /*public static void main(String[] args) {
        PersonDAO p = new PersonDAO("05037452430", "Marcos Vinicius", "Batista Costa", "MarcosvbCosta10@outlook.com", 
                new Date(2001 - 1900, 06 - 1, 10), "M");
        System.out.println(p.save());
        System.out.println(p.find());
        System.out.println(p.getOne());
        System.out.println(p.getAll());
        //System.out.println(p.delete());
        //System.out.println(p.getAll());
    }*/

}
