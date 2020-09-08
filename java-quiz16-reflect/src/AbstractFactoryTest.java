public class AbstractFactoryTest {

    public static void main(String [] args) {

        /**
         * M1 简单工厂+抽象工厂
         */
        IPerson p = SchoolFactory.createPeople("teacher");
        IOffice office = SchoolFactory.createRoom("teacher");

        p.join();
        p.leave();
        office.join();
        office.leave();

        System.out.println("----------------------------------");

        /**
         * M2 反射+抽象工厂
         */
        try {
            IPerson p2 = SchoolFactory.getPeople("Student");
            IOffice office1 = SchoolFactory.getOffice("GradeRoom");
            p2.join();
            p2.leave();
            office1.join();
            office1.leave();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}


class SchoolFactory {

    private static String person = "teacher";

    public static IPerson createPeople(String person) {
        if (person.equalsIgnoreCase("teacher"))
            return new Teacher();
        else
            return new Student();
    }

    public static IOffice createRoom(String room) {
        if (room.equalsIgnoreCase("teacher"))
            return new StaffRoom();
        else
            return new GradeRoom();
    }

    public static IPerson getPeople(String person) throws ClassNotFoundException,InstantiationException,IllegalAccessException {

        Class<?> classObj = Class.forName(person);
        return (IPerson)classObj.newInstance();
    }

    public static IOffice getOffice(String room) throws ClassNotFoundException,InstantiationException,IllegalAccessException {
        Class<?> classObj = Class.forName(room);
        return (IOffice)classObj.newInstance();
    }
}

interface IPerson {

    public void join();

    public void leave();
}

class Teacher implements IPerson {
    @Override
    public void join() {
        System.out.println("Teacher 加入学校");
    }

    @Override
    public void leave() {
        System.out.println("Teacher 离开学校");
    }
}

class Student implements IPerson {
    @Override
    public void join() {
        System.out.println("Student 加入学校");
    }

    @Override
    public void leave() {
        System.out.println("Student 离开学校");
    }
}

interface IOffice {

    public void join();

    public void leave();
}

class GradeRoom implements IOffice {
    @Override
    public void join() {
        System.out.println("Student 加入班级");
    }

    @Override
    public void leave() {
        System.out.println("Student 离开班级");
    }

}

class StaffRoom implements IOffice {
    @Override
    public void join() {
        System.out.println("Teacher 加入教学办公室");
    }

    @Override
    public void leave() {
        System.out.println("Teacher 离开教学办公室");
    }
}

