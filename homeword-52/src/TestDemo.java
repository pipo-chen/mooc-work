import jdk.management.resource.internal.inst.SocketRMHooks;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;
import java.util.Scanner;

public class TestDemo {
    public static void notice() {
        System.out.println("*********************************");
        System.out.println("          **主菜单**              ");
        System.out.println("          1--商品管理              ");
        System.out.println("          2--购物车              ");
        System.out.println("          0--退出              ");
        System.out.println("*********************************");
        System.out.println("请输入对应数字进行操作:");
    }
    public static void goodsNotice() {
        System.out.println("*********************************************************");
        System.out.println("                         **商品管理**              ");
        System.out.println("                      1--商品信息导入             ");
        System.out.println("                      2--显示所有商品信息            ");
        System.out.println("                      9--返回上一级菜单              ");
        System.out.println("*********************************************************");
        System.out.println("请输入对应数字对商品进行管理:");
    }
    public static void cartNotice() {
        System.out.println("*********************************************************");
        System.out.println("                         **购物车管理**              ");
        System.out.println("                      1--添加商品到购物车             ");
        System.out.println("                      2--修改购物车中的商品数量            ");
        System.out.println("                      3--显示购物车中的所有商品信息              ");
        System.out.println("                      4--结算              ");
        System.out.println("                      9--返回上一级菜单              ");
        System.out.println("*********************************************************");
        System.out.println("请输入对应数字对购物车进行管理:");
    }

    public static void main(String[] args) {
        Goods g1 = new Goods("goods001","手机",2300,"android 手机");
        Goods g2 = new Goods("goods002","饮水机",299,"带净化功能的饮水机");
        Goods g3 = new Goods("goods003","笔记本电脑",4999,"15寸笔记本电脑");
        Goods g4 = new Goods("goods004","水杯",56,"不锈钢水杯");
        GoodsManage gm = new GoodsManage();
        ShoppingCart shoppingCart = new ShoppingCart();

        while (true) {
            notice();
            Scanner scanner = new Scanner(System.in);
            int op = scanner.nextInt();
            switch (op) {
                case 1:
                    goodsNotice();
                    int gop = scanner.nextInt();
                    while (gop != 9) {
                        switch (gop) {
                            case 1:
                                gm.importGoods(g1);
                                gm.importGoods(g2);
                                gm.importGoods(g3);
                                gm.importGoods(g4);
                                System.out.println("商品导入成功！");
                                break;
                            case 2:
                                gm.displayAllGoods();
                                break;
                            case 9:
                                System.out.println("退出成功！");
                                break;
                            default:
                                System.out.println("参数非法！");
                        }
                        goodsNotice();
                        gop = scanner.nextInt();
                    }
                    break;
                case 2:
                    cartNotice();
                    int cop = scanner.nextInt();
                    while (cop!=9) {
                        switch (cop) {
                            case 1:
                                gm.displayAllGoods();
                                System.out.println("请输入要添加的商品编号：");
                                String gid = scanner.nextLine();
                                System.out.println("请输入要添加的商品数量：");
                                int gnum = scanner.nextInt();
                                Iterator<Goods> iterator = gm.getGoodsSet().iterator();
                                Goods selectedGoods = g1;
                                boolean flag = false;
                                while (iterator.hasNext()) {
                                    if (gid == iterator.next().getGoodsId()) {
                                        selectedGoods = iterator.next();
                                        flag = true;
                                    }
                                }
                                if (! flag) {
                                    System.out.println("商品编号错误，请重新输入！");
                                    break;
                                }

                                GoodsInCart goodsInCart = new GoodsInCart(selectedGoods,gnum);
                                shoppingCart.addGoods(goodsInCart);
                                System.out.println("加购成功！");
                                break;
                            case 2:


                            case 9:
                                System.out.println("退出成功！");
                                break;
                            default:
                                System.out.println("参数非法！");

                        }
                        cartNotice();
                        cop = scanner.nextInt();
                    }

            }
        }

    }
}
