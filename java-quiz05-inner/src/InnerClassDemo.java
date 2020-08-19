import sun.rmi.server.Activation$ActivationSystemImpl_Stub;

/**
 * 编写代码
 */
interface Inter {
    public abstract void method();
}
class Test {
    //通过匿名内部类
    public static Inter function() {
        return new Inter() {
            @Override
            public void method() {
                System.out.println("实现 function 中匿名内部类的 method 方法");
            }
        };
    }
}
class InnerClassDemo {
    public static void main(String[] args) {
        Test.function().method();
    }
}
