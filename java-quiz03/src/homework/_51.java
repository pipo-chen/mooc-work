package homework;

/**
 * 接口和继承
 * 向上转型
 */
interface IA {
    void ma();
}
interface IB {
    void mb();
}
class MA implements IA {
    @Override
    public void ma() {

    }
}
class MB extends MA implements IB {
    @Override
    public void mb() {

    }
}

public class _51 {
    public static void main(String [] args) {
        MA ms = new MB();
        System.out.println(ms instanceof  IA);
        System.out.println(ms instanceof IB);
        System.out.println(ms instanceof MA);
        System.out.println(ms instanceof MB);
    }

}
