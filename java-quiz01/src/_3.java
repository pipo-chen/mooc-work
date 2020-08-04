import java.util.Scanner;

public class _3 {
    /**
     * 实现对三个整数进行排序，输出时按照从小到大的顺序输出。
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入第 1 个数字：");
        int a = scanner.nextInt();
        System.out.println("请输入第 2 个数字：");
        int b = scanner.nextInt();
        System.out.println("请输入第 3 个数字：");
        int c = scanner.nextInt();

        if (a < b && a < c) {
            if (b < c)
                System.out.println(a+"<="+b+"<="+c);
            else
                System.out.println(a+"<="+c+"<="+b);
        } else if (b <c && b <a) {
            if (a <c)
                System.out.println(b+"<="+a+"<="+c);
            else
                System.out.println(b+"<="+c+"<="+a);
        } else {
            if (a < b)
                System.out.println(c+"<="+a+"<="+b);
            else
                System.out.println(c+"<="+b+"<="+a);
        }

    }
}
