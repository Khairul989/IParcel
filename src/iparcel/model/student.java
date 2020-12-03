package iparcel.model;

public class student extends customer{
	String status, program;

	public student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public student(String id, String fullname, String ic, String phone, String email, String password, String status, String program) {
		super(id, fullname, ic, phone, email, password);
		this.status = status;
		this.program = program;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	@Override
	public String toString() {
		return "student [status=" + status + ", program=" + program + "]";
	}
	
	
}
