package model;

public abstract class Person {
	protected  String name;
    protected String surname;
    protected String email;
    
    public String getFullName(){return name+" "+surname;}
    
    private final int id;
    public Person(final String name, final int id) { super();
    this.name = name;
    this.id = id; }
    public String getName (){
    	return name;
    }
    public int getId () { 
    	return id;
    }
    
    public String toString (){
    return "Person [name=" + name + ", id=" + id + "]";
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
