package context.model;
// 이전의 VO클래스를 의미한다.
// Client 사이드와 Server 사이드를 Transfer 한다는 개념으로 앞으로는 DTO라는 
// 용어를 사용 하겠다.
public class MemberDTO {
	private String id;
	private String password;
	private String name;
	private String address;
	
	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", password=" + password + ", name="
				+ name + ", address=" + address + "]";
	}
	public MemberDTO(String id, String password, String name, String address) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.address = address;
	}



	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
