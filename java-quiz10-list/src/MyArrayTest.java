public class MyArrayTest {
    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();
        list.add("str");
        list.add("nihao");
        list.add("youxi");
        list.add("women");
        System.out.println(list);
        list.remove(1);
        System.out.println(list);
    }
}
