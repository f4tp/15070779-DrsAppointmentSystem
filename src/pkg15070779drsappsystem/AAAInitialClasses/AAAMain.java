package pkg15070779drsappsystem.AAAInitialClasses;

import pkg15070779drsappsystem.JFrames.JFrameLoginScreen;
import java.text.ParseException;
import pkg15070779drsappsystem.MainClasses.MainAppointment;

public class AAAMain {
    
        public static void main(String[] args) throws ParseException {
        
        //load user, appointments, prescription data into the system
        AABLoadData.LoadData();
        
        //routine checks all appointments  that haven't had their attended status (marked / missed / cancelled) updated
    //that have happened before today's date and time, and will mark them as missed
        MainAppointment.setAllRelAppsAsMissed();       
 
 //Login screen - should be first thing to see
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrameLoginScreen mainLoginScreen = JFrameLoginScreen.getInstance();
                mainLoginScreen.setVisible(true);
            } 
        });

 
    }
        

    
}
