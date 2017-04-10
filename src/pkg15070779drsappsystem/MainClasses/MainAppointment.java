package pkg15070779drsappsystem.MainClasses;
import java.time.LocalDateTime;
import pkg15070779drsappsystem.AbstractClasses.MainAbsAppointmentComponent;
import java.util.*;
public final class MainAppointment extends MainAbsAppointmentComponent {
//@@@@@@@@@@@ Instance Variables @@@@@@@@@@    
    private String AppUniqueKey, patientUniqueID, strTitle, patientFirstname,patientSurname, appDrComments, appMedicine;
    private String drUniqueKeyAppWith;
    private Boolean appAttended,appCancelled; 
    private LocalDateTime appDateAndTime;

//@@@@@@@@@@@ Constructors @@@@@@@@@@    
         
    public MainAppointment(String title, String patientfirstname, String patientsurname, String uniqueID, LocalDateTime appDateAndTime, String drwith){
        //@@@@@@@@@@ check the Dr is not busy on the appointment set, if they are - display an error message - Dr, dateTime object
    
        setCreateAppointment(title, patientfirstname, patientsurname, uniqueID, appDateAndTime, drwith);
    }
    
    private void setCreateAppointment(String title, String firstname, String surname, String uniqueid, LocalDateTime appdaateandtime, String drwith){
        this.AppUniqueKey = generateAppUniqueKey(); //creates a key for the map
        this.strTitle = title;
        this.patientFirstname = firstname;
        this.patientSurname = surname;
        this.patientUniqueID = uniqueid;
        
        this.drUniqueKeyAppWith = drwith; //patient needs regsitering with a Dr before this can be set
        
        this.appDateAndTime = appdaateandtime;

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
       
    public MainAppointment getAppointment(String uniqueKey){
        return super.getAppointment(uniqueKey);
    }
    
        
    
    //returns the unique key of each appointment instance so this can be stored
    //in tehpatient string list, not the actual appointment object (which would duplicate it)
    //the key can be used to get the appointment if needed later
    public String getAppUniqueKey(){
        return this.AppUniqueKey;
    }
                

    
    
    
        
}
