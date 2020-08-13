package bind_study;

/**
 * 静态绑定和动态绑定
 * 1、静态绑定：
 *  a、子类和父类的属性名相同
 *  b、子类和父类拥有相同的静态方法
 *  特点：调用那个类的资源，看类型
 *
 *  2、动态绑定
 *  a、子类重写了父类的方法
 *  特点：调用那个方法，看对象
 */
public class StaticBindDemo {
    public static void main(String[] args) {
        //当你构建的是 t2 对象并且类型也是 t2
        T2 t2 = new T2();
        //1 使用父类来接收子类对象
        T1 t1 = new T2();

        //测试静态绑定
        System.out.println(t1.a);//静
        T2 t11 = (T2)t1;
        t1.test2();//静
        System.out.println(t11.a);
        t11.test2();//静态

        //2、使用父类接收子类对象
        //b、测试动态绑定
        t1.test1();
        t11.test1();

    }
}

class T1 {
    int a = 10;
    int b = 20;

    public void test1() {
        System.out.println("我是父类的test1");
    }
    public static void test2() {
        System.out.println("我是父类的静态 test2");
    }
}

class T2 extends T1 {
    int a = 110;
    int c = 30;

    public void test1() {
        System.out.println("我是子类的test1");
    }
    public static void test2() {
        System.out.println("我是子类的静态 test2");
    }
}
