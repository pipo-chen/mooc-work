/**
 * 静态代码块加载顺序
 */
public class _38 {
    public static void main(String[] args) {
        My mc1 = new My();
        System.out.println(mc1.i);
        My mc2 = new My(10);
        System.out.println(mc2.i);
    }
}
class My {
    static int i = 10;
    static {
        i = 20;
        System.out.println("In Static");
    }
    public My() {
        System.out.println("MyClass()");
    }
    public My(int i) {
        System.out.println("MyClass(int)");
        this.i = i;
    }
}

