import org.omg.CORBA.MARSHAL;

import java.util.Scanner;

public class _14 {
    /**
     * 有3个整数，给出提示信息：
     * 能否创建三角形；两边之和大于第三边  三个条件都要写
     * 如果能构建三角形，提示是直角三角形/等边三角形/等腰三角形/普通三角形；
     * 最后输出三角形面积；
     */
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入第 1 条边：");
        int a = scanner.nextInt();
        System.out.println("请输入第 2 条边：");
        int b = scanner.nextInt();
        System.out.println("请输入第 3 条边：");
        int c = scanner.nextInt();

        if (!(a + b > c && a + c > b && b + c > a)) {
            System.out.println("无法创建三角形");
            return;
        }

        if (Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2) || Math.pow(a, 2) + Math.pow(c, 2) == Math.pow(b, 2) || Math.pow(b, 2) + Math.pow(c, 2) == Math.pow(a, 2)) {
            System.out.print("直角三角形");
        } else if (a == b && a == c) {
            System.out.print("等边三角形");
        } else if (a == b || a == c) {
            System.out.print("等腰三角形");
        } else {
            System.out.print("普通三角形");
        }

        double s = 0.5 * (a + b + c);
        double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
        System.out.println(" 三角形面积为：" + String.format("%.2f",area));



    }
}
