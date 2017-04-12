/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg15070779drsappsystem.JPanels;

import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import pkg15070779drsappsystem.AbstractClasses.MainAbsSystemUserComponent;
import pkg15070779drsappsystem.MainClasses.MainPatient;

/**
 *
 * @author Quad
 */
public class JPartPanelPatRecordPatView extends JPanel {
    
    
        public static JPartPanelPatRecordPatView JPanPatRecPatViewSingInst;
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
        JPartPanelPatRecButPanPAT patientButtons = JPartPanelPatRecButPanPAT.getInstance();
        
        //JPanelPatientRecButPanSEC secretaryButtons = JPanelPatientRecButPanSEC.getInstance();
    private JPartPanelPatRecordPatView(){

        setBorder(BorderFactory.createEmptyBorder(20, 100, 20, 100));
        setLayout (new BorderLayout ());
        
        add(patientScreen, BorderLayout.NORTH);
        add(patientButtons, BorderLayout.CENTER);
    
    }
    
    //singleton object generation here
   public static JPartPanelPatRecordPatView getInstance(){
         if (JPanPatRecPatViewSingInst == null){
            JPanPatRecPatViewSingInst = new JPartPanelPatRecordPatView();
         }
        
        return JPanPatRecPatViewSingInst;
    }
    
    //set all textfields to the correct data;
    //private static void setPatientJPanel(){
        //setUpdateTextField();
    //}
    
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
    
    
}
