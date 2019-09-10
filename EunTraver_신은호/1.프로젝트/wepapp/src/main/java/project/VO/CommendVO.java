package project.VO;

import java.sql.Timestamp;

public class CommendVO {
	private String commend;
	private String id;
	private Timestamp indate;
	private String re_useyn;
	private String qseq;
	private int cseq;
	public int getCseq() {
		return cseq;
	}
	public void setCseq(int cseq) {
		this.cseq = cseq;
	}
	public String getQseq() {
		return qseq;
	}
	public void setQseq(String qseq) {
		this.qseq = qseq;
	}
	public String getCommend() {
		return commend;
	}
	public void setCommend(String commend) {
		this.commend = commend;
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
	public String getRe_useyn() {
		return re_useyn;
	}
	public void setRe_useyn(String re_useyn) {
		this.re_useyn = re_useyn;
	}
	
}
