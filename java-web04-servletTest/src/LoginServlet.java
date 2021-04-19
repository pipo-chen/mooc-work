import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;


public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
		ArrayList<User> users = new ArrayList<>();
		User a = new User("xiaming","123");
		User b = new User("laowang", "345");
		users.add(a);
		users.add(b);
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		boolean flag = false;
		for (User user : users) {
			if (user.getName().equals(name) && user.getPassword().equals(password)) {
					response.sendRedirect(request.getContextPath()+"/welcome.jsp?name="+name);
					flag = true;
			}
		}

		if (!flag) {
			request.setAttribute("message","账号或密码错误，请重新登录！");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}

	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		this.doPost(request, response);
	}



}
