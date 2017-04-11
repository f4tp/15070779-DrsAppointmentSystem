package pkg15070779drsappsystem.AAAInitialClasses;

import pkg15070779drsappsystem.AbstractClasses.MainAbsScheduling;
import pkg15070779drsappsystem.JFrames.JFrameLoginScreen;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.*;
import pkg15070779drsappsystem.JFrames.JFrameUseToTestPanels;
import pkg15070779drsappsystem.JPanels.JPanelSelDateFlow;

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
   
        
     JFrameUseToTestPanels tester = new JFrameUseToTestPanels();
     tester.setVisible(true);
 
        
      
 
    }
        

    
}
