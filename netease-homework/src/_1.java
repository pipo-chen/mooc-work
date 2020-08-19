import com.sun.org.apache.xerces.internal.util.XMLSymbols;

import java.util.Scanner;

public class _1 {
    /**
     * 二维数组 - 酒店管理系统
     */
    public static void notice() {
        System.out.println("=========== 欢迎来到华天大酒店 ==========");
        System.out.println("============== 请输入命令 ==============");
        System.out.println("查询>search 入住>in 退房>out 退出>exit");
    }

    /**
     * 退房 & 入住操作管理
     * @param rooms 酒店
     * @param inType 操作类型：1. 为入住 2. 退房
     */
    public static void operateInAndOut(String [][] rooms, boolean inType) {

        Scanner scanner = new Scanner(System.in);
        boolean room = false;
        boolean empty = false;

        do {
            System.out.println("请输入房间号: ");
            String roomNum = scanner.nextLine();
            String name = "EMPTY";
            if (inType) {
                System.out.println("请输入您的姓名: ");
                name = scanner.nextLine();
            }
            boolean flag = false;
            int row_j = 0;
            int col_i = 0;
            for (int j = 0; j < rooms.length; j++) {
                String [] row = rooms[j];
                for (int i = 0; i < row.length; i += 2) {
                    //比较房间号 比较完之后 比较是否可以入住
                    if (row[i].equals(roomNum)) {
                        room = true;
                        row_j = j;
                        if (inType) {
                            if (row[i + 1].equals("EMPTY")) {
                                empty = true;
                                col_i = i + 1;
                            }
                        } else {
                            empty = !row[i + 1].equals("EMPTY") ? false : true;
                            col_i = i +1;
                        }
                        flag = true;
                        break;
                    }

                }
                if (flag)
                    break;
            }
            if (!room) {
                System.out.println("错误的房间号");
                continue;
            }
            if (inType) {
                if (!empty) {
                    System.out.println("这个房间已经有人住了，请另外选择");
                    continue;
                }
            }
            else  {
                if (empty) {
                    System.out.println("这个房间本来就没人住，你是不是搞错了？");
                    continue;
                }
                if (!empty) {
                    rooms[row_j][col_i] = "EMPTY";
                    System.out.println("欢迎下次再来！");
                    break;
                }
            }

            rooms[row_j][col_i] = name;
            System.out.println("欢迎"+name+"入住华天");
            break;
        } while (inType ? (room && empty) : (room && !empty));
    }

    public static void main(String[] args) {
        String[][] rooms = {
                {"101","EMPTY","102","EMPTY","103","EMPTY","104","EMPTY","105","EMPTY","106","EMPTY"},
                {"201","EMPTY","202","EMPTY","203","EMPTY","204","EMPTY","205","EMPTY","206","EMPTY"},
                {"301","EMPTY","302","EMPTY","303","EMPTY","304","EMPTY","305","EMPTY","306","EMPTY"}
        };
        notice();
        Scanner scanner = new Scanner(System.in);
        String op = scanner.nextLine();
        while (!op.equals("exit")) {
            switch (op) {
                case "search":
                    for (String[] s : rooms) {
                        for (String room : s) {
                            System.out.print(room + "\t");
                        }
                        System.out.println();
                    }
                    break;
                case "in":
                    operateInAndOut(rooms, true);
                    break;

                case "out":
                    operateInAndOut(rooms, false);
                    break;

                case "exit":
                    return;

                default:
                    System.out.println("指令非法！");
            }
            notice();
            op = scanner.nextLine();
        }
    }
}
