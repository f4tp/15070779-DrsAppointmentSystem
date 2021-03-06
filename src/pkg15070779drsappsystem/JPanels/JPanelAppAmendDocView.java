
package pkg15070779drsappsystem.JPanels;

import java.awt.GridLayout;
import java.time.LocalDateTime;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import pkg15070779drsappsystem.ListenersAction.ActListDisplayJPanAddPrescription;
import pkg15070779drsappsystem.ListenersAction.ActListAmendAppointmentDOC;
import pkg15070779drsappsystem.ListenersAction.ActListBackToPatientApps;
import pkg15070779drsappsystem.ListenersFocus.FocusListAmendAppSymptomsJTFDateNotAffected;
import pkg15070779drsappsystem.MainAbstractClasses.SchedulingAbstract;


public class JPanelAppAmendDocView extends JPanel {
    private static Boolean formUpdatedNotDateTime;
    public static JPanelAppAmendDocView jpanAppAmendSingInst;
    
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
     JPartPanelAmendAppDateOfAppDOC jpanDate = JPartPanelAmendAppDateOfAppDOC.getInstance();
     private static JLabel lblDateRes = new JLabel();
    
     JLabel lblTime= new JLabel ("Time of appointment:");
     //can update time of appointment on this form
    //this will be in another JPanel
  
     JPartPanelAmendAppTimeOfAppDOC jpanTime = JPartPanelAmendAppTimeOfAppDOC.getInstance();
    private static  JLabel lblTimeRes = new JLabel();
    //can update symptoms on this form
    JLabel lblSymptoms= new JLabel ("Symptoms:");
    private static JLabel lblSymptomsRes = new JLabel();
    
    JLabel lblDrsComments = new JLabel("Dr's Comments: ");
    private static JTextField jtfDrsCommentsRes = new JTextField();
    
   
    //can update this on this form
    JLabel lblAttended= new JLabel ("Attended");
    private static JLabel lblAttendedRes = new JLabel();
    
    //can update this on this form
    JLabel lblCancelled= new JLabel ("Cancelled:");
    private static JLabel lblCancelledRes= new JLabel();
    
    //can update this on this form
    JLabel lblMissed= new JLabel ("Missed:");
    private static JLabel lblMissedRes = new JLabel();
    
    JLabel lblPresDetails= new JLabel ("Prescription Details:");
     private static JLabel lblPrescDetailRes= new JLabel ();
    

    
    JButton btnCancel = new JButton("Cancel");
    JButton btnAmend = new JButton("Amend Appointment");
    JButton btnAddpresc = new JButton("Add prescription");
    
    public JPanelAppAmendDocView(){
        jtfDrsCommentsRes.addFocusListener(new FocusListAmendAppSymptomsJTFDateNotAffected("Doc"));
        //NTD this action listsner needs editing - call with string, and it takes you back to the correct Jpanel
        btnCancel.addActionListener(new ActListBackToPatientApps("Doc"));
       
        
        
         btnAmend.addActionListener(new ActListAmendAppointmentDOC(lblUserNameRes, lblAppIDRes, lblDrWithRes,
                JPartPanelAmendAppDateOfAppDOC.getInstance().getJComboDay(), 
                JPartPanelAmendAppDateOfAppDOC.getInstance().getJComboMonth(), 
                JPartPanelAmendAppDateOfAppDOC.getInstance().getJComboYear(), 
                JPartPanelAmendAppTimeOfAppDOC.getInstance().getJComboTime(), lblSymptoms, jtfDrsCommentsRes, lblAttendedRes, lblCancelledRes, lblMissedRes));
         
         
         
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
        add(lblDateRes);
        
        add(lblTime);

        add(lblTimeRes);
        add(lblSymptoms);
        
      
        add(lblSymptomsRes);//
        
        add (lblDrsComments);
        
        add(jtfDrsCommentsRes);//
        
        add(lblAttended);
      
       
        add(lblAttendedRes);//
        
        add(lblCancelled);
        
       
        add(lblCancelledRes);//
        add(lblMissed);
        
        
        add(lblMissedRes);//

        add(lblPresDetails);
        add(lblPrescDetailRes);

     
        
        add(btnCancel);
        add(btnAmend);
        add(btnAddpresc);
        
          
    }

       public static JPanelAppAmendDocView getInstance(){
        if (jpanAppAmendSingInst == null) {
            jpanAppAmendSingInst = new JPanelAppAmendDocView();
        }
        
        return jpanAppAmendSingInst;
    }
       
       
        public static void updateFormComponents(String title, String name, String surname, String username, String appointmentid, String drwith, LocalDateTime datetimein, String symptoms, String drscomment, String attended, String cancelled, String missed, String presdetails){
        
        jlTitleRes.setText(title);
        lblFirstNameRes.setText(name);
        lblSurnameRes.setText(surname);
        lblUserNameRes.setText(username);
        lblAppIDRes.setText(appointmentid);
       lblDrWithRes.setText(drwith);
       //update the form with the date combos - pass it the datetime object and in there it will split strings of day, month and year
       lblDateRes.setText(SchedulingAbstract.getConvDateTimeToStringDay(datetimein) + "-" + SchedulingAbstract.getConvDateTimeToStringMonth(datetimein)+ "-" + SchedulingAbstract.getConvDateTimeToStringYear(datetimein));
        JPartPanelAmendAppDateOfAppSEC.getInstance().updateFormWidgets(datetimein);
        //update the form with the time combos - pass it the datetime object and in there it will split strings of hour and minute
        JPartPanelAmendAppTimeOfAppSEC.getInstance().updateFormWidgets(datetimein);
        lblTimeRes.setText(SchedulingAbstract.getConvDateTimeToStringHour(datetimein) + ":" + SchedulingAbstract.getConvDateTimeToStringMinute(datetimein));
        lblSymptomsRes.setText(symptoms);
        jtfDrsCommentsRes.setText(drscomment);
        lblAttendedRes.setText(attended);
        lblCancelledRes.setText(cancelled);
        lblMissedRes.setText(missed);
        lblPrescDetailRes.setText(presdetails);
        
        //all widgets have been set up, so the changed status of the form is set to false using these three 
        //variables (the form can be changed in 3 different ways. This will change if there is any movement
        //on any of the items
        formUpdatedNotDateTime = false;
        
        JPanelAppAmendDocView.getInstance().btnAddpresc.addActionListener(new ActListDisplayJPanAddPrescription(lblAppIDRes.getText(), lblUserNameRes.getText(), lblDrWithRes.getText()));
  
        }
           
           //if someone changes somethign on this form, this value will be set to true
    //when someone presses the update button, if the value is false it won;t update anything, but if it is true it will run 
    //through the routine of updating all objects involved
    //this will be set back to false after the updating has taken place so another appointment can be amended
    public void setFormUpdatedNotDateTime(Boolean formneedsupdating){
        formUpdatedNotDateTime = formneedsupdating;
    }
    
     //if someone changes somethign on this form, this value will be set to true
    //when someone presses the update button, if the value is false it won;t update anything, but if it is true it will run 
    //through the routine of updating all objects involved
    //this will be set back to false after the updating has taken place so another appointment can be amended
    public Boolean getFormUpdatedNotDateTime(){
        return formUpdatedNotDateTime;
    }
    
    public String getAppointmentID(){
        return lblAppIDRes.getText();
    }
    
    
 
}
