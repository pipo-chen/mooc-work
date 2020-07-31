import java.util.Scanner;

public class DataManage {
    private static final int LEN = 10;
    private static final int BEGIN_LEN = 9;
    /**
     * 插入数据
     * @return
     */
    public int[] insertData() {
        int[] nums = new int[LEN];
        for ( int i = 0; i < BEGIN_LEN; i++) {
            System.out.println("请输入第"+(i+1)+"个数据");
            Scanner in = new Scanner(System.in);
            int value = in.nextInt();
            while ( value == 0) {
                System.out.println("不能输入为 0 的数据，请重新输入!");
                value = in.nextInt();
            }
            nums[i] = value;
        }
        return nums;
    }

    /**
     * 显示所有数据
     * @param a 数组
     * @param length 长度
     */
    public void showData(int[] a, int length) {
        System.out.println("数组元素为：");
        for (int i = 0; i < length; i++)
            System.out.print(a[i] + "  ");
        System.out.println();

    }

    /**
     * 指定位置处插入数据
     * @param a 数组
     * @param n 插入内容
     * @param k 插入位置
     */
    public void insertAtArray(int[] a, int n, int k) {
        if (a[LEN - 1] != 0) {
            System.out.println("数组已满，无法插入");
            return;
        }
        if (a[k] == 0) {
            a[k] = n;
        } else {
            //当前位置有值，则所有从k开始的值都往后移动一位
            for (int i = LEN - 1; i >= k; i--) {
                a[i] = a[i-1];
            }
            a[k] = n;
        }
    }

    /**
     * 查询能被 3 整除的数据
     * @param a 数组
     */
    public void divThree(int[] a) {
        String str = "";

        for (int i : a) {
            if (i % 3 == 0 && i != 0)
                str += i + "  ";
        }
        if (str.length() > 0)
            System.out.println("数组中能被3整除的元素为：" + str);
        else
            System.out.println("数组中没有数据能被3整除");

    }

    /**
     * 显示提示信息
     */
    public void notice() {
        System.out.println("**********************************");
        System.out.println("         1--插入数据");
        System.out.println("         2--显示所有数据");
        System.out.println("         3--在指定位置处插入数据");
        System.out.println("         4--查询能被 3 整除的数据");
        System.out.println("         0--退出");
        System.out.println("**********************************");
        System.out.println("请输入对应的数字进行操作：");
    }

    public static void main(String[] args) {
        DataManage dm = new DataManage();
        int nums[] = new int[LEN];
        boolean flag = true;
        while(flag) {
            dm.notice();
            Scanner in = new Scanner(System.in);
            switch (in.nextInt()) {
                case 1:
                    nums = dm.insertData();
                    dm.showData(nums, BEGIN_LEN);
                    break;
                case 3:
                    System.out.println("请输入要插入的数据：");
                     int value = in.nextInt();
                     while ( value == 0) {
                        System.out.println("不能输入为 0 的数据，请重新输入");
                        value = in.nextInt();
                    }
                    System.out.println("请输入要插入数据的位置：");
                    int pos = in.nextInt();
                    dm.insertAtArray(nums, value, pos);
                    dm.showData(nums,LEN);
                    break;
                case 2:
                    dm.showData(nums,LEN);
                    break;
                case 4:
                    dm.divThree(nums);
                    break;
                case 0:
                    flag = false;
                    System.out.println("退出程序！");
                    break;
                default:
                    System.out.println("操作数字非法！请重试");

            }
        }

    }
}
