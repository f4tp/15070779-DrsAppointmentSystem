
package pkg15070779drsappsystem;

import java.awt.BorderLayout;
import javax.swing.*;

//jpanel for the patient record when it has been found
public class JPanelPatientRecord extends JPanel {
    public static JPanelPatientRecord JPanPatRecSingInst;
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
        JTextField JTFFirstName = new JTextField();
        JTextField JTFSurname = new JTextField();
        JTextField JTFdob = new JTextField();
        JTextField JTFContact = new JTextField();
        JTextField JTFDrsRegsWith = new JTextField();


        //JButton btnAllApps = new JButton("View All appointments");
        //JButton btnNewApp = new JButton("New Appointment");
        JPanelTwelveGridView patientScreen = new JPanelTwelveGridView(lblTitle, JTFTitle, lblFirstName,JTFFirstName,lblSurname,JTFSurname, lblDob,JTFdob, lblContact, JTFContact, lblDrsRegsWith, JTFDrsRegsWith);

    private JPanelPatientRecord(){
        

        setBorder(BorderFactory.createEmptyBorder(20, 100, 20, 100));
        setLayout (new BorderLayout ());
        add(patientScreen, BorderLayout.NORTH);

    }
    
    //singleton object generation here
    public static JPanelPatientRecord getInstance(){
         if (JPanPatRecSingInst == null){
            JPanPatRecSingInst = new JPanelPatientRecord();
        }
  
        return JPanPatRecSingInst;
    }
    
    //set all textfields to the correct data;
    //private static void setPatientJPanel(){
        //setUpdateTextField();
    //}
    
    public void setUpdateTextField(){
        JTFTitle.setText(MainPatient.currentPatient.getTitle());
        JTFFirstName.setText(MainPatient.currentPatient.getFirstName());
        JTFSurname.setText(MainPatient.currentPatient.getSurname());
        JTFdob.setText(MainPatient.currentPatient.getDOB());
        JTFContact.setText(MainPatient.currentPatient.getContactDetail());
        //JTADrsRegsWith.setText(MainPatient.currentPatient.getDrsRegWithAsStringAsUserNames());
        JTFDrsRegsWith.setText(MainPatient.currentPatient.getDrsRegWithAsStringAsDrsnames());
        
    }

}
