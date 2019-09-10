

public class MemberVO {
	private String id;
	private String pw;
	private String name;
	private String img;
	private int frendstats = 0;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public int getFrendstats() {
		return frendstats;
	}
	public void setFrendstats(int frendStats) {
		this.frendstats = frendStats;
	}
}
