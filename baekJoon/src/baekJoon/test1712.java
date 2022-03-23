package baekJoon;

import java.util.Scanner;

public class test1712 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		long a = scanner.nextInt(); // 고정비용
		long b = scanner.nextInt(); // 가변비용
		long c = scanner.nextInt(); // 노트북 가격
		
		scanner.close();
		
		int n = 1;	// 노트북 대수
		
		// 손익분기점 = 총 수입(c*n) > 총 비용(a+(b*n))
		while(c*n <= a+(b*n) && n < Integer.MAX_VALUE)  // 손익분기점을 넘지 않고 정수 n이 범위값보다 작은 동안
			n++;					// 최대값도 포함시키면 오버플로우로 인해 -2147483648이 출력됨
		
		if(n == Integer.MAX_VALUE)  // 루프 빠져나왔을 때 노트북 대수가 정수의 최대값이라면(손익분기점 존재 x)
			n = -1;
		
		System.out.println(n);
		
	}

}
