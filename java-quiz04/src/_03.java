/**
 * 我需要把这个数组所有元素都输出到控制台上，不够长的地方用X代替
 */
public class _03 {
    public static void main(String[] args) {
        int [][] arr = {{2,1,4}, {8,1,2,4,5},{1,2}};
        int max = -1;

        for (int []col : arr) {
            max = Math.max(col.length, max);
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < max; j++) {
                if (j < arr[i].length) {
                    System.out.print(arr[i][j]+"\t");
                    continue;
                }
                System.out.print("X\t");
            }
            System.out.println();
        }
    }
}
