import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class SnakeDemo {
    public static void main(String[] args) {

        LinkedList<Node> list = new LinkedList<>();
        list.addFirst(new Node(1,3));
        list.addFirst(new Node(1,2));

        Snake snake = new Snake(list, Snake.RIGHT);
        SnakeField snakeField = new SnakeField(snake);
        Food food = new Food();
        Scanner sc = new Scanner(System.in);

        //进行移动
        while (true) {
            Iterator iterator = Food.foods.iterator();
            while (iterator.hasNext()) {
                System.out.print(iterator.next()+ ",");
            }
            System.out.println();
            snakeField.print();
            String key = sc.next();
            int order;
            if (key.equalsIgnoreCase("s")) {
                order = 2;
            } else if (key.equalsIgnoreCase("w")) {
                order = 3;
            } else if (key.equalsIgnoreCase("a")) {
                order = 0;
            } else {
                order = 1;
            }
            snake.step(order);
        }
    }
}
