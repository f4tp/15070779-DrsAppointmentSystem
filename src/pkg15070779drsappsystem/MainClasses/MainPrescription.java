package pkg15070779drsappsystem.MainClasses;

import java.util.ArrayList;
import java.util.List;
import pkg15070779drsappsystem.MainAbstractClasses.MainAbsPrescriptionComponent;

public class MainPrescription extends MainAbsPrescriptionComponent{
    
    //holds the current prescriptions that are being worked on by a doctor, secretary or phramacist
    
    //this is teh searched for appointments prescription list
    public static List <MainPrescription> currentPrescription = new ArrayList<>();
    
    //holds all prescription keys so they can be searched, never deleted from as all appointments stay on file
    //for report searching
    private static List<String> lstStrAllPresKeys = new ArrayList<>();
    private String presUniqueKey;
    private String presMedicineDesc;
    private String presMedAmount;
    private String patUniqueID;
    private String docUniqueID;
    private String appUniqueID;
    private Boolean presDispatched;
    
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
        
        MainAbsPrescriptionComponent.setPutInMap(this.presUniqueKey, this);
        
         
                //put in map to store it
    }
    
    public void setPresAsDispatched(){
        this.presDispatched = true;
    }
    
        public void setpresAsNotDispatched(){
        this.presDispatched = false;
    }
    
    public static void addPresKeyToList(String appkeyin){
        lstStrAllPresKeys.add(appkeyin);
    }
    
    public static List <String> getPresKeyList(){
        return lstStrAllPresKeys;
    }
    

    
 
    public String getPresUniqueID(){
         if (this.presUniqueKey == null){
             this.presUniqueKey = "there is no prescription for this appointment yet";
         }
         
         System.out.println("raaarrr" + this.presUniqueKey);
        
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
    
    @Override
    public String toString(){
        return "Prescription ID: " + this.presUniqueKey + "| Medicine Description: " +  this.presMedicineDesc + "| Medicine Amount: " + this.presMedAmount + "| Patient Prescribed For: " + this.patUniqueID + "| Doctor Prescribed by: " + this.docUniqueID + " |Appointment ID Connected by: " + this.appUniqueID + "| prescription dispatched to patient: " + this.presDispatched +  "\n \n";
    }
    

    
}
