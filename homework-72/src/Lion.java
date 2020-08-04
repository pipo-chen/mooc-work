public class Lion extends Animal {
    private String color;
    private String sex;

    public Lion(String name, int age, String color, String sex) {
        super(name, age);
        this.color = color;
        this.sex = sex;
    }

    @Override
    public void love() {
        System.out.println("爱好：喜欢吃各种肉类");
    }

    @Override
    public void skill() {
        System.out.println("擅长钻火圈");
    }

    @Override
    public void act() {
        System.out.println("表演者："+this.getName());
        System.out.println("年龄："+this.getAge()+"岁");
        System.out.println("性别："+this.getSex());
        System.out.println("毛色："+this.getColor());
        skill();
        love();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
