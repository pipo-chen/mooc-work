import com.sun.scenario.effect.impl.sw.java.JSWColorAdjustPeer;

import java.util.Scanner;

/**
 *01 酒店管理系统
 */
public class Hotel {
    /**
     * 操作提示
     */
    public static void notice() {
        System.out.println("=========== 欢迎来到华天大酒店 ==========");
        System.out.println("============== 请输入命令 ==============");
        System.out.println("查询>search 入住>in 退房>out 退出>exit");
    }

    /**
     * 查询房间及状态
     * @param rooms
     */
    public static void search(String[][] rooms) {
        for (int i = 0; i < rooms.length; i++) {

            //输出房间
            for (int j = 0; j < rooms[i].length; j++) {
               System.out.print(rooms[i][j]+"\t\t");
            }
            System.out.println();

            //输出状态
            i++;
            for (int j = 0; j < rooms[i].length; j++) {
               System.out.print(rooms[i][j]+"\t");
            }

            System.out.println();
        }
    }


    /**
     * 入住酒店
     * @param rooms
     * @param pos 房间号位置下标
     * @param name 客户姓名
     */
    public static void roomIn(String[][] rooms, int[] pos, String name) {
       int i = pos[0];
       int j = pos[1];
       rooms[i+1][j] = name;
       System.out.println("欢迎"+name+"入住华天");
    }

    /**
     * 退住酒店
     * @param rooms
     * @param pos 房间号位置下标
     * 备注：1. 判断该房间是是有人入住的房间 2.退住
     */
    public static void roomOut(String[][] rooms, int[] pos) {
        int i = pos[0];
        int j = pos[1];
        if (rooms[i+1][j].equals("EMPTY"))
            System.out.println("这个房间本来就没有人住，是不是搞错了？？🤔️");
        else {
            rooms[i+1][j] = "EMPTY";
            System.out.println("欢迎下次再来！");
        }
    }

    /**
     * 检验房间号
     * @param rooms
     * @param roomNum
     * @return
     */
    public static int[] hasRoomNum(String[][] rooms, int roomNum) {

        for (int i = 0; i < rooms.length; i+=2) {
            for (int j = 0; j < rooms[i].length; j++) {
                if (rooms[i][j].equals(String.valueOf(roomNum))) {
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {

        String[][] rooms = {
                {"101","102","103","104","105","106"},
                {"EMPTY","EMPTY","EMPTY","EMPTY","EMPTY","EMPTY"},
                {"201","202","203","204","205","206"},
                {"EMPTY","EMPTY","EMPTY","EMPTY","EMPTY","EMPTY"},
                {"301","302","303","304","305","306"},
                {"EMPTY","EMPTY","EMPTY","EMPTY","EMPTY","EMPTY"}
        };

        while (true) {
            notice();
            Scanner scanner = new Scanner(System.in);
            String operate = scanner.nextLine();

            switch (operate) {
                case "search":
                    search(rooms);
                    break;

                case "in":
                    System.out.println("请输入房间编号：");
                    int roomNum = scanner.nextInt();
                    System.out.println("请输入您的姓名：");
                    String name = scanner.next();
                    int []pos = hasRoomNum(rooms, roomNum);
                    if (pos == null) {
                        System.out.println("错误的房间号");
                        break;
                    }
                    roomIn(rooms, pos, name);
                    break;

                case "out":
                    System.out.println("请输入房间编号：");
                    roomNum = scanner.nextInt();
                    pos = hasRoomNum(rooms, roomNum);
                    if (pos == null) {
                         System.out.println("错误的房间号");
                        break;
                    }
                    roomOut(rooms, pos);
                    break;

                case "exit":
                    return;
                default:
                    System.out.println("参数非法，请重新操作！");

            }
        }

    }

}
