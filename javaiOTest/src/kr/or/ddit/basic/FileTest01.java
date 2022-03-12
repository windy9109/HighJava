package kr.or.ddit.basic;

import java.io.File;

public class FileTest01 {

	public static void main(String[] args) {
		//File객체 만들기 연습
		//1. new File(String 파일명 또는 경로)
		// ==> 파일 또는 경로를 나타낼때 디렉토리와 데렉토리 사이 또는 
		//디렉토리와 파일명 사이의 구분 문자로 '/'를 사용하거나 '\'를 사용할 수 있다.
		
		//File file1 = new File("d:/d_other/test.txt"); //구분문자로 '/'사용
		File file1 = new File("D:\\D_Other\\test.txt"); //구분문자로 '\'사용
		
		System.out.println("파일명: "+file1.getName());
		System.out.println("파일인가? ==> "+ file1.isFile());
		System.out.println("폴더인가? => "+file1.isDirectory());
		System.out.println();
		
		File file2 = new File("d:/d_other");  //디렉토리 정보만 가지고 있는 File객체
		System.out.println("파일명: "+file2.getName());
		System.out.println("파일인가? ==> "+ file2.isFile());
		System.out.println("폴더인가? => "+file2.isDirectory());
		System.out.println();
		
		//2. new File(File parent, String child)
		// ==> 'parent' 디렉토리(폴더) 안에있는 'child'파일을 갖는 File 객체
		File file3 = new File(file2, "text.txt");
		System.out.println("파일명: "+file3.getName());
		System.out.println("파일인가? ==> "+ file3.isFile());
		System.out.println("폴더인가? => "+file3.isDirectory());
		System.out.println();
		
		
		//3. new File(String parent, String child)
		// ==> 'parent' 디렉토리(폴더) 안에있는 'child'파일을 갖는 File 객체
		File file4 = new File("d:/d_other","test.txt");
		System.out.println("파일명: "+file4.getName());
		System.out.println("파일인가? ==> "+ file4.isFile());
		System.out.println("폴더인가? => "+file4.isDirectory());
		System.out.println();
		
		// 디렉토리(폴더) 만들기
		/*
		 * - mkdir() ==> File객체의 경로 중에서 마지막 위치의 디렉토리를 생성한다.
		 * 		반환값 => 만들기 성공: true, 만들기 실패: false
		 * 			 ==> 중간부분의 경로가 모두 만들어져 있어야 마지막 위치의 경로를 만들수있다.
		 * - mkdirs() ==> 중간부분의 경로가 없으면 중간 부분의 경로도 같이 만들어준다.
		 * 
		 * 
		*/
		File file5 = new File("d:/d_other/연습용"); //존재하지 않는 파일
		/*
		 * System.out.println("파일명: "+file5.getName()); System.out.println("파일인가? ==> "+
		 * file5.isFile()); System.out.println("폴더인가? => "+file5.isDirectory());
		 * System.out.println();
		 */
		System.out.println(file5.getName()+"의 존재여부: "+ file5.exists());
		
		//만약 존재하지 않는다면 디렉토리를 새로만든다. 
		if(!file5.exists()) {
			if(file5.mkdir()) {
				System.out.println(file5.getName()+"폴더 만들기 성공!!");
			}else {
				System.out.println(file5.getName()+"폴더 만들기 실패!!");
			}
		}
		System.out.println();
		
		File file6 = new File ("d:/d_other/test/java/src");			
		if(file6.mkdirs()){
			System.out.println("만들기성공 ---");
		}else {
			System.out.println("만들기 실패@@@");
		}
		
		
			
		
		
	}

}










