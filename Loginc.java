import java.util.ArrayList;
import java.util.Scanner;

public class Loginc {
static ArrayList<User> userlist = new ArrayList<User>();
static int id;
public static void listusers()
{
	System.out.println("--------------------------");
	System.out.println();
	System.out.println("List of Users : \n");
	for(int i = 0;i<userlist.size();i++){
	listuser(i);		
	}
}
public static void listuser(int x)
{
	int i= x;
		System.out.print("\n ACCOUNT INFO \n");
		System.out.print("Username : ");
		System.out.println(userlist.get(i).username);
		System.out.print("Password : ");
		System.out.println(userlist.get(i).password);
		System.out.print("Authorization : ");
		System.out.println(userlist.get(i).authorization);
		System.out.print("\n PERSONAL INFO \n");
		System.out.print("Name: ");
		System.out.println(userlist.get(i).name);
		System.out.print("Age: ");
		System.out.println(userlist.get(i).age);
		System.out.print("Sex: ");
		System.out.println(userlist.get(i).sex);
		System.out.print("Aadhar: ");
		System.out.println(userlist.get(i).aadhar);
		System.out.print("Address: ");
		System.out.println(userlist.get(i).address);			
	}
	
	public static void modify(String chu)
	{
		Scanner s = new Scanner(System.in);
		int flag = -1;
		int x = search(chu);
		System.out.println("Modify username (1) or (2) password (3) authorization ?");
		int c = Integer.parseInt(s.nextLine());
		String y = null;
		switch(c)
		{
			case 1: System.out.println("Enter new username");
					y = s.nextLine();
					if(search(y)==-1)
					{
						if(y.length()>=6) {
							flag = 1;
						}
					}
					break;
			case 2: System.out.println("Enter new password");
					if(y.length()>=6)
					{
						String numRegex   = ".*[0-9].*";
						String alphaRegex = ".*[A-Z].*";
							if (y.matches(numRegex) && y.matches(alphaRegex)) 
							{
								flag = 1;
							}
					}
					break;
			case 3: try {
				        int d = Integer.parseInt(y);
				    } catch (NumberFormatException nfe) {
				        flag = -1;
				    }
				    flag = 1;
				    break;
		}
		if(flag == 1) {
			userlist.get(x).modify(c, y);
			}
		s.close();
	}
	
	
	public static void delete(String chu)
	{
		// PLEASE MAKE SURE USERNAME EXISTS BEFORE CALLING THIS FUNCTION !!
		int x = search(chu);
		if(x!=-1)
		{
			userlist.remove(x);
			System.out.println("USER DELETED");
		}
		else
			System.out.println("USERNAME DOES NOT EXIST");
	}
	
	
	public static int search(String chu)
	{
		for(int i = 0; i < userlist.size(); i++)
		{
			if(userlist.get(i).getusn().equals(chu))
					return i;
		}
		return -1;
	}
	
	
	public static boolean signin(String chu, String chp)
	{
		int x= search(chu);
		if(x!=-1){
			if((userlist.get(x).getpwd()).equals(userlist.get(x).hash(chp)))
			{
				return true;
			}
			else return false;
		}
		else return false;
	}
	
	
	public static boolean isNumeric(String str) { 
		  try {  
		    Double.parseDouble(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
		}
	
	
	static boolean signup(String chu, String chp)
	{

		Scanner s = new Scanner(System.in);
		if(chu!= null && chp!= null)
		{
			if(chu.length()>=6 && chp.length()>=6)
			{
				if(search(chu)==-1)
				{
					String numRegex   = ".*[0-9].*";
					String alphaRegex = ".*[A-Z].*";

					if (chp.matches(numRegex) && chp.matches(alphaRegex)) 
					{
						System.out.println("+------------------------------------------------+");
						System.out.println("|                 ENTER AUTHORIZATION            |");
						System.out.println("|                [NORMAL USERS ENTER 0]          |");
						System.out.println("+------------------------------------------------+");
						int au = Integer.parseInt(s.nextLine());
						if(au>=0 && au<=3)
						{
						userlist.add(new User(chu,chp,au));

						System.out.println("+------------------------------------------------+");
						System.out.println("|       USER ACCOUNT CREATED SUCCESSFULLY!       |");
						System.out.println("+------------------------------------------------+");
						return true;
						}
						else
						{
							System.err.println("+------------------------------------------------+");
							System.err.println("|  					INVALID                      |");
							System.err.println("|				 AUTHORIZATION                   |");
							System.err.println("+------------------------------------------------+");
							return false;
						}
					}
					else {

						System.err.println("+------------------------------------------------+");
						System.err.println("|  PASSWORD NEEDS TO BE LONGER THAN SIX DIGITS   |");
						System.err.println("|AND MUST CONTAIN NUMBERS AND UPPERCASE ALPHABETS|");
						System.err.println("+------------------------------------------------+");
						return false;
					}

				}
				else {

					System.err.println("+------------------------------------------------+");
					System.err.println("|      USERNAME ALREADY IN USE, TRY AGAIN.       |");
					System.err.println("+------------------------------------------------+");
					return false;
					}
			}
			else {

				System.err.println("+------------------------------------------------+");
				System.err.println("|           PASSWORD AND USERNAME                |");
				System.err.println("|     NEEDS TO BE LONGER THAN SIX DIGITS         |");
				System.err.println("+------------------------------------------------+");
				return false;
				}
		}
		else {

			System.err.println("+------------------------------------------------+");
			System.err.println("|              PASSWORD AND USERNAME             |");
			System.err.println("|                 CANNOT BE NULL                 |");
			System.err.println("+------------------------------------------------+");
			return false;
			}
	}
}
