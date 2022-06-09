
package Bean;

import java.io.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Interview implements Serializable {

	private int Cv_No;
	private java.sql.Timestamp Created_Time;
	private Date Int_Time;
	private String Comp_Name;
	private String Job_Name;
	private String Offer;
	private String Test;
	private String Language;
	private Languages[] LanguageArray;
	private String[] LanList;
	private String QA;
	private String Share;
	private int Int_Score;
	private int Comp_Score;
	private String USER_ID;

	public Interview() {
		initLanguageArray();
	}

	private void initLanguageArray() {
		LanguageArray = new Languages[10];
		LanguageArray[0] = new Languages("國語", "N");
		LanguageArray[1] = new Languages("英語", "N");
		LanguageArray[2] = new Languages("日語", "N");
		LanguageArray[3] = new Languages("韓文", "N");
		LanguageArray[4] = new Languages("德文", "N");
		LanguageArray[5] = new Languages("法文", "N");
		LanguageArray[6] = new Languages("義大利文", "N");
		LanguageArray[7] = new Languages("西班牙文", "N");
		LanguageArray[8] = new Languages("葡萄牙文", "N");
		LanguageArray[9] = new Languages("其他", "N");
	}

	public java.sql.Timestamp getCreated_Time() {
		return Created_Time;
	}

	public void setCreated_Time(java.sql.Timestamp created_Time) {
		Created_Time = created_Time;
	}

	public void setCreated_Time(String created_Time) throws ParseException {
		this.Created_Time = stringToSQLDateSs(created_Time);
	}

	public Date getInt_Time() {
		return Int_Time;
	}

	public void setInt_Time(Date int_Time) {
		this.Int_Time = int_Time;
	}

	public void setInt_Time(String int_Time) throws ParseException {
		this.Int_Time = stringToSQLDate(int_Time);
	}

	public String getComp_Name() {
		return Comp_Name;
	}

	public void setComp_Name(String comp_Name) {
		Comp_Name = comp_Name;
	}

	public String getJob_Name() {
		return Job_Name;
	}

	public void setJob_Name(String job_Name) {
		Job_Name = job_Name;
	}

	public String getOffer() {
		return Offer;
	}

	public void setOffer(String offer) {
		Offer = offer;
	}

	public String getTest() {
		return Test;
	}

	public void setTest(String test) {
		Test = test;
	}

	public String getLanguage() {
		return Language;
	}

	public void setLanguage(String language) {
		Language = language;
	}

	public String getQA() {
		return QA;
	}

	public void setQA(String qA) {
		QA = qA;
	}

	public String getShare() {
		return Share;
	}

	public void setShare(String share) {
		Share = share;
	}

	public int getInt_Score() {
		return Int_Score;
	}

	public void setInt_Score(int int_Score) {
		Int_Score = int_Score;
	}

	public int getComp_Score() {
		return Comp_Score;
	}

	public void setComp_Score(int comp_Score) {
		Comp_Score = comp_Score;
	}

	public String getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(String uSER_ID) {
		USER_ID = uSER_ID;
	}

	public int getCv_No() {
		return Cv_No;
	}

	public void setCv_No(int cv_No) {
		Cv_No = cv_No;
	}

	public String execute() throws Exception {
		return Language;
	}

	public Languages[] getLanguageArray() {
		return LanguageArray;
	}

	public void setLanguageArray(Languages[] languageArray) {
		LanguageArray = languageArray;
	}

	public String[] getLanList() {
		return LanList;
	}

	public void setLanList(String[] lanList) {
		LanList = lanList;
	}

	private Date stringToSQLDate(String date) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date utilDate = df.parse(date);
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		return sqlDate;
	}

	private java.sql.Timestamp stringToSQLDateSs(String date) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date utilDate = df.parse(date);
		java.sql.Timestamp sqlDate = new java.sql.Timestamp(utilDate.getTime());
		return sqlDate;
	}

}