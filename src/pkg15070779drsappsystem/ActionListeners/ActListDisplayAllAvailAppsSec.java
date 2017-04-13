
package pkg15070779drsappsystem.ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import pkg15070779drsappsystem.JFrames.JFrameSecretaryMenu;

public class ActListDisplayAllAvailAppsSec implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent ae) {
       
        JFrameSecretaryMenu refHolder = JFrameSecretaryMenu.getInstance();
        refHolder.setSecSouthBorderString("ShowAvailApps");
    }
    
}
