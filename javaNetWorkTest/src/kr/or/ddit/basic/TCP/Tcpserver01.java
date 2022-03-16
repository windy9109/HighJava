package kr.or.ddit.basic.TCP;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Tcpserver01 {

	public static void main(String[] args) throws IOException{
		// tcp소켓 통신을 하기 위해 ServerSocket객체를 생성한다.
		ServerSocket server = new ServerSocket(7777);
		System.out.println("접속을 기다립니다...");
		
		//accept()메서드
		// 		==> 클라이언트의 연결요청이 올때까지 계속 기다린다.
		//		==> 연결요청이 오면 새로운 Socket객체를 생성해서 클라이언트의 Socket과 연결하여 반환한다.
		
		Socket socket = server.accept();
		//accept() 메서드 이후의 소스는 연결이 완료되어야만 실행된다.
		System.out.println("클라이언트와 연결되었습니다.");
		System.out.println();
		
		System.out.println("접속된 상대방의 정보");
		System.out.println("IP주소: "+socket.getInetAddress().getHostAddress());
		System.out.println("port번호: "+ socket.getPort());
		System.out.println();
		
		System.out.println("접속된 현재 컴의 정보");
		System.out.println("IP주소: "+socket.getLocalAddress());
		System.out.println("Port번호: "+socket.getLocalPort());
		System.out.println();
		
		//클라이언트에게 메세지 보내기
		//socket의 outputStream객체를 구성하여 전송한다.
		//socket의 getOutputStream() 메서드를 이용한다.
		OutputStream out = socket.getOutputStream();
		DataOutputStream dos = new DataOutputStream(out);
		
		//클라이언트에게 메시지 전송하기(소켓에서 쓰기 작업 진행한다.)
		dos.writeUTF("환영합니다. 어서오세요.");
		System.out.println("메세지를 보냈습니다...");
		
		// 소켓과 스트림 닫기
		dos.close();
		socket.close();
		server.close();
		
		
		
	}

}








