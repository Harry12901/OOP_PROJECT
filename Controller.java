import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
	
//	
//ARRAY LIST:
	static ArrayList<Road> Roads = new ArrayList<>();
    static ArrayList<Junction> Junctions = new ArrayList<>();
    static ArrayList<Traffic_Police> TrafficPolice = new ArrayList<>();
    static ArrayList<Police_Station> PoliceStations = new ArrayList<>();
    
  //RETURN FUNCTIONS - checks if the required object exists    
    public static Road return_road(int RID){
        for(int i=0;i<Roads.size();i++){
            if(RID == Roads.get(i).RoadId){
                return Roads.get(i);
            }
        }
        return null;
    }

    public static Junction return_jn(int JID){
        for(int i=0;i<Junctions.size();i++){
            if(JID == Junctions.get(i).JunctionID){
                return Junctions.get(i);
            }
        }
        return null;
    }

    public static Traffic_Police return_police(Police_Station ps, int PID){
        ArrayList<Traffic_Police> TrafficPolice = ps.Personnel;
        for(int i=0;i<TrafficPolice.size();i++){
            if(PID == TrafficPolice.get(i).PoliceID){
                return TrafficPolice.get(i);
            }
        }
        return null;
    }

    public static Police_Station return_police_station(int SID){
        for(int i=0;i<PoliceStations.size();i++){
            if(SID == PoliceStations.get(i).StationID){
                return PoliceStations.get(i);
            }
        }
        return null;
    }
    
    public static int return_police_station_index(int SID){
        for(int i=0;i<PoliceStations.size();i++){
            if(SID == PoliceStations.get(i).StationID){
                return i;
            }
        }
        return -1;
    }
    
  //ADD:  
    public static void addRoad(int RID,String Name,double Length){
      Roads.add(new Road(RID,Name,Length));
      
   }

    public static void addJunction(int JID, String Name,String Type, ArrayList<Road> conn_roads){
        Junctions.add(new Junction(JID,Name,Type,conn_roads));
        
    }
    
    public static Traffic_Police addPolice(int PID,String Name,int age,int salary,int yoe,String address){
          return new Traffic_Police(PID,Name,age,salary,yoe,address);
    }

    
    public static void addPoliceStation(int SID,String Name,ArrayList<Traffic_Police> police,ArrayList<Junction> junctions,int pinCode){
        PoliceStations.add(new Police_Station(SID,Name,police,junctions,pinCode));   
    }
    
    public static void addPolice1(Police_Station ps,int i, int PID,String pName,int age, int salary,int yoe,String address){
    	    PoliceStations.remove(ps);
            ps.Personnel.add(new Traffic_Police(PID,pName,age,salary,yoe,address));
            PoliceStations.add(i,ps);
      }
    
//DISPLAY
    
    public static void listJunctions(){
        System.out.println("--------------------------");
        System.out.println();
        System.out.println("List of Junctions : \n");
        for(int i = 0;i<Junctions.size();i++){
            System.out.print("Junction ID : ");
            System.out.println(Junctions.get(i).JunctionID);
            System.out.print("Junction Name : ");
            System.out.println(Junctions.get(i).JunctionName);
            System.out.print("Junction Type : ");
            System.out.println(Junctions.get(i).JunctionType);
            System.out.println();
        }
        System.out.println("--------------------------");
    }
   
    public static void listRoads(){
        System.out.println("--------------------------");
        System.out.println();
        System.out.println("List of Roads : \n");
        for(int i = 0;i<Roads.size();i++){
            System.out.print("Road ID : ");
            System.out.println(Roads.get(i).RoadId);
            System.out.print("Road Name : ");
            System.out.println(Roads.get(i).RoadName);
            System.out.print("Road Length : ");
            System.out.println(Roads.get(i).Length);
            System.out.println();
        }
        System.out.println("--------------------------");
    }
    
    public static void listStations(){
        System.out.println("--------------------------");
        System.out.println();
        System.out.println("List of Police Stations : \n");
        for(int i = 0;i<PoliceStations.size();i++){
            System.out.print("Police Station ID : ");
            System.out.println(PoliceStations.get(i).StationID);
            System.out.print("Name : ");
            System.out.println(PoliceStations.get(i).StationName);
            System.out.println();
        }
        System.out.println("--------------------------");
    }
    
    public static void listPolice(int SID){
        Police_Station PS = return_police_station(SID);
        if(PS == null){
            System.err.println("Station Does Not Exist");
        }
        else {
            for(int i =0;i<PS.Personnel.size();i++){
                System.out.print("Police ID : ");
                System.out.println(PS.Personnel.get(i).PoliceID);
                System.out.print("Police Name : ");
                System.out.println(PS.Personnel.get(i).Name);
                System.out.println();
            }
        }
        System.out.println("--------------------------");
    }
    
    
    
