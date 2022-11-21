package entities;

public class Vendor {
	
	private Integer vId;
	private String vName;
	private String vPhone;
	private String vMail;
	
	public Vendor() {}
	public Vendor(Integer vId, String vName, String vPhone, String vMail) {
		this.vId=vId;
		this.vName=vName;
		this.vPhone=vPhone;
		this.vMail=vMail;
	}
	
	public Integer getvId() {
		return vId;
	}
	public void setvId(Integer vId) {
		this.vId = vId;
	}
	public String getvName() {
		return vName;
	}
	public void setvName(String vName) {
		this.vName = vName;
	}
	public String getvPhone() {
		return vPhone;
	}
	public void setvPhone(String vPhone) {
		this.vPhone = vPhone;
	}
	public String getvMail() {
		return vMail;
	}
	public void setvMail(String vMail) {
		this.vMail = vMail;
	}
	@Override
	public String toString() {
		return "Vendor [vId=" + vId + ", vName=" + vName + ", vPhone=" + vPhone + ", vMail=" + vMail + "]";
	}
}