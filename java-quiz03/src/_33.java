public class _33 {
    public static void main(String[] args) {
        _Sub s1 = new _Sub();
        _Sub s2 = new _Sub(10);
        _Sub s3 = new _Sub("hello");
    }
}
class _Super {
    public _Super() {
        System.out.println("Super()");
    }
    public _Super(String str) {
        System.out.println("Super(String)");
    }
}

class _Sub extends _Super {
    public _Sub() {
        System.out.println("Sub()");
    }

    public _Sub(int i) {
        this();
        System.out.println("Sub(int)");
    }

    public _Sub(String str) {
        System.out.println("Sub(String)");
    }
}
