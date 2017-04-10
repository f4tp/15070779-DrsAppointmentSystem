package pkg15070779drsappsystem.AAAInitialClasses;

import pkg15070779drsappsystem.AbstractClasses.MainAppointmentSchedule;
import pkg15070779drsappsystem.JFrames.JFrameLoginScreen;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class AAAMain {
    
        public static void main(String[] args) throws ParseException {
         
        AABLoadData.LoadData();
               
 
 //Login screen - should be first thing to see
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrameLoginScreen mainLoginScreen = JFrameLoginScreen.getInstance();
                mainLoginScreen.setVisibility(true);
            } 
        });
   
 
    }
        

    
}
