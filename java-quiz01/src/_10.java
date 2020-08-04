public class _10 {
    /**
     * 输出所有的水仙花数
     * 所谓水仙花数是指一个3位数，其各个位上数字立方和等于其本身。
     * 例如： 153 = 1*1*1 + 3*3*3 + 5*5*5
     * 三位数中所有的水仙花数
     */
    public static void main(String[] args) {

        for (int i = 100; i<1000; i++) {
            int sum =(int)(Math.pow(i/100, 3) + Math.pow(i/10 % 10,3) + Math.pow(i % 10,3));
            if (sum == i)
                System.out.println(i);
        }
    }
}
