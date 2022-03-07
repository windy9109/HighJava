package kr.or.ddit.basic;

public class ThreadTest15 {

	public static void main(String[] args) {
		ShareObject sObj = new ShareObject();
		
		TestThread th1 = new TestThread("test1", sObj);
		TestThread th2 = new TestThread("test2", sObj);
		
		th1.start();
		th2.start();

	}

}

class TestThread extends Thread{
	private ShareObject sObj;
	public TestThread(String name, ShareObject sObj) {
		super(name);
		this.sObj = sObj;
	}
	
	@Override
	public void run() {
		for(int i=1; i<=10; i++) {
			sObj.add();
		}
	}
	
}


//공통으로 사용할 클래스
class ShareObject{
	
	private int sum =0;
	
	//동기화 하기 ==> synchronized를 이용해서 처리한다.
	
	
	
	//방법1 	==> 메서드 자체에 동기화 설정을 하는 방법
	/*
	public synchronized void add(){
		처리할 내용들....
	}
	*/
	
	//방법2	==> 동기화 블력으로 설정하는 방법
	/*
	public void add(){
		synchronized(동기화 할 객체){
			처리할내용들...
		}
	}
	*/
	
	//synchronized를 설정하면 다른 스레드의 방해를 받지않고 처리함
	//	public synchronized void add() { 		//방법1
	public void add() {
		synchronized(this) {	//방법2
		int n = sum;
		n += 10;
		sum = n;
		//현재진행중인스레드가 어떤것인지 알려줌
		System.out.println(Thread.currentThread().getName() + "합계: "+ sum);
		}
	}
	
}