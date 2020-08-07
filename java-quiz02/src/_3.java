import java.util.Scanner;

public class _3 {
    /**
     * 在一个由5个元素组成的一维数组中 查找一个已经定义好的数字，如果数组中有此元素，提示“此数组中有***数字”，如果此数组中没有则提示“数字不在此数组中”
     */
    public static void main(String[] args) {
        int [] nums = {1,2,3,4,5};
        int guessNum = 1;
        for (int x : nums) {
            if (x == guessNum) {
                System.out.println("此数组中有"+guessNum+"数字");
                return;
            }
        }
        System.out.println("数字不在此数组中");
    }
}
