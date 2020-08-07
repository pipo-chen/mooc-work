import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ShoppingCart {
    private Map<String, GoodsInCart> shoppingCart = new HashMap<>();

    public void addGoods(GoodsInCart goodsInCart) {
        shoppingCart.put(goodsInCart.getGoods().getGoodsId(),goodsInCart);
    }
    /**
     * 添加商品到购物车
     * @param gm
     */
    public void addGoodsToCart(GoodsManage gm) {

    }

    /**
     * 修改购物车的商品数量
     */
    public void updateNumInCart() {

    }

    /**
     * 显示购物车中的所有商品
     */
    public void displayAllInCart() {

    }

    /**
     * 结算
     */
    public void settleAccounts() {

    }

}
