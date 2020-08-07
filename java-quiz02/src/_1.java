public class _1 {
    /**
     * 定义一个10个元素组成的一维数组，求该数组中的最大值和最小值。
     */
    public static void main(String[] args) {
        int [] nums = {1,2,3,4,5,6,7,8,9,10};
        int min = nums[0];
        int max = nums[0];
        System.out.print("当前数组为：[ ");
        for (int x : nums) {
            max = x > max ? x : max;
            min = x < min ? x : min;
            System.out.print(x+" ");
        }
        System.out.println("]");
        System.out.println("最大值 : "+ max+" 最小值 : "+min);
    }
}
