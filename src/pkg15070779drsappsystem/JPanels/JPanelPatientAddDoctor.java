
package pkg15070779drsappsystem.JPanels;

import pkg15070779drsappsystem.ListenersAction.ActListAddDoctor;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import pkg15070779drsappsystem.ListenersAction.ActListReturnPatientRec;
import pkg15070779drsappsystem.MainClasses.SysUserDoctor;


public class JPanelPatientAddDoctor extends JPanel {
    public static JPanelPatientAddDoctor JPanPatAddDocSingInst;
        
        
        private JPanelPatientAddDoctor(){
            JLabel lblTitle = new JLabel ("Select a doctor to add");
            JComboBox cmbDrs = new JComboBox(SysUserDoctor.getListAllDoctors().toArray());
            JButton btnAddDoctor = new JButton("Register Patient With Doctor");
            btnAddDoctor.addActionListener(new ActListAddDoctor(cmbDrs));
            
            JButton btnCancel = new JButton("Cancel");
            btnCancel.addActionListener(new ActListReturnPatientRec("Sec"));
            
            setLayout (new BoxLayout(this, BoxLayout.X_AXIS));
            add(lblTitle);
            add(cmbDrs);
            add(btnAddDoctor);
            add(btnCancel);
        }
        
            //singleton object generation here
    public static JPanelPatientAddDoctor getInstance(){
         if (JPanPatAddDocSingInst == null){
            JPanPatAddDocSingInst = new JPanelPatientAddDoctor();
        }
  
        return JPanPatAddDocSingInst;
    }
        
}
