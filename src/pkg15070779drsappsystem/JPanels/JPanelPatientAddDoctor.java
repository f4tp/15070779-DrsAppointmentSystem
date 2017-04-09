
package pkg15070779drsappsystem.JPanels;

import pkg15070779drsappsystem.ActionListeners.ActListAddDoctor;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import pkg15070779drsappsystem.MainClasses.MainDoctor;


public class JPanelPatientAddDoctor extends JPanel {
    public static JPanelPatientAddDoctor JPanPatAddDocSingInst;
        
        
        private JPanelPatientAddDoctor(){
            JLabel lblTitle = new JLabel ("Select a doctor to add");
            JComboBox cmbDrs = new JComboBox(MainDoctor.getListAllDoctors().toArray());
            JButton btnAddDoctor = new JButton("Register Patient With Doctor");
            btnAddDoctor.addActionListener(new ActListAddDoctor(cmbDrs));
            
            setLayout (new BoxLayout(this, BoxLayout.X_AXIS));
            add(lblTitle);
            add(cmbDrs);
            add(btnAddDoctor);
        }
        
            //singleton object generation here
    public static JPanelPatientAddDoctor getInstance(){
         if (JPanPatAddDocSingInst == null){
            JPanPatAddDocSingInst = new JPanelPatientAddDoctor();
        }
  
        return JPanPatAddDocSingInst;
    }
        
}
