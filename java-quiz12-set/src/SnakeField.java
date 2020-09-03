public class SnakeField {

    //游戏棋盘的宽度和高度
    public static final int WIDTH = 20;
    public static final int HEIGHT = 10;

    Snake snake;
    //棋盘上还要有食物对象

    public void print() {
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if (i == 0 || i == HEIGHT - 1 || j == WIDTH - 1 || j== 0) {
                    System.out.print("*");
                } else if (snake.contains(j,i)) {
                    System.out.print("o");
                } else if (Food.contains(new Node(j, i)) ) {
                    System.out.print("z");
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }

    public SnakeField(Snake snake) {
        super();
        this.snake = snake;
    }

}
