package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Lotto {
	/*
	 * 로또를 구매하는 프로그램 작성하기
 
	 사용자는 로또를 구매할 때 구매할 금액을 입력하고
	 입력한 금액에 맞게 로또번호를 출력한다.
	 (단, 로또 한장의 금액은 1000원이며 최대 100장까지만 구입할 수 있고,
	      거스름돈도 계산하여 출력한다.)
	
	1~25사이의 중복되지않은숫자 6개 
	 * 
	*/	
	

	public static void main(String[] args) {
		
		Lotto.start();
		

	}
	
	
	//로또를 구입하는 메서드
	public static int LottoGet() {
		System.out.println("로또구입시작"
				+ "\n1000원에 로또번호 하나입니다."
				+ "\n금액 입력> ");
		Scanner scc = new Scanner(System.in);
		int coin = Integer.parseInt(scc.nextLine());
		
		if(1000 > coin) {
			System.out.println("금액이 너무 적습니다. 로또번호 구입실패!!");
			return Lotto.start();
		}
		if(101000 < coin) {
			System.out.println("입력금액이 너무 많습니다. 로또번호 구입실패!");
			return Lotto.start();
		}
	
		return Lotto.Success(coin);
	
		
	}
	
	
	//성공시
	public static int Success(int coin) {
		

		
		HashSet<Integer> coinNum = new HashSet<Integer>();
		System.out.println("행운의 로또번호는 아래와 같습니다.");
		for(int i=0; i<coin/1000; i++) {
			//발생된 난수를 6열의 HashSet에 넣기
			while(coinNum.size()<6) {
				//중복되지 않는 난수발생 HashSet
				int random = (int)(Math.random()*(25-1+1)+1);
				coinNum.add(random);
			}
			
			//행운의 로또번호 장수는 cion/1000 나눈 몫만큼
			ArrayList<Integer> coinList = new ArrayList<Integer>(coinNum);
			Collections.sort(coinList);
			
			System.out.println("로또번호"+(i+1)+": ");
			for(int j=0; j<coinList.size(); j++) {
				if(j+1 != coinList.size()) {
					System.out.print(coinList.get(j)+", ");
				}
				if( j+1 == coinList.size() ) {
					System.out.print(coinList.get(j));
				}
			}
			System.out.println();
			coinNum.clear();
		}
		System.out.println("\n받은금액은 "+coin+"원 이고 거스름돈은 "+coin%1000+"원 입니다.\n");
		return Lotto.start();
		
	}
	
	
	
	
	
	public static int start() {
		System.out.println("=========================="
				+ "\n\tLotto 프로그램"
				+ "\n--------------------------"
				+ "\n1. Lotto 구입"
				+ "\n2. 프로그램 종료"
				+ "\n=========================="
				+ "\n메뉴선택 > ");
		Scanner sc = new Scanner(System.in);
		int input = Integer.parseInt(sc.nextLine());
		
		switch(input) {
		case 1: Lotto.LottoGet(); break;
		case 2: System.exit(input); break;	
		}
		return Lotto.start();
	}
	

}



