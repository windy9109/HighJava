package util;

import java.util.Arrays;

public class keyPressed {
	
	
	public static String[] LRkey(String key[], String menu[]) {
	
		String keyInput = null;
		
		for(int i = 0; i < key.length; i++ ) {
			System.out.print(key[i] + menu[i] + "  ");
		}
			
		keyInput = ScanUtil.nextLine();
		int keyIndex = Arrays.asList(key).indexOf("●");
		switch (keyInput) {
		case "\t": //왼쪽
			if(keyIndex == 0) {
				key[0] = " ";
				key[key.length-1] = "●";
			}else {					
				key[keyIndex] = " ";
				key[keyIndex-1] = "●";
			}
			break;
		case "\t\t": //오른쪽
			if(keyIndex == key.length-1) {
				key[0] = "●";
				key[key.length-1] = " ";
			}else {
				key[keyIndex] = " ";
				key[keyIndex+1] = "●";
			}
			break;
		case "":
			key[0] = Integer.toString(Arrays.asList(key).indexOf("●")+1);
			break;
		}
		
		return key;
		//return Arrays.asList(key).indexOf("●")+1;
	}
	
	
public static String[] LRkey(String key[]) {
		
		String keyInput = ScanUtil.nextLine();
		int keyIndex = Arrays.asList(key).indexOf("●");
		switch (keyInput) {
		case "\t": //왼쪽
			if(keyIndex == 0) {
				key[0] = " ";
				key[key.length-1] = "●";
			}else {					
				key[keyIndex] = " ";
				key[keyIndex-1] = "●";
			}
			break;
		case "\t\t": //오른쪽
			if(keyIndex == key.length-1) {
				key[0] = "●";
				key[key.length-1] = " ";
			}else {
				key[keyIndex] = " ";
				key[keyIndex+1] = "●";
			}
			break;
		case "":
			key[0] = Integer.toString(Arrays.asList(key).indexOf("●")+1);
			break;
		}
		
		return key;
		//return Arrays.asList(key).indexOf("●")+1;
	}


	public static String[] UDkey(String key[]) {
	
	String keyInput = ScanUtil.nextLine();
	int keyIndex = Arrays.asList(key).indexOf("●");
	switch (keyInput) {
	case "\t\t\t": //위
		if(keyIndex == 0) {
			key[0] = " ";
			key[key.length-1] = "●";
		}else {					
			key[keyIndex] = " ";
			key[keyIndex-1] = "●";
		}
		break;
	case "\t\t\t\t": //아래
		if(keyIndex == key.length-1) {
			key[0] = "●";
			key[key.length-1] = " ";
		}else {
			key[keyIndex] = " ";
			key[keyIndex+1] = "●";
		}
		break;
	case "":
		key[0] = Integer.toString(Arrays.asList(key).indexOf("●")+1);
		break;
	}
	
	return key;
	//return Arrays.asList(key).indexOf("●")+1;
	}
public static String[][] LRUDkey(String key[][]) {
		
		String keyInput = ScanUtil.nextLine();
		int keyIndex_x = 0;
		int keyIndex_y = 0;
		for(int i = 0; i < key.length ; i++) {
			if(Arrays.asList(key[i]).indexOf("●") != -1) {
				keyIndex_x = i;
				keyIndex_y = Arrays.asList(key[i]).indexOf("●");
			}
		}
		switch (keyInput) {
		case "\t": //왼쪽
			if(keyIndex_x ==0 && keyIndex_y == 0) {
				key[0][0] = " ";
				key[key.length-1][key[key.length-1].length-1] = "●";
				
			}else if(keyIndex_x !=0 && keyIndex_y == 0) {
				key[keyIndex_x][0] = " ";
				key[keyIndex_x-1][key[keyIndex_x-1].length-1] = "●";
				
			}else {					
				key[keyIndex_x][keyIndex_y] = " ";
				key[keyIndex_x][keyIndex_y-1] = "●";
			}
			break;
			
			
		case "\t\t": //오른쪽
			if(keyIndex_x == key.length -1 && keyIndex_y == key[keyIndex_x].length-1) {
				key[keyIndex_x][keyIndex_y] = " ";
				key[0][0] = "●";
			}else if(keyIndex_x != key.length -1 && keyIndex_y == key[keyIndex_x].length-1){
				key[keyIndex_x][keyIndex_y] = " ";				
				key[keyIndex_x+1][0] = "●";
			}else {
				key[keyIndex_x][keyIndex_y] = " ";	
				key[keyIndex_x][keyIndex_y+1] = "●";
			}
			break;
			
			
		case "\t\t\t": //위
			if(keyIndex_x == 0 && keyIndex_y <= key[key.length-1].length-1 )  {
				key[0][keyIndex_y] = " ";
				key[key.length-1][keyIndex_y] = "●";

		}else if(keyIndex_x == 0 && keyIndex_y > key[key.length-1].length-1 ) { //위에있는 x줄의 ㅣength보다 큰 경우
			key[keyIndex_x][keyIndex_y] = "●";
		}else if(keyIndex_y > key[keyIndex_x-1].length-1 ) { //위에있는 x줄의 ㅣength보다 큰 경우
			key[keyIndex_x][keyIndex_y] = "●";
			}else {					
				key[keyIndex_x][keyIndex_y] = " ";
				key[keyIndex_x-1][keyIndex_y] = "●";
			}
			break;
			
			
		case "\t\t\t\t": //아래
			if(keyIndex_x == key.length-1) {
				key[keyIndex_x][keyIndex_y] = " ";
				key[0][keyIndex_y] = "●";
				
			}else if(keyIndex_y > key[keyIndex_x+1].length-1) {
				key[keyIndex_x][keyIndex_y] = "●";
				
			}else {					
				key[keyIndex_x][keyIndex_y] = " ";
				key[keyIndex_x+1][keyIndex_y] = "●";
			}
			break;	
			
			
			
			
			
			
		case "":
			int num = 0;
			for(int i = 0; i <keyIndex_x ; i++) {
				if(keyIndex_x != 0 && i==0) {
					num += key[i].length;
				}
				num += i * key[i].length;
			}
			num += keyIndex_y;
			key[0][0] = Integer.toString(num+1);
			break;
		}
		
		return key;
		//return Arrays.asList(key).indexOf("●")+1;
	}
}