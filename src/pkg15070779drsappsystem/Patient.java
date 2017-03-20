package pkg15070779drsappsystem;
import java.util.*;

public class Patient extends SystemUserComponent {
    //fields the patient must be initialised with
    private String apptest; //change this - only there for test purposes
    
    //fields that are optional
    private String MedicalNotes;//comments about the patient, generated from appointment comments
    private Appointment newAppinstance; //object composition - new appointment object each time the patient
    
    //collections of objects that the patient might have / are all optional
    private List<String> lstDrsRegsWith; //list of Doctors for each patient - stores dr username, can use this to return doctor name
    private List<String> lstPatientApps;
    private String fullName;
           
    public Patient(String fname, String sname, String title, int yob, String newer){
        super(fname, sname, title, yob); //initialise this object using its superclass
        this.apptest = newer; //example new data added to teh patient specific data
        setPutInMap(this); //add the user object to the map
        lstDrsRegsWith  = new ArrayList<>(); //each patient gets a new list to store dr username
        lstPatientApps = new ArrayList<>(); //each paient gets a new arraylist of appointments
    }
    
     public String getFullName(){
        return super.getFirstName(this) + " " + super.getSurname(this);
    }
    
    private String getUserName(Patient patient){
        return super.getUserName(this);
    }
    
    public void setAddNewAppointment(String name, Date appdate, long apptime, String drwith){
       
        String Name = name;
        Date appDate = appdate;
        long appTime = apptime;
        String drWith = drwith;
        this.newAppinstance = new Appointment (Name, appDate, appTime, drWith);
        
        this.lstPatientApps.add(newAppinstance.getAppUniqueKey());
        //added again
    }
    
    
    
   
    //adds a doctor string - unique key - to the list for the patient created
    public void setAddDrRegsWith(Doctor docName){
        //this.lstDrsRegsWith.add(docName);
    }
    
    //@@@@@ needs to return a composite of all toString calls on the objects inside of the Doctors ArrayList @@@@@
    private String getDrsRegWith(){ 
         String allDrs="";
        
         //iterator design pattern
        for (String Drs : this.lstDrsRegsWith) {                        // <4>
            System.out.println (Drs);
            if (allDrs == ""){
                //allDrs = Drs;
            }
            else {
                allDrs = allDrs + ", " + Drs;
            }
        }
        
        if (allDrs == "") {
            return "the patient is not regisered with any doctors";
        }
        else {
            return allDrs;
        }
    }
    
    
    public void getAppointment(){
        
    }
}
       

