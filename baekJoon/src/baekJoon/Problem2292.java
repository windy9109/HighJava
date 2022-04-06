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
		
		Scanner scan = new Scanner(System.in);
		Long sc = scan.nextLong();
		int layer=0;
		int sum =2;
		
		while( sum <= sc ) {
			sum += (6*layer);
			layer ++;
		}
		if(sc == 1) layer=1;
		
		System.out.println(layer);
		
		
		
	}

}
