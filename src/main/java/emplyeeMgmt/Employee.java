package emplyeeMgmt;

public class Employee {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String designation;
	private String deptId;
	private String contact;
	
	public Employee(String firstName, String lastName, String email, String designation, String deptId,
			String contact) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.designation = designation;
		this.deptId = deptId;
		this.contact = contact;
	}
	
	
	public Employee(int id, String firstName, String lastName, String email, String designation, String deptId,
			String contact) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.designation = designation;
		this.deptId = deptId;
		this.contact = contact;
	}
	

	public Employee() {
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
}
