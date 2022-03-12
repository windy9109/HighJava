package test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {

	public static void main(String[] args) {
		
		try {
			FileInputStream input = new FileInputStream("d:/d_other/펭귄.jpg");
			FileOutputStream output = new FileOutputStream("d:/d_other/펭귄_copy.jpg");
			
			int c;
			while((c = input.read()) != -1) {
				output.write(c);
			}
			input.close();
			output.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
