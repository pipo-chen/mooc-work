import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * 劳动合同的续签问题：
 * 通过Scanner往程序里输入一个日期和年份，
 * 假设这个日期和年份就是签劳动合同的日期以及签订的年份，
 * 然后算出你续签的日期，所谓续签的日期是指合同到期那天的前一个月的那天，
 * 如果那天是周末，那么顺延到周一，算出周一那天的日期。
 */
public class _02 {
    public static void main(String[] args) {
        //1. 输入日期
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入合同签订日期（2020-08-22）：");
        String date = sc.next();
        String[] dates = date.split("-");
        int year = Integer.parseInt(dates[0]);
        int month = Integer.parseInt(dates[1]);
        int day = Integer.parseInt(dates[2]);

        //按照横杠来接收
        System.out.println("请输入签订的年份（年）：");
        int yearNum = sc.nextInt();

        //按照到期年来构造 Calendar 对象
        Calendar cal = new GregorianCalendar(year,month,day);
        //根据签订的日历对象加上年
        cal.add(cal.YEAR, yearNum);
        //减去签订日历对象的月
        cal.add(cal.MONTH, -2);
        //周六或周日 顺延到周一
        int dayOfweek = cal.get(Calendar.DAY_OF_WEEK);
        if (dayOfweek == Calendar.SATURDAY ) {
            cal.add(Calendar.WEEK_OF_YEAR, 1);
            cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        } else if (dayOfweek == Calendar.SUNDAY ) {
            cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        }

        System.out.println("续签日："+cal.getTime());

    }
}
