package servlet;

import com.alibaba.fastjson.JSON;
import entity.Actor;
import service.ActorService;
import service.imp.ActorServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/actor-list")
public class ActorListServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Actor> list = new ArrayList<>();
		ActorService actorService = new ActorServiceImp();
		PrintWriter out = resp.getWriter();

		list = actorService.getAllActors();
		String result = JSON.toJSONString(list);
		out.write(result);

	}
}

