package homework;

public class TestShape {
    public static void main(String [] args) {
        Shape [] shapes = new Shape[3];
        shapes[0] = new Circle(5);
        shapes[1] = new Rect(3,4);
        shapes[2] = new Square(5);

        for (Shape s : shapes) {
            System.out.println("面积："+s.area() + " 周长： "+s.girth());
        }
    }

}

abstract class Shape {

    public abstract double area();

    public abstract double girth();
}

class Circle extends Shape {
    //半径
    public double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double girth() {
        return 2 * Math.PI * radius;
    }
}

class Rect extends Shape {
    //长
    public double length;
    //宽
    public double width;

    public Rect(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return length * width;
    }

    @Override
    public double girth() {
        return 2 * (length + width);
    }
}

class Square extends Rect {
    //边长
    public double board;

    public Square(double board) {
        super(board, board);
        this.board = board;
    }
}


