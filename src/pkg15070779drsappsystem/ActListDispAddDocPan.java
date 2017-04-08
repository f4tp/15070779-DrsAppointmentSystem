
package pkg15070779drsappsystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActListDispAddDocPan implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent ae) {
        JFrameSecretaryMenu SecMenuRef = JFrameSecretaryMenu.getInstance();
         SecMenuRef.setSecSouthBorderString("AddDocsPanel");
    }
    
}
