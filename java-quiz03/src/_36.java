public class _36 {
    public static void main(String[] args) {
        Sub4 s = new Sub4();
        s.m1();
        s.m1(10);
        s.m1(1.3);
    }
}

class Super4 {
    public final void m1() {
        System.out.println("m1() in Super");
    }
    public void m1(int i) {
        System.out.println("m1(int) in Super");
    }
}

class Sub4 extends Super4 {
    public void m1(int i) {
        System.out.println("m1(int) in Sub");
    }

    public void m1(double d) {
        System.out.println("m1(double) in Sub");
    }
}
