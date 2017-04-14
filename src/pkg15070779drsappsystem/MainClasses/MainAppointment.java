package pkg15070779drsappsystem.MainClasses;
import java.time.LocalDateTime;
import pkg15070779drsappsystem.MainAbstractClasses.MainAbsAppointmentComponent;
import java.util.*;
import javax.swing.JOptionPane;
import pkg15070779drsappsystem.MainAbstractClasses.MainAbsPrescriptionComponent;
import pkg15070779drsappsystem.MainAbstractClasses.MainAbsSystemUserComponent;
public final class MainAppointment extends MainAbsAppointmentComponent {
//@@@@@@@@@@@ static variables @@@@@@@@@@@
    //will hold the appointment that the user of the system is working with
    public static MainAppointment currentAppointment;

    //holds all appointments so they can be searched, never deleted from as all appointments stay on file
    private static List<String> lstStrAllAppKeys = new ArrayList<>();

//@@@@@@@@@@@ Instance Variables @@@@@@@@@@    
    private String AppUniqueKey, patientUniqueID, strTitle, patientFirstname,patientSurname, appDrComments, appSymptoms;
    private List <String> lstPrescriptionsUniqueID;
    
    private String drUniqueKeyAppWith;
    private Boolean appAttended,appCancelled, appMissed; 
    private LocalDateTime appDateAndTime;

//@@@@@@@@@@@ Constructors @@@@@@@@@@    
         
    public MainAppointment(String title, String patientfirstname, String patientsurname, String uniqueID, LocalDateTime appDateAndTime, String drwith, String symptoms){
        //@@@@@@@@@@ check the Dr is not busy on the appointment set, if they are - display an error message - Dr, dateTime object
    
        setCreateAppointment(title, patientfirstname, patientsurname, uniqueID, appDateAndTime, drwith, symptoms);
        
        //adds the time into the Drs appointment list
        addAppointmentToDrsList(this.drUniqueKeyAppWith, this.appDateAndTime, this.AppUniqueKey);
        
    }
    
    private void setCreateAppointment(String title, String firstname, String surname, String uniqueid, LocalDateTime appdateandtime, String drwith, String symptoms){
        this.AppUniqueKey = generateAppUniqueKey(); //creates a key for the map
        this.strTitle = title;
        this.patientFirstname = firstname;
        this.patientSurname = surname;
        this.patientUniqueID = uniqueid;
        
        this.drUniqueKeyAppWith = drwith; //patient needs regsitering with a Dr before this can be set
        
        this.appDateAndTime = appdateandtime;

        this.appAttended = false;
        this.appCancelled = false;
        this.appMissed = false;
        this.appDrComments="please enter comments";
        //his.appMedicine="please update this if medicine is required for this appointment";
        this.appSymptoms = symptoms;
        
        //each appointment has an array list to store IDs of prescriptions for this appointment
        this.lstPrescriptionsUniqueID = new ArrayList<>();
        
        //adds the key to a list of all appointment keys, so it ca nbe searched for teh reports later
        addAppKeyToList(this.AppUniqueKey);
        MainAbsAppointmentComponent.setPutInMap(this.AppUniqueKey, this);
    }
    
//@@@@@@@@@@@ Setters @@@@@@@@@@   
    
    public static void addAppKeyToList(String appkeyin){
        lstStrAllAppKeys.add(appkeyin);
    }
    
    public static List <String> getAppKeyList(){
        return lstStrAllAppKeys;
    }
    public void addAppointmentToDrsList(String drin, LocalDateTime apptimein, String appkeyin){
        //object composition to create relationship
        MainDoctor tempDoc = (MainDoctor) MainAbsSystemUserComponent.getSystemUserComponent(drin);
        tempDoc.addAppointmentToDrsList(apptimein, appkeyin);
    
        
    }
    
