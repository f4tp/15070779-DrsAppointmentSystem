package pkg15070779drsappsystem.MainClasses;

import pkg15070779drsappsystem.MainAbstractClasses.MainAbsPrescriptionComponent;

public class MainPrescription extends MainAbsPrescriptionComponent{
    
    //holds the current prescription that is being worked on by a doctor, secretary or phramacist
    public static MainPrescription currentPrescription;
    private String presUniqueKey;
    private String presMedicineDesc;
    private String presMedAmount;
    private String patUniqueID;
    private String docUniqueID;
    
    public MainPrescription(String medicinedesc, String medamount, String patientid, String doctorid){
        this.presUniqueKey = generatePresUniKey();
        this.presMedicineDesc = medicinedesc;
        this.presMedAmount = medamount;
        this.patUniqueID = patientid;
        this.docUniqueID = doctorid;
        
         
                //put in map to store it
    }
    
    
    
    public String getPresUniqueID(){
         if (this.patUniqueID == null){
             this.patUniqueID = "there is no prescription for this appointment yet";
         }
        
        return this.patUniqueID;
    }
    
    public String getPresMedicineDesc(){
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
        return "Prescription ID: " + this.presUniqueKey + "| Medicine Description: " +  this.presMedicineDesc + "| Medicine Amount: " + this.presMedAmount + "| Patient Prescribed For: " + this.patUniqueID + "| Doctor Prescribed by: " + this.docUniqueID + "\n \n";
    }
    

    
}
