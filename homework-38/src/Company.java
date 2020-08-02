public class Company {
    public static void main(String[] args) {
        Department hr = new Department("D001","人事部");
        Department market = new Department("D002","市场部");

        Position l1 = new Position("P001","经理");
        Position l2 = new Position("P002","助理");
        Position l3 = new Position("P003","职员");

        Staff zhang = new Staff("S001","张铭",89,"",hr,l1);
        Staff li = new Staff("S002","李艾爱",21,"女",hr,l2);
        Staff sun = new Staff("S003","孙超",29,"男",hr,l3);
        Staff meimei = new Staff("S004","张美美",26,"女",market,l3);
        Staff landi = new Staff("S005","蓝迪",37,"男",market,l1);
        Staff mi = new Staff("S006","米莉", 24,"女",market,l3);
        Staff zhao = new Staff("S007","赵太阳",29,"男",hr,l3);

        zhang.printStaffInfo();
        li.printStaffInfo();
        sun.printStaffInfo();
        meimei.printStaffInfo();
        landi.printStaffInfo();
        mi.printStaffInfo();

        hr.print();
        market.print();

    }
}
