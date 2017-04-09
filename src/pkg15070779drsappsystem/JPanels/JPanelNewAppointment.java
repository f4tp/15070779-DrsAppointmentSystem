package pkg15070779drsappsystem.JPanels;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import pkg15070779drsappsystem.MainClasses.MainDoctor;

public class JPanelNewAppointment extends JPanel{
    
         String arrFebDays [] = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "32", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27",
        "28"};
        
        String arrThirtyDays [] = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "32", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27",
        "28", "29", "30"};
        
        String arrDays [] = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "32", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27",
        "28", "29", "30", "31"};
        
        String arrMonths [] = {"Jan", "feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        
        String arrYears[] = {"2017", "2018"};
    
    private static JPanelNewAppointment jPanNewAppSingInst;
    
    private JPanelNewAppointment(){
        
       
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
       JComboBox cmbSelDoctor = new JComboBox(MainDoctor.getListAllDoctors().toArray());
       
       
       JLabel lblSelDay = new JLabel("Please select a date for the appointment");
       JComboBox cmbSelDay = new JComboBox(arrDays);
       
       JLabel lblSelMon = new JLabel("Please select a month for the appointment");
       JComboBox cmbSelMonth = new JComboBox(arrMonths);
       
       JLabel lblSelYear = new JLabel("Please select a year for the appointment");
       JComboBox cmbSelYear = new JComboBox(arrYears);
       
       
       //layout the screen
      
       
       setLayout(new GridLayout(8,2));
       add(lblFirstName);
       add(JTFFirstName);
       add(lblSurname);
       add(JTFSurname);
       add(lblDob);
       add(JTFdob);
       add(lblUserName);
       add(JTFUserName);
       add(lblSelDoc);
       add(cmbSelDoctor);
       add(lblSelDay);
       add(cmbSelDay);
       add(lblSelMon);
       add(cmbSelMonth);
        add(lblSelYear);
        add(cmbSelYear);
    }
    
 
    
    
    //singleton design - only 1 JPanel ever needed
    public static JPanelNewAppointment getInstance(){
        if (jPanNewAppSingInst == null){
            jPanNewAppSingInst = new JPanelNewAppointment();
            
        }
  
        return jPanNewAppSingInst;
    }
    
}
