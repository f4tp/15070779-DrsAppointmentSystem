package pkg15070779drsappsystem.ListenersAction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import pkg15070779drsappsystem.MainAbstractClasses.LogoutAbstract;


public class ActListLogoutSystem implements ActionListener {
    
    public ActListLogoutSystem(){
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //when called, logs out of the system
        LogoutAbstract.Logout();
      }
    
   
    
    
    
}
