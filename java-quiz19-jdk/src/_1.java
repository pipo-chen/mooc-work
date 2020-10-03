import java.util.function.Consumer;

public class _1 {
	public static void main(String[] args) {
		String [] strArray = {"zhangsan,18","lisi,20","wangwu,19"};

        printInfo(strArray,
                s -> System.out.print("Name:"+s.split(",")[0]),
                s -> System.out.println(",Age:"+Integer.parseInt(s.split(",")[1])));
    }
    private static void printInfo(String [] strArray, Consumer<String> c1, Consumer<String> c2){
        for (String i:strArray){
            c1.andThen(c2).accept(i);
        }
    }
}

