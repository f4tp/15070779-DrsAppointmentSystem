
package pkg15070779drsappsystem.JPanels;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import static pkg15070779drsappsystem.JPanels.JPanelAppsShowAllForPatientSEC.lblAppFor;
import pkg15070779drsappsystem.MainClasses.SysUserPatient;

public class JPanelAppsShowAllForPatientDOC extends JPanel {
    
  public static JPanelAppsShowAllForPatientDOC ViewAllAppsSingInst;
  public static  JLabel lblAppFor = new JLabel("");
    //JTextArea JTFName = new JTextArea();
   private static JTextArea JTFAllAppointments = new JTextArea();
   private static  JScrollPane scrollpane = new JScrollPane(JTFAllAppointments);
    
    //will hold the keys of the appointments, so they can be selected and edited
    private static JComboBox cmbAppKeys = new JComboBox();
    //JButton btnReturn = new JButton("Back");
    
    JPartPanelAppsShowAllPatButPanelDOC ButPanSingInst = JPartPanelAppsShowAllPatButPanelDOC.getInstance();
    
    private JPanelAppsShowAllForPatientDOC(){
         setLayout (new BoxLayout(this, BoxLayout.Y_AXIS));
        JTFAllAppointments.setLineWrap(true);
        add(lblAppFor);
        add(scrollpane);
        add(cmbAppKeys);
        add(ButPanSingInst);
    }
    
     //updates the label with the name of the person
    public static void updateLabelTitleForShowPatApps(){
        lblAppFor.setText("Showing appointments for: " + SysUserPatient.currentPatient.getFirstName() + " " + SysUserPatient.currentPatient.getSurname() );
    }
    
      //clears the appointment area ready to append with the new appointment details of the next patient
    public static void clearAppointmentTextArea(){
        JTFAllAppointments.setText("");
    }
    
    //appends the area with the appointment details of the current patient
    public static void updateAppointmentsTextArea(String textToAdd){
        JTFAllAppointments.append(textToAdd);
     }
    
    public static void updateComboAppKeys(String textToAdd){
            cmbAppKeys.addItem(textToAdd);
    }
    
    public static void setClearCombo(){
        cmbAppKeys.removeAllItems();
    }
    
    
    public static JPanelAppsShowAllForPatientDOC getInstance(){
        if (ViewAllAppsSingInst == null){
            ViewAllAppsSingInst = new JPanelAppsShowAllForPatientDOC();
        }
        
        return ViewAllAppsSingInst;
    }
    
    public static JComboBox getComboAppkeys(){
        return cmbAppKeys;
    }
    
}
