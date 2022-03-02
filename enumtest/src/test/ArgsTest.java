package test;

public class ArgsTest {
	
	
	public int sumArr(int...data) {
		int sum = 0;
		for(int i=0; i< data.length; i++) {
			sum += data[i];
		}
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArgsTest test = new ArgsTest();
		
		
		System.out.println(test.sumArr(100,20,300));

	}

}
