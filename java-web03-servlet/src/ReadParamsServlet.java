import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class ReadParamsServlet extends HttpServlet {
	//处理 get 方法
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out = response.getWriter();
		String title = "读取参数";
		out.println(
				"<!DOCTYPE html>\n" +
						"<html>\n" +
						"<head><title>" + title + "</title></head>\n" +
						"<body bgcolor=\"#f0f0f0\">\n"+
						"<h1 align=\"center\">" + title + "</h1>\n" +
						"<ul>\n");

		Enumeration paraNames = request.getParameterNames();
		while (paraNames.hasMoreElements()) {
			String paramName = (String) paraNames.nextElement();
			out.println("<li><b>" + paramName + "</b>:");
			String[] paramValues = request.getParameterValues(paramName);
			//读取单个值的数据
			if (paramValues.length == 1) {
				String paramValue = paramValues[0];
				if (paramValue.length() == 0) {
					out.println("没有值");
				} else {
					out.println(paramValue);
				}
			} else {
				for (int i = 0; i < paramValues.length; i++) {
					out.println(paramValues[i]);
				}
			}
		}
		out.println("</ul>\n");
		out.println("</body></html>");

	}
	//处理 post 方法
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}

