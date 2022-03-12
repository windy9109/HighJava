package kr.or.ddit.basic.stream;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedIOTest01 {

	public static void main(String[] args) {
		//입출력 향상을 위하여 Buffered스트림을 사용한다.
		try {
			FileOutputStream fout = new FileOutputStream("d:/d_other/bufferTest.txt");
			BufferedOutputStream bout = new BufferedOutputStream(fout, 5);

			//1~9까지중에서 6~9까지는 4개 숫자가 들어가므로 1~5까지만 출력
			//따라서 close() 혹은 flush()를 반드시 명시해준다.
			for(char i='1'; i<='9'; i++) {
				bout.write(i);
			}
			//bout.flush();
			//버퍼스트림을 닫아주면 버퍼의 내용을 모두 flush한 후에 닫아준다.
			bout.close();
			
			System.out.println("작업 끝...");
			
		} catch (IOException e) {
			// TODO: handle exception
		}
		

	}

}
