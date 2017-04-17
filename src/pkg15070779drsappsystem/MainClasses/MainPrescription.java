package pkg15070779drsappsystem.MainClasses;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import pkg15070779drsappsystem.MainAbstractClasses.MainAbsAppointmentComponent;
import pkg15070779drsappsystem.MainAbstractClasses.MainAbsPrescriptionComponent;

public class MainPrescription extends MainAbsPrescriptionComponent{

//@@@@@@@@@@ static fields @@@@@@@@@@
    //holds the current prescriptions that are being worked on by a doctor, secretary or phramacist
    //this is the searched for appointments prescription list
    public static List <MainPrescription> currentPrescription = new ArrayList<>();
    private static List<String> lstStrAllPresKeys = new ArrayList<>();
//@@@@@@@@@@ instance fields @@@@@@@@@@  
    //holds all prescription keys so they can be searched, never deleted from as all appointments stay on file
    //for report searching

    private String presUniqueKey;
    private String presMedicineDesc;
    private String presMedAmount;
    private String patUniqueID;
    private String docUniqueID;
    private String appUniqueID;
    private Boolean presDispatched;
    

//@@@@@@@@@@ construtor @@@@@@@@@@
    
    public MainPrescription(String medicinedesc, String medamount, String patientid, String doctorid, String appid){
        this.presUniqueKey = generatePresUniKey();
        this.presMedicineDesc = medicinedesc;
        this.presMedAmount = medamount;
        this.patUniqueID = patientid;
        this.docUniqueID = doctorid;
        this.appUniqueID = appid;
        this.presDispatched = false;
        //adds the prescription unique key to the static list, so it contains all prescription IDss issued... can be searched later
        addPresKeyToList(this.presUniqueKey);
        //add to the map in the component class
        MainAbsPrescriptionComponent.setPutInMap(this.presUniqueKey, this);
     }
    
    
//@@@@@@@@@@ more complicated setters @@@@@@@@@@
    
   //given a date from, date to and a status of prescription, this methofreturns a list of prescription IDs 
    //when they are within a certain date range and of a certain status (dispatched / not dispatched).
    public static List<String> getListPresWithDateAndStatus(LocalDateTime datefrom, LocalDateTime dateto, Boolean status){
        List <String> lstFoundPrescriptions = new ArrayList<>();
        
        //dates set are illogical as it expects a posiive increment on the range, so will display an error message
         if (dateto.isBefore(datefrom)){
                JOptionPane.showMessageDialog (null,
                     "The date to is before the date FROM. Please check your dates and try again",
                     "Check Dates",
                     JOptionPane.ERROR_MESSAGE);
            } 
         else{
             
                for (String tempPresKey : lstStrAllPresKeys){
                    MainPrescription tempPres = (MainPrescription) MainAbsPrescriptionComponent.getMainPrescription(tempPresKey);
                    MainAppointment tempApp = (MainAppointment) MainAbsAppointmentComponent.getAppointment(tempPres.getLinkedAppID());

                    //sort the days from and to out so that they can be included in the search themselves, otherwise they
                    //would be left out
                    datefrom = datefrom.minusDays(1L);
                    dateto = dateto.plusDays(1L);
                    
                    //@@@@@ NTD - does not work if the date from and to are on the same day - fix
                   if (tempApp.getAPPDateAndTime().isAfter(datefrom) && (tempApp.getAPPDateAndTime().isBefore(dateto))
                           && tempPres.getDispatchedStatus() == status)
                   lstFoundPrescriptions.add(tempPres.getPresUniqueID());
               }
         }
         
         //will return a full list or an empty list, either way it has to return
         return lstFoundPrescriptions;
    }    
    
    public void setPresMedicineDesc(String meddescin){
        
        if (this.presMedicineDesc == null){
             this.presMedicineDesc = "there is no prescription for this appointment yet";
         }
        this.presMedicineDesc = meddescin;
    }
    
    public void setPresMedicineAmount(String medamountin){
        
         if (this.presMedAmount == null){
             this.presMedAmount = "there is no prescription for this appointment yet";
         }
        this.presMedAmount = medamountin;
    }
    
  
//@@@@@@@@@@simple setters @@@@@@@@@@
    
    public void setPresAsDispatched(){
        this.presDispatched = true;
    }
    
        public void setpresAsNotDispatched(){
        this.presDispatched = false;
    }
    
    public static void addPresKeyToList(String appkeyin){
        lstStrAllPresKeys.add(appkeyin);
    }
    
    
 //@@@@@@@@@@More complex  getters @@@@@@@@@@   
      public String getPresUniqueID(){
         if (this.presUniqueKey == null){
             this.presUniqueKey = "there is no prescription for this appointment yet";
         }
        
        return this.presUniqueKey;
    }
    
    public String getPresDescAsString(){
         if (this.presMedicineDesc == null){
             this.presMedicineDesc = "there is no prescription for this appointment yet";
         }
        
        return this.presMedicineDesc;
    }
    
    public String getPresMedAmount(){
         if (this.presMedAmount == null){
             this.presMedAmount = "there is no prescription for this appointment yet";
         }
        
        return this.presMedAmount;
    }
    
    public String getPatUniqueID(){
        if (this.patUniqueID == null){
             this.patUniqueID = "there is no prescription for this appointment yet";
         }
        
        return this.patUniqueID;
    }
    
    public String getDocUniqueID(){
        if (this.docUniqueID == null){
             this.docUniqueID = "there is no prescription for this appointment yet";
         }
        
        return this.docUniqueID;
    }  
    

//@@@@@@@@@@simple getters @@@@@@@@@@
    
    public static List <String> getPresKeyList(){
        return lstStrAllPresKeys;
    }
    
    public String getLinkedAppID(){
        return this.appUniqueID;
    }
    
    public Boolean getDispatchedStatus(){
        return this.presDispatched;
    }
    

    
 

    

 
    
//@@@@@@@@@@ other methods @@@@@@@@@@    
    @Override
    public String toString(){
        return "Prescription ID: " + this.presUniqueKey + "| Medicine Description: " +  this.presMedicineDesc + "| Medicine Amount: " + this.presMedAmount + "| Patient Prescribed For: " + this.patUniqueID + "| Doctor Prescribed by: " + this.docUniqueID + " |Appointment ID Connected by: " + this.appUniqueID + "| prescription dispatched to patient: " + this.presDispatched +  "\n \n";
    }
    

    
}
