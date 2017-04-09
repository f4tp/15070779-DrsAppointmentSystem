package pkg15070779drsappsystem.AAAInitialClasses;

import pkg15070779drsappsystem.AbstractClasses.MainDateResolution;
import pkg15070779drsappsystem.JFrames.JFrameLoginScreen;
import java.text.ParseException;
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
        
        //Date testDate = new Date(556656444);
        String strDate = "2016-08-16";
        System.out.println(MainDateResolution.resolveDate(strDate));
        
                   
    }
    
}
