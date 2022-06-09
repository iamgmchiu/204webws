package tw.leonchen.model;

import org.springframework.stereotype.Component;

@Component("house")
public class House {

	private int houseid;
	private String housename;
	public int getHouseid() {
		return houseid;
	}
	public void setHouseid(int houseid) {
		this.houseid = houseid;
	}
	public String getHousename() {
		return housename;
	}
	public void setHousename(String housename) {
		this.housename = housename;
	}
	
}
