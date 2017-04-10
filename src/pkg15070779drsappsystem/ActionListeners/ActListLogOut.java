package pkg15070779drsappsystem.ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import pkg15070779drsappsystem.AbstractClasses.MainAbsSystemUserComponent;
import pkg15070779drsappsystem.JFrames.JFrameDoctorMenu;
import pkg15070779drsappsystem.JFrames.JFrameLoginScreen;
import pkg15070779drsappsystem.JFrames.JFramePatientMenu;
import pkg15070779drsappsystem.JFrames.JFramePharmacistMenu;
import pkg15070779drsappsystem.JFrames.JFrameSecretaryMenu;
import static pkg15070779drsappsystem.JFrames.JFrameSecretaryMenu.getInstance;
import pkg15070779drsappsystem.MainClasses.MainAppointment;
import pkg15070779drsappsystem.MainClasses.MainDoctor;
import pkg15070779drsappsystem.MainClasses.MainPatient;

public class ActListLogOut implements ActionListener {
    
    public ActListLogOut(){
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainAbsSystemUserComponent.currentSystemUser = null;
        MainPatient.currentPatient = null;
        MainAppointment.currentAppointment = null;
        MainDoctor.currentDoctor = null;
        
        JFrameSecretaryMenu instHolder = JFrameSecretaryMenu.getInstance();
        instHolder.setVisible(false);
        
        JFrameDoctorMenu instHolderr = JFrameDoctorMenu.getInstance();
        instHolderr.setVisible(false);
        
        JFramePatientMenu instHolderrr = JFramePatientMenu.getInstance();
        instHolderrr.setVisible(false);
        
        //JFramePharmacistMenu instHolderrrr = JFramePharmacistMenu.getInstance();
        //instHolderrrr.setVisible(false);
        
        JFrameLoginScreen loginInstance = JFrameLoginScreen.getInstance();
        loginInstance.setVisible(true);
            
    }
    
   
    
    
    
}
