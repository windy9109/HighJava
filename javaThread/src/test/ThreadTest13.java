package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
    10마리의 말들이 경주하는 경마 프로그램 작성하기
    
    말은 Horse라는 이름의 쓰레드 클래스로 작성하는데
    이 클래스는 말이름(String),등수(int),현재위치(int)를 멤버변수로 갖는다.
    그리고,이 클래스에는 등수를 오름차순으로 처리할 수 있는 내부 정렬기준이 있다.
    (Compare인터페이스 구현)
    
    경기 구간은 1~50 구간으로 되어 있다.
    
    경기가 끝나면 등수 순으로 출력한다.
    
    경기가 진행 중일때는 중간 중간에 말들의 위치를 아래와 같이 나타낸다.
    예)
    01번말 : --->--------------------------------------------
    02번말 : --------->--------------------------------------
    ...
    10번말 :-------->---------------------------------------
*/


public class ThreadTest13 {

	public static void main(String[] args) {
		ArrayList<Horse>horseList=new ArrayList<Horse>(); 
		horseList.add(new Horse("얼룩말"));
		horseList.add(new Horse("조랑말"));
		horseList.add(new Horse("하양말"));
		horseList.add(new Horse("양말"));
		
		for(Horse ho:horseList) {
			ho.start();
		}
		try {
			for(Horse ho:horseList) {
				ho.join();
			}
		} catch (Exception e) {
			
		}
		Collections.sort(horseList);
		for(int i=0;i<Horse.rankName.size();i++) {
			for(int j=0;j<horseList.size();j++) {
			if(Horse.rankName.get(i).equals(horseList.get(j).name)) {
				horseList.get(j).rank=i+1;
			}
		}
		}
		Collections.sort(horseList);
	      for(int i=0;i<horseList.size();i++) {
	    	  System.out.println(horseList.get(i).name+":"+horseList.get(i).rank);
	      }
	     
			}

}

class Horse  extends Thread implements Comparable<Horse>{
	public String name;
	public int rank;
	public int rocation=0;
    public static ArrayList<String>rankName=new ArrayList<String>();

	public Horse(String name) {
		
		this.name = name;
	}
	
	
	@Override
	public void run() {
		 String[] rocationView=new String[50];
		for(int i=0;i<rocationView.length;i++) {
			rocationView[i]="-";
		}
		while(true) {
			if(rocation>=1) {
				rocationView[rocation-1]="-";
			}
			rocation+=(int)(Math.random()*10+5);
			if(rocation<=50) {
				rocationView[rocation-1]=">";
			}
			if(rocation>50) {
				rocation=50;
			}
			try {
				Thread.sleep((int)(Math.random()*300+2000));
				
			} catch (Exception e) {
				
			}
			if(rocation==50) {
				break;
			}
			System.out.println("_____________________________________________________________________________________________________________________________________________________");
			System.out.println(name+"의 위치");
			System.out.println((Arrays.toString(rocationView).replace("[", " ").replace("]", " ")
					            .replace(",", " ")).trim());
			System.out.println("_____________________________________________________________________________________________________________________________________________________");
		}
		//	System.out.println(name+"완주!!");
			
			rankName.add(name);
			
		
		
		
		
		
		
	}


	


	@Override
	public int compareTo(Horse o) {
		// TODO Auto-generated method stub
		return Integer.compare(rank, o.rank);
	}



	
}





