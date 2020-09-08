public class AbstractFoodFactoryDemo {

    public static void main(String[] args) {

        User user = new User();

        IFactory factory = new SqlSeverFactory();

        IUser iu = factory.createUser();

        iu.Insert(user);
        iu.getUser(1);

        IDeparment id = factory.createDepartment();
        id.Insert(new Department());
        id.getDepartment(1);
    }
}

interface IUser {
    void Insert(User user);

    User getUser(int id);
}

class User {

}

class SqlServerUser implements IUser {
    @Override
    public void Insert(User user) {
        System.out.println("Sql 中增加 User 记录");
    }

    @Override
    public User getUser(int id) {
        System.out.println("Sql 中根据 id 查询记录");

        return null;
    }
}

class AccessUser implements IUser {
    @Override
    public void Insert(User user) {
        System.out.println("Access 中增加 User 记录");
    }

    @Override
    public User getUser(int id) {
        System.out.println("Access 中根据 id 获得 User 记录");
        return null;
    }
}

interface IFactory {
    IUser createUser();
    IDeparment createDepartment();

}

class SqlSeverFactory implements IFactory {
    @Override
    public IUser createUser() {
        return new SqlServerUser();
    }

    @Override
    public IDeparment createDepartment() {
        return new SqlDepartment();
    }
}

class AccessFactory implements IFactory {
    @Override
    public IUser createUser() {
        return new AccessUser();
    }

    @Override
    public IDeparment createDepartment() {
        return new AccessDepartment();
    }
}

interface IDeparment {
    void Insert(Department department);

    Department getDepartment(int id);

}

class Department {

}

class SqlDepartment implements IDeparment {
    @Override
    public void Insert(Department department) {
        System.out.println("Sql 给 Department 增加记录");
    }

    @Override
    public Department getDepartment(int id) {
        System.out.println("Sql 查询 Department 数据");
        return null;
    }
}

class AccessDepartment implements IDeparment {
    @Override
    public void Insert(Department department) {
        System.out.println("Access 给 Department 增加记录");
    }

    @Override
    public Department getDepartment(int id) {
        System.out.println("Access 查询 Department 数据");

        return null;
    }
}

