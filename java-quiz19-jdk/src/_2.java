import java.util.function.Function;

public class _2 {
	public static void main(String[] args) {
		String s = "林青霞,30";
        operator(s, ss -> ss.split(",")[1], Integer::parseInt, i -> i + 70);
    }

    private static void operator(String s, Function<String, String> fun1, Function<String, Integer> fun2, Function<Integer, Integer> fun3) {
        int i = fun1.andThen(fun2).andThen(fun3).apply(s);
        System.out.println(i);
    }

}
