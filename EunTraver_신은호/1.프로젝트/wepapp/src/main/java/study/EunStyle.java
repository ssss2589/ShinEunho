package study;

public class EunStyle {
	private String name;
	private String id;
	private String pw;
	private String sex;
	private String rrn;
	private String email;
	private String phone;

	public String getName() {
		return name;
	}

	public EunStyle setName(String name) {
		this.name = name;
		return this;
	}

	public String getId() {
		return id;
	}

	public EunStyle setId(String id) {
		this.id = id;
		return this;
	}

	public String getPw() {
		return pw;
	}

	public EunStyle setPw(String pw) {
		this.pw = pw;
		return this;
	}

	public String getSex() {
		return sex;
	}

	public EunStyle setSex(String sex) {
		this.sex = sex;
		return this;
	}

	public String getRrn() {
		return rrn;
	}

	public EunStyle setRrn(String rrn) {
		this.rrn = rrn;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public EunStyle setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getPhone() {
		return phone;
	}

	public EunStyle setPhone(String phone) {
		this.phone = phone;
		return this;
	}

}
