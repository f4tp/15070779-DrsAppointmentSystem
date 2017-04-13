package pkg15070779drsappsystem.MainClasses;

import pkg15070779drsappsystem.MainAbstractClasses.MainAbsPrescriptionComponent;

public class MainPrescription extends MainAbsPrescriptionComponent{
    
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
        return this.patUniqueID;
    }
    
    public String getPresMedicineDesc(){
        return this.presMedicineDesc;
    }
    
    public String getPresMedAmount(){
        return this.presMedAmount;
    }
    
    public String getPatUniqueID(){
        return this.patUniqueID;
    }
    
    public String getDocUniqueID(){
        return this.docUniqueID;
    }
    
    public void setPresMedicineDesc(String meddescin){
        this.presMedicineDesc = meddescin;
    }
    
    public void setPresMedicineAmount(String medamountin){
        this.presMedAmount = medamountin;
    }
    
    @Override
    public String toString(){
        return "Prescription ID: " + this.presUniqueKey + "| Medicine Description: " +  this.presMedicineDesc + "| Medicine Amount: " + this.presMedAmount + "| Patient Prescribed For: " + this.patUniqueID + "| Doctor Prescribed by: " + this.docUniqueID + "\n \n";
    }
    

    
}
