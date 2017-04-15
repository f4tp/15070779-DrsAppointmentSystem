
package pkg15070779drsappsystem.ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import pkg15070779drsappsystem.JFrames.JFrameDoctorMenu;

public class ActListDisplayJPanePatientRecDocView implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent ae) {
    
        JFrameDoctorMenu singinst = JFrameDoctorMenu.getInstance();
        singinst.setDocSouthBorderString("DisplayPatientDetails");
        
    }
    
}
