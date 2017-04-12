
package pkg15070779drsappsystem.ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;

public class ActListAmendSelPatientRec implements ActionListener{
    //combobox with the appointment keys is passed to this action listener so you can get the selected item
    JComboBox cmbAppKeys;
    public ActListAmendSelPatientRec(JComboBox appkeys){
        this.cmbAppKeys = appkeys;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        //get the key from the combobox that has been passed in
        String keyToSearch = this.cmbAppKeys.getSelectedItem().toString();
        
        //get the appointment object from the map
        
        
        //populate a JPanel form with all details, ready to be edited & updated... then when button is pressed...
        
        
        
        //...in another class - update teh appointment with given key, put the appointment back in the map
        

        
    }
    
}
