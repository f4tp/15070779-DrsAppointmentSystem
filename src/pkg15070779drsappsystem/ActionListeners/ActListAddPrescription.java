
package pkg15070779drsappsystem.ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import pkg15070779drsappsystem.JFrames.JFrameDoctorMenu;
import pkg15070779drsappsystem.JPanels.JPanelAppAddPrescrip;
import pkg15070779drsappsystem.MainAbstractClasses.MainAbsAppointmentComponent;
import pkg15070779drsappsystem.MainAbstractClasses.MainAbsPrescriptionComponent;
import pkg15070779drsappsystem.MainClasses.MainAppointment;

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
        //object composition - need an appointment to update with the prescription
        //System.out.println("appppppp"+AppointmentID);
       // System.out.println("patttttttttt"+PatientID);
       // System.out.println("appppppp"+DrID);
      MainAppointment currAppInst = (MainAppointment) MainAbsAppointmentComponent.getAppointment(JPanelAppAddPrescrip.getInstance().getAppID());
        
        //add Prescription with details passed through
       currAppInst.addPrescriptionForApp(JPanelAppAddPrescrip.getInstance().getPresDesc(), JPanelAppAddPrescrip.getInstance().getPresAmount(), 
               JPanelAppAddPrescrip.getInstance().getPatID(), JPanelAppAddPrescrip.getInstance().getDrID(),
               JPanelAppAddPrescrip.getInstance().getAppID());
       
       System.out.println("HELLLLOOOO " + MainAbsPrescriptionComponent.getMainPrescription("Prescription1"));
        
        
        //show message box to say it is complete
        
        
        
        //go back to patient record screen
        
        JFrameDoctorMenu DocMenuRef = JFrameDoctorMenu.getInstance();
        DocMenuRef.setDocSouthBorderString("DisplayPatientDetails");
    }
    
}
