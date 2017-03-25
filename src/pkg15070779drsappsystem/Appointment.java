package pkg15070779drsappsystem;
import java.util.*;
public class Appointment extends AppointmentComponent {
//@@@@@@@@@@@ Instance Variables @@@@@@@@@@    
    private String AppUniqueKey, patientName, appDrComments, appMedicine;
    private String drAppWith;
    private Boolean appAttended,appCancelled; 
    private Date appDate;
    private long appTime;

//@@@@@@@@@@@ Constructors @@@@@@@@@@    
         
    public Appointment(String patientname, Date appdate, long apptime, String drwith){
        setCreateAppointment(patientname, appdate, apptime, drwith);
    }
    
    public void setCreateAppointment(String patientname, Date appdate, long apptime, String drwith){
        this.AppUniqueKey = generateAppUniqueKey(); //creates a key for the map
        this.patientName = patientname;
        
        this.drAppWith = drwith; //patient needs regsitering with a Dr before this can be set
        
        this.appDate = appdate;
        this.appTime = apptime;
        this.appAttended = false;
        this.appCancelled = false;
        this.appDrComments="please enter comments";
        this.appMedicine="please update this if medicine is required for this appointment";
        setPutInMap(this.AppUniqueKey, this);
    }
    
//@@@@@@@@@@@ Setters @@@@@@@@@@   
    
    public void setAppAttend(){
        if (this.appAttended = false){
            this.appAttended = true;
        }
        else if (this.appAttended = true){
            this.appAttended = false;
        }
    }
    
    public void setAppCancelled(){
        if (this.appCancelled = false){
            this.appCancelled = true;
        }
        else if (this.appCancelled = true){
            this.appCancelled = false;
        }
    }
    
 //@@@@@@@@@@@ Getters @@@@@@@@@@  
     
        
    @Override //this does the exact same thing in the super class... do I need this here?
    //can I call this differently?
       
    public Appointment getAppointment(String uniqueKey){
        return super.getAppointment(uniqueKey);
    }
    
        
    
    //returns the unique key of each appointment instance so this can be stored
    //in tehpatient string list, not the actual appointment object (which would duplicate it)
    //the key can be used to get the appointment if needed later
    public String getAppUniqueKey(){
        return this.AppUniqueKey;
    }
                

    
    
    
        
}
