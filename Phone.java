package system.usersEmployees;

public class Phone {
    
    private Person cpf;
    private String phone;
    
    public Phone (){
    }
    
    public Phone (String phone){
        this.phone = phone;
    }
    
    public Phone (String cpf, String phone){
        this.cpf = new Person(cpf);
        this.phone = phone;
    }
    
    //getters
    protected String getCpf (){
        return this.cpf.getCpf();
    }
    
    protected String getPhone (){
        return this.phone;
    }
    
    //setters 
    protected void setCpf (String phone){
        this.cpf.setCpf(phone);
    }
    
    protected void setPhone (String phone){
        this.phone = phone;
    }
}
