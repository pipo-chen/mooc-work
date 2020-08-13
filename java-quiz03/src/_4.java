public class _4 {
    public static void main(String[] args) {
        MySubClass msc = new MySubClass(10);
        System.out.println(msc.value);
    }
}

class MyClass1 {
    int value;
}

class MySubClass extends MyClass1 {
    public MySubClass(int value) {
        this.value = value;
    }
}
