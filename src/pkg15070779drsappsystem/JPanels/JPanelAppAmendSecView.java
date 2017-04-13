
package pkg15070779drsappsystem.JPanels;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import pkg15070779drsappsystem.ActionListeners.ActListBackToPatientApps;

public class JPanelAppAmendSecView extends JPanel {
    public static JPanelAppAmendSecView jpanAppAmendSingInst;
    
    JLabel jlTitle = new JLabel("Title");
     private static JLabel jlTitleRes = new JLabel();
     
     JLabel lblFirstName = new JLabel ("First Name:     ");
     private static JLabel lblFirstNameRes = new JLabel ();
     
     JLabel lblSurname = new JLabel ("Surname:        ");
    private static JLabel lblSurnameRes = new JLabel ();
     
     JLabel lblUserName = new JLabel ("UserName on system:");
     private static JLabel lblUserNameRes = new JLabel ();
     
    JLabel lblAppID= new JLabel ("Appointment ID:");
    public static JLabel lblAppIDRes= new JLabel ();
    
     JLabel lblDrWith= new JLabel ("Dr With:");
     private static JLabel lblDrWithRes= new JLabel ();
    
     
     JLabel lblDate= new JLabel ("Date of appointment:");
      //can update date of appointment on this form
     //this will be in another JPanel
     JPartPanelAmendAppDateOfApp jpanDate = JPartPanelAmendAppDateOfApp.getInstance();
    
     JLabel lblTime= new JLabel ("Time of appointment:");
     //can update time of appointment on this form
    //this will be in another JPanel
  
     JPartPanelAmendAppTimeOfApp jpanTime = JPartPanelAmendAppTimeOfApp.getInstance();
     
    //can update symptoms on this form
    JLabel lblSymptoms= new JLabel ("Symptoms:");
    private static JTextField jtfSymptoms = new JTextField("");
    
    //can update this on this form
    JLabel lblAttended= new JLabel ("Attended");
    private static JCheckBox jtbAttend = new JCheckBox();
    
    //can update this on this form
    JLabel lblCancelled= new JLabel ("Cancelled:");
    private static JCheckBox jtbCancelled= new JCheckBox();
    
    //can update this on this form
    JLabel lblMissed= new JLabel ("Missed:");
    private static JCheckBox jtbMissed = new JCheckBox();
    
    JLabel lblPresID= new JLabel ("Prescription ID:");
     private static JLabel lblPresIDRes= new JLabel ();
    
    JLabel lblMedPrescribed= new JLabel ("Medicine Prescribed:");
     private static JLabel lblMedPrescribedRes= new JLabel ();
     
    JLabel lblMedAmount= new JLabel ("Medicine Amount:");
    private static JLabel lblMedAmountRes= new JLabel ();
    
    JButton btnCancel = new JButton("Cancel");
    JButton btnAmend = new JButton("Amend Appointment");
    
    private JPanelAppAmendSecView(){
        setLayout(new GridLayout(16,2));
        add(jlTitle);
        add(jlTitleRes);
        add(lblFirstName);
        add(lblFirstNameRes);
        add(lblSurname);
        add(lblSurnameRes);
        add(lblUserName);
        add(lblUserNameRes);
        add(lblAppID);
        add(lblAppIDRes);
        add(lblDrWith);
        add(lblDrWithRes);
        add(lblDate);
        add(jpanDate);
        add(lblTime);
        add(jpanTime);
        add(lblSymptoms);
        add(jtfSymptoms);
        add(lblAttended);
        add(jtbAttend);
        add(lblCancelled);
        add(jtbCancelled);
        add(lblMissed);
        add(jtbMissed);
        add(lblMedPrescribed);
        add(lblMedPrescribedRes);
        add(lblMedPrescribed);
        add(lblMedPrescribedRes);
        add(lblMedAmount);
        add(lblMedAmountRes);
        add(btnCancel);
        add(btnAmend);
        
        btnCancel.addActionListener(new ActListBackToPatientApps());
        //btnAmend.addActionListener(newActList());
    }
    
    public static JPanelAppAmendSecView getInstance(){
        if (jpanAppAmendSingInst == null) {
            jpanAppAmendSingInst = new JPanelAppAmendSecView();
        }
        
        return jpanAppAmendSingInst;
    }
    
    public static void updateFormComponents(String title, String name, String surname, String username, String appointmentid, String drwith, LocalDateTime datetimein, String symptoms, Boolean attended, Boolean cancelled, Boolean missed, String presid, String medicinepres, String medicineamount){
        
        jlTitleRes.setText(title);
        lblFirstNameRes.setText(name);
        lblSurnameRes.setText(surname);
        lblUserNameRes.setText(username);
        lblAppIDRes.setText(appointmentid);
       lblDrWithRes.setText(drwith);
       //update the form with the date combos - pass it the datetime object and in there it will split strings of day, month and year
        JPartPanelAmendAppDateOfApp.updateFormWidgets(datetimein);
        //update the form with the time combos - pass it the datetime object and in there it will split strings of hour and minute
        JPartPanelAmendAppTimeOfApp.updateFormWidgets(datetimein);
        jtfSymptoms.setText(symptoms);
        jtbAttend.setSelected(attended);
        jtbCancelled.setSelected(cancelled);
        jtbMissed.setSelected(missed);
        lblMedPrescribedRes.setText(presid);
        lblMedPrescribedRes.setText(medicinepres);
       lblMedAmountRes.setText(medicineamount);

    }
    
    

    
}
