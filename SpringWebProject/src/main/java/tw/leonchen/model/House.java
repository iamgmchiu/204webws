package tw.leonchen.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity @Table(name="house")
@Component("house")
public class House {
	@Id @Column(name="HOUSEID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int houseid;
	@Column(name = "HOUSENAME")
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