    public void setAppAttendSec(Boolean attendstatus){
        this.appAttended = attendstatus;
    }
    
    
    //used for teh patient's access screen - so they can book themselves in
    public void setAppAttendPatientResponse(){

        
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
        
        //NTD - put the appointment back in the map
        //didn't need to put it back in the map - when updating variables it will automatically do this
    }
    
    public void setSymptoms(String symptomstoset){
        this.appSymptoms = symptomstoset;
    }
    
    public void setAppCancelled(Boolean cancelledstatus){
        this.appCancelled = cancelledstatus;
    }
    
    public void setAppMissed(Boolean missedstatus){
       this.appMissed = missedstatus;
    }
    
    //returns false if the appointment doesn't have a prescription yet
    //returns true if it does
    public String getPrescriptionIDsff(){
        if (this.lstPrescriptionsUniqueID.isEmpty()){
            return "There is no prescription for this appointment yet";
        }
        else{
            String presToRet = "";
            for (String temp: this.lstPrescriptionsUniqueID){
                presToRet = presToRet + temp;
            }
            
            return presToRet;
        }
    }
    
    public Boolean getHasPrescBeenGenerated(){
        if (this.lstPrescriptionsUniqueID.isEmpty()){
            return false;
        }
        else{
            return true;
        }
    }
    
    public List<String> getListOfPrescriptionIDs(){
        return this.lstPrescriptionsUniqueID;
    }
    
    //for every prescription ID in the appointment prescription ID list, it will return the prescription as a String - all
    //prescription details for this appointment will be returned
    public String getAllPresDetailsForAppAsString(){
        
         if (this.lstPrescriptionsUniqueID.isEmpty()){
            return "There is no prescription for this appointment yet";
        }
         
         else{
             
         
                String presToRet = "";
                   for (String temp: this.lstPrescriptionsUniqueID){
                       presToRet = presToRet + MainAbsPrescriptionComponent.getMainPrescription(temp).toString();
                   }

                   return presToRet;
         }
    }
    
    
    public void addPrescriptionForApp(String meddesc, String medamount, String patientid, String drwith){
        //object composition - create new prescitpion called from here
        //used rather than interface or implements inheritence as a 
        MainPrescription appPres = new MainPrescription(meddesc, medamount, patientid, drwith);
        this.lstPrescriptionsUniqueID.add(appPres.getPresUniqueID());
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
              return ("\n" + "Appointment ID: " + this.AppUniqueKey + "| Date & Time of Appointment:  " + this.appDateAndTime + "| Symptoms Given: "
               + this.appSymptoms + "Dr with: " + this.drUniqueKeyAppWith + "| Comments from Dr: " + this.appDrComments + "| Appointment attended? " + this.appAttended +"| Appointment cancelled? " + this.appCancelled +  " | Appointment Missed: " + this.appMissed);
    }
    
  
   
    
        
    
    //returns the unique key of each appointment instance so this can be stored
    //in tehpatient string list, not the actual appointment object (which would duplicate it)
    //the key can be used to get the appointment if needed later
    public String getAppUniqueKey(){
        return this.AppUniqueKey;
    }
    
    
    //returns the date and time object for the appointment that it is called on
    public LocalDateTime getAPPDateAndTime(){
         return this.appDateAndTime;
    }
    
    public static List <MainAppointment> getAppointmentsOfDoc (MainDoctor doctorin){
        List<MainAppointment> lstFoundAppointments = new ArrayList<>();
        
        return lstFoundAppointments;
        
    }
    
    public String getDrAppWith(){
        return this.drUniqueKeyAppWith;
    }
    
    public String getSymptoms(){
        return this.appSymptoms;
    }
    
    public Boolean getAttended(){
        return this.appAttended;
    }
    public Boolean getMissed(){
        return this.appMissed;
    }
    public Boolean getCancelled(){
        return this.appCancelled;
    }
    
    //public static String getPresID
    
    public void setAppDateTime(LocalDateTime appDateTime){
        this.appDateAndTime = appDateTime;
    }
    
                

    
    
    
        
}
