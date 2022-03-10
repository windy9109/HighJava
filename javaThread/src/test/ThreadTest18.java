package test;

public class ThreadTest18 {

	public static void main(String[] args) {
		
		
		WorkObject1 work = new WorkObject1();
		ThreadA tha = new ThreadA(work);
		ThreadB thb = new ThreadB(work);

		tha.start();
		thb.start();
		
	}

	
	
	
}



//공통으로 사용할 클래스
class WorkObject1{
	public synchronized void methodA() {
		System.out.println("memthodA()메서드 실행중...");
		notify();
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		System.out.println("memthodA()메서드 wait()다음실행중...");
		
	}
	
	public synchronized void methodB() {
		System.out.println("memthodA()메서드 실행중...");
		notify();
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		System.out.println("memthodB()메서드 wait()다음실행중...");
		
	}
	
}



//공통으로 사용하는 객체의 methodA()메서드만 호출하는 스레드
class ThreadA extends Thread{
	private WorkObject1 workObj;
	
	public ThreadA(WorkObject1 workObj) {
		this.workObj = workObj;
	}
	
	@Override
	public void run() {
		for(int i=1; i<=10; i++) {
			workObj.methodA();
		}
		synchronized (workObj) {
			workObj.notify();
		}
		
	}
	
}



//공통으로 사용하는 객체의 methodB()메서드만 호출하는 스레드
class ThreadB extends Thread{
	private WorkObject1 workObj;
	
	public ThreadB(WorkObject1 workObj) {
		this.workObj = workObj;
	}
	
	@Override
	public void run() {
		for(int i=1; i<=10; i++) {
			workObj.methodB();
		}
		synchronized (workObj) {
			workObj.notify();
		}
		
	}
	
}



