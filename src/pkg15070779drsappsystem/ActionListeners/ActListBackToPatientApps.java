
package pkg15070779drsappsystem.ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import pkg15070779drsappsystem.JFrames.JFrameSecretaryMenu;


public class ActListBackToPatientApps implements ActionListener{

     //takes you back to the patient's appointments that were previously loaded simply by hiding the amend
    //Jpanel and making visible the old JPanel
    @Override
    public void actionPerformed(ActionEvent ae) {
         JFrameSecretaryMenu refHolder = JFrameSecretaryMenu.getInstance();
        refHolder.setSecSouthBorderString("DispPatientAppointments");
        
    }
    
}
