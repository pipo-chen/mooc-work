package servlet;

import entity.Staff;
import service.StaffService;
import service.StaffServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 员工登录 servlet
 * 1. 用户点击登录发送请求到 servlet.StaffServlet 方法进行请求处理，并将封装相关数据为 request 和 response 作为参数传递给 service
 * 2. 在 StaffService 中处理
 * 3. 在业务层方法中调用 dao 层方法完成数据库操作
 * 4. 完成功能跳转 mvc
 * 		m：model 模型层
 * 		v: view
 * 		c:controller
 */
@WebServlet("/staff")
public class StaffServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置编码格式
		req.setCharacterEncoding("utf-8");

		//设置响应编码格式
		resp.setContentType("text/html;charset=utf-8");

		//获取请求参数
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		/*进行业务处理
		StaffService staffService = new StaffServiceImp();
		Staff staff = staffService.getStaffInfoService(username, password);
		*/
		//模拟登录
		Staff staff = new Staff();
		staff.setUsername("Jon");
		System.out.println("用户查询结果为：");


		HttpSession session = req.getSession();
		//响应处理结果
		if (staff != null) { //登录成功
			session.setAttribute("staff", staff);
			resp.sendRedirect("main.jsp");
		} else { //登录失败
			session.setAttribute("flag","loginfalse");
			//重定向到 login.jsp
			resp.sendRedirect("login.jsp");

		}


		//获取 session




	}
}
