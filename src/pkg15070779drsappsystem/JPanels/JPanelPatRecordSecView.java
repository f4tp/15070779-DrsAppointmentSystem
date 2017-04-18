
package pkg15070779drsappsystem.JPanels;

import java.awt.BorderLayout;
import javax.swing.*;
import pkg15070779drsappsystem.MainAbstractClasses.SystemUserComponent;
import pkg15070779drsappsystem.MainClasses.SysUserPatient;
import pkg15070779drsappsystem.MainClasses.SysUserSecretary;

//jpanel for the patient record when it has been found
public class JPanelPatRecordSecView extends JPanel {
    public static JPanelPatRecordSecView JPanPatRecSingInst;
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

        JPartPanelPatRecButPanSEC secretaryButtons = JPartPanelPatRecButPanSEC.getInstance();
    
    private JPanelPatRecordSecView(){
     
        setBorder(BorderFactory.createEmptyBorder(20, 100, 20, 100));
        setLayout (new BorderLayout ());
        
        add(patientScreen, BorderLayout.NORTH);
        add(secretaryButtons, BorderLayout.CENTER);
        
    
    }
    
    //singleton object generation here
   public static JPanelPatRecordSecView getInstance(){
         if (JPanPatRecSingInst == null){
            JPanPatRecSingInst = new JPanelPatRecordSecView();
         }
        
        return JPanPatRecSingInst;
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
    
    //DisplayPatientDetails on sec jframe updated so it no longer uses the global variable
     public void setUpdateTextFields(String patientid){

       
        if (SystemUserComponent.currentSystemUser != null){
            SysUserPatient currentPatInst = (SysUserPatient) SystemUserComponent.getSystemUserComponent(patientid);
            
            JTFTitle.setText(currentPatInst.getTitle());
            JTFFirstName.setText(currentPatInst.getFirstName());
            JTFSurname.setText(currentPatInst.getSurname());
            JTFdob.setText(currentPatInst.getDOB());
            JTFContact.setText(currentPatInst.getContactDetail());
            JTFDrsRegsWith.setText(currentPatInst.getDrsRegWithAsStringAsDrsnames());
        }
        
        
       
    }

}
