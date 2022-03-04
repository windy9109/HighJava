package test;

import javax.swing.JOptionPane;

public class ThreadTest06 {

	public static void main(String[] args) {
		Thread th1 = new DataInput();
		Thread th2 = new CountDown();
		th1.start();
		th2.start();

	}

}


//데이터를 입력하는 메서드
class DataInput extends Thread{
	//입력여부 확인하기
	//스레드에서 공동으로 사용할 변수
	
	public static boolean inputCheck = false;
	
	@Override
	public void run() {
		String str = JOptionPane.showInputDialog("아무거나 입력하세요");
		inputCheck = true;
		System.out.println("입력값: "+str);
	}
	
}


//카운트다운을 진행하는 스레드
class CountDown extends Thread{
	@Override
	public void run() {
		for(int i=10; i>=1; i--) {
			//입력이 완료되었는지 여부를 검사해서 와뇰되면 스레드를 종료시킨다.
			//즉, 카운트아운을 멈춘다.
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
			if(DataInput.inputCheck == true ) {
				return;
			}
			
		}
		System.out.println("10초가 지났습니다. 프로그램을 종료합니다.");
		System.exit(0);
	}
	
}








