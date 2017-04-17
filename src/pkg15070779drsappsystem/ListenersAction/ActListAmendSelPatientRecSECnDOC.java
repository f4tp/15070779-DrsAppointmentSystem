
package pkg15070779drsappsystem.ListenersAction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import javax.swing.JComboBox;
import pkg15070779drsappsystem.JFrames.JFrameDoctorMenu;
import pkg15070779drsappsystem.JFrames.JFrameSecretaryMenu;
import pkg15070779drsappsystem.JPanels.JPanelAppAmendDocView;
import pkg15070779drsappsystem.JPanels.JPanelAppAmendSecView;
import pkg15070779drsappsystem.MainAbstractClasses.MainAbsAppointmentComponent;
import pkg15070779drsappsystem.MainAbstractClasses.MainAbsPrescriptionComponent;
import pkg15070779drsappsystem.MainAbstractClasses.MainAbsSystemUserComponent;
import pkg15070779drsappsystem.MainClasses.MainAppointment;
import pkg15070779drsappsystem.MainClasses.MainPatient;
import pkg15070779drsappsystem.MainClasses.MainPrescription;

public class ActListAmendSelPatientRecSECnDOC implements ActionListener{
    
    MainAppointment currentAppInst;
    String calledFrom;

    
    //combobox with the appointment keys is passed to this action listener so you can get the selected item
    JComboBox cmbAppKeys;
    public ActListAmendSelPatientRecSECnDOC(JComboBox appkeys, String calledfrom){
        this.cmbAppKeys = appkeys;
        this.calledFrom = calledfrom;
    }
    
    
 //displays the amend the patient's record form by hiding all the rest and displaying just this one
    //secreatary view
    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.println(this.calledFrom);
        if (this.calledFrom == "Sec"){
            System.out.println("I have got inside the sec routine");
        
                    //get the key from the combobox that has been passed in
                    String keyToSearch = this.cmbAppKeys.getSelectedItem().toString();        

                    //set the currently selected appointment to the one you want to work on
                    currentAppInst = (MainAppointment) MainAbsAppointmentComponent.getAppointment(keyToSearch);

                    MainAppointment.currentAppointment = (MainAppointment) MainAbsAppointmentComponent.getAppointment(keyToSearch);
                     //main patient already set when we searched for the patient so doesn't need resetting






                      //if there is a prescription for this appointment, set the current prescription based on the current 
                      //appointment  to the one you want to work on
                      if (currentAppInst.getHasPrescBeenGenerated() == true){
                          MainPrescription.currentPrescription.clear(); //clear the list so it doesn't have old prescriptions in it

                          //for all prescriptions IDs in this appointment precription list...
                          for(String temp: currentAppInst.getListOfPrescriptionIDs())
                              //resolve the prescription and store in the Main appointment list
                              MainPrescription.currentPrescription.add((MainPrescription) MainAbsPrescriptionComponent.getMainPrescription(temp));
                           }




                     //at this point, the right appointment will be in the static variable, and so will the right patient, and so
                     //will the right prescription if it exists, we can then use
                     //these details to populate the amend form by callign the method which does this in this JPanel

                     String curPatTitle = MainPatient.currentPatient.getTitle();
                     String curPatFirstname = MainPatient.currentPatient.getFirstName();
                     String curPatSurname = MainPatient.currentPatient.getSurname();
                     String curPatUsername = MainPatient.currentPatient.getUserName();

                     String curAppId = MainAppointment.currentAppointment.getAppUniqueKey();
                     String curAppDrWith = MainAppointment.currentAppointment.getDrAppWith();
                     LocalDateTime curAppDateTime = MainAppointment.currentAppointment.getAPPDateAndTime();
                     String currAppsymptoms = MainAppointment.currentAppointment.getSymptoms();
                     String curDrsComments = MainAppointment.currentAppointment.getDrsComments();
                     Boolean curAppAttended = MainAppointment.currentAppointment.getAttended();
                     Boolean curAppCancelled = MainAppointment.currentAppointment.getCancelled();
                     Boolean currAppMissed = MainAppointment.currentAppointment.getMissed();

                     String currPresDetails;

                     if (MainAppointment.currentAppointment.getAllPresDetailsForAppAsString()== "There is no prescription for this appointment yet"){
                        currPresDetails = "";
                     }
                     else {
                         currPresDetails = MainAppointment.currentAppointment.getAllPresDetailsForAppAsString();
                     }



                     //JPanelAppAmendSecView jpanAmmendAppSingInst = JPanelAppAmendSecView.getInstance();
                     JPanelAppAmendSecView.updateFormComponents(curPatTitle, curPatFirstname, curPatSurname, 
                             curPatUsername, curAppId, curAppDrWith, curAppDateTime, currAppsymptoms, curDrsComments, curAppAttended, 
                             curAppCancelled, currAppMissed, currPresDetails);



                     JFrameSecretaryMenu refHolder = JFrameSecretaryMenu.getInstance();
                    refHolder.setSecNorthBorderString("ShowAmendApps");



                    //get the appointment object from the map


                    //populate a JPanel form with all details, ready to be edited & updated... then when button is pressed...



                    //...in another class - update the appointment with given key, put the appointment back in the map

        }
        
