package kr.or.ddit.basic.stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedIOTest02 {

	public static void main(String[] args) {
		// 문자기반의 Buffered 스트림 사용예제
		
		try {
			//'FileTest01.java'파일을 읽어와 출력하기
			FileReader fr = new FileReader("./src/kr/or/ddit/basic/FileTest01.java");
			BufferedReader br = new BufferedReader(fr);
			
			String temp = ""; //일어온 문자열을 저장할 변수
			
			//방법1 ----------------------------------------------
//			for(int i=1; (temp = br.readLine()) != null; i++) {
//				System.out.printf("%4d : %s\n", i, temp);
//			}
			
			//방법2 ----------------------------------------------
			int i =1;
			while((temp = br.readLine()) != null ) {
				System.out.printf("%4d : %s\n", i, temp);
				i++;
			}
			//--------------------------------------------------
			
			br.close();
			
			
		} catch (IOException e) {
			// TODO: handle exception
		}

	}

}
