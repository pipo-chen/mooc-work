/**
 * 静态绑定和动态绑定
 */
public class _37 {
    public static void main(String[] args) {
        Super33 sup = new Sub33();
        sup.m1();
        sup.m2();
        Sub33 sub = (Sub33) sup;
        sub.m1();
        sub.m2();
    }
}

class Super33 {
    public static void m1() {
        System.out.println("m1 in Super");
    }

    public void m2() {
        System.out.println("m2 in Super");
    }
}

class Sub33 extends Super33 {
    public static void m1() {
        System.out.println("m1 in Sub");
    }

    public void m2() {
        System.out.println("m2 in Sub");
    }
}