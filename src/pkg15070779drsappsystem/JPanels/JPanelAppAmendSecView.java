
package pkg15070779drsappsystem.JPanels;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;

import java.time.LocalDateTime;
import pkg15070779drsappsystem.ActionListeners.ActListAmendAppFormChangedDateAffected;
import pkg15070779drsappsystem.ActionListeners.ActListAmendAppFormChangedDateNotAffected;
import pkg15070779drsappsystem.ActionListeners.ActListAmendAppFormChangedDateNotAffectedAppDocAre;
import pkg15070779drsappsystem.ActionListeners.ActListAmendAppointment;
import pkg15070779drsappsystem.ActionListeners.ActListBackToPatientApps;
import pkg15070779drsappsystem.ItemListeners.FocusListAmendAppSymptomsJTFDateNotAffected;
//import pkg15070779drsappsystem.ItemListeners.ItemListAmendAppFormChanged;
public class JPanelAppAmendSecView extends JPanel {
    
    private static Boolean formUpdatedNotDateTime;
    private static Boolean formUpdatedNotDateTimeBuTAppAndDoc;
    private static Boolean formUpdatedDateTime;
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
    private static JCheckBox jcbAttended = new JCheckBox();
    
    //can update this on this form
    JLabel lblCancelled= new JLabel ("Cancelled:");
    private static JCheckBox jcbCancelled= new JCheckBox();
    
    //can update this on this form
    JLabel lblMissed= new JLabel ("Missed:");
    private static JCheckBox jcbMissed = new JCheckBox();
    
    JLabel lblPresDetails= new JLabel ("Prescription ID:");
     private static JLabel lblPrescDetailRes= new JLabel ();
    

    
    JButton btnCancel = new JButton("Cancel");
    JButton btnAmend = new JButton("Amend Appointment");
    
    private JPanelAppAmendSecView(){
        
          jtfSymptoms.addFocusListener(new FocusListAmendAppSymptomsJTFDateNotAffected());
          jcbAttended.addActionListener(new ActListAmendAppFormChangedDateNotAffected());
          jcbMissed.addActionListener(new ActListAmendAppFormChangedDateNotAffected());
          
         jcbCancelled.addActionListener(new ActListAmendAppFormChangedDateNotAffectedAppDocAre());
        
        btnCancel.addActionListener(new ActListBackToPatientApps());
        
        //calls the amend details act list with all components needed to make the change
        btnAmend.addActionListener(new ActListAmendAppointment(lblUserNameRes, lblAppIDRes, lblDrWithRes,
                JPartPanelAmendAppDateOfApp.getInstance().getJComboDay(), 
                JPartPanelAmendAppDateOfApp.getInstance().getJComboMonth(), 
                JPartPanelAmendAppDateOfApp.getInstance().getJComboYear(), 
                JPartPanelAmendAppTimeOfApp.getInstance().getJComboTime(), jtfSymptoms, jcbAttended, jcbCancelled, jcbMissed));
    
        
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
        
        add(jpanDate);// item listeners set in the part Jpanel
        
        add(lblTime);
        
        add(jpanTime);// item listeners set in the part Jpanel
        
        add(lblSymptoms);
        
      
        add(jtfSymptoms);//
        
        add(lblAttended);
      
        
        add(jcbAttended);//
        
        add(lblCancelled);
        
       
        add(jcbCancelled);//
        add(lblMissed);
        
        
        add(jcbMissed);//

        add(lblPresDetails);
        add(lblPrescDetailRes);

        add(btnCancel);
        add(btnAmend);
        
        
        
      
    }
    
    public static JPanelAppAmendSecView getInstance(){
        if (jpanAppAmendSingInst == null) {
            jpanAppAmendSingInst = new JPanelAppAmendSecView();
        }
        
        return jpanAppAmendSingInst;
    }
    
    public static void updateFormComponents(String title, String name, String surname, String username, String appointmentid, String drwith, LocalDateTime datetimein, String symptoms, Boolean attended, Boolean cancelled, Boolean missed, String presdetails){
        
        jlTitleRes.setText(title);
        lblFirstNameRes.setText(name);
        lblSurnameRes.setText(surname);
        lblUserNameRes.setText(username);
        lblAppIDRes.setText(appointmentid);
       lblDrWithRes.setText(drwith);
       //update the form with the date combos - pass it the datetime object and in there it will split strings of day, month and year
        JPartPanelAmendAppDateOfApp.getInstance().updateFormWidgets(datetimein);
        //update the form with the time combos - pass it the datetime object and in there it will split strings of hour and minute
        JPartPanelAmendAppTimeOfApp.getInstance().updateFormWidgets(datetimein);
        jtfSymptoms.setText(symptoms);
        jcbAttended.setSelected(attended);
        jcbCancelled.setSelected(cancelled);
        jcbMissed.setSelected(missed);
        lblPrescDetailRes.setText(presdetails);
        
        //all widgets have been set up, so the changed status of teh form is set to false using these three 
        //variables (the form can be changed in 3 different ways. This will change if there is any movement
        //on any of the items
        formUpdatedNotDateTime = false;
        formUpdatedNotDateTimeBuTAppAndDoc = false;
        formUpdatedDateTime = false;
        System.out.println(formUpdatedNotDateTime);
        System.out.println(formUpdatedDateTime);
    }
    
    //if someone changes somethign on this form, this value will be set to true
    //when someone presses the update button, if the value is false it won;t update anything, but if it is true it will run 
    //through the routine of updating all objects involved
    //this will be set back to false after the updating has taken place so another appointment can be amended
    public void setFormUpdatedNotDateTime(Boolean formneedsupdating){
        formUpdatedNotDateTime = formneedsupdating;
    }
    
     public void setFormUpdatedDateTime(Boolean formneedsupdating){
        formUpdatedDateTime = formneedsupdating;
    }
     
     public void setFormUpdatedNotDateTimeButAppAndDoc(Boolean formneedsupdating){
         formUpdatedNotDateTimeBuTAppAndDoc = formneedsupdating;
     }
     
    
    
     //if someone changes somethign on this form, this value will be set to true
    //when someone presses the update button, if the value is false it won;t update anything, but if it is true it will run 
    //through the routine of updating all objects involved
    //this will be set back to false after the updating has taken place so another appointment can be amended
    public Boolean getFormUpdatedNotDateTime(){
        return formUpdatedNotDateTime;
    }
    
     public Boolean getFormUpdatedDateTime(){
        return formUpdatedDateTime;
    }
     
      public Boolean getFormUpdatedNotDateTimeButAppAndDoc(){
         return formUpdatedNotDateTimeBuTAppAndDoc;
      }
    
    

    
}
