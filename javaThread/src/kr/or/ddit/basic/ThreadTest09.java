package kr.or.ddit.basic;

//thread 상태를 출력하는 예제

public class ThreadTest09 {

	public static void main(String[] args) {
		
		PrintStateThread th = new PrintStateThread(new TargetThread());
		
		th.start();
		

	}

}


// thread상태의 검사 대상이 되는 thread 
class TargetThread extends Thread{
	@Override
	public void run() {
		
		long sum =0L;
		for(long i=1L; i<2_000_000_000L; i++) {
			sum += i;
		}
		
		
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		
		sum =0L;
		for(long i=1L; i<2_000_000_000L; i++) {
			sum += i;
		}
		
	}
	
}


//TargetThread의 상태를 출력하는 thread
class PrintStateThread extends Thread{
	private TargetThread target;
	
	public PrintStateThread(TargetThread target) {
		this.target = target;
	}
	
	@Override
	public void run() {
		while(true) {
			//스레드의 상태값 구하기 ==> getState()이용
			Thread.State state = target.getState();
			System.out.println("TargetThresd의 상태값: "+ state);
			
			//Thread의 상태가 NEW 상태인지 검사
			//thread가 생성되고 아직 start()가 호출되지 않은 상태
			if(state == Thread.State.NEW) {
				target.start(); //target 스레드를 실행시킨다.
			}
			//thread의 상태가 종료이면(작업이 종료된건지 검사)
			if(state == Thread.State.TERMINATED) {
				break; //반복문을 빠져나간다. 검사종료
			}

			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
			
		}
	}
	
}









