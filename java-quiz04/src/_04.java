import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * 有n个整数，使其前面各数顺序向后移m个位置，最后m个数变成最前面的m个数
 * 最后输出数组（n和m为Scanner输入）
 */
public class _04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入数组长度 n：");
        int n = scanner.nextInt();
        System.out.print("请输入数组后移 m：");
        int m = scanner.nextInt();
        while (n <= 0) {
            System.out.print("n 必须大于 0，请重新输入：");
            n = scanner.nextInt();
        }
        while (m <= 0) {
            System.out.print("m 必须大于 0，请重新输入：");
            m = scanner.nextInt();
        }
        //1. 创建数组
        int [] data = new int[n];

        //2. 初始化数组
        for (int i = 0; i < n; i++) {
            Random rand = new Random();
            data[i] = rand.nextInt(30)+1;
        }
        System.out.println(Arrays.toString(data) +"后移"+m+"位为：");

        //3. 进行后移
        int []move = new int[n];
        int start = n - (m % n);
        int end = n;
        int i = 0;
        while (i < n) {
            while (start < end) {
                move[i++] = data[start++];
            }
            end = n - (m % n) ;
            start = 0;
        }

        //4. 打印数组
        System.out.println(Arrays.toString(move));
    }
}
