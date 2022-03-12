package kr.or.ddit.basic.stream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteArrayIOTest01 {
	//입력스트림 사용법
	public static void main(String[] args) {
		byte[] inSrc = {1,2,3,4,5,6,7,8,9};
		byte[] outSrc = null;
		
		//입력용 스트림 객체 생성
		ByteArrayInputStream input = new ByteArrayInputStream(inSrc);
		
		//출력용 스트림 객체 생성
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		
		int data; 	//읽어온 자료가 저장될 변수 
		//data로 값을 일어오고 -1이 아닐때까지 실행하라
		//read() 메서드 ==> 더이상 읽어올 데이터가 없으면 -1을 반환
		while( (data = input.read()) != -1 ) {
			//읽어온 데이터를 처리하는 부분
			output.write(data); //출력하기
		}
		
		//출력된 스트림값을 배열로 변환하기
		outSrc = output.toByteArray();
		
		//입출력 작업이 완료되면 사용하던 스트림을 닫아준다.
		try {
			input.close();
			output.close();
		} catch (IOException e) {
			// TODO: handle exception
		}
		
		System.out.println("inSrc: "+ Arrays.toString(inSrc));
		System.out.println("outSrc: "+ Arrays.toString(outSrc));
		
		
		
	}

}
