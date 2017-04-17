
package pkg15070779drsappsystem.ListenersAction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import pkg15070779drsappsystem.JFrames.JFramePharmacistMenu;

public class ActListSetSecJFramePARTofFACTORYpharm implements ActionListener {
    String panelStringToSet;
    public ActListSetSecJFramePARTofFACTORYpharm(String paneltodisp){
        this.panelStringToSet = paneltodisp;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        JFramePharmacistMenu frameholder = JFramePharmacistMenu.getInstance();
        frameholder.setPharmNorthBorderString(this.panelStringToSet);
    }
    
}
