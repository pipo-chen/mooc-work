import java.util.Scanner;

public class _12 {
    /**
     * 生成13位条形码
     * Ean-13码规则：第十三位数字是前十二位数字经过计算得到的校验码。
     * 例如：690123456789
     * 计算其校验码的过程为：
     * ① 前十二位的奇数位和6+0+2+4+6+8=26
     * ② 前十二位的偶数位和9+1+3+5+7+9=34
     * ③ 将奇数和与偶数和的三倍相加26+34*3=128
     * ④ 取结果的个位数：128的个位数为8
     * ⑤ 用10减去这个个位数10-8=2
     * 所以校验码为2
     * （注：如果取结果的个位数为0，那么校验码不是为10（10-0=10），而是0）
     * 实现上述代码的功能，计算验证码，输入12位条码，返回带验证码的条码。
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入 12 位的条码：");
        long nums = scanner.nextLong();

        //判断非法
        if (nums < 100000000000L || nums > 999999999999L ) {
            System.out.println("输入非法数字！");
            return;
        }
        long nums_copy = nums;

        int even = 0;
        int odd = 0;
        for (int i = 12; i > 0; i--) {
            int cur = (int)(nums % 10);
            if (i % 2 == 0)
                even += cur;
            else
                odd += cur;
            nums = nums / 10;
        }
        int final_num = (10 - (odd + even * 3) % 10) % 10;
        long result = nums_copy * 10 + final_num;
        System.out.println("输出："+result);

    }
}
