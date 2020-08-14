public class _24 {
    public static void main(String[] args) {
        MyClass2 mc1 = new MyClass2();
        MyClass2 mc2 = new MyClass2(10);
        System.out.println(mc1.value);
        System.out.println(mc2.value);
    }
}

class MyClass2 {
    int value;

    /**
     * 需要创建构造函数，且无参构造函数也要
     * @param value
     */
    public MyClass2(int value) {
        this.value = value;
    }

    public MyClass2() {

    }
}