        else if (this.calledFrom == "Doc"){
    
        
                    //get the key from the combobox that has been passed in
                    String keyToSearch = this.cmbAppKeys.getSelectedItem().toString();        
                
                    //set the currently selected appointment to the one you want to work on
                    currentAppInst = (MainAppointment) MainAbsAppointmentComponent.getAppointment(keyToSearch);

                    MainAppointment.currentAppointment = (MainAppointment) MainAbsAppointmentComponent.getAppointment(keyToSearch);
                     //main patient already set when we searched for the patient so doesn't need resetting






                      //if there is a prescription for this appointment, set the current prescription based on the current 
                      //appointment  to the one you want to work on
                      if (currentAppInst.getHasPrescBeenGenerated() == true){
                          MainPrescription.currentPrescription.clear(); //clear the list so it doesn't have old prescriptions in it

                          //for all prescriptions IDs in this appointment precription list...
                          for(String temp: currentAppInst.getListOfPrescriptionIDs())
                              //resolve the prescription and store in the Main appointment list
                              MainPrescription.currentPrescription.add((MainPrescription) MainAbsPrescriptionComponent.getMainPrescription(temp));
                           }




                     //at this point, the right appointment will be in the static variable, and so will the right patient, and so
                     //will the right prescription if it exists, we can then use
                     //these details to populate the amend form by callign the method which does this in this JPanel

                     String curPatTitle = MainPatient.currentPatient.getTitle();
                     String curPatFirstname = MainPatient.currentPatient.getFirstName();
                     String curPatSurname = MainPatient.currentPatient.getSurname();
                     String curPatUsername = MainPatient.currentPatient.getUserName();

                     String curAppId = MainAppointment.currentAppointment.getAppUniqueKey();
                     String curAppDrWith = MainAppointment.currentAppointment.getDrAppWith();
                     LocalDateTime curAppDateTime = MainAppointment.currentAppointment.getAPPDateAndTime();
                     String currAppsymptoms = MainAppointment.currentAppointment.getSymptoms();
                     String curDrsComments = MainAppointment.currentAppointment.getDrsComments();
                     String curAppAttended = MainAppointment.currentAppointment.getAttended().toString();
                     String curAppCancelled = MainAppointment.currentAppointment.getCancelled().toString();
                     String currAppMissed = MainAppointment.currentAppointment.getMissed().toString();

                     String currPresDetails;

                     if (MainAppointment.currentAppointment.getAllPresDetailsForAppAsString()== "There is no prescription for this appointment yet"){
                        currPresDetails = "";
                     }
                     else {
                         currPresDetails = MainAppointment.currentAppointment.getAllPresDetailsForAppAsString();
                     }



                     //JPanelAppAmendSecView jpanAmmendAppSingInst = JPanelAppAmendSecView.getInstance();
                     JPanelAppAmendDocView.updateFormComponents(curPatTitle, curPatFirstname, curPatSurname, 
                             curPatUsername, curAppId, curAppDrWith, curAppDateTime, currAppsymptoms, curDrsComments, curAppAttended, 
                             curAppCancelled, currAppMissed, currPresDetails);



                     JFrameDoctorMenu refHolder = JFrameDoctorMenu.getInstance();
                    refHolder.setDocSouthBorderString("ShowAmendApps");



                    //get the appointment object from the map


                    //populate a JPanel form with all details, ready to be edited & updated... then when button is pressed...



                    //...in another class - update the appointment with given key, put the appointment back in the map
        }
        
       
        
    }
    
}
