package dao;

import entity.Staff;
import utils.JDBCUtils;

import java.sql.*;
import java.util.Date;

public class StaffDao {
	public Staff queryStaffByInfo(String username, String password) {
		//获取连接
		Connection conn = JDBCUtils.getConnnection();
		//sql
		String sql = "select * from staff where username=? and password = ?";
		//预编译
		PreparedStatement psmt = null;
		ResultSet rs = null;
		Staff result = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, username);
			psmt.setString(2, password);
			rs = psmt.executeQuery();
			while (rs.next()) {
				result = new Staff();
				result.setUsername(username);
				result.setPassword(password);
				result.setActive(rs.getInt("active"));
				result.setAddress_id(rs.getInt("address_id"));
				result.setEmail(rs.getString("email"));
				result.setFirst_name(rs.getString("first_name"));
				result.setLast_name(rs.getString("last_name"));
				Object date = (Object)rs.getDate("last_update");
				result.setLast_update((Date) date);
				result.setSotre_id(rs.getInt("store_id"));
				result.setStaff_id(rs.getInt("staff_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public Boolean changStaffPassword(String password, int staff_id) {
		//获取连接
		Connection conn = JDBCUtils.getConnnection();
		//sql
		String sql = "update staff SET `password` = ? WHERE staff_id =?";
		PreparedStatement psmt = null;
		boolean rs = true;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, password);
			psmt.setInt(2, staff_id);
			rs = psmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
}
