package otherTest;

public class StopThreadTest implements Runnable {
	public volatile boolean flag = true;
//	private static Object lock = new Object();

	public static void main(String[] args) throws InterruptedException {

		StopThreadTest stopThreadTest = new StopThreadTest();
		Thread thread = new Thread(stopThreadTest);
		thread.start();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		stopThreadTest.flag = false;
	}

	@Override
	public void run() {
//		int i = 0;
		// while (flag) {
		// System.out.println(i);
		// }
		while (true) {
//			synchronized (lock) {
//				if (!flag) {
//					break;
//				}
//			}
			if (!flag) {
				break;
			}
		}
		System.out.println("计数器已经停止");
	}
}
