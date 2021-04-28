import com.alibaba.fastjson.JSON;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.UnsupportedCharsetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/findSales")
public class ShopListConnect extends HttpServlet {
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";

	public static final String URL = "jdbc:mysql://localhost:3306/sakila";

	public static final String USER = "root";

	public static final String PASSWORD = "wzy950505";

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");

		PrintWriter printWriter = response.getWriter();
		//查询数据库
		List<Sales> list = getList();
		String listStr = JSON.toJSONString(list);
		printWriter.write(listStr);
	}
	//入口
	private List<Sales> getList(){
		List<Sales> list = new ArrayList();

		try {
			//1. 加载驱动
			Class.forName(DRIVER);
			//2 获取数据
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

			//3 操作数据
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from t_sales order by t_num  DESC LIMIT 3");

		while (rs.next()) {
			Sales sale = new Sales(rs.getInt("t_id"), rs.getFloat("t_price"),rs.getInt("t_num"), rs.getString("t_name"));
			list.add(sale);
		}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}
}
