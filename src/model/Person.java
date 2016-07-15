package model;

public abstract class Person {
	protected  String name;
    protected String surname;
    protected String email;
    protected String tmp;
    private final String cf;
    
    public String getFullName(){return name+" "+surname;}
    
    
    public Person(final String name, final String cf) { super();
    this.name = name;
    this.cf = cf; }
    public String getName (){
    	return name;
    }
    public String getId () { 
    	return cf;
    }
    
    public String toString (){
    return "Person [name=" + name + ", id=" + cf + "]";
    }
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	} 
    
}