//DELETE
    public static void deleteRoad(Road rd){
        
        Roads.remove(rd);
        System.out.println("Road Successfully deleted");

}

public static void deleteJunction(Junction jn){
        Junctions.remove(jn);
        System.out.println("Junction Successfully deleted");
  }

public static void deletePoliceStation(Police_Station ps){
        PoliceStations.remove(ps);
        System.out.println("Police Station Successfully deleted");
}

public static void deletePolice(Police_Station ps,int i, Traffic_Police police){
    
        	PoliceStations.remove(ps);
        	ps.Personnel.remove(police);
        	PoliceStations.add(i, ps);

}
//public static void deletePolice(){
//    System.out.println("--------------------------");
//    System.out.println();
//    Scanner input = new Scanner(System.in);
//    System.out.print("Enter Police Station ID : ");
//    int SID = input.nextInt();
//    Police_Station ps = return_police_station(SID);
//    if(ps == null){
//        System.err.println("Police Station does not exist");
//    }
//    else{
//        System.out.println("Enter Police ID : ");
//        int pid = input.nextInt();
//        Traffic_Police police = return_police(ps,pid);
//        if(police == null){
//            System.out.println("Traffic Police does not exist");
//        }
//        else{
//            ps.Personnel.remove(police);
//        }
//        System.out.println("Police Successfully deleted");
//    }
//    System.out.println();
//    System.out.println("--------------------------");
//
//    input.close();
//
//}

    
//
//ARRAY LIST    
    static ArrayList<Logs> log  = new ArrayList<>();
    static ArrayList<AccidentLog> alog  = new ArrayList<>();
    static ArrayList<TrafficViolationLog> vlog = new ArrayList<>();
    static ArrayList<Vehicle> vehicle = new ArrayList<>();
    
//RETURN FUNCTIONS - checks if the required object exists  
    public static Logs return_log(int LID){
        for(int i=0;i<log.size();i++){
            if(LID == log.get(i).LogID){
                return log.get(i);
            }
        }
        return null;
    }
  
    public static AccidentLog return_accident(int AID){
        for(int i=0;i<alog.size();i++){
            if(AID == alog.get(i).AccID){
                return alog.get(i);
            }
        }
        return null;
    }

    public static TrafficViolationLog return_violation(int VID){
        for(int i=0;i<vlog.size();i++){
            if(VID == vlog.get(i).VID){
                return vlog.get(i);
            }
        }
        return null;
    }
    
    public static Vehicle return_vehicle(String regno){
        for(int i=0;i<vehicle.size();i++){
            if(regno.equals(vehicle.get(i).Regno) ){
                return vehicle.get(i);
                
            }
        }
        return null;
    }
    
  //ADD:  
    public static void addVehicle(String name,String regno) {
        vehicle.add(new Vehicle(regno,name));
    }
 
    

    public static void addViolation(int VID,double penalty,String reason,String regno,double speed,int RID,int PID,int SID){
                	vlog.add(new TrafficViolationLog(VID,penalty,reason,regno,speed,RID,PID,SID,"Violation"));
    }
    

    public static void addAccident(int AID,String damage,String reason,int ni,int nov,ArrayList<String> vehicles,int RID,int PID,int SID){
                	alog.add(new AccidentLog(AID,damage,reason,ni,nov,vehicles,RID,PID,SID,"Accident"));        
    }
    
 //DISPLAY: 
    public static void listVehicle(){
        System.out.println("--------------------------");
        System.out.println();
        System.out.println("List of Vehicles : \n");
        for(int i = 0;i<vehicle.size();i++){
            System.out.print("Regno : ");
            System.out.println(vehicle.get(i).Regno);
            System.out.print("Name : ");
            System.out.println(vehicle.get(i).Name);
        }
        System.out.println("--------------------------");
    }
    public static void listViolation(){
        System.out.println("--------------------------");
        System.out.println();
        System.out.println("List of Violations : \n");
        for(int i = 0;i<vlog.size();i++){
            System.out.print("Violation ID : ");
            System.out.println(vlog.get(i).VID);
            System.out.print("Registration Number : ");
            System.out.println(vlog.get(i).regno);
            System.out.print("Reason : ");
            System.out.println(vlog.get(i).Reason);
            System.out.print("Speed : ");
            System.out.println(vlog.get(i).speed);
            System.out.print("Penalty amount : ");
            System.out.println(vlog.get(i).PenaltyAmount);
            System.out.print("Road ID : ");
            System.out.println(vlog.get(i).RoadID);
            System.out.print("Police ID : ");
            System.out.println(vlog.get(i).PoliceID);
            System.out.print("Station ID : ");
            System.out.println(vlog.get(i).StationID);
            System.out.print("Date : ");
            System.out.println(vlog.get(i).date);
            System.out.print("Time : ");
            System.out.println(vlog.get(i).time);
            
            System.out.println();
        }
        System.out.println("--------------------------");
    }
    

    public static void listAccident(){
        System.out.println("--------------------------");
        System.out.println();
        System.out.println("List of Accidents : \n");
        for(int i = 0;i<alog.size();i++){
            System.out.print("Accident ID : ");
            System.out.println(alog.get(i).AccID);
            System.out.print("Number of people injured : ");
            System.out.println(alog.get(i).NoofPersonsInjured);
            System.out.print("Damage Caused : ");
            System.out.println(alog.get(i).DamageCaused);
            System.out.print("Reason for the accident : ");
            System.out.println(alog.get(i).AccReason);
            System.out.print("Number of Vehicles involved : ");
            System.out.println(alog.get(i).NoofVehicles);
            System.out.print("Vehicles involved : ");
            System.out.println(alog.get(i).regnos);
            System.out.print("Road ID : ");
            System.out.println(alog.get(i).RoadID);
            System.out.print("Police ID : ");
            System.out.println(alog.get(i).PoliceID);
            System.out.print("Station ID : ");
            System.out.println(alog.get(i).StationID);
            System.out.print("Date : ");
            System.out.println(alog.get(i).date);
            System.out.print("Time : ");
            System.out.println(alog.get(i).time);
            
            System.out.println();
        }
        System.out.println("--------------------------");
    }


