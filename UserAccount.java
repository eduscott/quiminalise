package system.usersEmployees.accounts;

import system.usersEmployees.User;

public class UserAccount {
    
    private User idUser;
    private Account idAccount;
    private int idUserAccount;
    private String login;
    
    public UserAccount (){
    }
    
    public UserAccount (int idUserAccount){
        this.idUserAccount = idUserAccount;
    }
    
    public UserAccount (int idUser, int idAccount, int idUserAccount, String login){
        this.idUser = new User(idUser);
        this.idAccount = new Account(idAccount);
        this.idUserAccount= idUserAccount;
        this.login = login;
    }
}
