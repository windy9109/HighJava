package test;

public class ThreadTest13_a2 {

	public static void main(String[] args) {
		Horse3[] horses = new Horse3[] {
				new Horse3("1번말"),
				new Horse3("2번말"),
				new Horse3("3번말"),
				new Horse3("4번말"),
				new Horse3("5번말")
				
		};
		
		
		GameState3 gs = new GameState3(horses);
		for(Horse3 h: horses) {
			h.start();
		}
		gs.start();
		
		for(Horse3 h: horses) {
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
		

	}

}


class Horse3 extends Thread implements Comparable<Horse3>{
	public static int currentRank = 0; //말들의 등수를 결정할 변수
	
	private String horseName;
	private int rank;
	private int position;
	public Horse3(String horseName) {
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
		return "Horse3 [horseName=" + horseName + ", rank=" + rank + ", position=" + position + "]";
	}
	//등수정렬
	@Override
	public int compareTo(Horse3 o) {
		return Integer.compare(rank, getRank());
	}
	
	@Override
	public void run() {
		for(int i =1; i<=50; i++) {
			this.position = i; //현재구간을 말의 위치로한다.
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



class GameState3 extends Thread{
	private Horse3[] horses;

	public GameState3(Horse3[] horses) {
		super();
		this.horses = horses;
	}
	
	@Override
	public void run() {
		
		while(true) {
			//모든말의 경주가 끝나면 반복문을 탈출한다.
			if(Horse3.currentRank == horses.length) {
				break;
			}
			for(int i=1; i<10; i++) {
				System.out.println();
			}
			for(int i=0; i<horses.length; i++) {
				System.out.println(horses[i].getHorseName()+" : ");
				for(int j=0; j<=50; j++) {
					if(horses[i].getPosition() == j) {
						System.out.println(">");
					}else{
						System.out.println("-");
					}
					System.out.println("-");
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