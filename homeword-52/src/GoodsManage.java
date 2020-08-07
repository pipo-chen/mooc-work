
import java.util.HashSet;
import java.util.Set;

public class GoodsManage {
    private Set<Goods> goodsSet = new HashSet<>();

    public GoodsManage() {

    }

    public void importGoods(Goods goods) {
        goodsSet.add(goods);
    }

    public Set<Goods> getGoodsSet() {
        return goodsSet;
    }

    public void displayAllGoods() {
        for (Goods goods: goodsSet) {
            System.out.println(goods);
        }
    }


}
