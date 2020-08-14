public class _23 {

    public static void main(String[] args) {
        Student s = new Student("nihao",111);
        Student s1 = new Student();
        System.out.println(s.toString());
    }
}
class Student {
//

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, int age) {
        this(name);
        this.age = age;

    }
    int age = 10;
    String name = "limy";
}
