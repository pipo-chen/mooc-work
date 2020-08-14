package homework;

class M {
    private static int count;

    public M() {
        count++;
    }

    public static int getCount() {
        return count;
    }
}
public class _54 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            M m = new M();
            System.out.println(m.getCount());
        }
    }
}
