package Bean;

import java.io.*;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Event implements Serializable {

	private int adId;
	private int compId;
	private int price;
	private String imgURL;
	private String eventLinkURL;
	private Date postStart;
	private Date postEnd;
	private String remark;

	public Event() {
	}

	public int getAdId() {
		return adId;
	}

	public void setAdId(int adId) {
		this.adId = adId;
	}

	public int getCompId() {
		return compId;
	}

	public void setCompId(int compId) {
		this.compId = compId;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getImgURL() {
		return imgURL;
	}

	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}

	public String getEventLinkURL() {
		return eventLinkURL;
	}

	public void setEventLinkURL(String eventLinkURL) {
		this.eventLinkURL = eventLinkURL;
	}

	public Date getPostStart() {
		return postStart;
	}

	public void setPostStart(Date postStart) {
		this.postStart = postStart;
	}

	public void setPostStart(String postStart) throws ParseException {
		this.postStart = stringToSQLDate(postStart);
	}

	public Date getPostEnd() {
		return postEnd;
	}

	public void setPostEnd(Date postEnd) {
		this.postEnd = postEnd;
	}

	public void setPostEnd(String postEnd) throws ParseException {
		this.postEnd = stringToSQLDate(postEnd);
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@Override
	public String toString() {
		return "adId:" + adId + "\n" + 
				"compId:" + compId + "\n" + 
				"price:" + price + "\n" + 
				"imgURL:" + imgURL + "\n" + 
				"eventLinkURL:" + eventLinkURL + "\n" + 
				"postStart:" + postStart + "\n" + 
				"postEnd:" + postEnd + "\n" + 
				"remark:" + remark;
	}

	private Date stringToSQLDate(String date) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date utilDate = df.parse(date);
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		return sqlDate;
	}

}