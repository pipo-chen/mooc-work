/**
 * 方法的重写与重载
 */
public class _31 {
    public static void main(String[] args) {
        _S s = new _S();
        s.method(10);
        s.method();
        s.method("123");
    }

}
class _F {
    public void method() {
        System.out.println("method() in super");
    }
    public void method(int i) {
        System.out.println("method(int) in super");
    }
}

class _S extends _F {
    public void method() {
        System.out.println("method() in Sub");
    }
    public void method(String s) {
        System.out.println("method(String) in sub");
    }
}
