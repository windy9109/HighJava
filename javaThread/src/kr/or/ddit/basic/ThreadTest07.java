package kr.or.ddit.basic;

import javax.swing.JOptionPane;

public class ThreadTest07 {
	
	/*
	 * 컴퓨터와 가위 바위 보를 진행하는 프로그램을 작성하시오.
	 * 컴푸터와의 가위 바위 보는 난수를 이용해서 구하고,
	 * 사용자의 가위바위보는 showInputDialog()를 이용해서 입력받는다.
	 * 
	 * 입력시간은 5초로 제한하고 카운트다운을 진행한다.
	 * 5초안에 입력이 없으면 게임에 진것으로 처리한다.
	 * 
	 * 5초안에 입력이 있으면 승패를 구해서 출력한다.
	 * 
	 * 결과 예시)
	 * 1) 5초(5000) 안에 입력이 없을때 
	 * - 결 과 -
	 * 시간 초과로 당신이 졌습니다.
	 * 
	 * 2)5초안에 입력이 있을 때
	 * - 결 과 -
	 * 컴퓨터: 가위
	 * 당신: 바위
	 * 결과: 당신이 이겼습니다. 
	 * 
	*/

	public static void main(String[] args) {
		
		Thread th1 = new DataInput2();
		Thread th2 = new CountDown2();
		th1.start();
		th2.start();
		

	}

}


//입력받는 메서드
class DataInput2 extends Thread{
	public static boolean inputCheck = false;
	

	
	
	@Override
	public void run() {
		String str = null;
		do {
			str = JOptionPane.showInputDialog("1.가위 2.바위 3.보 숫자를 선택하세요.");
		}while(  !(str.equals("1") || str.equals("2")|| str.equals("3")) );
		
		inputCheck = true;
		int str2    = Integer.parseInt(str);
		int random = (int)(Math.random()*(3+1-1)+1);
		
		if(random == str2) {
			System.out.println("비겼습니다.");
		}
		if(str2 == 1 && random == 2 || str2 == 2 && random == 3 || str2 == 3 && random == 1) {
			System.out.println("당신이 졌습니다.");
		}
		if(str2 == 1 && random == 3 || str2 == 2 && random == 1 || str2 == 3 && random == 2) {
			System.out.println("당신이 이겼습니다.");
		}

		
		System.out.println("\n- 결 과 -");
		switch(random) {
			case 1:System.out.println("컴퓨터: 가위"); break;
			case 2:System.out.println("컴퓨터: 바위"); break;
			case 3:System.out.println("컴퓨터: 보"); break;
		}
		
		switch(str2) {
			case 1:System.out.println("당신: 가위"); break;
			case 2:System.out.println("당신: 바위"); break;
			case 3:System.out.println("당신: 보"); break;
		}
		
	}
	
	
}


//카운트다운을 징행하는 메서드
class CountDown2 extends Thread{
	
	@Override
	public void run() {
		for(int i=5; i>=1; i--) {
			System.out.println(i);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
			if(DataInput2.inputCheck == true) {
				return;
			}
			if(i == 1) {
				System.out.println("시간초과로 졌습니다."
						+ "게임을 종료합니다.");
			}			
		}
		
		System.exit(0);

		
	}
	
}












