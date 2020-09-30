import java.util.LinkedList;

public class _2 {
	public static void main(String[] args) {

		Storage storage = new Storage();
		Product p1 = new Product(storage);
		Product p2 = new Product(storage);
		Product p3 = new Product(storage);
		Custom c1 = new Custom(storage);
		Custom c2 = new Custom(storage);
		Custom c3 = new Custom(storage);
		p1.start();
		p2.start();
		p3.start();
		c1.start();
		c2.start();
		c3.start();

	}
}

class Storage {
	//仓库最大容量
	public static final int MAX_SIZE = 3;

	//仓库存储载体
	LinkedList<Object> list = new LinkedList<>();
}

class Custom extends Thread {
	Storage storage;

	public Custom(Storage storage) {
		super();
		this.storage = storage;
	}

	@Override
	public void run() {
		synchronized (storage) {
			while (true) {
				if (storage.list.size() <= 0) {
					System.out.println("仓库已空{"+Thread.currentThread().getName()+"}：暂时不能进行消费");
					try {
						storage.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					storage.list.remove();
					System.out.println("{"+Thread.currentThread().getName()+"}:消费了一个商品\t{现仓库中的存储量为:"+storage.list.size()+"}");
					storage.notifyAll();
				}
			}
		}
	}
}
class Product extends Thread {
	Storage storage;

	public Product(Storage storage) {
		super();
		this.storage = storage;
	}

	@Override
	public void run() {
		synchronized (storage) {
			int count = 0;
			while (count < 10) {
				if (storage.list.size() >= storage.MAX_SIZE) {
					System.out.println("仓库已满{"+Thread.currentThread().getName()+"}:暂时不能执行生产");
					try {
					storage.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					storage.list.add(new Object());
					System.out.println("{"+Thread.currentThread().getName()+"}:生产了一个商品\t{现仓库的存储量为："+storage.list.size()+"}");
					storage.notify();
				}
				count++;

			}
		}
	}
}