import java.util.Scanner;

public class _4 {
    /**
     * 从键盘接收整数参数。如果该数为1-7，打印对应的星期值，否则打印“非法参数”。
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入星期值：");
        int week = scan.nextInt();
        switch (week) {
            case 1:
                System.out.println("周一");
                break;
            case 2:
                System.out.println("周二");
                break;
            case 3:
                System.out.println("周三");
                break;
            case 4:
                System.out.println("周四");
                break;
            case 5:
                System.out.println("周五");
                break;
            case 6:
                System.out.println("周六");
                break;
            case 7:
                System.out.println("周日");
                break;
            default:
                System.out.println("非法参数");
                break;
        }

    }
}
