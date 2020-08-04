public class _2 {
    /**
     * 编程题：今天是周二，1000天以后是周几？
     */
    public static void main(String args[]) {

        int daysLater = 1000;
        int result = daysLater % 7;

        switch (result) {
            case 0:
                //周二作为开始
                System.out.println("周二");
                break;
            case 1:
                System.out.println("周三");
                break;
            case 2:
                System.out.println("周四");
                break;
            case 3:
                System.out.println("周五");
                break;
            case 4:
                System.out.println("周六");
                break;
            case 5:
                System.out.println("周日");
                break;
            case 6:
                System.out.println("周一");
                break;
            default:
                break;
        }
    }
}
