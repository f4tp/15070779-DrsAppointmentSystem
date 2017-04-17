package pkg15070779drsappsystem.MainClasses;
import java.time.LocalDateTime;
import pkg15070779drsappsystem.MainAbstractClasses.MainAbsAppointmentComponent;
import java.util.*;
import javax.swing.JOptionPane;
import pkg15070779drsappsystem.Interfaces.MainInterfaceAppoinment;
import pkg15070779drsappsystem.MainAbstractClasses.MainAbsPrescriptionComponent;
import pkg15070779drsappsystem.MainAbstractClasses.MainAbsScheduling;
import pkg15070779drsappsystem.MainAbstractClasses.MainAbsSystemUserComponent;
public final class MainAppointment extends MainAbsAppointmentComponent implements MainInterfaceAppoinment {
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
        
        //adds the key to a list of all appointment keys, so it ca nbe searched forhe reports later
        addAppKeyToAllAppsList(this.AppUniqueKey);
        MainAbsAppointmentComponent.setPutInMap(this.AppUniqueKey, this);
    }
    
//@@@@@@@@@@@ More Complicated Setters @@@@@@@@@@   
    
    
     public void addAppointmentToDrsList(String drin, LocalDateTime apptimein, String appkeyin){
        //object composition to create relationship
        MainDoctor tempDoc = (MainDoctor) MainAbsSystemUserComponent.getSystemUserComponent(drin);
        tempDoc.addAppointmentToDrsList(apptimein, appkeyin);
   
    }
     
     
         //used for the patient's access screen - so they can book themselves in
    public void setAppAttendPatientResponse(){

        
        if (this.appAttended == false){
            
            this.setAppAttend(true);
           // this.appAttended = true;
            
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
     
   
    
    public void setAppCancelled(Boolean cancelledstatus, MainDoctor drin, LocalDateTime ltdfordredit){
        this.appCancelled = cancelledstatus;
        MainDoctor docToUpdate = drin;
        LocalDateTime ldtToupdateDoctorWith;
        //remove the appointment time from the doctors appointment times taken list
        docToUpdate.setRemoveLDTFromAppTimesTakenList(ltdfordredit);
        //add the appointment time to the doctors appointments available list
        docToUpdate.setAddLDTToAppTimesAvailableList(ltdfordredit);
    }
    
        //returns false if the appointment doesn't have a prescription yet
    //returns true if it does
    public String getPrescriptionIDsAsString(){
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
    
    
     public void addPrescriptionForApp(String meddesc, String medamount, String patientid, String drwith, String appid){
        //object composition - create new prescitpion called from here
        //used rather than interface or implements inheritence as a 
        MainPrescription appPres = new MainPrescription(meddesc, medamount, patientid, drwith, appid );
        MainAppointment currAppInst = MainAbsAppointmentComponent.getAppointment(appid);
        currAppInst.lstPrescriptionsUniqueID.add(appPres.getPresUniqueID());
    }
    
    
    //routine checks all appointments  that haven't had their attended status (marked / missed / cancelled) updated
    //that have happened before today's date and time, and will mark them as missed
    public static void setAllRelAppsAsMissed(){
        for (String temp: lstStrAllAppKeys){
            MainAppointment currAppInst = (MainAppointment) MainAbsAppointmentComponent.getAppointment(temp);
            if (currAppInst.getAttended() == false && currAppInst.appCancelled == false && currAppInst.appMissed ==false && currAppInst.getAPPDateAndTime().isBefore(MainAbsScheduling.getDateToday())){
                currAppInst.setAppMissed(true);
            }
        }
    }
    
    public static List <MainAppointment> getAppointmentsOfDoc (MainDoctor doctorin){
        List<MainAppointment> lstFoundAppointments = new ArrayList<>();
        
        return lstFoundAppointments;
        
    }
    
  //@@@@@@@@@@@ Interface Setters @@@@@@@@@@ 
    
      public void setProfessionalsComments(String proessionalscommentsin){
        this.appDrComments = proessionalscommentsin;
    }
    
    
    
    
      public void setAppAttend(Boolean attendstatus){
        this.appAttended = attendstatus;
    }
      
      
      public void setSymptoms(String symptomstoset){
        this.appSymptoms = symptomstoset;
    }
    

    
    public void setAppMissed(Boolean missedstatus){
       this.appMissed = missedstatus;
    }
    
   public void setAppDateTime(LocalDateTime appDateTime){
        this.appDateAndTime = appDateTime;
    }
  
    
//@@@@@@@@@@@  Setters @@@@@@@@@@ 
    public static void addAppKeyToAllAppsList(String appkeyin){
        lstStrAllAppKeys.add(appkeyin);
    }
  
 //@@@@@@@@@@@ More Complicated Getters @@@@@@@@@@  
    
    public Boolean getHasPrescBeenGenerated(){
        if (this.lstPrescriptionsUniqueID.isEmpty()){
            return false;
        }
        else{
            return true;
        }
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
                       presToRet +=  "\t" + MainAbsPrescriptionComponent.getMainPrescription(temp).toString();
                   }

                   return presToRet;
         }
    }
    
    //@@@@@@@@@@@ Interface Getters @@@@@@@@@@  
    

     
     //returns the unique key of each appointment instance so this can be stored
    //in this patient string list, not the actual appointment object (which would duplicate it)
    //the key can be used to get the appointment if needed later
    @Override
    public String getAppUniqueKey(){
        return this.AppUniqueKey;
    }
    
     //returns the date and time object for the appointment that it is called on
    @Override
    public LocalDateTime getAPPDateAndTime(){
         return this.appDateAndTime;
         
    }
    @Override
   public String getSymptoms(){
   return this.appSymptoms;
    }
        
        
    @Override
     public Boolean getAttended(){
        return this.appAttended;
    }
    @Override
    public Boolean getMissed(){
        return this.appMissed;
    }
    @Override
    public Boolean getCancelled(){
        return this.appCancelled;
    }
    
    
    @Override
    public String getProfessionalAppWith(){
        return this.drUniqueKeyAppWith;
    }
    

    @Override
    public String getProfessionalsComments(){
        return this.appDrComments;
    }
 //@@@@@@@@@@@ Getters @@@@@@@@@@  
     
      public List<String> getListOfPrescriptionIDs(){
        return this.lstPrescriptionsUniqueID;
    }
    
      
     public static List <String> getAppKeyList(){
        return lstStrAllAppKeys;
    }
   
    
//@@@@@@@@@@ other methods @@@@@@@@@@    
    
   
    @Override
    public String toString(){
              return ("\n" + "Appointment ID: " + this.AppUniqueKey + " | Patient with: | " + this.patientUniqueID + "| Date & Time of Appointment:  " + this.appDateAndTime + "| Symptoms Given: "
               + this.appSymptoms + "Dr with: " + this.drUniqueKeyAppWith + "| Comments from Dr: " + this.appDrComments + "| Appointment attended? " + this.appAttended +"| Appointment cancelled? " + this.appCancelled +  " | Appointment Missed: " + this.appMissed + "\n");
    }
    
    
        
}
