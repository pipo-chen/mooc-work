package interface_demo;

public class Laptop {
    public void run() {
        System.out.println("笔记本运行");
    }

    public void shutdown() {
        System.out.println("笔记本关闭");
    }

    public void useUSB(USB usb) {
        if (usb!=null) {
            usb.open();
            if (usb instanceof Mouse) {
                Mouse m = (Mouse)usb;
                m.click();
            } else if (usb instanceof KeyBoard) {
                KeyBoard k = (KeyBoard)usb;
                k.type();
            }
            usb.close();
        }
    }
}
