public class _21 {
    public static void main(String[] args) {
        Dog dog = new Dog();
    }
    public static Animal getAnimal() {
//     return null;
//        return new Animal();
//        return new Dog();
        return new Cat();
    }

}

class Animal {}
class Dog extends Animal {

    /**
     * 构造函数不允许有返回值
     * @return
     */
    public int Dog() {
        System.out.println("dog");
        return 1;
    }
}
class Cat extends Animal {}
