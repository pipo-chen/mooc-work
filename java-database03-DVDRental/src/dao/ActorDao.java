package dao;

import entity.Actor;
import utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//实现 Actor 的增删改查
public class ActorDao {

	/**
	 * 增加
	 * @param actor
	 * @throws SQLException
	 */
	public void addActor(Actor actor) throws SQLException {
		//获取连接
		Connection conn = JDBCUtils.getConnnection();
		//sql
		String sql = "insert into actor (actor_id,first_name, last_name,last_update) value (null, ?,?, now())";
		//预编译
		PreparedStatement psmt = conn.prepareStatement(sql);
		//参数替换
		psmt.setString(1, actor.getFirst_name());
		psmt.setString(2,actor.getLast_name());
		//执行 sql
		psmt.execute();
	}

	/**
	 * 修改
	 * @param actor
	 * @throws SQLException
	 */
	public void updateActor(Actor actor) throws SQLException {
		//获取连接
		Connection conn = JDBCUtils.getConnnection();
		//sql
		String sql = "update actor set first_name=?, last_name = ? where actor_id = ?";
		//预编译
		PreparedStatement psmt = conn.prepareStatement(sql);
		//参数替换
		psmt.setString(1, actor.getFirst_name());
		psmt.setString(2,actor.getLast_name());
		psmt.setInt(3, actor.getActor_id());
		//执行 sql
		psmt.execute();
	}

	/**
	 * 删除
	 * @param actor
	 * @throws SQLException
	 */
	public void deleteActor(Actor actor) throws SQLException {
		//获取连接
		Connection conn = JDBCUtils.getConnnection();
		//sql
		String sql = "delete  from actor where actor_id = ?";
		//预编译
		PreparedStatement psmt = conn.prepareStatement(sql);
		//参数替换
		psmt.setInt(1, actor.getActor_id());
		//执行 sql
		psmt.execute();
	}

	/**
	 * 查询
	 * @param id
	 * @return
	 */
	public Actor queryActor(int id) {
		//获取连接
		Connection conn = JDBCUtils.getConnnection();
		//sql
		String sql = "select * from actor where actor_id=?";
		//预编译
		PreparedStatement psmt = null;
		ResultSet rs = null;
		Actor result = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			rs = psmt.executeQuery();
			while (rs.next()) {
				result = new Actor();
				result.setActor_id(rs.getInt("actor_id"));
				result.setFirst_name(rs.getString("first_name"));
				result.setLast_name(rs.getString("last_name"));
				result.setLast_update(rs.getDate("last_update"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 查询全部数据
	 * @return
	 * @throws SQLException
	 */
	public List<Actor> queryAllActor() {
		//获取连接
		Connection conn = JDBCUtils.getConnnection();
		//sql
		String sql = "select * from actor ";

		//预编译
		Statement stmt = null;
		ResultSet rs = null;
		List<Actor> list = null;

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			list = new ArrayList<>();
			Actor result = null;
			while (rs.next()) {
			result = new Actor();
			result.setActor_id(rs.getInt("actor_id"));
			result.setFirst_name(rs.getString("first_name"));
			result.setLast_name(rs.getString("last_name"));
			result.setLast_update(rs.getDate("last_update"));
			list.add(result);
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}
}
