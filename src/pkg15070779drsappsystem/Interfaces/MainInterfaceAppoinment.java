
package pkg15070779drsappsystem.Interfaces;

import java.time.LocalDateTime;
import java.util.List;

//will ensure all different types of appointment will include all of the relevent methods, should teh doctor's surgery 
//every add different appointment types - nurse appoitnments, physiotherapy appointments etc.
public abstract interface MainInterfaceAppoinment {
    
    //all getters
    String getAppUniqueKey();
    LocalDateTime getAPPDateAndTime();
    String getSymptoms();
    Boolean getAttended();
    Boolean getMissed();
    Boolean getCancelled();
    String getProfessionalAppWith();
    String getProfessionalsComments();
    
    //all setters
    void setProfessionalsComments(String proessionalscommentsin);
    void setAppAttend(Boolean attendstatus);
    void setSymptoms(String symptomstoset);
    void setAppMissed(Boolean missedstatus);
    void setAppDateTime(LocalDateTime appDateTime);


}
