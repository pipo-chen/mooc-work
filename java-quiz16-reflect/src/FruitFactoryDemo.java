public class FruitFactoryDemo {
    /**
     * 简单工厂方法
     * @param args
     */
    public static void main(String[] args) {
        /**
         * M1. 通过挨个工厂中的方法创建
         */
        Fruit f1 = FruitFactory.apple();
        f1.product();
        Fruit f2 = FruitFactory.banana();
        f2.product();

        System.out.println("-----------------------------");

        /**
         * M2. 通过传参创建
         */
        Fruit f3 = FruitFactory.getFruit("apple");
        f3.product();
        Fruit f4 = FruitFactory.getFruit("banana");
        f4.product();

        System.out.println("-----------------------------");

        /**
         * M3. 通过反射获取
         */
        Fruit f5 = FruitFactory.getInstance("Apple");
        f5.product();

        Fruit f6 = FruitFactory.getInstance("Banana");
        f6.product();

    }

}

class FruitFactory {

    public static Apple apple() {
        return new Apple();
    }
    public static Banana banana() {
        return new Banana();
    }

    public static Fruit getFruit (String name) {
        if (name.equalsIgnoreCase("apple")) {
            return new Apple();
        }
        return new Banana();
    }

    public static Fruit getInstance(String class_name){

        try {
            Class<?> classObj = Class.forName(class_name);
            return (Fruit)classObj.newInstance();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

interface Fruit {
    public void product();
}

class Apple implements Fruit {
    @Override
    public void product() {
        System.out.println("product an Apple");
    }
}

class Banana implements Fruit {
    @Override
    public void product() {
        System.out.println("product an Banana");
    }
}
