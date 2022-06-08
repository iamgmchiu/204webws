package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bean.Event;

public class EventsDAO {
	private Connection conn;

	private static final String GET_ONE_SQL = "SELECT * FROM events WHERE ad_id = ?";
	private static final String GET_ALL_SQL = "SELECT * FROM events";
	private static final String CRTAE_SQL = "INSERT INTO events VALUES (?, ?, ?, ?, ?, ?, ?)";
	private static final String UPDATE_SQL = "UPDATE events " 
			+ "SET comp_id = ?, " 
			+ "price = ?, " 
			+ "image = ?, "
			+ "event_link = ?, " 
			+ "post_start = ?, " 
			+ "post_end = ?, " 
			+ "remark = ? " 
			+ "WHERE ad_id = ?";
	private static final String DELETE_SQL = "DELETE FROM events WHERE ad_id = ?";
	private static final String GET_BY_PAGE_SQL = "Select * From events " 
			+ "Order By ad_id " 
			+ "Offset ? Rows "
			+ "Fetch Next 10 Rows Only;";
	private static final String GET_COUNT_SQL = "SELECT COUNT(*) 'counts' FROM events;";

	public EventsDAO(Connection conn) {
		this.conn = conn;
	}

	public boolean createEvent(Event event) {
		try {
			PreparedStatement pstmt = conn.prepareStatement(CRTAE_SQL);
			pstmt.setInt(1, event.getCompId());
			pstmt.setInt(2, event.getPrice());
			pstmt.setString(3, event.getImgURL());
			pstmt.setString(4, event.getEventLinkURL());
			pstmt.setDate(5, event.getPostStart());
			pstmt.setDate(6, event.getPostEnd());
			pstmt.setString(7, event.getRemark());
			int createCount = pstmt.executeUpdate();
			pstmt.close();
			if (createCount > 0) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			return false;
		}
	}

	public boolean updateEvent(Event event) {
		try {
			PreparedStatement pstmt = conn.prepareStatement(UPDATE_SQL);
			pstmt.setInt(1, event.getCompId());
			pstmt.setInt(2, event.getPrice());
			pstmt.setString(3, event.getImgURL());
			pstmt.setString(4, event.getEventLinkURL());
			pstmt.setDate(5, event.getPostStart());
			pstmt.setDate(6, event.getPostEnd());
			pstmt.setString(7, event.getRemark());
			pstmt.setInt(8, event.getAdId());
			int updateCount = pstmt.executeUpdate();
			pstmt.close();System.out.println(updateCount);
			if (updateCount > 0) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			return false;
		}
	}

	public boolean deleteEvent(int adId) {
		try {
			PreparedStatement pstmt = conn.prepareStatement(DELETE_SQL);
			pstmt.setInt(1, adId);
			int deleteCount = pstmt.executeUpdate();
			pstmt.close();
			if (deleteCount > 0) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			return false;
		}
	}

	public Event searchByAdId(int adId) {
		try {
			PreparedStatement pstmt = conn.prepareStatement(GET_ONE_SQL);
			pstmt.setInt(1, adId);
			ResultSet rs = pstmt.executeQuery();
			Event event = new Event();
			if (rs.next()) {
				event.setAdId(rs.getInt("ad_id"));
				event.setCompId(rs.getInt("comp_id"));
				event.setPrice(rs.getInt("price"));
				event.setImgURL(rs.getString("image"));
				event.setEventLinkURL(rs.getString("event_link"));
				event.setPostStart(rs.getDate("post_start"));
				event.setPostEnd(rs.getDate("post_end"));
				event.setRemark(rs.getString("remark"));
			}else {
				rs.close();
				pstmt.close();
				return null;
			}
			rs.close();
			pstmt.close();
			return event;
		} catch (SQLException e) {
			return null;
		}
	}

	public List<Event> searchAll() {
		try {
			Event event = null;
			List<Event> events = new ArrayList<Event>();
			PreparedStatement pstmt = conn.prepareStatement(GET_ALL_SQL);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				event = new Event();
				event.setAdId(rs.getInt("ad_id"));
				event.setCompId(rs.getInt("comp_id"));
				event.setPrice(rs.getInt("price"));
				event.setImgURL(rs.getString("image"));
				event.setEventLinkURL(rs.getString("event_link"));
				event.setPostStart(rs.getDate("post_start"));
				event.setPostEnd(rs.getDate("post_end"));
				event.setRemark(rs.getString("remark"));
				events.add(event);
			}
			rs.close();
			pstmt.close();
			return events;
		} catch (SQLException e) {
			return null;
		}
	}

	public List<Event> searchByPage(int page) {
		try {
			Event event = null;
			List<Event> events = new ArrayList<Event>();
			PreparedStatement pstmt = conn.prepareStatement(GET_BY_PAGE_SQL);
			pstmt.setInt(1, (page - 1) * 10);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				event = new Event();
				event.setAdId(rs.getInt("ad_id"));
				event.setCompId(rs.getInt("comp_id"));
				event.setPrice(rs.getInt("price"));
				event.setImgURL(rs.getString("image"));
				event.setEventLinkURL(rs.getString("event_link"));
				event.setPostStart(rs.getDate("post_start"));
				event.setPostEnd(rs.getDate("post_end"));
				event.setRemark(rs.getString("remark"));
				events.add(event);
			}
			rs.close();
			pstmt.close();
			return events;
		} catch (SQLException e) {
			return null;
		}
	}

	public int getPageCount() {
		try {
			int counts = 0;
			PreparedStatement pstmt = conn.prepareStatement(GET_COUNT_SQL);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				counts = rs.getInt("counts");
			}
			int pageCount = counts / 10;
			if (counts % 10 != 0) {
				pageCount++;
			}
			rs.close();
			pstmt.close();
			return pageCount;
		} catch (SQLException e) {
			return -1;
		}
	}

	public void closeConn() throws SQLException {
		if (conn != null) {
			conn.close();
		}
	}

}
