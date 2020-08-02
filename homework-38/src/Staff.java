public class Staff {
    private String staffNo;
    private String staffName;
    private Integer staffAge;
    private String staffSex;
    private Department department;
    private Position position;

    public Staff(String staffNo, String staffName, Integer staffAge, String staffSex, Department department, Position position) {
       this.setDepartment(department);
       this.setPosition(position);
       this.setStaffAge(staffAge);
       this.setStaffName(staffName);
       this.setStaffNo(staffNo);
       this.setStaffSex(staffSex);
    }

    public String getStaffNo() {
        return staffNo;
    }

    public void setStaffNo(String staffNo) {
        this.staffNo = staffNo;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public Integer getStaffAge() {
        return staffAge;
    }

    public void setStaffAge(Integer staffAge) {
        if (staffAge < 18 || staffAge > 65)
            this.staffAge = 18;
        else
            this.staffAge = staffAge;
    }

    public String getStaffSex() {
        return staffSex;
    }

    public void setStaffSex(String staffSex) {
        if (!staffSex.equals("男") || !staffSex.equals("女"))
            this.staffSex = "男";
        else
            this.staffSex = staffSex;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        department.setStaff(this);
        this.department = department;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        if (position == null)
            this.position = new Position();
        else
            this.position = position;
    }

    public void printStaffInfo() {
        System.out.println("========================================");
        System.out.print("姓名："+staffName+"\n"+"工号："+staffNo+"\n"+"性别："+staffSex+"\n"+
                "年龄："+staffAge+"\n"+"职务："+department.getDepartmentName()+position.getPositionName()+"\n");

    }
}
