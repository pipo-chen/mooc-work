public class _6 {
    public static void main(String[] args) {
        ClassC cc = new ClassC();
    }
}

class ClassA {
    public ClassA() {
        System.out.println("Calss A()");
    }
}

class ClassB {
    public ClassB() {
        System.out.println("Class B()");
    }
}

class ClassC {
    ClassA a = new ClassA();
    ClassB b;
    public ClassC() {
        System.out.println("Class C()");
        b = new ClassB();
    }
}
