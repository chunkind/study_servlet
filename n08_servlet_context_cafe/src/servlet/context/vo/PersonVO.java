/*
 * vo ::
 * 
 * 1) 디비 Side에서 살펴본 vo
 * 	 쿼리문에서 select 같은 경우 디비 테이블의 정보(row)를 받아오도록 되어있다.
 * 	 디비 테이블의 row는 일단 ResultSet에 담겨지고 --> ResultSet에 담겨진 정보가
 * 	 결국 VO에 담겨진다.
 * 
 * 2) Client의 폼에서 살펴본 vo
 * 	 클라이언트의 정보 Form을 통해서 서버 쪽으로 전달되면
 *	 서블릿이 이를 받아서 (request.getParamenet()) 정보를 vo에 setting하게 되고
 *	 이 vo가 ServletContext 같은 저장공간에 Binding 되어진다.
 *	::
 *	 결과적으로 디비 테이블의 정보 / Form에 입력된 정보는 서버와 클라이언트 사이드를
 *	 왔다갔다 하는 Transfer object이다.
 *	::
 *	 VO(Value Object) -> DO(Domain Object) -> DTO(Data Transer Object)
 */
package servlet.context.vo;

public class PersonVO {
	private String name;
	private int age;
	
	
	@Override
	public String toString() {
		return "PersonVO [name=" + name + ", age=" + age + "]";
	}

	public PersonVO(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
