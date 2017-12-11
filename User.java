package system.usersEmployees;

import java.sql.Date;

public class User extends Person {
    
    private int idUser;
    
    public User (){
    }
    
    public User (int idUser){
        super();
        this.idUser = idUser;
    }
   
    public User (String cpf, int idUser){
        super(cpf);
        this.idUser = idUser;
    }
 
    public User (String cpf, String name, String lastName, String email, Date birthDate, String sex, int idUser) {
        super(cpf, name, lastName, email, birthDate, sex);
        this.idUser = idUser;
    }

    //getters
    protected int getIdUser (){
        return this.idUser;
    }
    
    //setters
    protected void setIdUser (int idUser){
        this.idUser = idUser;
    }
}
