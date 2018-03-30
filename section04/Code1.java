package section01;

public class Code1 {

	public static void main(String[] args) {
		
		Person1 first;
		first = new Person1(); // object
		
		first.name = "John";
		first.number = "010-1525-4502";
		
		System.out.println(first.name + " " + first.number);
		
		Person1 [] members = new Person1 [10];
		members[0] = first;
		members[1] = new Person1();
	}

}
