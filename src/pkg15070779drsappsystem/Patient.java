package pkg15070779drsappsystem;
import java.util.*;

public class Patient extends SystemUserComponent {
    
    //fields the patient must be initialised with
    private String apptest; //change this - only there for test purposes
    
    //fields that are optional
    private String MedicalNotes;//comments about the patient, generated from appointment comments
    private Appointment newAppinstance; //object composition - new appointment object each time the patient
    
    //collections of objects that the patient might have / are all optional
    private List<String> lstDrsRegsWith; //list of Doctors for each patient
    private List<Appointment> lstPatientApps;
    private String fullName;
    
    public String getFullName(){
        return this.getFirstName(this) + " " + this.getSurname(this);
    }
    
    public Patient(String fname, String sname, String title, int yob, String newer){
        super(fname, sname, title, yob); //initialise this object using its superclass
        this.apptest = newer; //example new data added to teh patient specific data
        setPutInMap(this); //add the user object to the map
        lstDrsRegsWith  = new ArrayList<>(); //each patient gets a new list
        lstPatientApps = new ArrayList<>(); //each paient gets a new arraylist of appointments
    
    }
    
    public void setAddNewAppointment(String name, Date appdate, long apptime, String drwith){
        //String Name = ""; //get first name get surname from super class & concatenate
        //Date appDate = new Date(1001001); //test data - change - this will be fed in from input boxes
        //long appTime = 99200029; //test data - change
        //String drWith = "Test Dr"; //test data - fed in from user screen
        
        String Name = name;
        Date appDate = appdate;
        long appTime = apptime;
        String drWith = drwith;
        this.newAppinstance = new Appointment (Name, appDate, appTime, drWith);
        this.lstPatientApps.add(newAppinstance);
    }
    
    //adds a doctor to the list for teh patient created
    public void setAddDrRegsWith(String docName){
        this.lstDrsRegsWith.add(docName);
    }
    
    //returns a string of all Doctors a patient is regsitered with
    public String getDrsRegWith(){ 
         String allDrs="";
        
         //iterator design pattern
        for (String Drs : this.lstDrsRegsWith) {                        // <4>
            System.out.println (Drs);
            if (allDrs == ""){
                allDrs = Drs;
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
       

