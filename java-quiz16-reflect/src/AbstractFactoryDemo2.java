import javax.xml.crypto.Data;
import java.util.Date;

public class AbstractFactoryDemo2 {
    public static void main(String[] args) {
        User user = new User();
        Department department = new Department();

        IUser iu = DataAccess.createUser();

        iu.Insert(user);
        iu.getUser(1);

        IDeparment id = DataAccess.createDepartment();
        id.Insert(department);
        id.getDepartment(1);
    }
}

class DataAccess {

    private static String db = "Sqlserver";

    public static IUser createUser() {
        IUser result = null;
        switch (db) {
            case "Sqlserver":
                result = new SqlServerUser();
                break;
            case "Access":
                result = new AccessUser();
                break;

        }
        return result;
    }

    public static IDeparment createDepartment() {
        IDeparment result = null;
        switch (db) {
            case "Sqlserver":
                result = new SqlDepartment();
                break;
            case "Access":
                result = new AccessDepartment();
                break;
        }
        return result;
    }
}


