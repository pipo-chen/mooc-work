package service.imp;

import dao.ActorDao;
import entity.Actor;
import service.ActorService;

import java.util.List;

public class ActorServiceImp implements ActorService {
	@Override
	public List<Actor> getAllActors() {
		ActorDao actorDao = new ActorDao();
		return actorDao.queryAllActor();
	}

	@Override
	public Actor getActorById(int id) {
		ActorDao actorDao = new ActorDao();
		return actorDao.queryActor(id);
	}
}
