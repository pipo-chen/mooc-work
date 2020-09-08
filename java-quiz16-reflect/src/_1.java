/**
 * 使用递归算法来完成：1+1/2+1/3+1/4+..+1/n，其中n的值，你自己指定
 */
public class _1 {

    public static void main(String[] args) {
       int n = 3;
       double result = f(n);
       System.out.println("截止1/"+n+"总和="+result);
    }

    public static double f( int n) {
        if (n == 1)
            return 1;
        return 1.0/n+ f(n-1);
    }
}
