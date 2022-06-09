package minedemo;


import java.io.*;

public class Interview implements Serializable{


    private int Cv_No;
	private String Created_Time;
    private String Int_Time;
    private String Comp_Name;
    private String Job_Name;
    private String Offer;
    private String Test;
    private String Language;
    private String QA;
    private String Share;
    private String Int_Score;
    private String Comp_Score;
    private String USER_ID;
    
    public Interview() {
    	
    }
    
 


	public String getCreated_Time() {
		return Created_Time;
	}






	public Interview(String created_Time, String int_Time, String comp_Name, String job_Name, String offer, String test,
			String language, String qA, String share, String int_Score, String comp_Score) {
		super();//少使用者ID
		Created_Time = created_Time;
		Int_Time = int_Time;
		Comp_Name = comp_Name;
		Job_Name = job_Name;
		Offer = offer;
		Test = test;
		Language = language;
		QA = qA;
		Share = share;
		Int_Score = int_Score;
		Comp_Score = comp_Score;
	}



	public Interview(String created_Time, String int_Time, String comp_Name, String job_Name, String offer, String test,
			String language, String qA, String share, String int_Score, String comp_Score, String uSER_ID) {
		super();
		Created_Time = created_Time;
		Int_Time = int_Time;
		Comp_Name = comp_Name;
		Job_Name = job_Name;
		Offer = offer;
		Test = test;
		Language = language;
		QA = qA;
		Share = share;
		Int_Score = int_Score;
		Comp_Score = comp_Score;
		USER_ID = uSER_ID;
	}



	public Interview(int cv_No, String created_Time, String int_Time, String comp_Name, String job_Name, String offer,
			String test, String language, String qA, String share, String int_Score, String comp_Score,
			String uSER_ID) {
		super();
		Cv_No = cv_No;
		Created_Time = created_Time;
		Int_Time = int_Time;
		Comp_Name = comp_Name;
		Job_Name = job_Name;
		Offer = offer;
		Test = test;
		Language = language;
		QA = qA;
		Share = share;
		Int_Score = int_Score;
		Comp_Score = comp_Score;
		USER_ID = uSER_ID;
	}




	public void setCreated_Time(String created_Time) {
		Created_Time = created_Time;
	}



	public String getInt_Time() {
		return Int_Time;
	}



	public void setInt_Time(String int_Time) {
		Int_Time = int_Time;
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



	public String getInt_Score() {
		return Int_Score;
	}



	public void setInt_Score(String int_Score) {
		Int_Score = int_Score;
	}



	public String getComp_Score() {
		return Comp_Score;
	}



	public void setComp_Score(String comp_Score) {
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

    

}