package pkg15070779drsappsystem.JPanels;

import java.awt.GridLayout;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import pkg15070779drsappsystem.MainClasses.MainPatient;

public class JPanelNewAppointment extends JPanel{
    
    //@@@@@@@@@@ iteration could be used here - sort when get time
    String arrFebDays [] = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "32", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27",
        "28"};
        
        String arrThirtyDays [] = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "32", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27",
        "28", "29", "30"};
        
        String arrDays [] = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "32", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27",
        "28", "29", "30", "31"};
        
        String arrMonths [] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        
        String arrYears[] = {"2017", "2018"};
        
        String arrTimes[] = {"0900", "0915", "0930", "0945", "1000", "1015", "1030", "1045", "1100", "1115", "1130", "1145", 
            "1200", "1215", "1230", "1245", "1300", "1315", "1330", "1345", "1400", "1415", "1430", "1445", "1500", "1515", "1530", "1545",
            "1600", "1615", "1630", "1645"};
        
        
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
       JComboBox cmbSelDay = new JComboBox(arrDays);
       
       JLabel lblSelMon = new JLabel("Please select a month for the appointment");
       JComboBox cmbSelMonth = new JComboBox(arrMonths);
       
       JLabel lblSelYear = new JLabel("Please select a year for the appointment");
       JComboBox cmbSelYear = new JComboBox(arrYears);
       JLabel lblSelTime= new JLabel("Please select a time for the appointment");
       JComboBox cmbSelTime = new JComboBox(arrTimes);
       
       
    
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
            //JComboBox cmbSelDoctor = new JComboBox(MainPatient.currentPatient.getDrsRegWithAsList().toArray());
            //cmbSelDoctor.removeAllItems();
            
            List<String> lstHolder = MainPatient.currentPatient.getDrsRegWithAsList();
            String[] arrHolder = new String[lstHolder.size()];
            arrHolder = lstHolder.toArray(arrHolder);
            
            cmbSelDoctor.removeAllItems();
            for(String s : arrHolder){
               cmbSelDoctor.addItem(s);
            }
            //cmbSelDoctor = new JComboBox(MainPatient.currentPatient.getDrsRegWithAsList().toArray());
            //cmbSelDoctor.addItem(MainPatient.currentPatient.getDrsRegWithAsList().toArray());
            
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
