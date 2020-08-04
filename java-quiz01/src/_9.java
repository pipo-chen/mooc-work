public class _9 {
    /**
     *  求调和级数中从第多少项开始值大于10
     *  调和级数的第n项形式为：1+1/2+1/3+…+1/n
     */
    public static void main(String[] args) {
        double sum = 0;
        int i = 1;
        while (10 - sum >= 0.0000001) {
            sum += 1.0/i;
            i++;
        }
        System.out.println(i);

    }
}
