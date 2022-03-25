package baekJoon;

import java.util.Scanner;

public class Problem2292 {

	public static void main(String[] args) {
//		입력
//		첫째 줄에 N(1 ≤ N ≤ 1,000,000,000)이 주어진다.
//
//		출력
//		입력으로 주어진 방까지 최소 개수의 방을 지나서 갈 때 몇 개의 방을 지나는지 출력한다.
//		예제입력 13, 예제출력 3
		
		
		System.out.println("숫자입력");
		Scanner scan = new Scanner(System.in);
		Long sc = scan.nextLong();
		int n = 0;
		do {
			n ++;
		}
		while( (6*(3*n))+1 < sc && Integer.MAX_VALUE > n);
		
		System.out.println(n+1);
	
		
//		if( 1(6) ) {
//			
//		}

		
		
		
		
		
	}

}
