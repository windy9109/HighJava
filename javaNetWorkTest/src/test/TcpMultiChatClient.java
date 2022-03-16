package test;

import java.io.DataInputStream;
import java.net.Socket;

public class TcpMultiChatClient {

	public static void main(String[] args) {
		

	}

	//시작메서드
	public void clientStart() {
		Socket socket = null;
		try {
			String serverIp = "localhost";
			socket = new Socket(serverIp, 7777);
			System.out.println("서버에 연결되었습니다.");
			System.out.println();
			
			//메세지 전송용 스레드와 수신용 스레드를 실행시킨다.
			//ClientSender sender = new ClientSender(socket);
			ClientRecriver recriver = new ClientRecriver(socket);
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	
}


//----------------------------------------------------

//메세지 수신용 스레드
class ClientRecriver extends Thread{
	private Socket socket;
	private DataInputStream dis;
	
	//생성자
	public ClientRecriver(Socket socket) {
		this.socket = socket;
		try {
			dis = new DataInputStream(this.socket.getInputStream());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	
}









