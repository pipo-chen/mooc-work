import java.util.Scanner;

/**
 * 定义一个一维数组存储4个学生名字；定义一个二维数组存储这4个学生的6门课
 * （C程序设计、物理、英语、高数、体育、政治）的成绩；
 * 并实现可以按名字查询出某个学生的所有成绩
 */
public class _02 {

    public static void main(String[] args) {
        String [][]score = {{"张三","10","20","30","40","30","40"},{"李四","11","12","13","14","30","40"},{"王五","22","33","44","55","30","40"},{"赵六","51","52","53","54","30","40"}};
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入学生姓名:");
            String name = scanner.next();
            for (int i = 0; i < score.length; i++) {
                if (score[i][0].equals(name)) {
                    System.out.println("C程序 \t 物理 \t 英语 \t 高数 \t 体育 \t 政治");
                    for (int j = 1; j < score[i].length; j++) {
                        System.out.print(score[i][j] + " \t\t");
                    }
                    System.out.println();
                    return;
                }
            }
            System.out.println("查无此人！");
        }

    }
}
