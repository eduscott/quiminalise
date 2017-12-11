package system.usersEmployees;

import java.sql.Date;
import system.usersEmployees.functions.Function;

public class Employee extends Person{
    
    private Function idFunction;
    private int idEmployee;
    
    public Employee (){ 
    }
    
    public Employee (int idEmployee){
        super();
        this.idEmployee = idEmployee;
    }
    
    public Employee (String cpf, int idFunction, int idEmployee){
        super(cpf);
        this.idFunction = new Function(idFunction);
        this.idEmployee = idEmployee;
    }
    
    public Employee (String cpf, String name, String lastName, String email, Date birthDate, String sex
            , int idFunction, int idEmployee, String controlPass) {
        super(cpf, name, lastName, email, birthDate, sex);
        this.idFunction = new Function(idFunction);
        this.idEmployee = idEmployee;
    }
    
    //getters
    protected int getIdFunction (){
        return this.idFunction.getIdFunction();
    }
    protected int getIdEmployee (){
        return this.idEmployee;
    }
    
    //setters
    protected void setIdFunction (int idFunction){
        this.idFunction.setIdFunction(idFunction);
    }
    
    protected void setIdEmployee (int idEmployee){
        this.idEmployee = idEmployee;
    }
}
