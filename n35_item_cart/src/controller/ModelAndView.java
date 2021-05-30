package controller;
/*
 * 이동할 뷰페이지 이름과 이동방식(RequestDispatcher / Redirect)에 대한 정보를
 * 담고 있는 클래스
 */
public class ModelAndView {
	private String url;
	private boolean isRedirect;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}	
}













