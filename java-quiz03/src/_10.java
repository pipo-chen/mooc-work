/**
 * 静态方法不可以被覆盖
 */
public class _10 {
    public static void main(String[] args){
//        new _10().method();
//        Son s = new Son();
//        s.test1();
//        Son s1 = new Son();
//        s1.test1();
//        Father f = new Father();
//        f.test1();
        /**
         * 静态方法中也可以调用静态方法 也可以调用非静态方法
         */
        print();

    }
    /**
     * ❌非静态方法中不能调用静态方法？
     */
    public void method() {
        Son s= new Son();
        s.test1();
        print();
    }

    public static void print(){
        System.out.println("hahaha");
    }
}

class Father {
    public static void test1() {
        System.out.println("hello father");
    }
}
class Son extends Father {
    public static void test1() {
        System.out.println("hello son");
    }
}
