package test;

public class ThreadTest03 {

	public static void main(String[] args) {
		Thread th = new Thread(new MyRunner2());
		long startTime = System.currentTimeMillis();
		th.start();
		
		try {
			th.join();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println("경과시간: "+(endTime - startTime));
		

	}

}

class MyRunner2 implements Runnable{
	@Override
	public void run() {
		long sum = 0L;
		for(long i = 1L; i<=1000000000L; i++) {
			sum += i;
		}
		System.out.println("합계: "+ sum);
		
	}
	
}