
package pkg15070779drsappsystem.ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import pkg15070779drsappsystem.AbstractClasses.MainAbsSystemUserComponent;

public class ActListPrintCurUserRec implements ActionListener {
    
    public ActListPrintCurUserRec(){
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        PrintCurrentUserRecord();
    }
    
    public static void PrintCurrentUserRecord(){
        //polymorphism - the overridden toString routine will display (which will be overridden in each subclass)
        System.out.println(MainAbsSystemUserComponent.currentSystemUser.toString());
    }
    
}
