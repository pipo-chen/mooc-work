import java.util.*;

public class Food {

    public static Set<Node> foods;
    public static final int TOTAL_FOOD = 3;

    public Food() {
        this.foods = new HashSet<>();
        generate();
    }

    /**
     * 判断该节点是否有食物存在，决定贪吃蛇是否要删除尾部节点前移
     * @param node
     * @return
     */
    public static boolean contains(Node node) {
        Iterator ite = foods.iterator();
        while (ite.hasNext()) {
            if (node.equals(ite.next())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 不能在有蛇的地方生成,且不能重复
     */
    public static void generate() {
        Random random = new Random();
        while (foods.size() < TOTAL_FOOD) {
            int r_x = random.nextInt(SnakeField.WIDTH -1) + 1;
            int r_y = random.nextInt(SnakeField.HEIGHT -1) + 1;
            if (!Snake.contains(r_x, r_y))
                foods.add(new Node(r_x, r_y));
        }
    }

    /**
     * 食物被吃掉
     * 1. 删除吃掉的食物节点
     * 2. 生成新的食物节点，且该节点不与蛇身重合
     * @param node
     */
    public static void be_eaten(Node node) {
        foods.remove(node);
        generate();
    }

}
