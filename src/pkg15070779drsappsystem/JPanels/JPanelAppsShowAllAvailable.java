
package pkg15070779drsappsystem.JPanels;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import pkg15070779drsappsystem.ActionListeners.ActListReturnPatientRec;
import pkg15070779drsappsystem.MainClasses.MainPatient;

public class JPanelAppsShowAllAvailable extends JPanel {
    public static JPanelAppsShowAllAvailable ViewAllAppsSingInst;
    JLabel lblAppFor = new JLabel("");
    //JTextArea JTFName = new JTextArea();
    JTextArea JTFAllAppointments = new JTextArea();
    //JScrollPane scrollpane = new JScrollPane(JTFAllAppointments);
    
    JButton btnReturn = new JButton("Back");
    

    private JPanelAppsShowAllAvailable(){
        
        btnReturn.addActionListener(new ActListReturnPatientRec());
         setLayout (new BoxLayout(this, BoxLayout.Y_AXIS));
        //JTFAllAppointments.setSize(400, 400);
        JTFAllAppointments.setLineWrap(true);
        add(lblAppFor);
        //add(JTFName);
        
        add(JTFAllAppointments);
        //add(scrollpane);
        add(btnReturn);
        
    }
    
    //updates the label with the name of the person
    public static void updateTextFields(){
        getInstance().lblAppFor.setText("Showing appointments for: " + MainPatient.currentPatient.getFirstName() + " " + MainPatient.currentPatient.getSurname() );
        //getInstance().revalidate();
        //getInstance().repaint();
    }
    
    //clears teh appointment area ready to append with the new appointment details of the next patient
    public static void clearAppointmentTextArea(){
        getInstance().JTFAllAppointments.setText("");
       //getInstance().revalidate();
       // getInstance().repaint();
        
    }
    
    //appends the area with the appointment details of the current patient
    public static void updateAppointmentsTextArea(String textToAdd){
        getInstance().JTFAllAppointments.append(textToAdd);
        //getInstance().revalidate();
        //getInstance().repaint();
        
    
    }
    
    
    public static JPanelAppsShowAllAvailable getInstance(){
        if (ViewAllAppsSingInst == null){
            ViewAllAppsSingInst = new JPanelAppsShowAllAvailable();
        }
        
        return ViewAllAppsSingInst;
    }
}
