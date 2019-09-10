package gheVO;

import java.sql.Timestamp;

public class GHEBoardVO {
	private int bseq;
	private String name;
	private String bcontent;
	private int bview;
	private int bgood;
	private int bbad;
	private int cseq;
	private String id;
	private Timestamp indate;
	private String nickname;
	public int getBseq() {
		return bseq;
	}
	public void setBseq(int bseq) {
		this.bseq = bseq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	public int getBview() {
		return bview;
	}
	public void setBview(int bview) {
		this.bview = bview;
	}
	public int getBgood() {
		return bgood;
	}
	public void setBgood(int bgood) {
		this.bgood = bgood;
	}
	public int getBbad() {
		return bbad;
	}
	public void setBbad(int bbad) {
		this.bbad = bbad;
	}
	public int getCseq() {
		return cseq;
	}
	public void setCseq(int cseq) {
		this.cseq = cseq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Timestamp getIndate() {
		return indate;
	}
	public void setIndate(Timestamp indate) {
		this.indate = indate;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	} 
	
}
