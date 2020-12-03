package iparcel.model;

public class lecturer extends customer{
	String faculty;

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public lecturer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public lecturer(String id, String fullname, String ic, String phone, String email, String password, String faculty) {
		super(id, fullname, ic, phone, email, password);
		this.faculty = faculty;
	}
	
	
	
}
