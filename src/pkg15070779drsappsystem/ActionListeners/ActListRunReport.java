package pkg15070779drsappsystem.ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import pkg15070779drsappsystem.JFrames.JFrameSecretaryMenu;

public class ActListRunReport implements ActionListener {
    private String typeOfReport;
        
    public ActListRunReport(String typeofreport){
        this.typeOfReport = typeofreport;
       
        
    }
   
    
    public void actionPerformed(ActionEvent e){
         //get the single instance of the Sec menu and call the method on it 
        //with the right border to set - passed in from the menu option
        JFrameSecretaryMenu holder = JFrameSecretaryMenu.getInstance();
        holder.setSecSouthBorderString(this.typeOfReport);
        
        
        //the type of report to run is based on the text in the label of the JPanel, this determines which data is to
        //be used... the same place will be populated with the details (the abstract jpanel)
        if (typeOfReport == "Report all Appointments for the month of..."){
            
        }
        
        else if (typeOfReport == "Report Doctor's appointments for the month of..."){
            
        }
        
        else if (typeOfReport == "Report all prescriptions issued for the month of..."){
            
        }
        
    }
    

    
}

