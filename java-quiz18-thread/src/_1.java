import oracle.jvm.hotspot.jfr.Producer;

public class _1 {
	public static void main(String[] args) {
		Object product = new Object();
		//创建一个 custom
		Thread custom = new Thread() {
			@Override
			public void run() {
				synchronized (product) {
					System.out.println("Custom：老板我要采购！");
					try {
						product.wait();
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("Custom：OK,已经购买到了！");
				}
			}
		};
		Thread factory = new Thread() {
			@Override
			public void run() {
				synchronized (product) {
					try {
						Thread.sleep(300);
						System.out.println("Factory：好的，我已经生产好了!");
						product.notify();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		custom.start();
		factory.start();

	}
}
