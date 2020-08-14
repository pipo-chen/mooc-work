package homework;

interface IIIA {
    void m1();
    static int a = 100;
}
class MMMA implements IIIA {
    @Override
    public void m1() {

    }
}
public class _53 {
    public static void main(String [] args) {
        IIIA ia = new MMMA();
        ia.m1();
        System.out.println(IIIA.a);
    }
}
