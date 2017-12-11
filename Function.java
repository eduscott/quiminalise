package system.usersEmployees.functions;

public class Function {
    
    private int idFunction;
    private String name;
    private String designation;
    
    public Function (int idFunction){
        this.idFunction = idFunction;
    }
    
    public Function (int idFunction, String name, String designation){
        this.idFunction = idFunction;
        this.name = name;
        this.designation = designation;
    }
    
    //getters
    public int getIdFunction (){
        return this.idFunction;
    }
    protected String getName (){
        return this.name;
    }
    protected String getDesignation (){
        return this.designation;
    }
    
    //setters
    public void setIdFunction (int idFunction){
        this.idFunction = idFunction;
    }
    protected void setName (String name){
        this.name = name;
    }
    protected void setDesignation (String designation){
        this.designation = designation;
    }
}
