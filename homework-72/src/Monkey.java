public class Monkey extends Animal {
    private String type;

    public String getType() {
        return type;
    }

    public Monkey(String name, int age, String type) {
        super(name, age);
        this.type = type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void love() {
        System.out.println("爱好：喜欢模仿人的动作表情");
    }

    @Override
    public void skill() {
        System.out.println("技能：骑独轮车过独木桥");
    }

    @Override
    public void act() {
        System.out.println("表演者："+this.getName());
        System.out.println("年龄：" + this.getAge()+"岁");
        System.out.println("品种："+this.getType());
        skill();
        love();

    }
}
