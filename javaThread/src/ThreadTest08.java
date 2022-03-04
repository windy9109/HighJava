
public class ThreadTest08 {

	
	// 데몬 쓰레드 연습 ==> 자동저장하기
	public static void main(String[] args) {
		AutoSaveThread autoSave = new AutoSaveThread();
		//데몬스레드로설정하기 ==> 반드시 start()메서드 실행전에 설정한다.
		//순서중요 setDaemon부터 실행하기!
		autoSave.setDaemon(true);
		autoSave.start();
		
		try {
			for(int i=1; i<=20; i++) {
				System.out.println(i);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		System.out.println("main 스레드 종료...");
		
		
		
	}

}


//자동저장하는 thread(3초에 한번씩 자동저장하는 thread)

class AutoSaveThread extends Thread{
	//작업내용르 저장하는메서드
	public void save() {
		System.out.println("작업내용을 저장합니다...");
		
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
			save();
		}
	}
	
	
	
	
}