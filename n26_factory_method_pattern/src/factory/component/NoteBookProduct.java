package factory.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import factory.model.Dao;
import factory.model.NoteBook;

/*
 * 인터페이스를 상속받아서 작성 실질적인 객체를 생성할수 있는 클래스..(구상객체)
 * 얘가 바로 Component 라고 이야기 할수 있다.
 */
public class NoteBookProduct implements Product{

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String model = request.getParameter("model");
		NoteBook notebook = Dao.getInstance().findNoteBookByModel(model);
		
		request.setAttribute("notebook", notebook);
		String path = "find_result.jsp";
		
		return path;
	}
}
