
package pkg15070779drsappsystem.ListenersAction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import pkg15070779drsappsystem.JFrames.JFrameDoctorMenu;
import pkg15070779drsappsystem.JPanels.JPanelAppAddPrescrip;
import pkg15070779drsappsystem.JPanels.JPanelAppAmendDocView;
import pkg15070779drsappsystem.MainAbstractClasses.AppointmentComponent;
import pkg15070779drsappsystem.MainAbstractClasses.PrescriptionComponent;
import pkg15070779drsappsystem.MainClasses.Appointment;

public class ActListAddPrescription implements ActionListener {
    JTextField jtfMedicineDesc;
    JTextField jtfMedicineAmount;
    //String AppointmentID;
    //String PatientID;
    //String DrID;
    
    //calls it with the appointment id, the medicie description textfield, and the amount textfield
    public ActListAddPrescription(JTextField medicinedesc, JTextField medicineamount){
        this.jtfMedicineDesc = medicinedesc;
        this.jtfMedicineAmount = medicineamount;

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
      Appointment currAppInst = (Appointment) AppointmentComponent.getAppointment(JPanelAppAddPrescrip.getInstance().getAppID());
        
        //add Prescription with details passed through
       currAppInst.addPrescriptionForApp(JPanelAppAddPrescrip.getInstance().getPresDesc(), JPanelAppAddPrescrip.getInstance().getPresAmount(), 
               JPanelAppAddPrescrip.getInstance().getPatID(), JPanelAppAddPrescrip.getInstance().getDrID(),
               JPanelAppAmendDocView.getInstance().getAppointmentID());
       
        //go back to patient record screen
        
        JFrameDoctorMenu DocMenuRef = JFrameDoctorMenu.getInstance();
        DocMenuRef.setDocSouthBorderString("DisplayPatientDetails");
    }
    
}
