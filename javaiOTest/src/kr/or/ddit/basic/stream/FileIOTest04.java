package kr.or.ddit.basic.stream;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class FileIOTest04 {
	//사용자가 입력한 내용을 그대로 파일로 저장하기
	
	public static void main(String[] args) {
		
		try {
			//System.in => 콘솔(표준입출력장치)의 입력스트림 객체
			//입력용 바이트기반 스트림을 문자기반 스트림으로
			//변환하는 스트림객체생성
			
			InputStreamReader isr = new InputStreamReader(System.in);
			
			//출력용 문자기반 스트림 객체생성
			FileWriter fw = new FileWriter("d:/d_other/testchar.txt");
			int c;
			System.out.println("아무내용이나 입력하세요. (입력의 끝은 'ctrl' + 'z'입니다.)");
			//콘솔에서 입력할 때 입력의 끝은 'ctrl' + 'z'키를 누른다.
			while((c=isr.read()) != -1) {
				fw.write(c);
			}
			isr.close();
			fw.close();
			
			
//			System.in.read();
//			Scanner ss = new Scanner(System.in);
		} catch (IOException e) {
			// TODO: handle exception
		}
		
	}
	
	
}
