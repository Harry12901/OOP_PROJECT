import java.util.ArrayList;
import java.util.Scanner;
public class Main {

	static Scanner input;
//
//ADD	
	
	static void aroad()
	{
		input = new Scanner(System.in);
		System.out.println("ADD ROAD");
		  System.out.println("--------------------------");
	      System.out.println();
	      System.out.println("Enter Road ID : ");
	      int RID = input.nextInt();
	      System.out.println("Enter Road Name : ");
	      String Name = input.next();
	      System.out.println("Enter Length : ");
	      double Length = input.nextDouble();
	      Controller.addRoad(RID,Name,Length);
	      System.out.println("Road added successfully");
	      System.out.println();
	      System.out.println("--------------------------");
	     // Controller.listRoads();
	}
	
	static void ajunction()
	{
		input = new Scanner(System.in);
		System.out.println("ADD JUNCTION");
	      System.out.println("--------------------------");
	        System.out.println();
	        System.out.println("Enter Junction ID : ");
	        int JID = input.nextInt();
	        System.out.println("Enter Junction Name : ");
	        String jName = input.next();
	        System.out.println("Enter Junction Type : ");
	        String Type = input.next();
	        System.out.println("Enter Number of Roads Connecting : ");
	        ArrayList<Road> conn_roads = new ArrayList<>();
	        int n = input.nextInt();
	        int i = 0;
	        while(i<n){
	            System.out.println("Enter Road ID : ");
	            int jRID = input.nextInt();
	            Road road = Controller.return_road(jRID);
	            if(road == null){
	                System.out.println("Road does not exist. Try again...");
	            }
	            else{
	                conn_roads.add(road);
	                i++;
	            }

	        }
	        
	       Controller.addJunction(JID, jName, Type, conn_roads);
	       System.out.println("Junction added successfully");
	        System.out.println();
	        System.out.println("--------------------------");
	      // Controller.listJunctions();
	}
	
	
	static void astation()
	{
		input = new Scanner(System.in);
		  System.out.println("ADD POLICE STATION");
	        
	      System.out.println("--------------------------");
	      System.out.println();
	      System.out.println("Enter Station ID : ");
	      int SID = input.nextInt();
	      System.out.println("Enter Station Name : ");
	      String sName = input.next();
	      System.out.println("Enter Pin Code : ");
	      int pinCode = input.nextInt();
	      System.out.println("Enter Initial Number of Personnel : ");
	      ArrayList<Traffic_Police> police = new ArrayList<>();
	      int sn = input.nextInt();
	      int si = 0;
	      while(si<sn){
	          /*System.out.println("Enter Police ID : ");
	          int PID = input.nextInt();*/
	    	  
	    	  System.out.println("ADD POLICE");
		       System.out.print("Enter Police ID : ");
		        int PID = input.nextInt();
		        System.out.print("Enter Name : ");
		        String pName = input.next();
		        System.out.print("Enter Age : ");
		        int age = input.nextInt();
		        System.out.print("Enter Salary : ");
		        int salary = input.nextInt();
		        System.out.print("Enter Years Of Experience : ");
		        int yoe = input.nextInt();
		        System.out.print("Enter Address : ");
		        String address = input.next();
	          Traffic_Police police1 = Controller.addPolice(PID, pName, age, salary, yoe, address);
	         
//          System.out.println("--------------------------");
//	        System.out.println();
//	        System.out.print("Enter Police Station ID : ");
//	        int listpSID = input.nextInt();
//	        Controller.listPolice(listpSID);
	          
	          
	          /*if(police1 == null){
	              System.err.println("Personnel does not exist. Try again...");
	          }
	          else*/
	          //{
	              police.add(police1);
	              si++;
	          //}

	      }

	      System.out.println("Enter Number of Junctions Under Control : ");
	      ArrayList<Junction> junctions = new ArrayList<>();
	      int m = input.nextInt();
	      si = 0;
	      while(si<m){
	          System.out.println("Enter Junction ID : ");
	          int sJID = input.nextInt();
	          Junction jn = Controller.return_jn(sJID);
	          if(jn == null){
	              System.out.println("Junction does not exist. Try again...");
	          }
	          else{
	              junctions.add(jn);
	              si++;
	          }

	      }
	      Controller.addPoliceStation(SID, sName, police, junctions, pinCode);
	      System.out.println("Police Station added successfully");
	        System.out.println();
	        System.out.println("--------------------------");
}
	
static void apolice()
{
	input = new Scanner(System.in);
	System.out.println("ADD POLICE");
    System.out.print("Enter Police ID : ");
     int PID = input.nextInt();
     System.out.print("Enter Name : ");
     String pName = input.next();
     System.out.print("Enter Age : ");
     int age = input.nextInt();
     System.out.print("Enter Salary : ");
     int salary = input.nextInt();
     System.out.print("Enter Years Of Experience : ");
     int yoe = input.nextInt();
     System.out.print("Enter Address : ");
     String address = input.next();
     Controller.addPolice(PID, pName, age, salary, yoe, address);
    // Controller.listPolice(1111);
}
//DELETE
static void djunction()
{
	input = new Scanner(System.in);
	System.out.println("--------------------------");
    System.out.println();
    System.out.print("Enter Junction ID : ");
    int JID = input.nextInt();
    Junction jn = Controller.return_jn(JID);

    if(jn == null){
        System.err.println("Junction does not exist");
    }
    else{
    	Controller.deleteJunction(jn);        
    }
    System.out.println();
    System.out.println("--------------------------");
	
}

static void droad()
{
	input = new Scanner(System.in);
	System.out.println("--------------------------");
    System.out.println();
    Scanner input = new Scanner(System.in);
    System.out.print("Enter Road ID : ");
    int RID = input.nextInt();
    input.close();
    Road rd = Controller.return_road(RID);

    if(rd == null){
        System.err.println("Road does not exist");
    }
    else{
        Controller.deleteRoad(rd);
    }
    System.out.println();
    System.out.println("--------------------------");
	
}

// static void dpolice()
// {
// 	input = new Scanner(System.in);
// 	 System.out.println("--------------------------");
//      System.out.println();
//      System.out.print("Enter Police Station ID : ");
//      int SID = input.nextInt();
//      Police_Station ps = Controller.return_police_station(SID);
//      if(ps == null){
//          System.err.println("Police Station does not exist");
//      }
//      else{
//          System.out.println("Enter Police ID : ");
//          int pid = input.nextInt();
//          Traffic_Police police = Controller.return_police(ps,pid);
//          if(police == null){
//              System.out.println("Traffic Police does not exist");
//          }
//          else{
//              ps.Personnel.remove(police);
//          }
//          System.out.println("Police Successfully deleted");
//      }
//      System.out.println();
//      System.out.println("--------------------------");
// }

static void dstation()
{
	input = new Scanner(System.in);
	System.out.println("--------------------------");
    System.out.println();
    Scanner input = new Scanner(System.in);
    System.out.print("Enter Police Station ID : ");
    int SID = input.nextInt();
    input.close();
    Police_Station ps = Controller.return_police_station(SID);

    if(ps == null){
        System.err.println("Police Station does not exist");
    }
    else{
    	Controller.deletePoliceStation(ps);
    }
    System.out.println();
    System.out.println("--------------------------");
}


//
//ADD
static void avehicle()
{
	input = new Scanner(System.in);
	System.out.println("ADD VEHICLE");
  	System.out.println("--------------------------");
    System.out.println();
    System.out.println("Enter Name : ");
    String name = input.next();
    System.out.println("Enter Registration number : ");
    String regno = input.next();
    Controller.addVehicle(name,regno);
    System.out.println("Vehicle added successfully");
    System.out.println();
    System.out.println("--------------------------");
}

static void aviolation()
{
	input = new Scanner(System.in);
	 System.out.println("--------------------------");
     System.out.println();
     System.out.println("Enter Violation ID : ");
     int VID = input.nextInt();
     System.out.println("Enter Registration number : ");
     String regno = input.next();
     System.out.println("Enter Speed : ");
     double speed = input.nextDouble();
     System.out.println("Enter Reason : ");
     String reason = input.next();
     System.out.println("Enter Penalty amount : ");
     double penalty = input.nextDouble();
     
     System.out.println("Enter Road ID : ");
     int RID = input.nextInt();
     Road r = Controller.return_road(RID);
     if(r == null){
         System.err.println("Road does not exist"); 
        }
     else
     {
     	System.out.println("Enter Station ID : ");
         int SID = input.nextInt();
         Police_Station ps = Controller.return_police_station(SID);
         if(ps == null){
             System.err.println("Police Station does not exist");
         }
         else
         {
         	System.out.println("Enter Police ID : ");
             int PID = input.nextInt();            
             Traffic_Police police = Controller.return_police(ps,PID);
             if(police == null){
                 System.out.println("Traffic Police does not exist");
             }
             else
             {
            	 Controller.addViolation(VID, penalty, reason, regno, speed, RID, PID, SID);
            	 System.out.println("Violation entry added successfully");
                 System.out.println();
                 System.out.println("--------------------------");
             }
         }
     } 
}

static void aaccident()
{
	input = new Scanner(System.in);
	System.out.println("--------------------------");
    System.out.println();
    System.out.println("Enter Accident ID : ");
    
    int AID = input.nextInt();
    System.out.println("Enter Number of People Injured : ");
    int ni = input.nextInt();
    System.out.println("Enter Damage caused : ");
    String damage = input.next();
    System.out.println("Enter Reason : ");
    String reason = input.next();
    System.out.println("Enter Number of Vehicles : ");
 
    ArrayList<String> vehicles = new ArrayList<>();
    int nov = input.nextInt();
    int i = 0;
    while(i<nov){
        System.out.println("Enter Registration Number"+(i+1)+" : "); //check if i+1 is working
        String Regno = input.next();
        Vehicle v = Controller.return_vehicle(Regno);
        if(v == null){
            System.err.println("Vehicle does not exist. Try again...");
        }
        else{
            vehicles.add(Regno);
            i++;
        }

    }
    
    System.out.println("Enter Road ID : ");
    int RID = input.nextInt();
    Road r = Controller.return_road(RID);
    if(r == null){
        System.err.println("Road does not exist"); 
       }
    else
    {
    	System.out.println("Enter Station ID : ");
        int SID = input.nextInt();
        Police_Station ps = Controller.return_police_station(SID);
        if(ps == null){
            System.err.println("Police Station does not exist");
        }
        else
        {
        	System.out.println("Enter Police ID : ");
            int PID = input.nextInt();            
            Traffic_Police police = Controller.return_police(ps,PID);
            if(police == null){
                System.out.println("Traffic Police does not exist");
            }
            else
            {
            	Controller.addAccident(AID, damage, reason, ni, nov, vehicles, RID, PID, SID);
            	 System.out.println("Accident entry added successfully");
                 System.out.println();
                 System.out.println("--------------------------");
             }
        }
    }
}

//DELETE
static void dvehicle()
{
	input = new Scanner(System.in);
	System.out.println("--------------------------");
    System.out.println();
    System.out.print("Enter Registration Number : ");
    String Regno = input.next();
    Vehicle v = Controller.return_vehicle(Regno);

    if(v == null){
        System.err.println("Vehicle does not exist");
        System.out.println();
        System.out.println("--------------------------");
    }
    else{
    	Controller.deleteVehicle(v);
    	}
}


public static void usermg()
	{
		String u,p;
		Scanner s = new Scanner(System.in);
			System.out.println("+-------------------------------------------+");
        	System.out.println("|               MANAGE USERS                |");
        	System.out.println("+-------------------------------------------+");
        	System.out.println("+--------------+   +-----------------+  +-----------------+  +------------------+  +----------------------+");
        	System.out.println("| 1. ADD USER  |   | 2. DELETE USER  |  | 3. MODIFY USER  |  | 4. DISPLAY USER  |  | 5. DISPLAY USER LIST |");
        	System.out.println("+--------------+   +-----------------+  +-----------------+  +------------------+  +----------------------+");
		int c = Integer.parseInt(s.nextLine());
		switch(c)
		{
			case 1: 
				System.out.println("Enter username");
				u = s.nextLine();
				System.out.println("Enter password");
				p = s.nextLine();
				Loginc.signup(u,p);
				u = null;
				p = null;
				break;
			case 2: 
				System.out.println("Enter username");
				u = s.nextLine();
				Loginc.delete(u);
				u = null;
				break;
			case 3:
				System.out.println("Enter username");
				u = s.nextLine();
				Loginc.modify(u);
				u = null;
				break;
			case 4:
				System.out.println("Enter username");
				u = s.nextLine();
				Loginc.listuser(Loginc.search(u));
				u = null;
				break;
			case 5: 
				Loginc.listusers();
				u = null;
				break;
				
		}
	}


//MAIN
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Loginc.userlist.add(new User("Admin001", "Hello123", 3, "Gomathi", 19, "F", 1234567890, "Chennai"));
		Loginc.userlist.add(new User("Police001", "Hello123", 1, "Sai Padmesh", 19, "M", 1234567800, "CBE"));
		Loginc.userlist.add(new User("User001", "Hello123", 0, "Harini", 19, "F", 1234567000, "CBE"));
		input = new Scanner(System.in);
		//Scanner input = new Scanner(System.in);
		 int c1,c2,c=0,status=0;
	       System.out.println("\t\t\t\t\t  _______         __  __ _                             \r\n"
		  		+ "\t\t\t\t\t |__   __|       / _|/ _(_)                            \r\n"
		  		+ "\t\t\t\t\t    | |_ __ __ _| |_| |_ _  ___                        \r\n"
		  		+ "\t\t\t\t\t    | | '__/ _` |  _|  _| |/ __|                       \r\n"
		  		+ "\t\t\t\t\t    | | | | (_| | | | | | | (__                        \r\n"
		  		+ "\t\t\t\t\t    |_|_|  \\__,_|_| |_| |_|\\___|        _              \r\n"
		  		+ "\t\t\t\t\t                       (_) |           (_)             \r\n"
		  		+ "\t\t\t\t\t  _ __ ___   ___  _ __  _| |_ ___  _ __ _ _ __   __ _  \r\n"
		  		+ "\t\t\t\t\t | '_ ` _ \\ / _ \\| '_ \\| | __/ _ \\| '__| | '_ \\ / _` | \r\n"
		  		+ "\t\t\t\t\t | | | | | | (_) | | | | | || (_) | |  | | | | | (_| | \r\n"
		  		+ "\t\t\t\t\t |_|_|_| |_|\\___/|_| |_|_|\\__\\___/|_|  |_|_| |_|\\__, | \r\n"
		  		+ "\t\t\t\t\t  / ____|         | |                            __/ | \r\n"
		  		+ "\t\t\t\t\t | (___  _   _ ___| |_ ___ _ __ ___             |___/  \r\n"
		  		+ "\t\t\t\t\t  \\___ \\| | | / __| __/ _ \\ '_ ` _ \\                   \r\n"
		  		+ "\t\t\t\t\t  ____) | |_| \\__ \\ ||  __/ | | | | |                  \r\n"
		  		+ "\t\t\t\t\t |_____/ \\__, |___/\\__\\___|_| |_| |_|                  \r\n"
		  		+ "\t\t\t\t\t          __/ |                                        \r\n"
		  		+ "\t\t\t\t\t         |___/ ");
		while(true)
		{
			do {
//				Loginc.listusers();
				System.out.println("    +---------------------------------------+");
				System.out.println("    |  WELCOME! PLEASE LOGIN IN OR SIGN UP  |");
				System.out.println("    +---------------------------------------+");
				
				System.out.println("+------------+    +----------+    +-----------+");
				System.out.println("| 0. EXIT    |    | 1. LOGIN |    | 2. SIGNUP |");
				System.out.println("+------------+    +----------+    +-----------+");
				System.out.println("===================================================== ");
				c = input.nextInt();
				if(c==0) 
				{
					System.out.println("THANK YOU");
					System.exit(0);
				}
					
				
				if(c == 1 || c==2)
				{
					System.out.println("+------------------------------------------------+");
					System.out.println("|             ENTER USERNAME                     |");
					System.out.println("+------------------------------------------------+");
					String x = input.next();
					System.out.println("+------------------------------------------------+");
					System.out.println("|           ENTER PASSWORD                       |");
					System.out.println("+------------------------------------------------+");
					String y = input.next();
					if(c==1)
					{
						boolean z = Loginc.signin(x,y);
						if(z)
						{
							System.out.println("+------------------------------------------------+");
							System.out.println("|                LOGIN SUCCESSFULL!              |");
							System.out.println("+------------------------------------------------+");
							status = 1;
							Loginc.id = Loginc.search(x);
						}
						else {
							System.err.println("+------------------------------------------------+");
							System.err.println("|          INVALID USERNAME OR PASSWORD          |");
							System.err.println("+------------------------------------------------+");
							status = 0;
						}
					}
					else if(c == 2)
					{
					 //boolean ret = Loginc.signup(x,y);
					Loginc.signup(x,y);
					status=0;
					}
				else {
					System.err.println("+------------------------------------------------+");
					System.err.println("|          INVALID INPUT. TRY AGAIN.             |");
					System.err.println("+------------------------------------------------+");
					status=0;
					
				}
				}
			
			}while(status==0);
			
	//HARD CODED PART:
			
			Controller.addVehicle("Harry","1122");
			Controller.addVehicle("Corpse","2211");
			Controller.addRoad(11,"Road1",123);
			Controller.addRoad(22,"Road2",456);
			  
			  ArrayList <Road> rd = new ArrayList<>();
			  rd.add(Controller.return_road(11));
			  rd.add(Controller.return_road(22));
			  Controller.addJunction(11, "Junction1","One Way", rd);
			  
			 Traffic_Police p1=Controller.addPolice(33, "Police1",23, 10000, 2, "1c,street,NY");
			  Traffic_Police p2=Controller.addPolice(44, "Police2",54, 100000, 4, "34,AL ave,NJ");
			  
			  ArrayList <Traffic_Police> tp = new ArrayList<>();
			 tp.add(p1);
			 tp.add(p2);
			  ArrayList <Junction> jal = new ArrayList<>();
			  jal.add(Controller.return_jn(11));
			  Controller.addPoliceStation(1111, "Station1", tp, jal, 123456);
			  
//			  Controller.listVehicle();
//			  Controller.listRoads();
//			  Controller.listJunctions();
//			  Controller.listPolice(1111);
//			  Controller.listStations();
			  
	//END OF HARD CODE
		
			  int inp1,inp2 = -1; 
			while (status==1)
			{

				System.out.println("+-------------------------------------------+");
				System.out.println("|               0. LOGOUT                   |");
				System.out.println("+-------------------------------------------+");
				
				//ADMIN
				if(Loginc.userlist.get(Loginc.id).getauth() == 3)
				{
				
				System.out.println("+-------------------------------------------+");
				System.out.println("|              1. JUNCTIONS                 |");
				System.out.println("+-------------------------------------------+");
				
				System.out.println("+-------------------------------------------+");
				System.out.println("|              2. ROADS                     |");
				System.out.println("+-------------------------------------------+");
				
				System.out.println("+-------------------------------------------+");
				System.out.println("|              3. VEHICLES                  |");
				System.out.println("+-------------------------------------------+");
				
				
				System.out.println("+-------------------------------------------+");
				System.out.println("|             4. POLICE STATIONS            |");
				System.out.println("+-------------------------------------------+");
				
				
				System.out.println("+-------------------------------------------+");
				System.out.println("|             5. USERS                      |");
				System.out.println("+-------------------------------------------+");
				inp1=input.nextInt();
				
				if(inp1!=5 && inp1!=0){
				System.out.println("+------------+    +--------+    +-----------+");
				System.out.println("| 1. DISPLAY |    | 2. ADD |    | 3. DELETE |");
				System.out.println("+------------+    +--------+    +-----------+");
				inp2=input.nextInt();
				}
				switch(inp1)
				{
				case 0: 
						System.out.println("+--------------------------+");
						System.out.println("|      LOGGING OUT...      |");
						System.out.println("+--------------------------+");
						status =0;
						Loginc.id = -1;
						break;
				case 1: switch(inp2)
						{
							case 1: Controller.listJunctions();
									break;
							case 2: ajunction();
									break; 
						    	case 3: djunction();
									break;
							default:System.err.println("INVALID INPUT");		
						}
						break;
						
				case 2: switch(inp2)
				{
					case 1: Controller.listRoads();
							break;
					case 2: aroad();
							break;
					case 3: droad();
							break;	
					default:System.err.println("INVALID INPUT");		
				}
				break;	
				
				case 3: switch(inp2)
				{
					case 1: Controller.listVehicle();
							break;
					case 2: avehicle();
							break;
					case 3: dvehicle();
							break;
					default:System.err.println("INVALID INPUT");		
				}
				break;
				case 4: switch(inp2)
				{
					case 1: Controller.listStations();
						break;
					case 2: astation();
						break;
					case 3: dstation();
						break;
				}
				break;
				case 5: usermg();
					break;
				default:System.err.println("INVALID INPUT");
				}
				}
				
				
				
				
				else if(Loginc.userlist.get(Loginc.id).getauth() == 1)
				{
				//TRAFFIC POLICE
				System.out.println("+---------------------------------+                +---------------------------------+ ");
				System.out.println("|       1. ACCIDENT LOG           |                | 2. TRAFFIC VIOLATION LOG        |");
				System.out.println("+---------------------------------+                +---------------------------------+ ");
				System.out.println("======================================================================================= ");
				c1 = input.nextInt();
				if(c1 == 0)
				{
					System.out.println("+--------------------------+");
					System.out.println("|      LOGGING OUT...      |");
					System.out.println("+--------------------------+");
					status =0;
					Loginc.id = -1;
				}
				
				else if(c1 ==1||c1 ==2)
				{
//					System.out.println("+-------------------------------------------+");
//					System.out.println("|		          1. DISPLAY LOG		    |");
//					System.out.println("+-------------------------------------------+");
//					System.out.println("+-------------------------------------------+");
//					System.out.println("|		          2. ADD LOG     		    |");
//					System.out.println("+-------------------------------------------+");
//					System.out.println("+-------------------------------------------+");
//					System.out.println("|		          3. DELETE LOG  		    |");
//					System.out.println("+-------------------------------------------+");
					System.out.println("+-------------------------------------------+");
					System.out.println("|		1. DISPLAY 		    |");
					System.out.println("+-------------------------------------------+");
					System.out.println("+-------------------------------------------+");
					System.out.println("|		2. ADD 		    	    |");
					System.out.println("+-------------------------------------------+");
					System.out.println("+-------------------------------------------+");
					System.out.println("|		3. DELETE 		    |");
					System.out.println("+-------------------------------------------+");
					c2 = input.nextInt();
					if(c1==1)
					{
						switch(c2)
						{
						case 1: Controller.listAccident();
								break;
						case 2: aaccident();
								break;
						case 3: Controller.deleteAccident();
								break;
						default: System.out.println("INVALID INPUT");		
						}
					
					}
					else if (c1 == 2)
					{
						switch(c2)
						{
						case 1: Controller.listViolation();
								break;
						case 2: aviolation();
								break;
						case 3: Controller.deleteViolation();
								break;
						default: System.out.println("INVALID INPUT");		
						}	
					}	
				}
				else
					System.out.println("INVALID INPUT");
				}
				
				else if(Loginc.userlist.get(Loginc.id).getauth() == 0)
				{
				//PENALTY PAY
				System.out.println("+--------------------------+");
				System.out.println("|   1. CHECK VIOLATION     |");
				System.out.println("+--------------------------+");
				inp2 = input.nextInt();
				if(inp2 == 0) {
					System.out.println("+--------------------------+");
					System.out.println("|      LOGGING OUT...      |");
					System.out.println("+--------------------------+");
					status =0;
					Loginc.id = -1;
				}
				else if(inp2 == 1)
				{
					//Controller.listVehicle();
					 System.out.println("--------------------------");
				     System.out.println();
				     System.out.println("Enter Reg number : \n");
				     String reg = input.next();
				     Vehicle r =Controller.return_vehicle(reg);
				     if(r!=null)
				    	 Controller.CheckViolation(reg);
				     else
				    	 System.err.println("Vehicle does not exist"); 
				}
				}
				}
			
		}
		//input.close();


	}

}
