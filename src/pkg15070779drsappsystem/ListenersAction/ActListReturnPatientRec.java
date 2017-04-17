
package pkg15070779drsappsystem.ListenersAction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import pkg15070779drsappsystem.JFrames.JFrameDoctorMenu;
import pkg15070779drsappsystem.JFrames.JFrameSecretaryMenu;

public class ActListReturnPatientRec implements ActionListener {
    
    String calledFrom;
    
    public ActListReturnPatientRec(String calledfrom){
        this.calledFrom = calledfrom;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (this.calledFrom == "Sec"){
            JFrameSecretaryMenu SecMenuRef = JFrameSecretaryMenu.getInstance();
        SecMenuRef.setSecNorthBorderString("DisplayPatientDetails");
        }
        else if (this.calledFrom =="Doc"){
        JFrameDoctorMenu DocMenuRef = JFrameDoctorMenu.getInstance();
        DocMenuRef.setDocSouthBorderString("DisplayPatientDetails");
        }
        
        
    }
    
}
