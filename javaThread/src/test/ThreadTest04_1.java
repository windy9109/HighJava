package test;


public class ThreadTest04_1 {

	/* 1~20억 까지의 합계를 구하는 프로그램을 하나의 끄레드가 단독으로 처리할때와
	 * 여러개의 쓰레드가 협력해서 처리할때의 경과 시간을 비교해보자.
	*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SumThread0 th = new SumThread0(1L, 2_000_000_000L);
		
		long startTime = System.currentTimeMillis();
		th.start();
		
		try {
			th.join();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println("단독으로 처리했을때 경과한 시간:"+(endTime-startTime));
		System.out.println();
		
		
		//협력
		SumThread0[] th2 = new SumThread0[] {
			new SumThread0(1L, 500_000_000L),
			new SumThread0(500_000_001L, 1_000_000_000L),
			new SumThread0(1_000_000_001L, 1_500_000_000L),
			new SumThread0(1_500_000_001L, 2_000_000_000L),
		};
		
		startTime = System.currentTimeMillis();
		
//		for( int i =0; i<th2.length; i++) {
//			th2[i].start();
//		}
		
		for(SumThread0 sm : th2) {
			sm.start();
		}
		
		
//		for(int i=0; i<th2.length; i++) {
//			th2[i].start();
//		}
		
		
		for( SumThread0 sm : th2) {
			try {
				sm.join();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		endTime = System.currentTimeMillis();
		
		System.out.println("여럿으로 처리했을때 경과한 시간:"+(endTime-startTime));
		
		
		
		

	}

}


class SumThread0 extends Thread{
	private long min;
	private long max;
	public SumThread0(long min, long max) {
		super();
		this.min = min;
		this.max = max;
	}
	
	@Override
	public void run() {
		long sum = 0L;
		for(long i=min; i<=max; i++) {
			sum += i;
		}
		System.out.println("합계: "+sum);
	}
	
	
	
}