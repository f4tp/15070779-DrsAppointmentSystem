package pkg15070779drsappsystem;
import java.util.*;
public class Appointment extends AppointmentComponent {
    
    private String AppUniqueKey;
    private String patientName;
    private Date appDate;
    private long appTime;
    private String drAppWith;
    private Boolean appAttended;
    private Boolean appCancelled;
    private String appDrComments;
    private String appMedicine;
     
    public Appointment(String patientname, Date appdate, long apptime, String drwith){
        setCreateAppointment(patientname, appdate, apptime, drwith);
    }
    @Override //this does the exact same thing in the super class... do I need this here?
    //can I call this differently?
    public Appointment getAppointment(String uniqueKey){
        return super.getAppointment(uniqueKey);
    }
                
    public void setCreateAppointment(String patientname, Date appdate, long apptime, String drwith){
        this.AppUniqueKey = generateAppUniqueKey();
        this.patientName = patientname;
        this.appDate = appdate;
        this.appTime = apptime;
        this.appAttended = false;
        this.appCancelled = false;
        this.appDrComments="please enter comments";
        this.appMedicine="please update this if medicine is required for this appointment";
        setPutInMap(this.AppUniqueKey, this);
    }
    
    public void setAppAttend(){
        if (this.appAttended = false){
            this.appAttended = true;
        }
        else if (this.appAttended = true){
            this.appAttended = false;
        }
    }
    
    public void setAppCancelled(){
        if (this.appCancelled = false){
            this.appCancelled = true;
        }
        else if (this.appCancelled = true){
            this.appCancelled = false;
        }
    }
    
        
}
