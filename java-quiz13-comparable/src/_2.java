import java.util.Arrays;

/**
 * 写一个student类，有学号、姓名（拼音）、年龄、性别四个字段，
 * 然后录入一些数据，形成一个Student的数组，要求对这个Student的数组进行排序。
 *
 * 要求排序的规则为：
 * 学号是从小到大，如果没有学号，
 * 那么姓名按照首字母升序排序，
 * 姓名的首字母相同的学生则按照他们的年龄的降序进行排序，
 * 男的在前面，女的在后面。
 */
public class _2 {

    public static void main(String[] args) {
        Student [] stus = new Student[7];
        stus[0] = new Student("zhangtwo",12,3,'男');
        stus[1] = new Student("lisizero", 12,'女');
        stus[2] = new Student("wangwu",11,1,'男');
        stus[3] = new Student("chenone",10,2,'女');
        stus[4] = new Student("lisitwo", 12,'男');
        stus[5] = new Student("lisithree", 11,'男');
        stus[6] = new Student("anji",10,'女');
        System.out.println(Arrays.toString(stus));
        Arrays.sort(stus);
        System.out.println("--------------排序后---------------------");
        System.out.println(Arrays.toString(stus));

    }
}

class Student implements Comparable<Student> {
    private String name;
    private int age;
    private int number;
    private char sex;

    public Student() {
    }

    public Student(String name, int age, char sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.number = Integer.MAX_VALUE;
    }

    public Student(String name, int age, int number, char sex) {
        this.name = name;
        this.age = age;
        this.number = number;
        this.sex = sex;
    }

    @Override
    public int compareTo(Student o) {

        if (this.number == o.number) {

            if (this.name.charAt(0) == o.name.charAt(0)) {
                if (o.age == this.age) {
                    return o.sex - this.sex;
                }
                return o.age - this.age;
            }
            return this.name.charAt(0) - o.name.charAt(0);
        }

        return this.number - o.number;
    }


    @Override
    public String toString() {
        return "学生："+ this.name + " 年龄：" + this.age + " 性别: "+ this.sex + " 学号："+ (this.number == Integer.MAX_VALUE ? "无" : this.number) + "\n";
    }
}
