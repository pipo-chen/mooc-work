/**
 * 输出结果
 */
public class _28 {
    public static void main(String[] args) {
        Sandwich s = new Sandwich();
    }
}
class Meal {
    public Meal() {
        System.out.println("Meal()");
    }
}

class Lunch extends Meal {
    public Lunch() {
        System.out.println("Lunch()");
    }
}

class Vegatable {
    public Vegatable() {
        System.out.println("Vegatable()");
    }
}

class Potato extends Vegatable {
    public Potato() {
        System.out.println("Potato()");
    }
}

class Tomato extends Vegatable {
    public Tomato() {
        System.out.println("Tomato()");
    }
}

class Meat {
    public Meat() {
        System.out.println("Meat()");
    }
}

class Sandwich extends Lunch {
    Potato p = new Potato();
    Meat m = new Meat();
    Tomato t = new Tomato();

    public Sandwich() {
        System.out.println("Sandwich()");
    }
}
