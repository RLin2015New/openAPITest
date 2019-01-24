package otherTest;

public class StopThreadTest01 implements Runnable {
	private boolean flag = true;
	private static Object lock = new Object();

	public static void main(String[] args) throws InterruptedException {

		StopThreadTest01 stopThreadTest = new StopThreadTest01();
		Thread thread = new Thread(stopThreadTest);
		thread.start();

		int i = 0;
		Object ob = new Object();
		System.out.println("abc");
		while (true) {
		
			if (!stopThreadTest.flag) {
				break;
			}
			// System.out.println(i);
		}
		System.out.println("计数器已经停止");

	}

	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		synchronized (lock) {
			flag = false;
		}
		
	}
}
