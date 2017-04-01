package pkg15070779drsappsystem;
import java.util.*;
import javax.swing.JOptionPane;

public class Patient extends SystemUserComponent {
//instance variables that are not essential to initialisation
    private String MedicalNotes;//comments about the patient, generated from appointment comments
    private Appointment newAppinstance; //object composition - new appointment object each time the patient
    private String fullName;
    private String telNumber;
    
//collections of objects that the patient has to have one of
    private List<String> lstDrsRegsWith; //list of Doctors for each patient - stores dr username, can use this to return doctor name
//collections of objects that the patient might have / are all optional
    private List<String> lstPatientApps;
    private List<String> lstMedicine; //stores string details only to display in each file, medicine objects stored in component class

//@@@@@@@@@@ constructor method @@@@@@@@@@
    public Patient(String fname, String sname, String title, String dob, String telnum, String dronfile){
        super(fname, sname, title, dob); //initialise this object using its superclass    
        telNumber = telnum;
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
        this.newAppinstance = new Appointment (Name, appDate, appTime, drWith);
        
        this.lstPatientApps.add(newAppinstance.getAppUniqueKey());
        //added again again
    }
    
// @@@@@@@@@@ getters @@@@@@@@@@
    //when passed the username of a Doctor, it will return their Dr Name
    private String getDoctorNameWithKy(String drUniqueKey){
         return "CHANGE ME  " + drUniqueKey;
    }
    
     public String getFullName(){
        return super.getFirstName(this) + " " + super.getSurname(this);
    }
    
    private String getUserName(){
        return super.getUserName(this);
    }
    
    
    //@@@@@ needs to return a composite of all toString calls on the objects inside of the Doctors ArrayList @@@@@
    public String getDrsRegWith(){ 
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
       

