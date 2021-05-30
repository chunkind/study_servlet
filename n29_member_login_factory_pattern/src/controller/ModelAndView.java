package controller;

public class ModelAndView {
	private String path;
	private boolean isRedirect;	//false...forward
	
	public ModelAndView(String path, boolean isRedirect) {
		this.path = path;
		this.isRedirect = isRedirect;
	}

	public ModelAndView(String path) {
		this.path = path;
	}

	public ModelAndView() { }

	public void setPath(String path) {
		this.path = path;
	}

	public boolean isRedirect() {
		return isRedirect;
	}
	
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}

	public String getPath() {
		return path;
	}
	
}
