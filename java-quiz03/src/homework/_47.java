package homework;

public class _47 {
     public static void main(String args[]) {
        Animal1 as[] = new Animal1[3];
        as[0] = new Dog1();
        as[1] = new Cat1();
        as[2] = new Wolf();
//调用 as 数组中所有动物的 eat 方法
//1
         for (Animal1 a: as)
             a.eat();

//调用 as 数组中所有宠物的 play 方法
         for (Animal1 a : as) {
             if (a instanceof Pet)
                 ((Pet) a).play();
         }
//2
    }
}

abstract class Animal1 {
    public abstract void eat();
}

interface Pet {
    void play();
}

class Dog1 extends Animal1 implements Pet {
    public void eat() {
        System.out.println("Dog eat Bones");
    }

    public void play() {
        System.out.println("Play with Dog");
    }
}

class Cat1 extends Animal1 implements Pet {
    public void eat() {
        System.out.println("Cat eat fish");
    }

    public void play() {
        System.out.println("Play with Cat");
    }
}

class Wolf extends Animal1 {
    public void eat() {
        System.out.println("Wolf eat meat");
    }
}
