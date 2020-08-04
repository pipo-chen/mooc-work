public class _11 {
    /**
     * 山上有一口缸可以装50升水，现在有15升水。老和尚叫小和尚下山挑水，每次可以挑5升。问：小和尚要挑几次水才可以把水缸挑满？
     */
    public static void main(String[] args) {
        int water = 15;
        int l = 0;
        while (water < 50) {
            water += 5;
            l++;
        }
        System.out.println(l);
    }
}
