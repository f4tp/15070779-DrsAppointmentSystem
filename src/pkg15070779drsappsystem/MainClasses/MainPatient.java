package pkg15070779drsappsystem.MainClasses;
import java.time.LocalDateTime;
import pkg15070779drsappsystem.AbstractClasses.MainAbsSystemUserComponent;
import pkg15070779drsappsystem.Interfaces.MainIntAbsUserComponent;
import java.util.*;
import javax.swing.JOptionPane;

public class MainPatient extends MainAbsSystemUserComponent implements MainIntAbsUserComponent   {
//instance variables that are not essential to initialisation
    private String strTitle, strFirstName, strSurname, strDOB, strKeyUserName, strContactDetail;
    private String MedicalNotes;//comments about the patient, generated from appointment comments
    private MainAppointment newAppointmentInst; //object composition - new appointment object each time the patient
    
    
//public static variables
    public static MainPatient currentPatient; //holds the current patient that any class is working on / with
    //does not hold an instance, acts as a pointer to the main object
    
    
    
//collections of objects that the patient has to have one of
    private List<String> lstStrDrsRegsWith; //list of Doctors for each patient - stores dr username, can use this to return doctor name
//collections of objects that the patient might have / are all optional
    private List<String> lstStrPatientApps;
    private List<String> lstMedicine; //stores string details only to display in each file, medicine objects stored in component class

//@@@@@@@@@@ constructor method @@@@@@@@@@
    public MainPatient(String title, String fname, String sname,  String dob, String telnum, String dronfile){
       
        this.strTitle = title;
        this.strFirstName = fname;
        this.strSurname = sname;
        this.strDOB = dob;
        this.strContactDetail = telnum;
        this.lstStrDrsRegsWith  = new ArrayList<>(); //each patient gets a new list to store dr username
        this.initialiseDrsRegsWith(dronfile); //forces at least one dr to be registered
        this.lstStrPatientApps = new ArrayList<>(); //each paient gets a new arraylist of appointments
        this.strKeyUserName = setGenerateUsername(this.strFirstName, this.strSurname, this.strDOB);
        setPutInMap(this.strKeyUserName, this); //add the user object to the map
    }
 
//@@@@@@@@@@ interface getters @@@@@@@@@@
    public String getUserName(){
        return this.strKeyUserName;
    }
    
    public String getTitle(){
        return this.strTitle;
    }
    public String getFirstName(){
        return this.strFirstName;
    }
    public String getSurname(){
        return this.strSurname;
    }

    public String getDOB(){
        return this.strDOB;
    }
  
 //@@@@@@@@@@ class specific getters @@@@@@@@@@
    
    
    @Override
    public String toString () {
        return "UserName: " + strKeyUserName + ", Details: " + this.getTitle() + " " + this.getFirstName() + 
                " " +this. getSurname() + ", Year of Birth: " + this.getDOB() +  
                ", Drs regs. With: " + this.getDrsRegWithAsStringAsDrsnames();
    }
    
 
    
    
//@@@@@@@@@@ SETTERS @@@@@@@@@@    
    //adds the username of a new dr that the patient will be regsitered with to the list
    
     public static void setFoundPatient(String key){
         //polymorphism - sets object subtype here
          currentPatient = (MainPatient)MainAbsSystemUserComponent.getSystemUserComponent(key);
     }
    
    
    public void initialiseDrsRegsWith(String drToAdd){
                  this.lstStrDrsRegsWith.add(drToAdd);
     }
    
    public  Boolean addDrRegsWith(String drToAdd,  String keyToUpdate){
        if (this.lstStrDrsRegsWith.contains(drToAdd)){
            JOptionPane.showMessageDialog (null,"The patient is already registered with this Dr",
                "Dr Already Registered With Patient",
                JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else {
            this.lstStrDrsRegsWith.add(drToAdd);
        
            //will update the existing record - with new Doctor in the list
            MainAbsSystemUserComponent.setPutInMap(keyToUpdate, this);
            return true;
        }
                
    }
    
     public void addNewAppointment(LocalDateTime appdateandtime,  String drwith){
       
            LocalDateTime appDateAndTime = appdateandtime;
            String drWith = drwith;
            this.newAppointmentInst = new MainAppointment (this.getTitle(), this.getFirstName(), this.getSurname(), this.getUserName(), appDateAndTime, drWith);


            //adds the appointments unique ID to a list for the patient, can be used to get all their appointments later
            this.lstStrPatientApps.add(this.newAppointmentInst.getAppUniqueKey());
        
    }
    
    public void addMedicine(String medtoadd){
        
    }
    
   
    
// @@@@@@@@@@ getters for this subclass @@@@@@@@@@
    

//only patients have their contact details stored on system so this wasn't in the 
//abstract class or interface    
    public String getContactDetail(){
       return this.strContactDetail;
    }
     
        
    //@@@@@ needs to return a composite of all toString calls on the objects inside of the Doctors ArrayList @@@@@
    //for parts of the program which need to retireve all doctors a patient is registered with
    /*public String getDrsRegWithAsStringAsUserNames(){ 
         String allDrs="";
        
         //iterator design pattern
        for (String Drs : this.lstStrDrsRegsWith) {                        // <4>
            System.out.println (Drs);
            
                allDrs = allDrs + ", " + Drs;
          
        }
        
        if (allDrs == "") {
            return "the patient is not registered with any doctors";
        }
        else {
            return allDrs.substring(2); //substring(2) crops unwanted commas
        }
   }
     */
    
    //for parts of the program which need to retrieve all doctors that a patient is registered with
    //but as a string, not a list collection
    public String getDrsRegWithAsStringAsDrsnames(){ 
         String allDrs="";
        
         //iterator design pattern
       
         
        for (String Drs : this.lstStrDrsRegsWith) {
        
            //MainDoctor drgenerator = (MainDoctor) MainAbsSystemUserComponent.getSystemUserComponent(Drs);
        
            //allDrs = drgenerator.getUserName() + ",";
            allDrs = allDrs + ", " + Drs;
         
        }
        
        if (allDrs == "") {
            return "the patient is not registered with any doctors";
        }
        else {
            return allDrs.substring(2);
            //.substring(2)
        }
    }
    
    //returns the patient object's Drs they are regsitered with as a list
    //these will be usernames, will need converting into Dr names
    public List<String> getDrsRegWithAsList(){
        
        return this.lstStrDrsRegsWith;
    }
    
       
    
    public void getAppointment(){
        
    }
}
       

