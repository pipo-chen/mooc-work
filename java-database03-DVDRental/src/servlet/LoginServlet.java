package servlet;

import com.alibaba.fastjson.JSON;
import entity.Staff;
import service.StaffService;
import service.imp.StaffServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		StaffService staffService = new StaffServiceImp();
		Staff staff = staffService.findStaffByInfo(username, password);
		PrintWriter out = resp.getWriter();
		String result = "error password or username!";
		if (staff != null) {
			result = JSON.toJSONString(staff);
		}
		out.println(result);
	}
}
