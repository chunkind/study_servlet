package factory.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Component가 실제 기능을 수행할 수 있는 메소드를 template로 작성한다.
 * Component ::
 * 인터페이스 기반의 재사용 가능한 라이브러리 클래스
 */
public interface Product {
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception;
}
