import java.util.ArrayList;
import java.util.function.Predicate;

public class _3 {
	public static void main(String[] args) {
		String[] strArray = {"林青霞,30", "柳岩,34", "张曼玉,35", "貂蝉,31", "王祖 贤,33"};
        ArrayList<String> array =operate(strArray,s->s.split(",")[0].length()>2,
                s->Integer.parseInt(s.split(",")[1])>33);
        for (String str : array){
            System.out.println(str);
        }
    }

    private static ArrayList<String> operate(String[] strArray, Predicate<String> pre1, Predicate<String> pre2){

        ArrayList<String> array = new ArrayList<String>();
        for(String str : strArray){
            if (pre1.and(pre2).test(str)){
                array.add(str);
            }
        }
        return array;
    }

}
