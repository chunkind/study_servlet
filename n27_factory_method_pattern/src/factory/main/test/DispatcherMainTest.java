package factory.main.test;

import factory.ActionFactory;
import factory.action.Action;

/*
 * Factory Method Pattern ::
 * 추상화된 클래스(Action)의 구상객체를 생성하고(ActionFactory) /
 * 반환하는 (ActionFactory) 방법
 * 
 * 구상객체를 생성하는 곳은 싱글톤으로 만들어진 Factory에서 진행된다..
 * createAction(command)... command값에 따라서 서로다른 Action이 생성된다..
 * 하지만 리턴타입은 인터페이스 타입으로 반환된다.(PolyMorphism)
 * --> 정작 사용자로 하여금 구상객체명은 Hidding 된다.
 * 
 * 1.	결국 클라이언트는 Factory로 하여금 command값을 전달함으로써 구상객체가
 * 		만들어 지도록 주문한다.
 * 2.	Factory는 command값에 따라 서로 다른 구상객체를 만들고 실질적인 객체는 감추면서
 * 		인터페이스를 돌려준다.
 * 3.	다시 클라이언트는 인터페이스의 execute()를 호출함으로써 결과페이지인 path를
 * 		스트링으로 리턴받아 뷰페이지를 포워딩 할 수 있다.
 * 
 * 		여기서 클라이언트는 누구를 의미하는 걸까요?
 * 		--> 서버상의 클라이언트(DispatcherServlet...Front Controller이다.)
 */
public class DispatcherMainTest {
	public static void main(String[] args) {
		String command = "INSERT";
		
		Action action = ActionFactory.GetInstance().createAction(command);
		action.execute();  //InsertAction의 execute()가 수행된다.
	}
}
