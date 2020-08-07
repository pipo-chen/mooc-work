public class GoodsInCart {
    private Goods goods;
    private int num;

    public GoodsInCart(Goods goods, int num) {
        this.goods = goods;
        this.num = num;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
