// DAO: Database Access Object
// 專責與Dept Table之新增,修改,刪除與查詢

import java.sql.*;

public class DeptDAO {

  private Connection conn;

  //建構子
  public DeptDAO(Connection conn) {
		this.conn = conn;
  }

  //建立新的部門
  public int createDept(String dname, String loc) {
    try {
  	  int deptno = 1;
	    String sqlString = "SELECT dept_id.nextval FROM DUAL";
  	  Statement stmt = conn.createStatement();
  	  //自取號機取得新部門的部門代號
	    ResultSet rs = stmt.executeQuery(sqlString);

      if (rs.next()) deptno = rs.getInt(1);

      rs.close();

    //新增部門到Dept Table
      sqlString = "INSERT INTO dept(deptno,dname) " +
	                "VALUES(" + deptno + ",'" + dname + "')";
      stmt.executeUpdate(sqlString);
  	  stmt.close();
	    return deptno;
	  } catch (Exception e) {
	    System.err.println("建立部門時發生錯誤:" + e);
		  return -1;
	  }
  }
  
  //刪除部門
  public boolean deleteDept(int deptno) {
    try {
      String sqlString = "DELETE FROM dept " +
			                   "WHERE deptno = " + deptno;
	    Statement stmt = conn.createStatement();
		  int deletecount = stmt.executeUpdate(sqlString);
		  stmt.close();
      if (deletecount >= 1) return true;
		  else                  return false;
	  } catch (Exception e) {
	    System.err.println("刪除部門時發生錯誤: "+ e);
		  return false;
	  }
  }

  //更新部門資料
  public boolean updateDept(Dept deptData) {
    try {
      String sqlString = "UPDATE dept " +
	                  	   	 "SET dname = '" + deptData.getDname() +"' "+ 
                    			 "WHERE deptno = " + deptData.getDeptno();

      Statement stmt = conn.createStatement();
	  int updatecount = stmt.executeUpdate(sqlString);
      stmt.close();
      if (updatecount >= 1) return true;
      else                  return false;
	  } catch (Exception e) {
	    System.err.println("更新部門資料時發生錯誤:" + e);
		  return false;
    }
  }

  //尋找部門資料
  public Dept findDept(int deptno) {
    try {
      Dept dep = null;
      String dname;
	   

      Statement stmt = conn.createStatement();
      String sqlString = "SELECT dname " +
	       			  "FROM dept WHERE deptno = " + deptno;
      
	  ResultSet rs = stmt.executeQuery(sqlString);

      if (rs.next()) {
        dname  =  rs.getString("dname");
		dep = new Dept(deptno,dname);
	  }
	  rs.close();
	  stmt.close();
	  return dep;
	  
    } catch (Exception e) {
	    System.err.println("尋找部門資料時發生錯誤:" + e);
	    return null;
    }
	}

}