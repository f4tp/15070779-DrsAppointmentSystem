package pkg15070779drsappsystem;
import java.util.*;

public class Patient extends SystemUser {
    private String apptest;
    private List<String> lstDrsRegsWith; //list of Doctors for each patient
    private String MedicalNotes;//comments about the patient, generated from appointment comments
    
    public Patient(String fname, String sname, String title, int yob, String newer){
        super(fname, sname, title, yob); //initialise this object using its superclass
        this.apptest = newer; //example new data added to teh patient specific data
        setPutInMap(this); //add teh user object to the map
        lstDrsRegsWith  = new ArrayList<>(); //each patient gets a new list
    }
    
    //adds a doctor to the list for teh patient created
    public void setAddDrRegsWith(String docName){
        this.lstDrsRegsWith.add(docName);
    }
    
    //returns a string of all Doctors a patient is regsitered with
    public String getDrsRegWith(){ 
         String allDrs="";
        
         //iterator design patter
        for (String Drs : this.lstDrsRegsWith) {                        // <4>
            System.out.println (Drs);
            if (allDrs == ""){
                allDrs = Drs;
            }
            else {
                allDrs = allDrs + ", " + Drs;
            }
        }
        return allDrs;
        
    }
}
       

