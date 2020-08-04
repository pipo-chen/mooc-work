public class _8 {
    /**
     * 打印自然数的个数
     * 1）打印1~100之间 6的倍数的个数
     * 2）求出1～100之间，既是3又是7的倍数的自然数出现的次数？
     */
    public static void main(String[] args) {
        int count_6 = 0;
        int count_37 = 0;
        for (int i = 1; i < 101; i++) {
            if (i % 6 == 0) {
                count_6++;
            }
            if (i % 3 == 0 && i % 7 ==0) {
                count_37++;
            }
        }
        System.out.println("1~100之间 6的倍数的个数:"+count_6);
        System.out.println("1～100之间，既是3又是7的倍数的自然数出现的次数:"+count_37);
    }
}
