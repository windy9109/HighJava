package test;

public class ThreadTest04 {

	public static void main(String[] args) {
		//단독처리
		SumThread smth = new SumThread(1L, 2000000000L);
		long startTime = System.currentTimeMillis();
		smth.start();
		
		try {
			smth.join();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		long endTime = System.currentTimeMillis();
		System.out.println("단독으로 처리했을때 경과시간: "+(endTime-startTime));
		System.out.println();
		
		
		
		//여럿의 스레드가 협력
		SumThread[] smths = new SumThread[] {
				new SumThread(1L, 500_000_000L),
				new SumThread(500_000_001L, 1_000_000_000L),
				new SumThread(1_000_000_001L, 1_500_000_000L),
				new SumThread(1_500_000_000L, 2_000_000_000L)
		};
		
		startTime = System.currentTimeMillis();
		
		for(int i=0; i< smths.length; i++) {
			smths[i].start();
		}
		for(SumThread sm : smths) {
			try {
				sm.join();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		
		endTime = System.currentTimeMillis();
		System.out.println("협력해서 처리한 경과시간: "+(endTime-startTime));
		

	}

}



class SumThread extends Thread{
	private long min;
	private long max;
	//생성자
	public SumThread(long min, long max) {
		super();
		this.min = min;
		this.max = max;
	}
	
	@Override
	public void run() {
		long sum = 0L;
		for(long i =min; i<max; i++) {
			sum += i;
		}
		System.out.println("합계: "+sum);
	}
	
	
}