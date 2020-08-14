public class _7 {
    public static void main(String[] args) {
        Class1 ca = new Class1();
        ca.value = 10;
        ca.method();
        ca.method(20);
    }
}

class Class1 {
    public void method(int value) {
        System.out.println(value);
    }
    public void method() {
        System.out.println(value);
    }
    int value;
}
