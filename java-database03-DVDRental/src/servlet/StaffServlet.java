package servlet;

import dao.StaffDao;
import service.StaffService;
import service.imp.StaffServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/changePassword")
public class StaffServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pw = req.getParameter("password");
		String id = req.getParameter("staff_id");
		int staff_id = Integer.valueOf(id);
		//前端校验密码
		StaffService staffService = new StaffServiceImp();
		boolean result = staffService.changeStaffPassword(pw, staff_id);

		PrintWriter out = resp.getWriter();
		if (!result) {
			out.write("congratulation update  password success!");
		} else {
			out.write("Sorry, update password fail!");
		}

	}
}
