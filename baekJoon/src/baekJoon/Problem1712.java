package baekJoon;

import java.util.Scanner;

public class Problem1712 {

	public static void main(String[] args) {


		

	
		      Scanner sc = new Scanner(System.in);
		      long a = sc.nextInt(); //고정비용
		      long b = sc.nextInt(); //가변비용
		      long c = sc.nextInt(); //가격
		     
		      sc.close();
		      

		      
		    //고정비용+가변비용 < 총수입 => 손익분기발생
		    
		    //고정비용+가변비용
		     int count = 1;
		      


	        	  
    	  out: for(int i= 1; a+(b*i) >= c*i; i++ ) {
	            if(Integer.MAX_VALUE < i) {
	            	break out;
	            }
	            count++;
	            
    	  }
    	  if(count == Integer.MAX_VALUE) {
    		  count = -1;
    	  }
		      System.out.println(count);
		    }

	

}
