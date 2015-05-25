import java.util.concurrent.atomic.AtomicInteger;


public class ThreadHelloWorld {
	public static class Main {
		public static void main(String[] args) throws InterruptedException {
			AtomicInteger counter = new AtomicInteger();
			ThreadTest first = new ThreadTest(counter);
			ThreadTest second = new ThreadTest(counter);
			ThreadTest third = new ThreadTest(counter);
			first.start();
			first.join();
			second.start();
			second.join();
			third.start();
			System.out.println(counter.get());
			third.join();
		}
	}
}
