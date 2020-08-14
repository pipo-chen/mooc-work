public class _14 {
    public static void main(String[] args) {
        C c = new C();
        c.fly();
//        F f = new F();
    }
}

interface A {
    int value = 10;
    public default void fly() {
        System.out.println("hello");
    }

}

abstract class F {
    int value = 10;

    /**
     * 抽象类虽然不能被创建对象，但是有构造函数
     */
    public F() {
        System.out.println("创建了 F 抽象类");
    }
}

class S extends F {

}

class C implements A {

}


