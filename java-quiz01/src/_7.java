import java.util.Scanner;

public class _7 {
    /**
     * 根据指定月份，打印该月份所属的季节。
     * 3,4,5 春季 6,7,8 夏季  9,10,11 秋季 12, 1, 2 冬季
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入月份：");
        int month = scanner.nextInt();
        if (month > 12 || month < 1) {
            System.out.println("月份非法！");
            return;
        }
        int season = month / 3;
        switch (season) {
            case 1:
                System.out.println("春季");
                break;
            case 2:
                System.out.println("夏季");
                break;
            case 3:
                System.out.println("秋季");
                break;
            default:
                System.out.println("冬季");
                break;
        }
    }

}
