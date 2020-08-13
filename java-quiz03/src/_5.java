public class _5 {
    public static void main(String args[]) {
        int value = 10;
        changInt(value);
        System.out.println(value);
        ClassA1 ca = new ClassA1();
        ca.value = 10;
        changeObect(ca);
        System.out.println(ca.value);
    }

    public static void changInt(int value) {
        value++;
    }

    public static void changeObect(ClassA1 ca) {
        ca.value++;
    }

}

class ClassA1 {
    int value;
}

