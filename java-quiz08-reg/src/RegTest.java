/**
 * 题目：
 * 1、	写出能匹配abc.123这个字符串的正则；
 * 2、	写出能匹配{123}这个字符串的正则；
 * 3、	比如有很多email地址，那么你只想获取到这些email地址的域名，那么你该如何做？
 * 4、	写一个能匹配日期的正则表达式，比如2014-07-15，（忽略月份和日份的最大值）
 * 5、	请写出身份证匹配的正则，（身份证有15位和18位，并且18位最后一位有可能是大小写X字符）
 */
public class RegTest {
	public static void main(String[] args) {
//		_01();
//		_02();
//		System.out.println(_03("12312@qq.com"));
//		_04();
		_05();
	}

	public static void _01() {
		String s = "abc.123";
		String reg = "\\w{3}[.]\\d{3}";
		System.out.println(s.matches(reg));
	}

	public static void _02() {
		String s = "{123}";
		String reg = "\\{\\d{3}\\}";
		System.out.println(s.matches(reg));
	}

	public static String _03(String s) {
		String reg = "\\@";
		String [] res = s.split(reg);
		return res.length ==2 ? res[1] : "";
	}

	public static void _04() {
		String data = "014-03-15";

		//忽略月份和日份的最大值
		String reg = "\\d{1,}\\-\\d{1,2}-\\d{1,2}";
		//日期考虑月份最大
		String reg1 = "\\d{1,}[-](([1][0-2])|([0][1-9]))[-]\\d{1,2}";

		System.out.println(data.matches(reg1));
	}

	public static void _05() {
		String s = "q23456789012345";
		String s1 = "q2345678901234567";
		String s2 = "r23456789012345678";
		String s3 = "12345678901234567X";
		String s4 = "12345678901234567x";

		//15/18 如果是 18 后面可能有大小写 x
		String reg = "(\\d{15})|((\\d{17})[x|X|\\d])";
		System.out.println(s.matches(reg));
		System.out.println(s1.matches(reg));
		System.out.println(s2.matches(reg));
		System.out.println(s3.matches(reg));
		System.out.println(s4.matches(reg));
	}
}
