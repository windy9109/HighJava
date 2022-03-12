package kr.or.ddit.basic.stream;

import java.io.FileReader;
import java.io.IOException;

public class FileIOTest03 {

	public static void main(String[] args) {
		// 문자기반 스트림을 이용한 파일내용 읽기
		
		try {
			//문자기반 파일 입력용 스트림 객체생성
			FileReader fr = new FileReader("d:/d_other/test.txt");
			
			int c;
			while((c=fr.read())!=-1) {
				System.out.print((char)c);
			}
			fr.close();
		} catch (IOException e) {
			// TODO: handle exception
		}

	}

}
