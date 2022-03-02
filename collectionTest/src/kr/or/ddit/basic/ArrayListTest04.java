package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

/*

	문제2) 5명 별명을 입력받아 ArrayList에 저장하고
		이 별명 중에 제일 긴 별명을 출력하시오.
		(단, 별명의 길이가 같은 것을 입력할 수 있다.)
	
*/

public class ArrayListTest04 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<String> aliasList = new ArrayList<String>();
		
		System.out.println("별명을 5번 입력하세요.");
		for(int i=1; i<=5; i++) {
			System.out.print(i + "번째 별명 : ");
			String alias = scan.nextLine();
			aliasList.add(alias);
		}
		
		// 제일 긴 별명의 길이가 저장될 변수 선언
		//		==> 첫번째 별명의 길이로 초기화한다.
		int maxLength = aliasList.get(0).length();
		
		for(int i=1; i<aliasList.size(); i++) {
			if(maxLength < aliasList.get(i).length()) {
				maxLength = aliasList.get(i).length();
			}
		}
		
		System.out.println("제일 긴 별명들...");
		for(String alias : aliasList) {
			if(maxLength == alias.length()) {
				System.out.println(alias);
			}
		}

	}

}







