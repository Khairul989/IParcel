package iparcel.model;

public class customer {
	String id, fullname, ic, phone, email, password;
	
	public customer() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getIc() {
		return ic;
	}

	public void setIc(String ic) {
		this.ic = ic;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public customer(String id, String fullname, String ic, String phone, String email, String password) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.ic = ic;
		this.phone = phone;
		this.email = email;
		this.password = password;
	}

	@Override
	public String toString() {
		return "customer [id=" + id + ", fullname=" + fullname + ", ic=" + ic + ", phone=" + phone + ", email=" + email
				+ ", password=" + password + "]";
	}
	
}
