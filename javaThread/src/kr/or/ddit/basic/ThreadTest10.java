package kr.or.ddit.basic;

//yield() 메서드연습

public class ThreadTest10 {

	public static void main(String[] args) {
		YieldThread th1 = new YieldThread("1번 스레드");
		YieldThread th2 = new YieldThread("2번 스레드");
		
		th1.start();
		th2.start();
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		System.out.println("1111111111111111111111111------------------------");
		
		th1.work = false;
		
		try {
			Thread.sleep(10);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("222222222222222222222222222------------------------");
		
		th1.work = true;
		
		
		try {
			Thread.sleep(10);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("333333333333333333333333333------------------------");
		
		th1.stop = true;
		th2.stop = true;
		
	}

}


//yield() 메서드 연습용 스레드
class YieldThread extends Thread{
	public boolean stop = false;
	public boolean work = true;
	
	public YieldThread(String name) {
		super(name); //부모 class인 thread의 생성자 호출
					 // ==> 스레드의 이름설정
	}
	
	@Override
	public void run() {
		while(!stop) {  //stop이 true이면 반복문 종료
			if(work) {
				//getName()메서드 ==> 스레드의 이름을 반환한다.
				System.out.println(getName()+"작업중...");
			}else{
				System.out.println(getName()+"양보...");
				//실행중에 다른 스레드에 양보(yield)하고 실행대기된 상태
				Thread.yield(); // ==> 시간만 보낸다는뜻
			}
			
		}
	}
	
	
}












