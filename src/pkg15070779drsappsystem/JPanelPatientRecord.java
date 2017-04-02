
package pkg15070779drsappsystem;

import java.awt.BorderLayout;
import javax.swing.*;

public class JPanelPatientRecord extends JPanel {
    
    public JPanelPatientRecord(){
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
        
        JTextField JTFTitle = new JTextField();
        //JTFTitle.setBorder(BorderFactory.createEmptyBorder(0, 100, 0, 100));
        JTextField JTFFirstName = new JTextField();
        JTextField JTFSurname = new JTextField();
        JTextField JTFdob = new JTextField();
        JTextField JTFContact = new JTextField();


        JButton btnAllApps = new JButton("View All appointments");
        JButton btnNewApp = new JButton("New Appointment");
        JPanelTwelveGridView patientScreen = new JPanelTwelveGridView(lblTitle, JTFTitle, lblFirstName,JTFFirstName,lblSurname,JTFSurname, lblDob,JTFdob, lblContact, JTFContact, btnAllApps, btnNewApp);


        setBorder(BorderFactory.createEmptyBorder(20, 100, 20, 100));
        setLayout (new BorderLayout ());
        add(patientScreen, BorderLayout.NORTH);

    }

}
