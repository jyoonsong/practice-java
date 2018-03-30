package section02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileSort {
	
	static String [] name = new String [1000]; //그냥 충분히 크게 (나중)
	static String [] number = new String [1000];
	static int count = 0;

	public static void main(String[] args) {
		String fileName = "input.txt";
		try {
			Scanner inFile = new Scanner( new File(fileName) );
			
			while (inFile.hasNext()) { //Scanner가 제공하는 함수. 읽을 게 남아 있는지 체
				name[count] = inFile.next();
				number[count] = inFile.next();
				count++;
			}
			inFile.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("No File");
			System.exit(9);
		}
		
		bubbleSort();
	
		for (int i=0; i<count; i++)
			System.out.println("Name: " + name[i] + ", Phone: " + number[i]);
	}
	
	static void bubbleSort() {
		for (int i=count-1; i>0; i--) {
			for (int j=0; j<i; j++) {
				if ( name[j].compareTo( name[j+1] ) > 0  ) {
					String tmp = name[j];
					name[j] = name[j+1];
					name[j+1] = tmp;
					
					tmp = number[j];
					number[j] = number[j+1];
					number[j+1] = tmp;
				}
			}
		}
	}
}
