package kr.or.ddit.basic.stream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteArrayIOTest02 {

	public static void main(String[] args) {

			byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
			byte[] outSrc = null;
			
			byte[] temp = new byte[4];
			
			//입력용 스트림 객체 생성
			ByteArrayInputStream input = new ByteArrayInputStream(inSrc);
			
			//출력용 스트림 객체 생성
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			
			
			try {
				
				//방법1
				/* // available()메서드 ==> 읽어올 수 있는 데이터 수를 반환 
				 * while(input.available()>0) {
				 * 
				 * //오류 - 무조건 4개씩 불러와짐 //input.read(temp); //output.write(temp);
				 * 
				 * //실제 읽어온 byte 수를 반환한다. int len = input.read(temp); //temp배열의 내용중에서 0번쨰부터 len개
				 * 만큼 출력한다. output.write(temp, 0, len);
				 * 
				 * System.out.println("반복문 안에서 temp => "+ Arrays.toString(temp));
				 * 
				 * }
				 */
				
				
				//방법2 :: 가장 많이 씀
				int len =0;
				while((len=input.read(temp))>0) {
					output.write(temp,0,len);
				}
				
				
				
				outSrc = output.toByteArray();
				System.out.println("inSrc => "+Arrays.toString(inSrc));
				System.out.println("outSrc => "+Arrays.toString(outSrc));
				input.close();
				output.close();
				
			} catch (IOException e) {
				// TODO: handle exception
			}
			
			

	}

}
