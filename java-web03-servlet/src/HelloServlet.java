import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {
	//处理 get 方法
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out = response.getWriter();
		String title = "使用 GET 方法读取表单数据";
		out.println(
				"<!DOCTYPE html>\n" +
						"<html>\n" +
						"<head><title>" + title + "</title></head>\n" +
						"<body bgcolor=\"#f0f0f0\">\n"+
						"<h1 align=\"center\">" + title + "</h1>\n" +
						"<ul>\n" +
						" <li><b>站点名</b>:" + request.getParameter("name") + "\n" +
						"<li><b>网站</b>:" + request.getParameter("url") + "\n" +
						"</ul>\n" +
						"</body></html>");
	}
	//处理 post 方法
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
