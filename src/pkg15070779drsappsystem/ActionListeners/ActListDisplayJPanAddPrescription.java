
package pkg15070779drsappsystem.ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import pkg15070779drsappsystem.JFrames.JFrameDoctorMenu;
import pkg15070779drsappsystem.JPanels.JPanelAppAddPrescrip;

public class ActListDisplayJPanAddPrescription implements ActionListener {
String appIDIn;
String patIDIn;
String DrIDIn;
    public ActListDisplayJPanAddPrescription(String appidin, String patientidin, String dridin) {
        this.appIDIn = appidin;
        this.patIDIn = patientidin;
        this.DrIDIn = dridin;
        System.out.println(appIDIn);
        System.out.println(patIDIn);
        System.out.println(DrIDIn);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.println("im here   " + this.appIDIn);
            //transfers tthe appoinment ID across to the jpan where we are adding the prescription
            JPanelAppAddPrescrip instHolderAddPres = JPanelAppAddPrescrip.getInstance();
            JPanelAppAddPrescrip.setIdsInAppPatDr(appIDIn, patIDIn, DrIDIn);
            
            
           JFrameDoctorMenu instHolder = JFrameDoctorMenu.getInstance();
            instHolder.setDocSouthBorderString("DisplayAddPresc");
            

    }
    
}
