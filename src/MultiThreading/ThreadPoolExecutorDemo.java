package MultiThreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 4, 5, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(2), new CustomThreadFactory(), new CustomRejectHandler());
		
		for(int i=1;i<=7;i++) {
			executor.submit(()->{
				try {
					Thread.sleep(5000);
				}
				catch(Exception e) {
					System.out.println(e);
				}
				System.out.println("Task Processed by: "+Thread.currentThread().getName());
			});
		}
	}

}

class CustomThreadFactory implements ThreadFactory{

	@Override
	public Thread newThread(Runnable r) {
		Thread th = new Thread(r);
		th.setPriority(Thread.NORM_PRIORITY);
		th.setDaemon(false);
		return th;
	}
	
}

//creating custom reject handler or else use predefined one - new ThreadPoolExecutor.DiscardOldestPolicy()
class CustomRejectHandler implements RejectedExecutionHandler{

	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		// TODO Auto-generated method stub
		System.out.println("Thread Executor: "+r.toString());
		
	}
}