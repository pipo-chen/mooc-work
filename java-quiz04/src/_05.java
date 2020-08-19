import java.util.Random;

/**
 * 双色球排序
 * 红球是01-33的33个球，兰球是01-16的16个球要取6个红球跟一个兰球
 */
public class _05 {
    public static void main(String [] args) {
        int [] red = new int[6];
        Random random = new Random();
        int [] blue = new int[]{random.nextInt(16) + 1};

        //1. 数组初始化并去重
        int count = 0;
        while (count < red.length) {
            int data = random.nextInt(33) + 1;
            boolean flag = false;
            for (int i = 0; i < count; i++) {
                if (red[i] == data) {
                    flag = true;
                    break;
                }
            }
            if (flag)
                continue;
            red[count++] = data;
        }

        //2. 数组排序结果打印
        quickSort(red, 0, red.length - 1);
        printArr(red);
        printArr(blue);
        System.out.println();
    }

    /**
     * 特定双色球数字打印方式
     * @param nums
     */
    public static void printArr(int [] nums) {
        int count = 0;
        for (int x : nums) {
            String s = x < 10 ? "0"+x : String.valueOf(x);
            if (count == 0) {
                System.out.print("[ ");
            }
            System.out.print(s+" ");
            if (count == nums.length - 1) {
                System.out.print("]");
            }
            count++;
        }
    }

    public static void quickSort(int[] nums, int left, int right) {
        if (left > right)
            return;
        int i = left;
        int j = right;
        int base = nums[left];
        while (i < j) {
            //顺序
            while (i < j && nums[j] >= base)
                j--;
            while (i < j && nums[i] <= base)
                i++;

            if (i < j) {
                swap(nums,i,j);
            }

        }
        //base 交换
        swap(nums, left, j);
        quickSort(nums, left, j-1);
        quickSort(nums, j + 1, right);
    }

    public static void swap(int [] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
