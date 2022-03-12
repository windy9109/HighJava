package kr.or.ddit.basic.stream;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileIOTest02 {
	public static void main(String[] args) {
		//파일로 출력하는 예제  ==>  FileOutputStream 이용
		
		try {
			
			//출력스트림에 사용한 파일은 없으면 새로만들고
			//있으면 그 내용을 덮어쓴다.
			FileOutputStream fout = new FileOutputStream("d:/d_other/out.txt");
			for(char ch ='A'; ch<='Z'; ch++) {
				fout.write(ch);  //ch변수의 값을 파일로 출력한다.
			}
			System.out.println("출력 작업 완료...");
			fout.close();
			
		} catch (IOException e) {
			// TODO: handle exception
		}
		
		
	}
}