//DELETE
    public static void deleteVehicle(Vehicle v)
    {
    	vehicle.remove(v);
        System.out.println("Vehicle Successfully deleted");
        System.out.println();
        System.out.println("--------------------------");
    }
    
   
    public static void deleteViolation(){
        System.out.println("--------------------------");
        System.out.println();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Violation ID : ");
        int VID = input.nextInt();
        //input.close();
        TrafficViolationLog v = return_violation(VID);
        Logs l = return_log(VID);
        
        if(v == null){
            System.err.println("Violation log does not exist");
        }
        else{
            vlog.remove(v);
            log.remove(l);
            System.out.println("Violation Successfully deleted");
        }

//        if(l == null){
//            System.err.println("Log does not exist");
//        }
//        else{
//            log.remove(l);
//            System.out.println("Log Successfully deleted");
//        }
//        
        System.out.println();
        System.out.println("--------------------------");
    }

    
    
    public static void deleteAccident(int AID){
        AccidentLog a = return_accident(AID);
        Logs l = return_log(AID);
        
        if(a == null){
            System.err.println("Accident log does not exist");
        }
        else{
            alog.remove(a);
            log.remove(l);
            System.out.println("Accident log Successfully deleted");
        }

//        if(l == null){
//            System.err.println("Log does not exist");
//        }
//        else{
//            log.remove(l);
//            System.out.println("Log Successfully deleted");
//        }
        
        System.out.println();
        System.out.println("--------------------------");
    }
    
//CHECK VIOLATION AND PENALTY PAY
    public static void CheckViolation(String reg){

         Scanner input = new Scanner(System.in);

        	int flag=0;
        	for(int i = 0;i<vlog.size();i++){
        		if(reg.equals(vlog.get(i).regno) )
        		{
        			System.out.print("Violation ID : ");
                    System.out.println(vlog.get(i).VID);
                    System.out.print("Registration Number : ");
                    System.out.println(vlog.get(i).regno);
                    System.out.print("Reason : ");
                    System.out.println(vlog.get(i).Reason);
                    System.out.print("Speed : ");
                    System.out.println(vlog.get(i).speed);
                    System.out.print("Penalty amount : ");
                    System.out.println(vlog.get(i).PenaltyAmount);
                    System.out.print("Road ID : ");
                    System.out.println(vlog.get(i).RoadID);
                    System.out.print("Police ID : ");
                    System.out.println(vlog.get(i).PoliceID);
                    System.out.print("Station ID : ");
                    System.out.println(vlog.get(i).StationID);
                    System.out.print("Date : ");
                    System.out.println(vlog.get(i).date);
                    System.out.print("Time : ");
                    System.out.println(vlog.get(i).time);
                    System.out.println("--------------------------");
                    System.out.println("Pay Penalty (y/n) :");
                    String inp = input.next();
                    if(inp.equals("y"))
                    {
                    	deleteViolation();
                    	System.out.println("Penalty removed");
                    }
                    
                    System.out.println();
                    flag=1;
        		}
                
            }
        	if(flag==0)
        	{
        		System.out.println("No Violation record found");
        	}
        	    System.out.println("--------------------------");
     }
    
}
