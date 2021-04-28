import java.sql.SQLException;

public class JDBCTest {

	public static void main(String[] args) {
		ActorDao actorDao = new ActorDao();

		Actor param = new Actor();
		param.setActor_id(1);

		try {
			Actor result = actorDao.queryActor(param);
			System.out.println(result.toString());

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}


}
