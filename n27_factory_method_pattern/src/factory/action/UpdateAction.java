package factory.action;
//구상객체..컴포넌트
public class UpdateAction implements Action{

	@Override
	public void execute() {
		/*
		 * 폼에 입력된 값 받아서
		 * DAO 호출.. 리턴된 값 받아서
		 * 바인딩
		 * 네비게이션(이부분은 디스페쳐가 한꺼번에 해준다.)
		 */
		update();
	}
	public void update(){
		// 여기서 비지니스 로직이 수행 됬다 치고 ..
		System.out.println("UPDATE OK..");
	}
}

