package ajax;

//用来接受前台判断用户名数据，然后来判断该用户名是否存在

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/checkUserName")
public class AjaxDemo2 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter writer = response.getWriter();

		String uname = request.getParameter("uname");

		if ("zhangsan".equals(uname)) {
			writer.write("uname already exists!");
		} else {
			writer.write("uname can is available!");
		}

	}

}
