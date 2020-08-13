package interface_demo;

public class KeyBoard implements USB {
    @Override
    public void open() {
        System.out.println("开启键盘");
    }

    @Override
    public void close() {
        System.out.println("关闭键盘");

    }
    public void type() {
        System.out.println("键盘敲击");
    }
}
