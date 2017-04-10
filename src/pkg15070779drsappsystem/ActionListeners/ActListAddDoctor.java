
package pkg15070779drsappsystem.ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import pkg15070779drsappsystem.JFrames.JFrameSecretaryMenu;
import pkg15070779drsappsystem.MainClasses.MainPatient;

public class ActListAddDoctor implements ActionListener {
        private String docToAdd;
        JComboBox drsComboBox;
    public ActListAddDoctor(JComboBox drsCombo){
      drsComboBox = drsCombo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      
        docToAdd = drsComboBox.getSelectedItem().toString();
        
        // this method returns false, it means teh patient is already regsitered with teh doctor - so a message
        //will display, but if true, it will add the Doctor to the patients instance list, then reput them back in the map
       if (MainPatient.currentPatient.addDrRegsWith(docToAdd, MainPatient.currentPatient.getUserName()) == true){
            JFrameSecretaryMenu SecMenuRef = JFrameSecretaryMenu.getInstance();
        SecMenuRef.setSecSouthBorderString("DisplayPatientDetails");
       }
       
    }
    
}
