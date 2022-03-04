package test;

public class ThreadTest09 {

	public static void main(String[] args) {
		PrintStateThread2 th2 = new PrintStateThread2(new TargetThread2());
		th2.start();
		
	}

}

//스레드의 상태를 검사하는 대상이되는 스레드
class TargetThread2 extends Thread{
	
	@Override
	public void run() {
		long sum = 0L;
		for(long i =1L; i< 2_000_000_000L; i++) {
			sum += i;
		}
		
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		
		sum = 0L;
		for(long i =1L; i<2_000_000_000L; i++) {
			sum +=i;
		}
		
	}
	
}


class PrintStateThread2 extends Thread{
	private TargetThread2 target;

	public PrintStateThread2(TargetThread2 target) {
		super();
		this.target = target;
	}
	
	
	@Override
	public void run() {
		
		while(true) {
			//스레드의 상태값 구하기 ==> getState()이용
			Thread.State state = target.getState();
			System.out.println("TargetThresd의 상태값: "+state);
			
			if(state == Thread.State.NEW) {
				target.start();
			}
			if(state == Thread.State.TERMINATED) {
				break;
			}
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
			
		}
	}
	
	
}








