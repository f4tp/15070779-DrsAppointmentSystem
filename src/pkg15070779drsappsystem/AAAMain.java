package pkg15070779drsappsystem;

import java.util.*;

public class AAAMain {
    
        public static void main(String[] args) {
         
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
