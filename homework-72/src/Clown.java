public class Clown extends Animal {
    public void dress() {
        System.out.println("着装：身穿五彩服装，头上戴着彩色的帽子，脸上画着夸张的彩妆");
    }

    @Override
    public void skill() {
        System.out.println("技能：脚踩高跷，进行杂技魔术表演");
    }

    @Override
    public void act() {
        System.out.println("表演者："+this.getName());
        System.out.println("艺龄："+this.getAge()+"年");
        dress();
        skill();
    }

    public Clown(String name, int age) {
        super(name, age);
    }

    @Override
    public void love() {
        System.out.println("爱好：");
    }
}
