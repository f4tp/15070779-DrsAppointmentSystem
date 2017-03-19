
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
     
    public void Appointment(String patientname, Date appdate, long apptime, String drwith){
        setCreateAppointment(patientname, appdate, apptime, drwith);
    }
    
    public void setCreateAppointment(String patientname, Date appdate, long apptime, String drwith){
        this.AppUniqueKey = generateAppUniqueKey();
        this.patientName = patientname;
        this.appDate = appdate;
        this.appTime = apptime;
        this.appAttended = false;
        this.appCancelled = false;
        this.appDrComments="please enter comments";
        setPutInMap(this.AppUniqueKey, this);
    }
    
    public void appAttend(){
        if (this.appAttended = false){
            this.appAttended = true;
        }
        else if (this.appAttended = true){
            this.appAttended = false;
        }
    }
    
    public void appCancelled(){
        if (this.appCancelled = false){
            this.appCancelled = true;
        }
        else if (this.appCancelled = true){
            this.appCancelled = false;
        }
    }
    
        
}
