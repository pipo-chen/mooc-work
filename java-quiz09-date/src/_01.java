import com.sun.javafx.tools.packager.PackagerException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 请使用日期时间相关的API，计算出一个人已经出生了多少天，提示：通过Scanner获取到你的生日。
 */
public class _01 {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入您的生日（年-月-日）：");
        String birth = scanner.next();
        //1. 当前时间
        Date date = new Date();
        long curTime = date.getTime();
        //2. 根据年月日获取生日时间
        Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(birth);
        long birthTime = date1.getTime();
        //3. 两时间相减
        System.out.println("已出生："+(curTime - birthTime) / (1000 * 60 * 60 *24) + "天");
    }
}
