package static_study;

/**
 * Static 如何修饰四种资源
 * 1、成员属性
 * 2、成员方法
 * 3、代码块
 * 4、内部类
 */
public class StaticDemo {
    public static void main(String[] args) {
        Static s1 = new Static();
        s1.a = 20;
        s1.b = 100;
        System.out.println("s1.a:" + s1.a + " s1.b:" + s1.b);
        s1.test1();
        s1.test2();
        System.out.println(Static.b);
        Static.test2(); //类似 Math.abs() Math.random()
        //再次构建一个对象 判断 static 修饰的属性 b 是否是被共享状态
        Static s2 = new Static();
        System.out.println("s2.a:" + s2.a + " s2.b:" + s2.b);
        //所以官方不推荐用对象来.静态资源

    }
    //定义一个内部类
    class MyInnerClass {

    }
    static class MyStaticInnerClass {

    }
}

class Static {
    int a=33;
    static int b; //默认静态资源编程斜体

    {
        //说明是在构造函数之前，在属性初始化之后运行。
        System.out.println("\n-----------我是代码块-----------"+a);
    }

    static {
        //static 修饰的资源属于类资源，那么类的两个特性它都有：
        /**
         * 1. 类被加载的时候它也会被加载
         * 2. 类有且只有加载一次，它也只能加载一次
         */
        System.out.println("\n*************我是静态代码块*************");
    }

    public void test1() {
        System.out.println("我是普通的成员方法");
    }
    public static void test2() {
        System.out.println("我是静态方法");
        //⚠️，静态方法不能叫成员方法 所谓成员，就说明是类的某一部分成分，但是 static 静态不是属于这个类，不能使用 this
    }

}
//❌ static 不能这样定义
//static class MyClass {
//
//}
