package test;

import java.util.ArrayList;
import java.util.Arrays;

public class ThreadTest13_a {

	public static void main(String[] args) {
		Horse2[] horses = new Horse2[] {
				new Horse2("01번말"),
				new Horse2("02번말"),
				new Horse2("03번말"),
				new Horse2("04번말"),
				new Horse2("05번말"),
				new Horse2("06번말"),
				new Horse2("07번말")
		};
		
		GameState gs = new GameState(horses);
		for(Horse2 h: horses) {
			h.start();
		}
		gs.start(); //말들의 현재위치를 나타내는 스레드
		
		//모든말들의 경주가 끝날때까지 기다림
		for(Horse2 h: horses) {
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
		System.out.println("경기끝....");
		System.out.println();
		
		//등수의 오름차순으로 정렬하기
		Arrays.sort(horses); //배열을 정렬하기
		for(Horse2 h: horses) {
			System.out.println(h);
		}
		
		ArrayList<Horse2> horseList = new ArrayList<Horse2>();
		for(Horse2 h: horseList) {
			horseList.add(h);
		}
		
		

	}

}


class Horse2 extends Thread implements Comparable<Horse2>{
	public static int currentRank = 0; //말들의 등수를 결정할 변수
	
	private String horseName;
	private int rank;
	private int position;
	public Horse2(String horseName) {
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
		return "Horse [horseName=" + horseName + ", rank=" + rank + ", position=" + position + "]";
	}
	
	
	@Override
	public int compareTo(Horse2 o) {
		return Integer.compare(rank,o.getRank());
	}
	
	@Override
	public void run() {
		//경주를 진행하는 스레드 처리
		
		//1~50 구간진행
		for(int i =1; i<=50; i++) {
			this.position = i; //현재구간을 말의 위치로 한다.
			try {
				Thread.sleep((int)(Math.random()*500));
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		
		currentRank++;
		this.rank = currentRank;
		
	}
}


//경기중에 말의 현재위치를 나타내는 스레드

class GameState extends Thread{
	private Horse2[] horses;

	public GameState(Horse2[] horses) {
		this.horses = horses;
	}
	
	@Override
	public void run() {
		while(true){
			//모든말들의 경주가 종료되면 반복문을 탈출한다.
			if(Horse2.currentRank == horses.length ) {
				break;
			}
			for(int i=1; i<10; i++){
				System.out.println();
			}
			// 1번말: ------------>---------------------------
			for(int i=0; i<horses.length; i++) {
				System.out.println(horses[i].getHorseName()+" : ");
				for(int j=0; j<=50; j++) {
					if(horses[i].getPosition() == j) {
						System.out.print(">");
					}else {
						System.out.print("-");
					}
					System.out.print("-");
					
				}
				System.out.println(); //줄바꿈
				
			}
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
			
			
			
		}
	}
	
	
	
	
	
	
	
}





