
package pkg15070779drsappsystem.ListenersAction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import javax.swing.JComboBox;
import pkg15070779drsappsystem.JFrames.JFrameDoctorMenu;
import pkg15070779drsappsystem.JFrames.JFrameSecretaryMenu;
import pkg15070779drsappsystem.JPanels.JPanelAppAmendDocView;
import pkg15070779drsappsystem.JPanels.JPanelAppAmendSecView;
import pkg15070779drsappsystem.MainAbstractClasses.AppointmentComponent;
import pkg15070779drsappsystem.MainAbstractClasses.PrescriptionComponent;
import pkg15070779drsappsystem.MainClasses.Appointment;
import pkg15070779drsappsystem.MainClasses.SysUserPatient;
import pkg15070779drsappsystem.MainClasses.Prescription;

public class ActListAmendSelPatientRecSECnDOC implements ActionListener{
    
    Appointment currentAppInst;
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

        if (this.calledFrom == "Sec"){
           
                    //get the key from the combobox that has been passed in
                    String keyToSearch = this.cmbAppKeys.getSelectedItem().toString();        

                    //set the currently selected appointment to the one you want to work on
                    currentAppInst = (Appointment) AppointmentComponent.getAppointment(keyToSearch);

                    Appointment.currentAppointment = (Appointment) AppointmentComponent.getAppointment(keyToSearch);
                     //main patient already set when we searched for the patient so doesn't need resetting


                      //if there is a prescription for this appointment, set the current prescription based on the current 
                      //appointment  to the one you want to work on
                      if (currentAppInst.getHasPrescBeenGenerated() == true){
                          Prescription.currentPrescriptionList.clear(); //clear the list so it doesn't have old prescriptions in it

                          //for all prescriptions IDs in this appointment precription list...
                          for(String temp: currentAppInst.getListOfPrescriptionIDs())
                              //resolve the prescription and store in the Main appointment list
                              Prescription.currentPrescriptionList.add((Prescription) PrescriptionComponent.getMainPrescription(temp));
                           }




                     //at this point, the right appointment will be in the static variable, and so will the right patient, and so
                     //will the right prescription if it exists, we can then use
                     //these details to populate the amend form by callign the method which does this in this JPanel

                     String curPatTitle = SysUserPatient.currentPatient.getTitle();
                     String curPatFirstname = SysUserPatient.currentPatient.getFirstName();
                     String curPatSurname = SysUserPatient.currentPatient.getSurname();
                     String curPatUsername = SysUserPatient.currentPatient.getUserName();

                     String curAppId = Appointment.currentAppointment.getAppUniqueKey();
                     String curAppDrWith = Appointment.currentAppointment.getProfessionalAppWith();
                     LocalDateTime curAppDateTime = Appointment.currentAppointment.getAPPDateAndTime();
                     String currAppsymptoms = Appointment.currentAppointment.getSymptoms();
                     String curDrsComments = Appointment.currentAppointment.getProfessionalsComments();
                     Boolean curAppAttended = Appointment.currentAppointment.getAttended();
                     Boolean curAppCancelled = Appointment.currentAppointment.getCancelled();
                     Boolean currAppMissed = Appointment.currentAppointment.getMissed();

                     String currPresDetails;

                     if (Appointment.currentAppointment.getAllPresDetailsForAppAsString()== "There is no prescription for this appointment yet"){
                        currPresDetails = "";
                     }
                     else {
                         currPresDetails = Appointment.currentAppointment.getAllPresDetailsForAppAsString();
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
                    currentAppInst = (Appointment) AppointmentComponent.getAppointment(keyToSearch);

                    Appointment.currentAppointment = (Appointment) AppointmentComponent.getAppointment(keyToSearch);
                     //main patient already set when we searched for the patient so doesn't need resetting






                      //if there is a prescription for this appointment, set the current prescription based on the current 
                      //appointment  to the one you want to work on
                      if (currentAppInst.getHasPrescBeenGenerated() == true){
                          Prescription.currentPrescriptionList.clear(); //clear the list so it doesn't have old prescriptions in it

                          //for all prescriptions IDs in this appointment precription list...
                          for(String temp: currentAppInst.getListOfPrescriptionIDs())
                              //resolve the prescription and store in the Main appointment list
                              Prescription.currentPrescriptionList.add((Prescription) PrescriptionComponent.getMainPrescription(temp));
                           }




                     //at this point, the right appointment will be in the static variable, and so will the right patient, and so
                     //will the right prescription if it exists, we can then use
                     //these details to populate the amend form by callign the method which does this in this JPanel

                     String curPatTitle = SysUserPatient.currentPatient.getTitle();
                     String curPatFirstname = SysUserPatient.currentPatient.getFirstName();
                     String curPatSurname = SysUserPatient.currentPatient.getSurname();
                     String curPatUsername = SysUserPatient.currentPatient.getUserName();

                     String curAppId = Appointment.currentAppointment.getAppUniqueKey();
                     String curAppDrWith = Appointment.currentAppointment.getProfessionalAppWith();
                     LocalDateTime curAppDateTime = Appointment.currentAppointment.getAPPDateAndTime();
                     String currAppsymptoms = Appointment.currentAppointment.getSymptoms();
                     String curDrsComments = Appointment.currentAppointment.getProfessionalsComments();
                     String curAppAttended = Appointment.currentAppointment.getAttended().toString();
                     String curAppCancelled = Appointment.currentAppointment.getCancelled().toString();
                     String currAppMissed = Appointment.currentAppointment.getMissed().toString();

                     String currPresDetails;

                     if (Appointment.currentAppointment.getAllPresDetailsForAppAsString()== "There is no prescription for this appointment yet"){
                        currPresDetails = "";
                     }
                     else {
                         currPresDetails = Appointment.currentAppointment.getAllPresDetailsForAppAsString();
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
