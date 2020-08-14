/**
 * static属性共享
 */
public class _39 {
    public static void main(String[] args) {
        Test t1 = new Test();
        Test t2 = new Test();
        Test t3 = new Test();
    }
}
class Test {
    static int count = 0;
    public Test() {
        count++;
        System.out.println(count);
    }
}
