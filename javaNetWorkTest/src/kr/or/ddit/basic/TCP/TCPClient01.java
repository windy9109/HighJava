package kr.or.ddit.basic.TCP;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient01 {
	 public static void main(String[] args) throws IOException {
		//현재 자신 컴퓨터를 나타내는 방법
		//  1) 원래의 IP주소: 예) 192.168.34.2
		// 	2) 지정된 IP주소: 127.0.0.1
		//  3) 원래의 컴퓨터이름: 예) SEM
		//  4) 지정된 컴퓨터이름: localhost
		 
		 //원래 IP주소 삽입
		 //IP 번호 192.168.34.40의 7777포트번호로 신호를 보낸다는뜻.
		 Socket socket = new Socket("192.168.34.40", 7777);
		 //이부분은 서버와 연결이 완료된 이후에 실행되는 코드이다.
		 System.out.println("서버에 연결되었습니다...");
		 System.out.println();
		 
		 
		 //서버에서 보낸메세지를 받아서 화면에 출력하기
		 InputStream is = socket.getInputStream();
		 DataInputStream dis = new DataInputStream(is);
		 
		 //서버가 보낸 데이터 받아서 출력
		 System.out.println("서버에서 보낸 메세지: "+dis.readUTF());
		 System.out.println();
		 
		 System.out.println("연결을 종료합니다....");
		 dis.close();
		 socket.close();
		 
		 
		 
		 
		 
	}
}
