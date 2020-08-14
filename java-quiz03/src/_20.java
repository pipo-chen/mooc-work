public class _20 {
    public static void main(String[] args) {
        Sub1 sub1 = new Sub1();
        sub1.method();
    }
}

class Super1 {
    int method() {
        return 0;
    }
}

class Sub1 extends Super1 {
//    public int method(){
//        return 0;
//    }

//    ❌
//    String method() {
//        System.out.println("haha");
//        return "";
//    }

//    void method(int n) {
//
//    }
}
