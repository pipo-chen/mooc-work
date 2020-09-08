/**
 * 使用递归算法来完成斐波那契数列：斐波那契数列的是这样一个数列：
 * 1、1、2、3、5、8、13、21、34....，
 * 即第一项 f(1) = 1,第二项 f(2) = 1.....,
 * 第 n 项目为 f(n) = f(n-1) + f(n-2)。
 * 求第 n 项的值是多少。
 */
public class _2 {
    public static void main(String[] args) {
        int n = 5;
        int n_value = f(n);
        System.out.println("第"+n+"项："+n_value);
    }

    public static int f( int n) {
        if (n <= 2)
            return 1;
        return f(n-1) + f(n-2);
    }
}
