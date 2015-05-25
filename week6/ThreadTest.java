import java.util.concurrent.atomic.AtomicInteger;

public class ThreadTest extends Thread{
	private AtomicInteger counter = new AtomicInteger();
	
	public ThreadTest(AtomicInteger counter){
		this.counter = counter;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10000; i++) {
			counter.incrementAndGet();
		}
	}
}
