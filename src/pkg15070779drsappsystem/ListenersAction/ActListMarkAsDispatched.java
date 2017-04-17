
package pkg15070779drsappsystem.ListenersAction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import pkg15070779drsappsystem.MainAbstractClasses.MainAbsPrescriptionComponent;
import pkg15070779drsappsystem.MainClasses.MainPrescription;

public class ActListMarkAsDispatched implements ActionListener {

    JComboBox cmbPresIDPassedIn;
    JButton btnReSubmitSearch;
    
    public ActListMarkAsDispatched(JComboBox passedin, JButton buttonpassedin){
        this.cmbPresIDPassedIn = passedin;
        this.btnReSubmitSearch = buttonpassedin;
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        
     if (this.cmbPresIDPassedIn.getSelectedItem() == null){
           //messagebox to say the item is empty
             JOptionPane.showMessageDialog (null,
                     "The prescription list is empty, please search for prescriptions above ",
                     "No prescription selected",
                     JOptionPane.ERROR_MESSAGE);
     }
        //if the combobox isn;t empty, update the given prescription as dispatched
        else if (this.cmbPresIDPassedIn.getSelectedItem() != null){
            MainPrescription currPresInst = (MainPrescription) MainAbsPrescriptionComponent.getMainPrescription(this.cmbPresIDPassedIn.getSelectedItem().toString());
            currPresInst.setPresAsDispatched();
            
            //messagebox to confirm
             JOptionPane.showMessageDialog (null,
                     "The prescription has been marked as DISPATCHED",
                     "Prescription status: Dispatched",
                     JOptionPane.ERROR_MESSAGE);
            
            //rerun the search so that this particular pres ID is not in the combobox anymore
            //do this by programatically clicking the button to rerun teh search just conducted, although now this
            //particular prescription will not be included as it is no longer marked as not dispatched
            btnReSubmitSearch.doClick();
            
      
            
        }
    }
    
}
