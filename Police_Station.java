import java.util.ArrayList;

public class Police_Station {
	 public int StationID;
	    public String StationName;
	    ArrayList<Traffic_Police> Personnel = new ArrayList<>();
	    ArrayList<Junction> JunctionsUnderControl = new ArrayList<>();
	    public int PinCode;

	    public Police_Station(int stationID, String stationName, ArrayList<Traffic_Police> personnel, ArrayList<Junction> junctionsUnderControl, int pinCode) {
	        StationID = stationID;
	        StationName = stationName;
	        Personnel = personnel;
	        JunctionsUnderControl = junctionsUnderControl;
	        PinCode = pinCode;
	    }

}
 
