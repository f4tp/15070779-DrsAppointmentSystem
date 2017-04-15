
package pkg15070779drsappsystem.JPanels;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import pkg15070779drsappsystem.ActionListeners.ActListReturnPatientRec;
import pkg15070779drsappsystem.MainClasses.MainPatient;

public class JPanelAppsShowAllForPatientSEC extends JPanel {
    public static JPanelAppsShowAllForPatientSEC ViewAllAppsSingInst;
  public static  JLabel lblAppFor = new JLabel("");
    //JTextArea JTFName = new JTextArea();
   private static JTextArea JTFAllAppointments = new JTextArea();
   private static  JScrollPane scrollpane = new JScrollPane(JTFAllAppointments);
    
    //will hold the keys of the appointments, so they can be selected and edited
    private static JComboBox cmbAppKeys = new JComboBox();
    //JButton btnReturn = new JButton("Back");
    
    JPartPanelAppsShowAllPatButPanelSEC ButPanSingInst = JPartPanelAppsShowAllPatButPanelSEC.getInstance();

    private JPanelAppsShowAllForPatientSEC(){
        
        //btnReturn.addActionListener(new ActListReturnPatientRec());
         setLayout (new BoxLayout(this, BoxLayout.Y_AXIS));
        //JTFAllAppointments.setSize(400, 400);
        JTFAllAppointments.setLineWrap(true);
        add(lblAppFor);
        //add(JTFName);
        
        //add(JTFAllAppointments);
        add(scrollpane);
        add(cmbAppKeys);
        //add(btnReturn);
        add(ButPanSingInst);
        
    }
    
    //updates the label with the name of the person
    public static void updateLabelTitleForShowPatApps(){
        lblAppFor.setText("Showing appointments for: " + MainPatient.currentPatient.getFirstName() + " " + MainPatient.currentPatient.getSurname() );
        //getInstance().revalidate();
        //getInstance().repaint();
    }
    
    //clears teh appointment area ready to append with the new appointment details of the next patient
    public static void clearAppointmentTextArea(){
        JTFAllAppointments.setText("");
       //getInstance().revalidate();
       // getInstance().repaint();
        
    }
    
    //appends the area with the appointment details of the current patient
    public static void updateAppointmentsTextArea(String textToAdd){
        JTFAllAppointments.append(textToAdd);
        //getInstance().revalidate();
        //getInstance().repaint();
        
    
    }
    
    public static void updateComboAppKeys(String textToAdd){
        
        cmbAppKeys.addItem(textToAdd);

        //getInstance().lblAppFor.setText("Showing appointments for: " + MainPatient.currentPatient.getFirstName() + " " + MainPatient.currentPatient.getSurname() );
        //getInstance().revalidate();
        //getInstance().repaint();
    }
    
    public static void setClearCombo(){
        cmbAppKeys.removeAllItems();
    }
    
    
    public static JPanelAppsShowAllForPatientSEC getInstance(){
        if (ViewAllAppsSingInst == null){
            ViewAllAppsSingInst = new JPanelAppsShowAllForPatientSEC();
        }
        
        return ViewAllAppsSingInst;
    }
    
    public static JComboBox getComboAppkeys(){
        return cmbAppKeys;
    }
}
