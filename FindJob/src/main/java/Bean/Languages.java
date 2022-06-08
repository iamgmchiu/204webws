package Bean;

public class Languages {

	private String language;
	private String checkStatus;
	
	public Languages() {
	}
	
	public Languages(String language, String checkStatus) {
		super();
		this.language = language;
		this.checkStatus = checkStatus;
	}

	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCheckStatus() {
		return checkStatus;
	}

	public void setCheckStatus(String checkStatus) {
		this.checkStatus = checkStatus;
	}
	
}
