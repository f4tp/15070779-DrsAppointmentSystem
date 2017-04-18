
package pkg15070779drsappsystem.JPanels;

import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import pkg15070779drsappsystem.MainAbstractClasses.SystemUserComponent;
import pkg15070779drsappsystem.MainClasses.SysUserPatient;

public class JPanelPatRecordPatView extends JPanel {
    
    
        public static JPanelPatRecordPatView JPanPatRecPatViewSingInst;
        JLabel lblTitle = new JLabel ("Title:          ");

        JLabel lblFirstName = new JLabel ("First Name:     ");

        JLabel lblSurname = new JLabel ("Surname:        ");

        JLabel lblDob = new JLabel ("DOB:            ");
   
        JLabel lblContact = new JLabel ("Contact Details:");

        
        JLabel lblDrsRegsWith= new JLabel ("Drs Regsitered With: ");

      
        
        JTextField JTFTitle = new JTextField();
        JTextField JTFFirstName = new JTextField();
        JTextField JTFSurname = new JTextField();
        JTextField JTFdob = new JTextField();
        JTextField JTFContact = new JTextField();
        JTextField JTFDrsRegsWith = new JTextField();
        
       
  
        JPartPanelTemplateTwelveGridView patientScreen = new JPartPanelTemplateTwelveGridView(lblTitle, JTFTitle, lblFirstName,JTFFirstName,lblSurname,JTFSurname, lblDob,JTFdob, lblContact, JTFContact, lblDrsRegsWith, JTFDrsRegsWith);
        JPartPanelPatRecButPanPAT patientButtons = JPartPanelPatRecButPanPAT.getInstance();
        JPartPanelTextAreaPrintPatRec JtASingInst = JPartPanelTextAreaPrintPatRec.getInstance();

    private JPanelPatRecordPatView(){

        setBorder(BorderFactory.createEmptyBorder(20, 100, 20, 100));
        setLayout (new BorderLayout ());
        
        //clear the text in case anything is in it from another user
        JtASingInst.setJtextArea("");
        
        add(patientScreen, BorderLayout.NORTH);
        add(patientButtons, BorderLayout.CENTER);
        add(JtASingInst, BorderLayout.SOUTH);
    }
    
    //singleton object generation here
   public static JPanelPatRecordPatView getInstance(){
         if (JPanPatRecPatViewSingInst == null){
            JPanPatRecPatViewSingInst = new JPanelPatRecordPatView();
         }
        
        return JPanPatRecPatViewSingInst;
    }
    
    public void setUpdateTextFields(){

       
        if (SystemUserComponent.currentSystemUser != null){
            JTFTitle.setText(SysUserPatient.currentPatient.getTitle());
            JTFFirstName.setText(SysUserPatient.currentPatient.getFirstName());
            JTFSurname.setText(SysUserPatient.currentPatient.getSurname());
            JTFdob.setText(SysUserPatient.currentPatient.getDOB());
            JTFContact.setText(SysUserPatient.currentPatient.getContactDetail());
            JTFDrsRegsWith.setText(SysUserPatient.currentPatient.getDrsRegWithAsStringAsDrsnames());
        }
        
        
       
    }
    
    
}
