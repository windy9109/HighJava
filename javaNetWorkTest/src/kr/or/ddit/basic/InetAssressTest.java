package kr.or.ddit.basic;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAssressTest {

	public static void main(String[] args) throws UnknownHostException {
		// InetAddress 클래스 ==> IP주소를 다루기 위한 클래스
		//cmd => ipconfig 명령어와 같음
		
		// www.naver.com 의 IP정보 가져오기
		InetAddress ip = InetAddress.getByName("www.naver.com");
		System.err.println("HostName: "+ip.getHostName());
		System.out.println("HostAddress: "+ip.getHostAddress());
		System.out.println("toString: "+ip.toString());
		System.out.println();
		
		//자신의 컴퓨터의 IP정보 가져오기
		InetAddress localIp = InetAddress.getLocalHost();
		System.out.println("HostName: "+localIp.getHostName());
		System.out.println("내컴의 HostAddress: "+localIp.getHostAddress());
		System.out.println();
		
		//IP주소가 여러개인 호스트의 정보 가져오기
		InetAddress[] multiIp = InetAddress.getAllByName("www.naver.com");
		for(InetAddress ips: multiIp) {
			System.out.println(ips.toString());
		}
		
		
		
	}

}
