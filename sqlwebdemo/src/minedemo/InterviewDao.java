package minedemo;
// DAO: Database Access Object
// 專責與Dept Table之新增,修改,刪除與查詢

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InterviewDao {

  private Connection conn;

  //建構子
  public InterviewDao(Connection conn) {
		this.conn = conn;
  }

      
     
  	//建立新的面試資料
      public boolean createInterview(Interview interviewdate) {
    	  /*String created_Time, String int_Time, String comp_Name, String job_Name, String offer, String test,
  			String language, String qA, String share, String int_Score, String comp_Score, String uSER_ID*/ 
    	  try {
    	  	  

    //新增資料到Interview Table
    	      String sql ="INSERT INTO interview values ('"
    					+ interviewdate.getCreated_Time()+"','"
    					+ interviewdate.getInt_Time()+"','"
    					+ interviewdate.getComp_Name()+"','"
    					+ interviewdate.getJob_Name()+"','"
    					+ interviewdate.getOffer()+"','"
    					+ interviewdate.getTest()+"','"
    					+ interviewdate.getLanguage()+"','"
    					+ interviewdate.getQA()+"','"
    					+ interviewdate.getShare()+"','"
    					+ interviewdate.getInt_Score()+"','"
    					+ interviewdate.getComp_Score()+"','"
    					+ interviewdate.getUSER_ID()+"')";
    					
    					
    	      Statement stmt = conn.createStatement();
    	      System.out.println(sql);
//  	  stmt.close();
  	int updatecount = stmt.executeUpdate(sql);
    stmt.close();
    if (updatecount >= 1) return true;
    else                  return false;
	  } catch (Exception e) {
	    System.err.println("新增資料發生錯誤:" + e);
		return false;
  }
}
  
 
      //利用CV_NO 刪除部門
  public boolean deleteInterview(int cv_no) {
    try {
      String sqlString = "DELETE FROM interview " +
			                   "WHERE cv_no = " + cv_no;
	    Statement stmt = conn.createStatement();
		  int deletecount = stmt.executeUpdate(sqlString);
		  stmt.close();
      if (deletecount >= 1) return true;
		  else                  return false;
	  } catch (Exception e) {
	    System.err.println("刪除資料時發生錯誤: "+ e);
		  return false;
	  }
  }
/*
  //更新面試資料 //利用使用者ID來更新資料
  public boolean updateDept(Interview viewData) {
    try {
      String sqlString = "UPDATE interview " +
	                  	   	 "SET created_Time = '" + viewData.getCreated_Time() +"' "+ 
	                  	   	 "SET int_Time = '" + viewData.getInt_Time() +"' "+ 
	                  	   	 "SET comp_Name = '" + viewData.getComp_Name() +"' "+ 
	                  	   	 "SET job_Name = '" + viewData.getJob_Name() +"' "+ 
	                  	   	 "SET offer = '" + viewData.getOffer() +"' "+ 
	                  	   	 "SET test = '" + viewData.getTest() +"' "+ 
	                  	   	 "SET language = '" + viewData.getLanguage() +"' "+ 
	                  	   	 "SET qA = '" + viewData.getQA() +"' "+ 
	                  	   	 "SET share = '" + viewData.getShare() +"' "+ 
	                  	   	 "SET int_Score = '" + viewData.getInt_Score() +"' "+ 
	                  	   	 "SET comp_Score = '" + viewData.getInt_Score() +"' "+ 
    		  
                    			 "WHERE deptno = " + viewData.getUSER_ID();

      Statement stmt = conn.createStatement();
	  int updatecount = stmt.executeUpdate(sqlString);
      stmt.close();
      if (updatecount >= 1) return true;
      else                  return false;
	  } catch (Exception e) {
	    System.err.println("更新面試資料時發生錯誤:" + e);
		  return false;
    }
  }
*/
  
 
     
      //利用公司名字尋找資料
  public List<Interview>  findComp_Name(String comp_Name) {
    List<Interview>list=new ArrayList<>();
    String sql ="select * from booktype where name like ?";
	  try {
		  
		  
		  
//      Interview iterview = null;
//      String Created_Time;
//     String Int_Time ;
//      String Job_Name;
//       String Offer;
//       String Test;
//       String Language;
//       String QA;
//       String Share ;
//       String Int_Score;
//       String Comp_Score ;
//       String USER_ID;

//      String sqlString = "SELECT Cv_No, Created_Time, Int_Time, comp_Name, Job_Name, Offer, Test, Language, QA, Share, Int_Score, Comp_Score,'USER_ID' " +
//	       			  "FROM interview WHERE Comp_Name =' " + comp_Name+"';";
      
		  PreparedStatement stmt = conn.prepareStatement(sql);
		  stmt.setString(1, comp_Name+ "%");
//	  ResultSet rs = stmt.executeQuery(sql);
	  
      ResultSet rs = stmt.executeQuery();
//      if (rs.next()) {
//    	  Created_Time  =  rs.getString("Created_Time");
//    	  Int_Time  =  rs.getString("Int_Time");
//    	  Created_Time  =  rs.getString("Created_Time");
//    	  Job_Name  =  rs.getString("Job_Name");
//    	  Offer  =  rs.getString("Offer");
//    	  Test  =  rs.getString("Test");
//    	  Language  =  rs.getString("Language");
//    	  QA  =  rs.getString("QA");
//    	  Share  =  rs.getString("Share");
//    	  Int_Score  =  rs.getString("Int_Score");
//    	  Comp_Score  =  rs.getString("Comp_Score");
//    	  USER_ID  =  rs.getString("USER_ID");
//    	  
//    	 iterview = new Interview( Created_Time, Int_Time, comp_Name, Job_Name, Offer, Test, Language, QA, Share, Int_Score, Comp_Score,USER_ID);
//    	 
//      }
      
	  rs.close();
	  stmt.close();
	  return iterview;
	  
    } catch (Exception e) {
	    System.err.println("尋找部門資料時發生錯誤:" + e);
	    return null;
    }
	}

}