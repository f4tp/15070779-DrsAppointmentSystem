
package pkg15070779drsappsystem.JPanels;

import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import pkg15070779drsappsystem.JPanels.JPartPanelPatRecButPanDOC;
import pkg15070779drsappsystem.JPanels.JPartPanelTemplateTwelveGridView;
import pkg15070779drsappsystem.MainAbstractClasses.MainAbsSystemUserComponent;
import pkg15070779drsappsystem.MainClasses.MainPatient;

public class JPanelPatRecordDocView extends JPanel {
    
      public static JPanelPatRecordDocView JPanPatRecSingInst;
        JLabel lblTitle = new JLabel ("Title:          ");
        //lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel lblFirstName = new JLabel ("First Name:     ");
        //lblFirstName.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel lblSurname = new JLabel ("Surname:        ");
        //lblSurname.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel lblDob = new JLabel ("DOB:            ");
        //lblDob.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel lblContact = new JLabel ("Contact Details:");
        //lblContact.setHorizontalAlignment(SwingConstants.CENTER);
        
        JLabel lblDrsRegsWith= new JLabel ("Drs Regsitered With: ");
        //lblContact.setHorizontalAlignment(SwingConstants.CENTER);   
      
        
        JTextField JTFTitle = new JTextField();
        //JTFTitle.setBorder(BorderFactory.createEmptyBorder(0, 100, 0, 100));
        //JTFTitle.setB
        JTextField JTFFirstName = new JTextField();
        JTextField JTFSurname = new JTextField();
        JTextField JTFdob = new JTextField();
        JTextField JTFContact = new JTextField();
        JTextField JTFDrsRegsWith = new JTextField();
        
       
        //JButton btnAllApps = new JButton("View All appointments");
        //JButton btnNewApp = new JButton("New Appointment");
        JPartPanelTemplateTwelveGridView patientScreen = new JPartPanelTemplateTwelveGridView(lblTitle, JTFTitle, lblFirstName,JTFFirstName,lblSurname,JTFSurname, lblDob,JTFdob, lblContact, JTFContact, lblDrsRegsWith, JTFDrsRegsWith);
        //JPanelPatientRecButPanPAT patientButtons = JPanelPatientRecButPanPAT.getInstance();
        
        
        //NTD - add Dr buttons here after creating the panel
        JPartPanelPatRecButPanDOC docButtons = JPartPanelPatRecButPanDOC.getInstance();
        
        private JPanelPatRecordDocView(){
             setBorder(BorderFactory.createEmptyBorder(20, 100, 20, 100));
        setLayout (new BorderLayout ());
        
        add(patientScreen, BorderLayout.NORTH);
        add(docButtons, BorderLayout.CENTER);
        
        }
        
        
          //singleton object generation here
   public static JPanelPatRecordDocView getInstance(){
         if (JPanPatRecSingInst == null){
            JPanPatRecSingInst = new JPanelPatRecordDocView();
         }
        
        return JPanPatRecSingInst;
    }
   
   
   public void setUpdateTextFields(){

       
        if (MainAbsSystemUserComponent.currentSystemUser != null){
            JTFTitle.setText(MainPatient.currentPatient.getTitle());
            JTFFirstName.setText(MainPatient.currentPatient.getFirstName());
            JTFSurname.setText(MainPatient.currentPatient.getSurname());
            JTFdob.setText(MainPatient.currentPatient.getDOB());
            JTFContact.setText(MainPatient.currentPatient.getContactDetail());
            //JTADrsRegsWith.setText(MainPatient.currentPatient.getDrsRegWithAsStringAsUserNames());
            JTFDrsRegsWith.setText(MainPatient.currentPatient.getDrsRegWithAsStringAsDrsnames());
        }
    
}
   
   
   public void setUpdateTextFields(String patientid){

       
        if (MainAbsSystemUserComponent.currentSystemUser != null){
           MainPatient currentPatInst = (MainPatient) MainAbsSystemUserComponent.getSystemUserComponent(patientid);
            
            JTFTitle.setText(currentPatInst.getTitle());
            JTFFirstName.setText(currentPatInst.getFirstName());
            JTFSurname.setText(currentPatInst.getSurname());
            JTFdob.setText(currentPatInst.getDOB());
            JTFContact.setText(currentPatInst.getContactDetail());
            //JTADrsRegsWith.setText(MainPatient.currentPatient.getDrsRegWithAsStringAsUserNames());
            JTFDrsRegsWith.setText(currentPatInst.getDrsRegWithAsStringAsDrsnames());
        }
    
}
}
