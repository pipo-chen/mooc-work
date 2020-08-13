package final_study;

/**
 * final 修饰的资源
 * 1、final 修饰变量
 *  a、局部变量（方法参数）
 *  b、成员变量
 *  c、静态变量
 * 2、final 修饰方法
 * 3、final修饰类
 *
 */
public class FinalTest {
    public static void main(String[] args) {
        final int num = 100;
        //        ❌final 修饰的局部变量不能进行二次赋值
        //        num = 200;
        //        final 修饰的局部变量可以拆开声明和赋值拆开书写。
        final int num1;
        num1 = 100;

        //在 main 方法中调用一个参数是 final 修饰的方法
        FinalTest tf = new FinalTest();
        int num2 = 200;

        //传递一个非 final 的值 到 final 修饰的变量中
        tf.test(num2);
        //传递一个final修饰的值 到 非final 修饰的参数中 方法的传递方式是值传递，所以不在乎传递过来的是不是final
        tf.test1(num1);

        //当final修饰的局部变量是一个引用数据类型的时候
        final  int [] arr = {1,2,3};
        arr[0] = 10;
        //        ❌ final 修饰的是 arr 跟里面的元素无关
        //        arr = new int [10];
        //        当 final 修饰自定义数据类型的时候
        final Student s = new Student();
        //修改 x 对象里面的属性值
        s.name = " zhang san";

        //        ❌不能修改final修饰的属性
        //        s.sex = "女";
        //        s.sex = "男";


    }
    public void test(final int num) {
        //        ❌ 参数是 final 的话 无法进行修改
        //        num += num;
    }
    public void test1(int num) {
        num += num;
    }
}
class Student{
    String name;
    //final 修饰的成员属性必须要被初始化，因为它无法自动初始化
    final String sex = "男";
}
