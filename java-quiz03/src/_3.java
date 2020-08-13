public class _3 {
    public static void main(String[] args) {
        MyClass mc = new MyClass(10);
        MyClass mc2 = new MyClass(12);
        System.out.println(mc.value);
        System.out.println(mc2.value);
    }

}
class  MyClass {
    final int value;
    public MyClass() {
        value = 11;
    }
    public MyClass(int value) {
        this.value = value;
    }

}


