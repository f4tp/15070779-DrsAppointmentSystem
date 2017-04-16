
package pkg15070779drsappsystem.JPanels;

import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import pkg15070779drsappsystem.ListenersAction.ActListAddPrescription;
import pkg15070779drsappsystem.ListenersAction.ActListDisplayJPanePatientRecDocView;

public class JPanelAppAddPrescrip extends JPanel {
    public static JPanelAppAddPrescrip jpanAddPresSingInst;
    JLabel lblMedicineDesc = new JLabel("Description of medicine to add:");
    JTextField jtfMedicineDesc = new JTextField("");
    
    JLabel lblMedicineAmount = new JLabel("Description of medicine amount:");
    JTextField jtfMedicineAmount = new JTextField("");
    
    JButton btnAddPres = new JButton("Add Prescription");

    JButton btnCancel = new JButton("Cancel");
    private static String AppIdIn;
    private static String patIDIn;
    private static String DrIDIn;
    
    private JPanelAppAddPrescrip(){
       
       setLayout(new GridLayout(3,2));
         add(lblMedicineDesc);
         add(jtfMedicineDesc);
         add(lblMedicineAmount);
         add(jtfMedicineAmount);
         add(btnCancel);
         add(btnAddPres);
       // btnAddPres.addActionListener(new ActListAddPrescription(AppIdIn, patIDIn, DrIDIn, jtfMedicineDesc, jtfMedicineAmount));
        btnAddPres.addActionListener(new ActListAddPrescription(jtfMedicineDesc, jtfMedicineAmount));
        btnCancel.addActionListener(new ActListDisplayJPanePatientRecDocView());
    }
    
    public static JPanelAppAddPrescrip getInstance(){
        if (jpanAddPresSingInst == null){
             jpanAddPresSingInst= new JPanelAppAddPrescrip();
        }
        return jpanAddPresSingInst;
    }
    
    //holds the appointment id that has been passed through where the appointment amendment was initiated
    public  static void setIdsInAppPatDr(String appIdIn, String patientidin, String dridin){
        AppIdIn = appIdIn;
        patIDIn = patientidin;
        DrIDIn = dridin;
        
    }
    
    public String getAppID(){
        return AppIdIn;
    }
    
    public String getDrID(){
        return DrIDIn;
    }
    
    public String getPatID(){
        return patIDIn;
    }
    
    public String getPresDesc(){
        return jtfMedicineDesc.getText();
    }
    
    public String getPresAmount(){
        return jtfMedicineAmount.getText();
    }
    
}
