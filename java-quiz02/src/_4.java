public class _4 {
    /**
     * 现在有如下的一个数组：
     * int oldArr[]={1,3,4,5,0,0,6,6,0,5,4,7,6,7,0,5} ;
     * 要求将以上数组中值为0的项去掉，将不为0的值存入一个新的数组，生成的新数组为：
     * int newArr[]={1,3,4,5,6,6,5,4,7,6,7,5} ;
     * 思路：生活中的问题解决 = 程序中的解决；
     * 1、确定出不为0的个数，这样可以开辟新数组；
     * 2、从旧的数组之中，取出内容，并将其赋给新开辟的数组；
     */

    public static void main(String[] args) {
        int oldArr[] = {1,3,4,5,0,0,6,6,0,5,4,7,6,7,0,5};
        int len = 0;

        //1. 统计需要创建新数组的大小
        for (int x : oldArr) {
            if (x != 0)
                len++;
        }

        //2. 开辟新数组 并进行非零数据导入
        int [] newArr = new int[len];
        int j = 0;
        System.out.print("新数组为：");
        for (int i = 0; i < len; i++, j++) {
            while (oldArr[j] == 0) {
                j++;
            }
            newArr[i] = oldArr[j];
            System.out.print(newArr[i] + " ");
        }

        System.out.println();
    }
}
