import java.util.Scanner;

public class _5 {
    /**
     * 从键盘分别输入年、月、日，判断这一天是当年的第几天
     */
    public static int monthFinalDay(int month, int year) {
        int finalDay = month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12 ? 31 : (month != 2 ? 30 : leapYear(year) ? 29 : 28);
        return finalDay;
    }

    public static boolean leapYear(int year) {
         return year % 400 == 0 || ( year % 4 == 0 && year % 100 != 0);
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("请输入年-月-日：");
        int year = scan.nextInt();
        int month = scan.nextInt();
        int day = scan.nextInt();

        //明显能判断非法
        if (month > 12 || day > 31 || year < 0 || day < 0 || month < 0 || day > _5.monthFinalDay(month, year)) {
            System.out.println("日期非法！");
            return;
        }

        //根据年份判断是否是闰年
        int sum = 0;
        for (int i = 1; i < month; i++)
            sum += _5.monthFinalDay(i,year);
        sum += day;

        System.out.println(year+"年"+month+"月"+day+"属于当年的第"+sum+"天");
    }

}
