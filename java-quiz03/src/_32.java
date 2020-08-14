public class _32 {
    public static void main(String[] args) {
        _Son s = new _Son();
        s.m1();
        s.m2();
    }
}

class _Father {
    public void m1() {
        System.out.println("m1() in super");
    }

    public void m2() {
        System.out.println("m2() in Super");
    }
}
class _Son extends _Father {
    public void m1() {
        System.out.println("m1() in sub");
        super.m1();
    }
}
