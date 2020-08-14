package homework;

class Employee {
    private String name;
    private int month;

    public Employee(String name, int month) {
        this.name = name;
        this.month = month;
    }

    public double getSalary(int month) {
        if (this.month == month)
            return 100;
        else
            return 0;
    }

    public String getName() {
        return name;
    }

}

//固定工资
class SalariedEmployee extends Employee {
    private double salary;

    public SalariedEmployee(String name, int month, double salary) {
        super(name, month);
        this.salary = salary;
    }

    @Override
    public double getSalary(int month) {
        return super.getSalary(month) + salary;
    }
}

//小时工
class HourlyEmployee extends Employee {
    private double hourlySalary;
    private int hours;

    public HourlyEmployee(String name, int month, double hourlySalary, int hours) {
        super(name, month);
        this.hourlySalary = hourlySalary;
        this.hours = hours;
    }

    @Override
    public double getSalary(int month) {
        double hoursSalary = hours > 160 ? (hours - 160) * 1.5 * hourlySalary + 160 * hourlySalary : hourlySalary * hours;
        return super.getSalary(month) + hoursSalary;
    }
}

//销售无底薪
class SalesEmployee extends Employee {
    private double sales;
    private double rate;

    public SalesEmployee(String name, int month, double sales, double rate) {
        super(name, month);
        this.sales = sales;
        this.rate = rate;
    }

    @Override
    public double getSalary(int month) {
        return super.getSalary(month) + rate * sales;
    }
}

class BasePlusSalesEmployee extends SalesEmployee {
    private double baseSalary;

    public BasePlusSalesEmployee(String name, int month, double sales, double rate, double baseSalary) {
        super(name, month, sales, rate);
        this.baseSalary = baseSalary;
    }

    @Override
    public double getSalary(int month) {
        return super.getSalary(month) + baseSalary;
    }
}

public class TestEmployee {
    public static void main(String[] args) {
        Employee [] employees = new Employee[8];

        //拿固定工资的员工
        employees[0] = new SalariedEmployee("zhangsan",5,8000);
        employees[1] = new SalariedEmployee("xiaosan",5,7000);

        //小时工，工作超出 160 小时 按 1.5 被工资发放
        employees[2] = new HourlyEmployee("lisi",4,50,162);
        employees[3] = new HourlyEmployee("xiaosi",4,50,100);

        //销售，工资由月销售额和提成决定
        employees[4] = new SalesEmployee("wangwu",3,20000,0.05);
        employees[5] = new SalesEmployee("xiaowu",3,100,0.05);


        //有固定底薪的销售，工资为底薪+销售提成
        employees[6] = new BasePlusSalesEmployee("zhaoliu",2,8000,0.02,3500);
        employees[7] = new BasePlusSalesEmployee("xiaoliu",6,10000,0.02,3000);

        int curMonth = 3;
        for (Employee e : employees) {
            System.out.println("姓名："+e.getName()+"\t"+curMonth+"月工资："+e.getSalary(curMonth));
        }

    }
}
