package homework;

import java.util.Scanner;

public class _46 {
    public static void main(String[] args) {
        //输入一个偶数
        int nums = 0;
        while (nums != -1) {
            System.out.println("请输入一个大于 6 的偶数(-1退出程序)：");
            Scanner sc = new Scanner(System.in);
            nums = sc.nextInt();
            while (nums % 2 != 0 || nums <= 6) {
                if (nums == -1)
                    break;
                System.out.println("参数非法，请重新输入：");
                nums = sc.nextInt();
            }

            //避免出现 3+7 = 10 和 7+3 = 10 的情况
            int another = nums;
            for (int i = 2; i < another; i++) {
                another = nums - i;
                if (primeNumber(i) && primeNumber(another)) {
                    System.out.println(i+"+"+another+"="+nums);
                }
            }

        }

    }
    //验证是否为素数
    public static boolean primeNumber(int a) {
        int data[] = {2,3,5,7};
        for (int d : data) {
            if (a == d)
                return true;
        }
        for (int d : data) {
            if (a % d == 0)
                return false;
        }
        return true;
    }
}
