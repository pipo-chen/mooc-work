public class Department {
    private String departmentNo;
    private String departmentName;
    private Staff staff;
    private Staff[] staffs;
    private int staffCount;


    public Department(String departmentNo, String departmentName) {
        this.setDepartmentNo(departmentNo);
        this.setDepartmentName(departmentName);
    }

    public String getDepartmentNo() {
        return departmentNo;
    }

    public void setDepartmentNo(String departmentNo) {
        this.departmentNo = departmentNo;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Staff[] getStaffs() {
        return staffs;
    }

    public void setStaff(Staff staff) {
        if (staffs == null) {
            this.staffs = new Staff[20];
        }
        this.staffs[0] = staff;
        this.staff = staff;
        staffCount++;
    }

    public void setStaffCount(int staffCount) {
        this.staffCount = staffCount;
    }

    public int getStaffCount() {
        return staffCount;
    }

    public void print() {
        System.out.println(departmentName+"总共有"+this.getStaffCount()+"名员工");
    }
}
