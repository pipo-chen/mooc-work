/**
 * 在之前的Circye类中求面积的方法上加一个异常处理的代码，
 * 当半径为负数时，抛出一个自定义异常，写好这个异常类，
 * 并自己判断这个异常应该属于哪个父类，写好测试类。
 */
public class _1 {

    public static void main(String[] args) {
        Circle cir = new Circle(-12);
        try {
            cir.checkRadius();
            System.out.println(cir.area());

        } catch (IllegalRadiusException e) {
            e.printStackTrace();

        }
    }
}

class Circle {
    private double radius;

    public Circle(double radius) {

        this.radius = radius;
    }

    public boolean checkRadius() throws IllegalRadiusException{
        if (radius < 0) {
            throw new IllegalRadiusException("半径" + radius +"为负数非法！");
        }
        return true;

    }

    public double area(){

        return Math.PI * radius * radius;
    }

}

class IllegalRadiusException extends Exception {
    public IllegalRadiusException() {
    }

    public IllegalRadiusException(String message) {
        super(message);
    }

}
