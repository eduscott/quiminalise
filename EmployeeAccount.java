package system.usersEmployees.accounts;

import system.usersEmployees.Employee;

public class EmployeeAccount {
    
    private Employee idEmployee;
    private Account idAccount;
    private int idEmployeeAccount;
    private String login;
    
    public EmployeeAccount (){
    }
    
    public EmployeeAccount (int idUserAccount){
        this.idEmployeeAccount = idUserAccount;
    }
    
    public EmployeeAccount (int idEmployee, int idAccount, int idEmployeeAccount, String login){
        this.idEmployee = new Employee(idEmployee);
        this.idAccount = new Account(idAccount);
        this.idEmployeeAccount= idEmployeeAccount;
        this.login = login;
    }
}