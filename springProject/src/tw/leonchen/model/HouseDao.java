package tw.leonchen.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("houseDao")
public class HouseDao {
	
	@Autowired
	private DataSource ds;
	
	public House findById(int houseid) throws SQLException {
		Connection conn = ds.getConnection();
		
		String sqlstr = "select * from House where houseid=?";
		PreparedStatement preState = conn.prepareStatement(sqlstr);
		preState.setInt(1, houseid);
		ResultSet rs = preState.executeQuery();
		
		House hBean = null;
		
		if(rs.next()) {
			hBean = new House();
			hBean.setHouseid(rs.getInt(1));
			hBean.setHousename(rs.getString(2));
		}
		
		rs.close();
		preState.close();
		conn.close();
		
		return hBean;
	}

}
