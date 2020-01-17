package mvcMem.control;

public class ActionForward {
	private String url;
	private boolean redirect;

	public ActionForward(String url, boolean redirect) {
		super();
		this.url = url;
		this.redirect = redirect;
	}
	public ActionForward(String url) {
		super();
		this.url = url;
	}
	public ActionForward() {
		super();
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public boolean isRedirect() {
		return redirect;
	}
	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}
	
	
}
