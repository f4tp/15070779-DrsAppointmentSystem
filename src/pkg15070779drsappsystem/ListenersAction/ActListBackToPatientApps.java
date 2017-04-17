
package pkg15070779drsappsystem.ListenersAction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import pkg15070779drsappsystem.JFrames.JFrameDoctorMenu;
import pkg15070779drsappsystem.JFrames.JFrameSecretaryMenu;


public class ActListBackToPatientApps implements ActionListener{
    String calledFrom;
    public ActListBackToPatientApps(String calledfrom){
        this.calledFrom = calledfrom;
    }

     //takes you back to the patient's appointments that were previously loaded simply by hiding the amend
    //Jpanel and making visible the old JPanel
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if (this.calledFrom == "Sec"){
             JFrameSecretaryMenu refHolder = JFrameSecretaryMenu.getInstance();
        refHolder.setSecNorthBorderString("DispPatientAppointments");
        }
        
        else if (this.calledFrom =="Doc"){
        JFrameDoctorMenu refHolder = JFrameDoctorMenu.getInstance();
        refHolder.setDocSouthBorderString("DispPatientAppointments");
        }
        
        
    }
    
}
