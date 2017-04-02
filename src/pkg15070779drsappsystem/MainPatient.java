package pkg15070779drsappsystem;
import java.util.*;
import javax.swing.JOptionPane;

public class MainPatient extends MainAbsSystemUserComponent {
//instance variables that are not essential to initialisation
    private String MedicalNotes;//comments about the patient, generated from appointment comments
    private MainAppointment newAppinstance; //object composition - new appointment object each time the patient
    private String fullName;
    private String contactDetail;
    
//public static variables
    public static MainPatient currentPatient; //holds the current patient that any class is working on / with
    //does not hold an instance, acts as a pointer to the main object
    
//collections of objects that the patient has to have one of
    private List<String> lstDrsRegsWith; //list of Doctors for each patient - stores dr username, can use this to return doctor name
//collections of objects that the patient might have / are all optional
    private List<String> lstPatientApps;
    private List<String> lstMedicine; //stores string details only to display in each file, medicine objects stored in component class

//@@@@@@@@@@ constructor method @@@@@@@@@@
    public MainPatient(String fname, String sname, String title, String dob, String telnum, String dronfile){
        super(fname, sname, title, dob); //initialise this object using its superclass    
        contactDetail = telnum;
        lstDrsRegsWith  = new ArrayList<>(); //each patient gets a new list to store dr username
        setAddDrRegsWith(dronfile); //forces at least one dr to be registered
        lstPatientApps = new ArrayList<>(); //each paient gets a new arraylist of appointments
        setPutInMap(this); //add the user object to the map
    }
//@@@@@@@@@@ SETTERS @@@@@@@@@@    
    //adds the username of a new dr that the patient will be regsitered with to the list
    public void setAddDrRegsWith(String drToAdd){
        if (this.lstDrsRegsWith.contains(drToAdd)){
            JOptionPane.showMessageDialog (null,"The patient is already registered with this Dr",
                "Dr Already Registered With Patient",
                JOptionPane.ERROR_MESSAGE);
        }
        else {
            this.lstDrsRegsWith.add(drToAdd);
        }
                
    }
    
    public void setAddMedicine(String medtoadd){
        
    }
    
    public void setAddNewAppointment(String name, Date appdate, long apptime, String drwith){
       
        String Name = name;
        Date appDate = appdate;
        long appTime = apptime;
        String drWith = drwith;
        this.newAppinstance = new MainAppointment (Name, appDate, appTime, drWith);
        
        this.lstPatientApps.add(newAppinstance.getAppUniqueKey());
        //added again again
    }
    
// @@@@@@@@@@ getters @@@@@@@@@@
    //when passed the username of a Doctor, it will return their Dr Name
    private String getDoctorNameWithKy(String drUniqueKey){
         return "CHANGE ME  " + drUniqueKey;
    }
    
    private String getUserName(){
        return super.getUserName(this);
    }
    
    public String getFullName(){
        return super.getFirstName(this) + " " + super.getSurname(this);
    }
    
    
    public String getContactDetail(){
        return this.contactDetail;
    }
     
     public String getTitle(){
         return  super.getTitle(this);
   
     }
     
     public String getFirstName(){
         return  super.getFirstName(this);
   
     }
      public String getSurname(){
         return  super.getSurname(this);
   
     }
      
      public String getDOB(){
         return  super.getDOB(this);
   
     }
    
    
    //@@@@@ needs to return a composite of all toString calls on the objects inside of the Doctors ArrayList @@@@@
    public String getDrsRegWithAsStringAsUserNames(){ 
         String allDrs="";
        
         //iterator design pattern
        for (String Drs : this.lstDrsRegsWith) {                        // <4>
            System.out.println (Drs);
            
                allDrs = allDrs + ", " + Drs;
          
        }
        
        if (allDrs == "") {
            return "the patient is not registered with any doctors";
        }
        else {
            return allDrs.substring(2);
        }
    }
    
    public String getDrsRegWithAsStringAsDrsnames(){ 
         String allDrs="";
        
         //iterator design pattern
        for (String Drs : this.lstDrsRegsWith) {                        // <4>
            System.out.println (Drs);
            MainDoctor drgenerator = (MainDoctor) MainAbsSystemUserComponent.getSystemUserComponent(Drs);
            allDrs = drgenerator.setGenerateUniqueDrName() + ",";
         
        }
        
        if (allDrs == "") {
            return "the patient is not registered with any doctors";
        }
        else {
            return allDrs;
            //.substring(2)
        }
    }
    
    //returns the patient object's Drs they are regsitered with as a list
    //these will be usernames, will need converting into Dr names
    public List<String> getDrsRegWithAsList(){
        
        return this.lstDrsRegsWith;
    }
    
       
    
    public void getAppointment(){
        
    }
}
       

