package system.usersEmployees;

import java.sql.Date;

public class Person extends Object{
    
    private String cpf;
    private String name;
    private String lastName;
    private String email;
    private Date birthDate;
    private String sex;
    
    public Person (){
    }
    
    public Person (String cpf){
        this.cpf = cpf;
    }
    
    public Person (String cpf, String name, String lastName, String email, Date birthDate, String sex){
        this.cpf = cpf;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.birthDate = birthDate;
        this.sex = sex;
    }
    
    //getters
    protected String getCpf (){
        return this.cpf;
    }
    protected String getName (){
        return this.name;
    }
    protected String getLastName (){
        return this.lastName;
    }
    protected String getEmail (){
        return this.email;
    }
    protected Date getBirthDate (){
        return this.birthDate;
    }
    protected String getSex (){
        return this.sex;
    }
    
    //setters
    protected void setCpf (String cpf){
        this.cpf = cpf;
    }
    protected void setName (String name){
        this.name = name;
    }
    protected void setLastName (String lastName){
        this.lastName = lastName;
    }
    protected void setEmail (String email){
        this.email = email;
    }
    protected void setBirthDate (Date birthDate){
        this.birthDate = birthDate;
    }
    protected void setSex (String sex){
        this.sex = sex;
    }
    
}

