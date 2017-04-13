
package pkg15070779drsappsystem.ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import javax.swing.JComboBox;
import pkg15070779drsappsystem.JFrames.JFrameSecretaryMenu;
import pkg15070779drsappsystem.JPanels.JPanelAppAmendSecView;
import pkg15070779drsappsystem.MainAbstractClasses.MainAbsAppointmentComponent;
import pkg15070779drsappsystem.MainAbstractClasses.MainAbsSystemUserComponent;
import pkg15070779drsappsystem.MainClasses.MainAppointment;
import pkg15070779drsappsystem.MainClasses.MainPatient;

public class ActListAmendSelPatientRec implements ActionListener{
    
    
    
    //combobox with the appointment keys is passed to this action listener so you can get the selected item
    JComboBox cmbAppKeys;
    public ActListAmendSelPatientRec(JComboBox appkeys){
        this.cmbAppKeys = appkeys;
    }
 //displays the amend the patient's record form by hiding all the rest and displaying just this one
    //secreatary view
    @Override
    public void actionPerformed(ActionEvent ae) {
        //get the key from the combobox that has been passed in
        String keyToSearch = this.cmbAppKeys.getSelectedItem().toString();        

        //set the currently selected appointment to the one you want to work on
        MainAppointment.currentAppointment = (MainAppointment) MainAbsAppointmentComponent.getAppointment(keyToSearch);
         //main patient already set when we searched for the patient so doesn't need resetting
       
         //at this point, the right appointment will be in teh static variable, and so will the right patient, we can then use
         //these details to populate the amend form by callign the method which does this in this JPanel
         
         String curPatTitle = MainPatient.currentPatient.getTitle();
         String curPatFirstname = MainPatient.currentPatient.getFirstName();
         String curPatSurname = MainPatient.currentPatient.getSurname();
         String curPatUsername = MainPatient.currentPatient.getUserName();
         String curAppId = MainAppointment.currentAppointment.getAppUniqueKey();
         //String curAppDrWith = MainAppointment.currentAppointment.
         
         
         
         //JPanelAppAmendSecView jpanAmmendAppSingInst = JPanelAppAmendSecView.getInstance();
         JPanelAppAmendSecView.updateFormComponents(keyToSearch, keyToSearch, keyToSearch, keyToSearch, keyToSearch, keyToSearch, LocalDateTime.MIN, keyToSearch, Boolean.TRUE, Boolean.FALSE, Boolean.FALSE, keyToSearch, keyToSearch);
        
        
         JFrameSecretaryMenu refHolder = JFrameSecretaryMenu.getInstance();
        refHolder.setSecSouthBorderString("ShowAmendApps");
        
       
        
        //get the appointment object from the map
        
        
        //populate a JPanel form with all details, ready to be edited & updated... then when button is pressed...
        
        
        
        //...in another class - update the appointment with given key, put the appointment back in the map
        

        
       
        
    }
    
}
