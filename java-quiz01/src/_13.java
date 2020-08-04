import java.util.Scanner;

public class _13 {
    /**
     * 开发一款软件，根据公式（身高-108）*2=体重，可以有10斤左右的浮动。来观察测试者体重是否合适。
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入身高(cm)：");
            int height = scanner.nextInt();
            while (height <= 0 || height > 300) {
                System.out.println("请重新输入正确身高！");
                height = scanner.nextInt();
            }
            System.out.println("请输入体重(斤)：");
            int weight = scanner.nextInt();
            while (weight <= 0) {
                System.out.println("请重新输入正确体重！");
                weight = scanner.nextInt();

            }
            int dream_weight = (height - 108) * 2;
            if (Math.abs(dream_weight - weight) <= 10) {
                System.out.println("测试结果：体重合适！");
            } else {
                System.out.println("测试结果：体重不合适！");
            }

        }



    }
}
