package pkg15070779drsappsystem.MainClasses;
import java.time.LocalDateTime;
import pkg15070779drsappsystem.AbstractClasses.MainAbsAppointmentComponent;
import java.util.*;
import javax.swing.JOptionPane;
public final class MainAppointment extends MainAbsAppointmentComponent {
//@@@@@@@@@@@ static variables @@@@@@@@@@@
    //will hold the appointment that the user of the system is working with
    public static MainAppointment currentAppointment;


//@@@@@@@@@@@ Instance Variables @@@@@@@@@@    
    private String AppUniqueKey, patientUniqueID, strTitle, patientFirstname,patientSurname, appDrComments, appMedicine, appSymptoms;
    private String drUniqueKeyAppWith;
    private Boolean appAttended,appCancelled; 
    private LocalDateTime appDateAndTime;

//@@@@@@@@@@@ Constructors @@@@@@@@@@    
         
    public MainAppointment(String title, String patientfirstname, String patientsurname, String uniqueID, LocalDateTime appDateAndTime, String drwith, String symptoms){
        //@@@@@@@@@@ check the Dr is not busy on the appointment set, if they are - display an error message - Dr, dateTime object
    
        setCreateAppointment(title, patientfirstname, patientsurname, uniqueID, appDateAndTime, drwith, symptoms);
    }
    
    private void setCreateAppointment(String title, String firstname, String surname, String uniqueid, LocalDateTime appdaateandtime, String drwith, String symptoms){
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
        this.appSymptoms = symptoms;
        MainAbsAppointmentComponent.setPutInMap(this.AppUniqueKey, this);
    }
    
//@@@@@@@@@@@ Setters @@@@@@@@@@   
    
    public void setAppAttend(){
        System.out.println(this.appAttended);
        
        if (this.appAttended == false){
            this.appAttended = true;
            
            JOptionPane.showMessageDialog (null,
                "Thank you. Your appointment has now been marked as ATTENDED",
                "Appointment Attended",
                JOptionPane.ERROR_MESSAGE);
        }
        else if (this.appAttended = true){
            //this.appAttended = false;
            
            JOptionPane.showMessageDialog (null,
                "Thank you. Your appointment has already  been marked as ATTENDED",
                "Appointment attended",
                JOptionPane.ERROR_MESSAGE);
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
     
        
    //@Override //this does the exact same thing in the super class... do I need this here?
    //can I call this differently?
       
    //public MainAppointment getAppointment(String uniqueKey){
      //  return super.getAppointment(uniqueKey);
  // }
    
    
    public void getAllAppointments(){
        
       
    }
    @Override
    public String toString(){
        return (" Date & Time of Appointment:  " + this.appDateAndTime + "| Symptoms Given: "
               + this.appSymptoms + "| Comments from Dr: " + this.appDrComments + "| Appointment attended? " + this.appAttended +"| Appointment cancelled? " + this.appCancelled +  "| Medicine Prescribed: " +  this.appMedicine + "\n");
   }
    
  
   
    
        
    
    //returns the unique key of each appointment instance so this can be stored
    //in tehpatient string list, not the actual appointment object (which would duplicate it)
    //the key can be used to get the appointment if needed later
    public String getAppUniqueKey(){
        return this.AppUniqueKey;
    }
    
    public static void setAppointmentAsAttended(String appID){
        
    }
    
    //returns the date and time object for the appointment that it is called on
    public LocalDateTime getAPPDateAndTime(){
         return this.appDateAndTime;
    }
                

    
    
    
        
}
