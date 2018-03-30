package section02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileInput {

	public static void main(String[] args) {
		String fileName = "input.txt";
		String [] name = new String [1000]; //그냥 충분히 크게 (나중)
		String [] number = new String [1000];
		int count = 0;
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
	
		for (int i=0; i<count; i++)
			System.out.println("Name: " + name[i] + ", Phone: " + number[i]);
	}
}
