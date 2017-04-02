package pkg15070779drsappsystem;

import java.awt.BorderLayout;
import javax.swing.*;


public class JPanelFindPatient extends JPanel {
    public static JPanelFindPatient FindPatSingInst;
    
    private JPanelFindPatient(){
       
       JLabel lblFirstName = new JLabel ("Enter the FIRST NAME of a patient");
       //lblFirstName.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
       JLabel lblSurname = new JLabel ("Enter the SURNAME of a patient");
       //lblSurname.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
       JLabel lblDob = new JLabel ("Enter the patient's DOB as a single number (e.g. 01012010 is the 1st Jan 2010");
       //lblYearOfBirth.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
       JTextField JTFFirstName = new JTextField();
       //JTFFirstName.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
       JTextField JTFSurname = new JTextField();
       //JTFSurname.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
       JTextField JTFdob = new JTextField();
       //JTFdob.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
       JPanelSixGridView searchFields = new JPanelSixGridView(lblFirstName,JTFFirstName,lblSurname,JTFSurname, lblDob,JTFdob);
       
       
       
       
       JPanelAddBoxPadUnderComp pad = new JPanelAddBoxPadUnderComp(searchFields);
       
       
       JButton btnRunReport = new JButton ("Find Patient");
       btnRunReport.addActionListener(new ActListFindPatient(JTFFirstName, JTFSurname, JTFdob));
       btnRunReport.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
       
       
       
       //update this with results, add them to a list, convert ot an array, then 
       //feed them into the combobox
       JComboBox foundPatients = new JComboBox();
       JButton btnSelectPatient = new JButton("Select Patient");
       
       
       
 //@@@@@@@@@@ Layout the Panel @@@@@@@@@@
       
       
       setBorder(BorderFactory.createEmptyBorder(20, 100, 20, 100));
       setLayout (new BorderLayout ());
       add(searchFields, BorderLayout.NORTH);
       //add(JTFSurname, BorderLayout.CENTER);
       add(pad, BorderLayout.CENTER);
       add(btnRunReport, BorderLayout.SOUTH);
    }
    
    public static JPanelFindPatient getInstance(){
         if (FindPatSingInst == null){
            FindPatSingInst = new JPanelFindPatient();
        }
        //panelRepDrsAppsSingInst.setVisible(true);
        return FindPatSingInst;
    }
    
    
    
}
