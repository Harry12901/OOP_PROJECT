import java.util.Scanner;
public class Person {
	
	Scanner sc = new Scanner(System.in);
	String name;
	int age;
	String sex;
	long aadhar;
	String address;
	public Person(String n, int a, String sx, long aad, String addr )
	{
		name = n;
		age = a;
		sex = sx;
		aadhar = aad;
		address = addr;
	}
	public Person()
	{
		System.out.println("Enter Name:");
		String n = sc.nextLine();
		String numRegex   = ".*[0-9].*";
		while(n.matches(numRegex))
		{
			System.out.println("Name cannot contain number. \n Try again. \n");
			n = sc.nextLine();
		}
		name = n;
		
		System.out.println("Enter Age: ");
		int a = Integer.parseInt(sc.nextLine());
		while(a>85 || a<15)
		{
			System.out.println("Age cannot exceede 85 or be less than 15. \n Try again. \n");
			a = Integer.parseInt(sc.nextLine());
		}
		age = a;
		
		System.out.println("Enter Sex [F/M/X] : ");
		String s = sc.nextLine() ;
		while(!(s.equalsIgnoreCase("F")||s.equalsIgnoreCase("M")||s.equalsIgnoreCase("X")))
		{
			System.out.println("Invalid Entry. Enter F, M or X for Female, Male or Non-Binary. \n Try again. \n");
			s = sc.nextLine();
		}
		sex = s;
		
		
		
		System.out.println("Enter Aadhar: ");
		String aadc = sc.nextLine();
		String alphaRegex = ".*[A-Z].*";
		while(aadc.matches(alphaRegex) || aadc.length()!=10)
		{
			System.out.println("Invalid Entry. Aadhar Number must be 10 digits with no alphabets. \n Try again. \n");
			aadc = sc.nextLine();
		}
		aadhar = Long.parseLong(aadc);
		
		System.out.println("Enter Adress: ");
		String addr = sc.nextLine();
		address = addr;
	}

}