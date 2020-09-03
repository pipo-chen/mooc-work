import java.util.Iterator;
import java.util.LinkedList;

public class Snake {
    static LinkedList<Node> snake;
    int dir;

    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int DOWN = 2;
    public static final int UP = 3;

    public Snake() {
        this.snake = new LinkedList<Node>();
        this.snake.add(new Node(2,2));
        this.dir = DOWN;
    }

    public Snake(LinkedList<Node> snake, int dir) {
        this.snake = snake;
        this.dir = dir;
    }

    public Snake(LinkedList<Node> snake) {
        this.snake = snake;
        this.dir = DOWN;
    }

    public void step(int dir) {
        Node head = snake.getFirst();
        int new_X = 0, new_Y = 0;
        //头部方向 看下一个节点在哪，然后判断是否可以上下或者左右移动
        switch (dir) {
            case LEFT:
                new_X = head.getX() - 1;
                new_Y = head.getY();
                break;
            case RIGHT:
                new_X = head.getX() + 1;
                new_Y = head.getY();
                break;
            case UP:
                new_Y = head.getY() - 1;
                new_X = head.getX();
                break;
            case DOWN:
                new_Y = head.getY() + 1;
                new_X = head.getX();
                break;
        }
        if (new_X == 0 || new_X == SnakeField.WIDTH - 1)
        {
            System.out.println("wall");
            return;
        }
        if (new_Y == 0 || new_Y == SnakeField.HEIGHT - 1)
        {
            System.out.println("wall");
            return;
        }
        Node newHead = new Node(new_X, new_Y);
        snake.addFirst(newHead);
        //判断下一步 是否有食物
        if (!Food.contains(newHead) ){
            snake.removeLast();
        } else {
            Food.be_eaten(newHead);
        }
    }

    public void step_class(int dir) {
        if (dir + this.dir == 0) {
            throw new IllegalArgumentException("方向反了");
        }
        Node head = snake.getFirst();
        int x = dir/10 + head.getX();
        int y = dir%10 + head.getY();
        Node newHead = new Node(x,y);

        snake.addFirst(newHead);
        if (!Food.contains(newHead) ){
            snake.removeLast();
        } else {
            Food.be_eaten(newHead);
        }
        this.dir = dir;
    }
    public static boolean contains(int x, int y) {
        //遍历贪吃蛇
        Iterator iterator = snake.iterator();
        while (iterator.hasNext()) {
            Node next = (Node) iterator.next();
            if (next.getX() == x && next.getY() == y)
                return true;
        }
        return false;
    }

}
