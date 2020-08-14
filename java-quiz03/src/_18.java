public class _18 {

}

class MC {
    int a;
    static int b;

    void fa() {

    }
    static void fb() {

    }
    public void m1() {
        System.out.println(a);
        System.out.println(b);
        fa();
        fb();
    }
    public static void m2() {
        /**
         * static方法中不能访问非 static属性/方法
         */
//         System.out.println(a);
        System.out.println(b);
//        fa();
        fb();
    }
}
