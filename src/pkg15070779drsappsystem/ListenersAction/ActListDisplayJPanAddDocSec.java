
package pkg15070779drsappsystem.ListenersAction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import pkg15070779drsappsystem.JFrames.JFrameSecretaryMenu;

public class ActListDisplayJPanAddDocSec implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrameSecretaryMenu SecMenuRef = JFrameSecretaryMenu.getInstance();
        SecMenuRef.setSecNorthBorderString("AddDocsPanel");
    }
    
}
