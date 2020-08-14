package homework;

public class TestDog {
    public static void main(String[] args) {
        Dog d;
        //创建一个 Dog 对象，调用有参构造函数
        d = new Dog("joy",2,false);
        //名字为 joy，年龄为 2 岁，性别为母

        //调用 Dog 对象无参的 play 方法。
        d.play();
        //调用 Dog 对象有参的 play 方法，参数为 30
        d.play(30);
    }

}

//定义一个 Dog 类
class Dog {
    //定义一个 name 属性，该属性为 String 类型
    public String name;
    //定义一个 age 属性，该属性为 int 类型
    public int age;
    //定义一个 sexual 属性，该属性为 boolean 类型
    //true 表示为公，false 表示为母
    public boolean sexual;

    public Dog() {
    }

    public Dog(String name, int age, boolean sexual) {
        //分别根据参数，设置 Dog 类的属性
        this.name = name;
        this.age = age;
        this.sexual = sexual;
    }

    public void play() {
        System.out.println(name+" play");
    }
    public void play(int n) {
        System.out.println(name + " play " + n + " minutes");
    }
}

