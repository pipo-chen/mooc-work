import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 通过Scanner录入一串字符串，通过一段程序，
 * 可以计算出这串字符串中每个字符出现的次数，
 * 请完成这段程序，完成效果如下：
 *
 * aaabbbeebad--->{b=4,e=2,a=4,d=1}
 */
public class _1 {

    public static void main(String[] args) {
        String s = "aaabbbeebad";
        letterCount(s);
    }

    public static void letterCount(String s) {
        Map<Character, Integer> map = new HashMap();
        char[] arr = s.toCharArray();
        for (char c : arr) {
            if (map.containsKey(c))
                map.put(c, map.get(c) + 1);
            else
                map.put(c, 1);
        }
        printMap(map);
    }

    public static void printMap(Map map) {
        Set entry = map.entrySet();
        Iterator ite = entry.iterator();
        while (ite.hasNext()) {
            System.out.print(ite.next()+" ");
        }
        System.out.println();
    }
}
