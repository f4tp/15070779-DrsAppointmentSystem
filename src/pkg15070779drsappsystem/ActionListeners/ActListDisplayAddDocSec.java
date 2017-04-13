
package pkg15070779drsappsystem.ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import pkg15070779drsappsystem.JFrames.JFrameSecretaryMenu;

public class ActListDisplayAddDocSec implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        //System.out.println("I have succeeded");
        JFrameSecretaryMenu SecMenuRef = JFrameSecretaryMenu.getInstance();
        SecMenuRef.setSecSouthBorderString("AddDocsPanel");
    }
    
}
