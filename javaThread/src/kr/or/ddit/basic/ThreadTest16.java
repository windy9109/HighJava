package kr.or.ddit.basic;

//은행의 입출금을 스레드로 처리하는 예제 - 동기화 처리 예제

public class ThreadTest16 {
	
	private int balance; //잔액이 저장될 변수
	

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	//입금하는 메서드
	public synchronized void deposit(int money) {
		balance += money;
	}
	
	//출금하는 메서드(반환값 => 출금성공: true, 출금실패 : false)
	public synchronized boolean withdraw(int money) {
		if(balance>=money) {
			
			
			for(int i =1; i<=100000000; i++) {
				//시간지연용
			}
			
			balance -= money;
			System.out.println("메서드 안에서 balance = "+balance);
			return true;
		}else {
			return false;
		}
	}



	public static void main(String[] args) {
		//공통을 사용할 객체 생성
		ThreadTest16 acount = new ThreadTest16();
		acount.setBalance(10000); //잔액을 10000원으로 설정
		
		//익명구현체로 스레드 구현
		Runnable test = new Runnable() {
			public void run() {
				boolean result = acount.withdraw(6000);
				System.out.println("스레드에서 result: "+result+", balance: "+ acount.getBalance());
				
			}
		};
		//---------------------------------------
		Thread th1 = new Thread(test);
		Thread th2 = new Thread(test);

		th1.start();
		th2.start();
		
	}

}







