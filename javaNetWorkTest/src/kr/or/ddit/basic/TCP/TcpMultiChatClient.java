package kr.or.ddit.basic.TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TcpMultiChatClient {

	public static void main(String[] args) {
		new TcpMultiChatClient().clientStart();

	}
	
	//시작메서드
	public void clientStart() {
		Socket socket = null;
		try {
			String serverIp ="192.168.34.41";
			socket = new Socket(serverIp, 7777);
			System.out.println("서버에 연결되었습니다.");
			System.out.println();
			
			//메세지 전송용 스레드와 수신용 스레드를 실행시킨다.
			ClientSender sender = new ClientSender(socket);
			ClientRecriver recriver = new ClientRecriver(socket);
			
			sender.start();
			recriver.start();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	} //clientStart() 메서드 끝...
	
	//  --------------------------------------------
	//메시지 전송용 쓰레드
	class ClientSender extends Thread{
		private Socket socket;
		private DataInputStream dis;
		private DataOutputStream dos;
		
		private String name;
		private Scanner scan;
		
		//생성자
		public ClientSender(Socket socket) {
				this.socket = socket;
				scan = new Scanner(System.in);
			
		
			try {
				dis= new DataInputStream(this.socket.getInputStream());
				dos= new DataOutputStream(this.socket.getOutputStream());
				
				if(dis != null) {
					//처음클라이언트가 실행되면 자신의 대화명(이름)을 서버로 전송하고
					//대화명의 중복여부를 feedBack으로 받아서 확인한다.
					do {
						System.out.println("대화명: ");
						String name = scan.nextLine();
						
						dos.writeUTF(name); //대화명 전송
						
						//대화명 중복여부(feedBack)를 받는다.
						String feedback = dis.readUTF();
						if("이름중복".equals(feedback)) {
							//대화명이 중복될때..
							System.out.println(name+"은 이름이 중복됩니다.");
							System.out.println("다른 대화명을 입력하세요.");
						}else {
							//중복되지 않을때 
							this.name = name;
							System.out.println(name+" 이름으로 대화방에 입장했습니다.");
							break;  //반복문 탈출
						}
						
					}while(true);
					
				}
				
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		
		} //생성자 끝...
		
		@Override
		public void run() {
			try {
				while(dos != null) {
					//키보드로 입력한 내용을 서버로 전송한다.
					dos.writeUTF("["+ name +"] "+ scan.nextLine());
					
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}
	
	//  -------------------------------------------
	
	// 메시지 수신용 스레드
	class ClientRecriver extends Thread{
		private Socket socket;
		private DataInputStream dis;
		
		//생성자
		public ClientRecriver(Socket socket) {
			this.socket = socket;
			
			try {
				dis= new DataInputStream(this.socket.getInputStream());
			} catch (Exception e) {
				// TODO: handle exception
			}
		}//생성자 끝...
		
		@Override
		public void run() {
			try {
				while(dis != null) {
					System.out.println(dis.readUTF());
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		
	}
	

}












