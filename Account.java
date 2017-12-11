package system.usersEmployees.accounts;

public class Account {
    
    private int idAccount;
    private String pass;
    
    public Account (){    
    }
    
    public Account (int idAccount){
        this.idAccount = idAccount;
    }
    
    public Account (int idAccount, String pass){
        this.idAccount = idAccount;
        this.pass = pass;
    }
    
    //getters
    protected int getIdAccount (){
        return this.idAccount;
    }
    protected String getPass (){
        return this.pass;
    }
    
    //setters
    protected void setIdAccount (int idAccount){
        this.idAccount = idAccount;
    }
    protected void setPass (String pass){
        this.pass = pass;
    }
}
