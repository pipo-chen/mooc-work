package singleton;

/**
 * 单例设计模式
 * 1、饿汉式单例设计模式
 *  因为该类对象在类被加载的时候就会创建出对象来，而且不管你用不用都会存在该对象
 * 2、懒汉式单例设计模式
 * 判断是否为 null
 *
 * 多线程的时候会有问题
 */
public class SingletonTest {
    public static void main(String[] args) {
        SingletonDemo1 s1 = SingletonDemo1.getInstance();
        SingletonDemo1 so = SingletonDemo1.getInstance();
        System.out.println(s1 == so);

        SingletonDemo2 s2 = SingletonDemo2.getInstance();
        SingletonDemo2 s3 = SingletonDemo2.getInstance();
        System.out.println(s2 == s3);
    }

}

//懒汉式
class SingletonDemo2 {
    private static SingletonDemo2 s1 = null;

    private SingletonDemo2() {

    }

    public static SingletonDemo2 getInstance() {
        if (s1 == null)
            s1 = new SingletonDemo2();
        return s1;
    }

}

//饿汉式
class SingletonDemo1 {

    //2. 内部构建一个类的对象，并且让它可以被共享
    private static SingletonDemo1 s1 = new SingletonDemo1();

    //1. 不能随便用，私有化构造函数
    private SingletonDemo1() {

    }

    //3. 提供一个对外访问的出口
    public static SingletonDemo1 getInstance() {
        return s1;
    }

}
