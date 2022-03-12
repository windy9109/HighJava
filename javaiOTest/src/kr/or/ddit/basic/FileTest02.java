package kr.or.ddit.basic;

import java.io.File;

public class FileTest02 {

	public static void main(String[] args) {
		File f1 = new File("d:/d_other/test.txt");
		//파일의 크기측정
		System.out.println(f1.getName()+"의 크기: "+f1.length()+"bytes");
		System.out.println("Path :"+f1.getPath());
		//절대경로
		System.out.println("AbsolutePath: "+f1.getAbsolutePath());
		System.out.println();
		
		//현재위치 확인
		File f2 = new File(".");
		System.out.println("path: "+f2.getPath());
		System.out.println("AbsolutePath: "+f2.getAbsolutePath());
		
		
		
		

	}

}
