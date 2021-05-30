package model;

public class MemberDTO {
	private String id;
	private String pass;
	private String name;
	private String addr;

	public MemberDTO(String id, String pass, String name, String addr) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.addr = addr;
	}

	public String getId() {
		return id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", pass=" + pass + ", name=" + name
				+ ", addr=" + addr + "]";
	}
}
