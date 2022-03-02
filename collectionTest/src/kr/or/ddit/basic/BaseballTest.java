package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/*
	문제) Set을 활용하여 숫자 야구 게임 프로그램을 작성하시오.
		컴퓨터의 숫자는 난수를 이용해서 구한다.
		(스트라이크는 S, 볼은 B로 나타낸다.)
		
	예시)
		컴퓨터 난수 ==> 9 5 7
		
	실행예시)
	숫자입력 : 3 5 6
	3 5 6 => 1S 0B
	숫자입력 : 7 8 9
	7 8 9 => 0S 2B
	숫자입력 : 9 7 5
	9 7 5 => 1S 2B
	숫자입력 : 9 5 7
	9 5 7 => 3S 0B
	
	축하합니다...
	당신은 4번째만에 맞췄습니다.
	
	
*/
public class BaseballTest {

	public static void main(String[] args) {
		

	
		
		HashSet<Integer> number = new HashSet<Integer>();
		
		while(number.size()<3) {
			int random =(int)(Math.random()*(9-0+1)+0);
			number.add(random);
		}

		
		ArrayList<Integer> numList = new ArrayList<Integer>(number);
		for( Integer numbers : numList) {
		System.out.print(numbers);
		}
		System.out.println();
		
		
		int s=0;
		int b=0;
		int count=0;
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Integer> inputList = new ArrayList<Integer>();
		while(s !=3 ) {
			
			s=0;
			b=0;
			inputList.clear();
			
			while(true) {
				for(int i=0; i<3; i++) {
				System.out.println("0~9 숫자입력["+(i+1)+"]> ");
				inputList.add(Integer.parseInt(sc.nextLine()));
				//입력중복 없얘기
					for(int j=0; j<i; j++) {
						if(inputList.get(i) == inputList.get(j)) {
							System.out.println("중복됩니다. 다시입력해주세요.");
							inputList.remove(i);
							--i;
						}
					}
				}
				
				
				break;
			}
			
			for(int i=0; i<numList.size(); i++) {
				for(int j=0; j<numList.size(); j++) {
					if( inputList.get(i) == numList.get(j) && j == i ) {
						s++;
					}
					if( inputList.get(i) == numList.get(j) && j != i  ) {
						b++;
					}
				}
			}
			
			System.out.println("S:"+s+", B:"+b);
			
			if( s == 0 && b==0 ) {
				System.out.println("하나도 맞추지 못했습니다.");
			}
			if( s != 3 ) {
				System.out.println("아쉽네요 재도전!");
			}
			count++;
			
		}
		
		System.out.println("정답입니다!");
		System.out.println(count+"회 만에 맞추셨습니다.");
		
		
		
		
		
		

	}

}
