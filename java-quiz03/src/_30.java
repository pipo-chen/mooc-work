/**
 * 动态绑定
 */
public class _30 {
    public static void foo(Sup_f s) {
        s.m();
    }
    public static void main(String[] args) {
        Sub_s sub = new Sub_s();
        Sup_f sup = new Sup_f();
        foo(sup);
        foo(sub);
    }

}
class Sup_f {
    public void m() {
        System.out.println("m() in super");
    }
}

class Sub_s extends Sup_f {
    public void m() {
        System.out.println("m() in sub");
    }
}
