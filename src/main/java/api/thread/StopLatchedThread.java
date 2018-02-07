package api.thread;

import java.util.concurrent.CountDownLatch;

public class StopLatchedThread implements Runnable {

	private final int number;
	private final int timeToStart;
	private final CountDownLatch stopLatch;

	public static int result = 0;

	public StopLatchedThread(int number, int timeToStart, CountDownLatch stopLatch) {
		this.number = number;
		this.timeToStart = timeToStart;
		this.stopLatch = stopLatch;
	}

	public void run() {
		System.out.println("Start of the thread: " + this.number);

		long startTime = System.currentTimeMillis();
		while (false || (System.currentTimeMillis() - startTime) < this.timeToStart) {

		}

		result += this.number;

		stopLatch.countDown();

		System.out.println("End of the thread: " + this.number);
	}
}