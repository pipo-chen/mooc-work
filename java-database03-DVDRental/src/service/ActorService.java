package service;

import entity.Actor;

import java.sql.SQLException;
import java.util.List;

public interface ActorService {
	List<Actor> getAllActors();

	Actor getActorById(int id);
}
