package api.service;

import java.util.concurrent.CountDownLatch;

import org.springframework.stereotype.Service;

import api.thread.StopLatchedThread;

@Service("threadService")
public class MyThreadService {

	public void performParallelTask() {
		CountDownLatch cdl = new CountDownLatch(3);

		new Thread(new StopLatchedThread(3, 3000, cdl)).start();
		new Thread(new StopLatchedThread(5, 5000, cdl)).start();
		new Thread(new StopLatchedThread(2, 2000, cdl)).start();

		try {
			cdl.await();
		} catch (InterruptedException e) {

		}

		System.out.println("Sum completed: " + StopLatchedThread.result);
		StopLatchedThread.result = 0;
	}
}