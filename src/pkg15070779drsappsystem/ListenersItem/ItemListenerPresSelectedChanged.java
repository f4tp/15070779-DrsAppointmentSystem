
package pkg15070779drsappsystem.ListenersItem;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import pkg15070779drsappsystem.JPanels.JPartPanelTextAreaPrintPresDetail;
import pkg15070779drsappsystem.MainAbstractClasses.AppointmentComponent;
import pkg15070779drsappsystem.MainAbstractClasses.PrescriptionComponent;
import pkg15070779drsappsystem.MainClasses.Appointment;
import pkg15070779drsappsystem.MainClasses.Prescription;

public class ItemListenerPresSelectedChanged implements ItemListener {
    
    JComboBox cmbPresId;
    public ItemListenerPresSelectedChanged(JComboBox cmbpresidin){
        this.cmbPresId = cmbpresidin;
    }

    
    //when the combobox changes, update the text area to reflect the details of the selected prescription ID
    @Override
    public void itemStateChanged(ItemEvent ie) {
       
        //validation - to make sure only valid data passed forward
        if (cmbPresId.getSelectedItem() == null){
            //if there is nothing in the combobox, update the text area with a blank string
              JPartPanelTextAreaPrintPresDetail singinst = JPartPanelTextAreaPrintPresDetail.getInstance();
              singinst.setJtextArea("");
        }
        
        //this means there is somethign in the combobox, so we can search for teh prescription and output the details
        else{
            
      
                    JPartPanelTextAreaPrintPresDetail singinst = JPartPanelTextAreaPrintPresDetail.getInstance();
                    //get the prescription details
                    Prescription currentpresInst = (Prescription) PrescriptionComponent.getMainPrescription(this.cmbPresId.getSelectedItem().toString());

                    //get the appointment thsi prescription is attached to
                    Appointment currentAppInst = (Appointment) AppointmentComponent.getAppointment(currentpresInst.getLinkedAppID());

                    //the actual output is the appointment and teh prescription details
                    singinst.setJtextArea(currentAppInst.toString() + currentpresInst.toString());
                    
        }
        
    }
    
}
