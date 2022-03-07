package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Arrays;

public class ThreadTest13_a {

	public static void main(String[] args) {
		Horse[] horses = new Horse[] {
				new Horse("01번말"),
				new Horse("02번말"),
				new Horse("03번말"),
				new Horse("04번말"),
				new Horse("05번말"),
				new Horse("06번말"),
				new Horse("07번말"),
				new Horse("08번말"),
				new Horse("09번말"),
				new Horse("10번말")
				
		};
		
		GameState gs =new GameState(horses);
		for(Horse h: horses) {
			h.start();
		}
		gs.start(); //말들의 현재위치를 나타나는 스레드로 시작한다.
		
		//모든말들의 경주가 끝날때까지 기다린다.
		for(Horse h: horses) {
			try {
				h.join();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		try {
			gs.join();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		System.out.println();
		System.out.println("경기 끝...");
		System.out.println();
		
		//등수의 오름차순으로 정렬하기
		Arrays.sort(horses); //배열을 정렬하기
		for(Horse h: horses) {
			System.out.println(h);
		}
		
		
		ArrayList<Horse> horseList = new ArrayList<Horse>();
		for(Horse h:  horseList) {
			horseList.add(h);
		}
		
		
		
		
		
	}

}


class Horse extends Thread implements Comparable<Horse>{
	public static int currentRank = 0; //말들의 등수를 결정할 변수
	
	
	private String horseName; //말이름
	private int rank;
	private int position;
	public Horse(String horseName) {
		super();
		this.horseName = horseName;
		this.rank = rank;
		this.position = position;
	}
	public String getHorseName() {
		return horseName;
	}
	public void setHorseName(String horseName) {
		this.horseName = horseName;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	@Override
	public String toString() {
		return  horseName + "은 " + rank + "등입니다.";
	}
	
	//등수의 오름차순 정렬기준 설정하기
	@Override
	public int compareTo(Horse o) {
		return Integer.compare(rank,o.getRank());
	}
	
	public void run () {
		//경주를 진행하는 스레드 처리
		
		//1~50 구간 진행
		for(int i=1; i<=50; i++) {
			this.position = i; //현재구간을 말의 위치로 한다.
			try {
				Thread.sleep((int)(Math.random()*500));
			} catch (InterruptedException e) {
				// TODO: handle exception
			}	
		}
		//한마리의 말이 경주가 끝난후에 등수를 구한다.
		currentRank++;
		this.rank = currentRank;
		
	}
	
	
	
	
	
	
	
}


//경기중에 말의 현재위치를 나타내는 스레드


class GameState extends Thread{
	private Horse[] horses;

	//생성자 - 경주에 참여한 말들이 저장된 배열을 받아서 초기화한다.
	public GameState(Horse[] horses) {
		this.horses = horses;
	}
	
	@Override
	public void run() {
		while(true) {
			//모든말들의 경주가 종료되면 반복문을 탈출한다.
			if( Horse.currentRank == horses.length ) {
				break;
			}
			
			for(int i=1; i< 10; i++) {
				System.out.println();
			}
			
			// 1번말: ------------>-----------------------------
			for(int i=0; i<horses.length; i++) {
				System.out.print(horses[i].getHorseName()+" : ");
				for(int j=0; j<=50; j++) {
					//말의 현재위치와 구간값이 같은지 여부검사
					if(horses[i].getPosition() == j) {
						//말의 현재위치와 구간값이 같은지 검사
						System.out.print(">");
					}else {
						System.out.print("-");
					}
					
					System.out.print("-");
				}
				System.out.println();//줄바꿈
			}
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
			
			
			
		}
	}
	
}




