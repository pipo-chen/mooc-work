import java.util.Random;

public class _2 {
    /**
     * 定义一个长度为10的一维数组，里面的元素是1-100的随机数，求该数组中的最大值和最小值
     */
    public static void main(String[] args) {
        int [] nums = new int[10];
        int max = 0;
        int min = 102;
        System.out.print("随机数组为：[ ");
        for (int i = 0; i < nums.length; i ++) {
            Random rand = new Random();
            int rand_data = rand.nextInt(100) + 1;
            System.out.print(rand_data + " ");
            min = min < rand_data ? min : rand_data;
            max = max > rand_data ? max : rand_data;
        }
        System.out.println("]");
        System.out.println("最大值 : "+ max+" 最小值 : "+min);
    }
}
