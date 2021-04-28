package servlet;

import com.alibaba.fastjson.JSON;
import dao.ActorDao;
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

@WebServlet("/select-actor")
public class ActorFindServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idstr = req.getParameter("actor_id");
		int id = Integer.valueOf(idstr);
		ActorService actorService = new ActorServiceImp();
		Actor actor = actorService.getActorById(id);
		PrintWriter out = resp.getWriter();
		String result = JSON.toJSONString(actor);

		if (actor != null)
			out.write(result);
		else
			out.write("{'message': 'no body'}");


	}
}
