package pkg15070779drsappsystem.JPanels;

import java.awt.GridLayout;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import pkg15070779drsappsystem.MainAbstractClasses.MainAbsScheduling;

import pkg15070779drsappsystem.MainClasses.MainPatient;

public class JPanelNewAppointment extends JPanel{
    
    //NTD iteration could be used here - sort when get time
    
        
        JLabel lblTitle = new JLabel ("Patient's Title:");
       //lblFirstName.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
       JTextField JTFTitle = new JTextField();
        
        JLabel lblFirstName = new JLabel ("Patient's First Name:");
       //lblFirstName.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
       JTextField JTFFirstName = new JTextField();
       
        JLabel lblSurname = new JLabel ("Patient's Surname");
       JTextField JTFSurname = new JTextField();
       
       
       JLabel lblDob = new JLabel ("Patient's Date of Birth");
        JTextField JTFdob = new JTextField();
       
       JLabel lblUserName= new JLabel ("Patient's System User Name");
        JTextField JTFUserName = new JTextField(); 
        
       JLabel lblSelDoc= new JLabel("Please select the doctor you wish to have an appointment with:");
       JComboBox cmbSelDoctor = new JComboBox(); 
       //only registered doctors will be shown once a patient has been searched for
       
        JLabel lblSymptoms= new JLabel ("Please enter the patient's symptoms");
       JTextField JTFSymptoms = new JTextField();

       
       JLabel lblSelDay = new JLabel("Please select a date for the appointment");
       JComboBox cmbSelDay = new JComboBox(MainAbsScheduling.getDaysArr());
       
       JLabel lblSelMon = new JLabel("Please select a month for the appointment");
       JComboBox cmbSelMonth = new JComboBox(MainAbsScheduling.getMonthsArr());
       
       JLabel lblSelYear = new JLabel("Please select a year for the appointment");
       JComboBox cmbSelYear = new JComboBox(MainAbsScheduling.getYearArr());
       JLabel lblSelTime= new JLabel("Please select a time for the appointment");
       JComboBox cmbSelTime = new JComboBox(MainAbsScheduling.getTimesArr());
       
       
    
    private static JPanelNewAppointment jPanNewAppSingInst;
    
    private JPanelNewAppointment(){
     
  //@@@@@@@@@@layout the screen
      
       setLayout(new GridLayout(11,2));
       addComponents();
     
    }
    
    private void addComponents(){
       
       add(lblTitle);
       add(JTFTitle);
        add(lblFirstName);
       add(JTFFirstName);
       add(lblSurname);
       add(JTFSurname);
       add(lblDob);
       add(JTFdob);
       add(lblUserName);
       add(JTFUserName);
       add(lblSymptoms);
       add(JTFSymptoms);
       add(lblSelDoc);
       add(cmbSelDoctor);
       add(lblSelDay);
       add(cmbSelDay);
       add(lblSelMon);
       add(cmbSelMonth);
        add(lblSelYear);
        add(cmbSelYear);
        add(lblSelTime);
        add(cmbSelTime);
        
    }
    
     
    
    public void updateForm(){
        
        //this routine updates the combo box with 
        if (MainPatient.currentPatient != null){
                   
            List<String> lstHolder = MainPatient.currentPatient.getDrsRegWithAsList();
            String[] arrHolder = new String[lstHolder.size()];
            arrHolder = lstHolder.toArray(arrHolder);
            
            cmbSelDoctor.removeAllItems();
            for(String s : arrHolder){
               cmbSelDoctor.addItem(s);
            }
         
        }
        
        JTFTitle.setText(MainPatient.currentPatient.getTitle());
         JTFFirstName.setText(MainPatient.currentPatient.getFirstName());
         JTFSurname.setText(MainPatient.currentPatient.getSurname());
        JTFdob.setText(MainPatient.currentPatient.getDOB());
        JTFUserName.setText(MainPatient.currentPatient.getUserName());
     
    }
    
 
    public String getSymptoms(){
        JPanelNewAppointment tempHolder = getInstance();
        return  tempHolder.JTFSymptoms.getText();
     
    }
    
    public String getDay(){
        JPanelNewAppointment tempHolder = getInstance();
        return  tempHolder.cmbSelDay.getSelectedItem().toString();
     
    }
    

    public String getDoctor(){
        JPanelNewAppointment tempHolder = getInstance();
        return  tempHolder.cmbSelDoctor.getSelectedItem().toString();
     
    }
    
    
    public String getMonth(){
        JPanelNewAppointment tempHolder = getInstance();
        return  tempHolder.cmbSelMonth.getSelectedItem().toString();
     
    }
    
     public String getYear(){
        JPanelNewAppointment tempHolder = getInstance();
        return  tempHolder.cmbSelYear.getSelectedItem().toString();
     
    }
     
      public String getTime(){
        JPanelNewAppointment tempHolder = getInstance();
        return  tempHolder.cmbSelTime.getSelectedItem().toString();
     
    }
    
    //singleton design - only 1 JPanel ever needed
    public static JPanelNewAppointment getInstance(){
        if (jPanNewAppSingInst == null){
            jPanNewAppSingInst = new JPanelNewAppointment();
            
        }
  
        return jPanNewAppSingInst;
    }
    
}
