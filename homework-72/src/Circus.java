import java.util.Scanner;

public class Circus {
    public void notice() {
        System.out.println("******************** 欢迎来到太阳马戏团 ************************");
        System.out.println("******************** 请选择表演者 *****************************");
        System.out.println("********************   1. 棕熊   *****************************");
        System.out.println("********************   2. 狮子   *****************************");
        System.out.println("********************   3. 猴子   *****************************");
        System.out.println("********************   4. 鹦鹉   *****************************");
        System.out.println("********************   5. 小丑   *****************************");

    }
    public static void main(String[] args) {
        Circus circus = new Circus();
        Bear bear = new Bear("Bill",1);
        Lion lion = new Lion("Lain",2,"灰色","公狮");
        Clown clown = new Clown("Kahle",5);
        Parrot parrot = new Parrot("Rose",1,"牡丹鹦鹉");
        Monkey monkey = new Monkey("Sun",3,"金丝猴");

        while (true) {
            circus.notice();
            Scanner operator = new Scanner(System.in);
            int op = operator.nextInt();

            switch (op) {
                case 1:
                    bear.act();
                    break;
                case 2:
                    lion.act();
                    break;
                case 3:
                    monkey.act();
                    break;
                case 4:
                    parrot.act();
                    break;
                case 5:
                    clown.act();
                    break;
                default:
                    System.out.println("操作数字错误，请重新输入!");
            }
            System.out.println("******************** 是否重新观看（1/0） ************************");

            int a = operator.nextInt();
            if (a == 0)
                break;
            while (a != 1 ) {
                System.out.println("操作数字错误，请重新输入!");
                a = operator.nextInt();
            }

        }

    }
}
