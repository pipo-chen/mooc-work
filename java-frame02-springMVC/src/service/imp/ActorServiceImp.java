package service.imp;

import dao.ActorDao;
import dao.imp.ActorDaoImp;
import service.ActorService;

public class ActorServiceImp implements ActorService {
	@Override
	public void saveActor() {
		ActorDao actorDao = new ActorDaoImp();
		actorDao.save();
	}
}
