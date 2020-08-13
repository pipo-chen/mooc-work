package interface_demo;

public class TestUSB {
    public static void main(String[] args) {
        Laptop laptop = new Laptop();
        laptop.run();
        laptop.useUSB(new Mouse());
        laptop.useUSB(new KeyBoard());
        laptop.shutdown();
    }
}
