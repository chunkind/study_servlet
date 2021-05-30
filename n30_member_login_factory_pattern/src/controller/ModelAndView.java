package controller;

public class ModelAndView {
	private String path;
	private boolean isRedirect; // false
	
	// Constructor.
	public ModelAndView(String path, boolean isRedirect) { // redirect 방식일 때,
		this.path = path;
		this.isRedirect = isRedirect;
	}
	public ModelAndView(String path){ // forward 방식일 때,
		this.path = path;
	}
	public ModelAndView(){} // 페이지로 연결할 필요가 없을 때,
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
}
