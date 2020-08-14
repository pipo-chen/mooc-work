package homework;

public class TestAnimal {
    public static void main(String[] args) {
        Animal[] as = new Animal[] { new Dog2("Pluto"), new Cat("Tom"), new Dog2("Snoopy"), new Cat("Garfield") };
        Dog2[] dogs = getAllDog(as);
        for (int i = 0; i < dogs.length; i++) {
            System.out.println(dogs[i].getName());
        }
    }

    public static Dog2[] getAllDog(Animal[] as) {

        int len = 0;
        for (Animal a : as) {
            if (a instanceof Dog2) {
                len++;
            }
        }
        if (len > 0) {
            Dog2[] dogs = new Dog2[len];
            int i = 0;
            for (Animal a : as) {
                if (a instanceof Dog2) {
                    dogs[i++] = (Dog2) a;
                }
            }
            return dogs;
        } else
            return null;
    }
}

class Animal {
    private String name;
    //1
    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Dog2 extends Animal {
    public Dog2(String name) {
        super(name);
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }
}

