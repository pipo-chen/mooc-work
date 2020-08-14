package homework;

public class TestStudent {

    public static void main(String[] args) {

        Student s = new Student("Zhangsan",10,"杭州市西湖区","310000","1329081239");
        System.out.println(s.getPostAddress());

    }
}

class Student {
    private String name;
    private int age;
    private String address;
    private String zipCode;
    private String mobile;

    public Student(String name, int age, String address, String zipCode, String mobile) {
        this.setName(name);
        this.setAge(age);
        this.setAddress(address);
        this.setMobile(mobile);
        this.setZipCode(zipCode);
    }

    public String getPostAddress() {
        return "地址： "+this.getAddress()+" 邮编: "+this.getZipCode();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMobile() {
        return mobile;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getZipCode() {
        return zipCode;
    }
}
