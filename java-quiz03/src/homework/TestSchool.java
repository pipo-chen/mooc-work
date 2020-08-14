package homework;

interface JavaTeacher {
    void teach();
}

class TeacherA implements JavaTeacher {
    public void teach() {
        System.out.println("TeacherA teach Java");
    }
}

class TeacherB implements JavaTeacher {
    @Override
    public void teach() {
        System.out.println("TeacherB teach Java");
    }
}

class School {
    public static JavaTeacher getTeacher(int i) {
        if (i == 0)
            return new TeacherA();
        else
            return new TeacherB();
    }
}

public class TestSchool {
    public static void main(String[] args) {
        JavaTeacher jt = School.getTeacher(0);
        jt.teach();
        JavaTeacher jt2 = School.getTeacher(11);
        jt2.teach();
    }
}
