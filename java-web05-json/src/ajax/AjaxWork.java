package ajax;
import com.alibaba.fastjson.JSON;
import json.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@WebServlet("/findAll")
public class AjaxWork extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		//拿到一个 printWriter 对象
		PrintWriter printWriter = response.getWriter();
		//模拟数据库表查询
		List<User> list = initData();
		//把数据转成 json 格式 转化接口有问题
//		String userString = JSON.toJSONString(list);
		String userString = "[{\"password\":\"123\",\"uid\":1001,\"username\":\"wangpang\"},{\"password\":\"456\",\"uid\":1002,\"username\":\"chenyao\"},{\"password\":\"789\",\"uid\":1003,\"username\":\"lisi\"}]";
		//发送给前台
		printWriter.write(userString);

	}
	//模拟数据库的查询某张表的所有数据方法
	private List<User> initData() {

		List<User> users = new ArrayList<>();
		Collections.addAll(users,
				new User(1001,"wangpang","123"),
				new User(1002, "chenyao","456"),
				new User(1003, "lisi","789"));
		return users;
	}
}
