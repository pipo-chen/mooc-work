import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class IteratorDemo {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList();

		//1. 元素装载
		for (int i = 0; i < 20000; i++) {
			list.add(i);
		}
		long begin_1 = new Date().getTime();
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i)+" ");
		}
		long end_1 = new Date().getTime();
		System.out.println("\n1. for 遍历时间："+(end_1 - begin_1));

		long begin_2 = new Date().getTime();
		for (int x : list) {
			System.out.print(x+" ");
		}
		long end_2 = new Date().getTime();
		System.out.println("\n2. foreach 遍历时间："+(end_2 - begin_2));

		long begin_3 = new Date().getTime();
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next()+" ");
		}
		long end_3 = new Date().getTime();
		System.out.println("\n3. iterator 遍历时间："+(end_3 - begin_3));


	}
}
