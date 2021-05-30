package controller;
/*
 * 이동할 view 페이지 이름과 이동방식(RequestDispatcher, redirect)
 * 에 대한 정보를 담고 있는 클래스
 */
public class ModelAndView {
	private String url;
	private boolean isRedirect;
	
	public ModelAndView() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ModelAndView(String url, boolean isRedirect) {
		super();
		this.url = url;
		this.isRedirect = isRedirect;
	}

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

	@Override
	public String toString() {
		return "ModelAndView [url=" + url + ", isRedirect=" + isRedirect + "]";
	}
	
}
