import java.util.Arrays;
import java.util.Comparator;

public class _1 {

    public static void main(String []args) {
        String []s = {"aaaaa","weeeeee","adccccc","mmhhhh"};
        System.out.println(Arrays.toString(s));
        Arrays.sort(s, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                return  o1.charAt(o1.length() - 1) -  o2.charAt(o2.length() - 1);
            }
        });

        System.out.println(Arrays.toString(s));
    }
}
