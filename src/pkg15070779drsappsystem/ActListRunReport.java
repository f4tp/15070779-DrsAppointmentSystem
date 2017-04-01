
package pkg15070779drsappsystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class ActListRunReport implements ActionListener {
    private String typeOfReport;
    
    public ActListRunReport(String typeofreport){
        typeOfReport = typeofreport;
        System.out.println(typeOfReport);
        
    }
    
    public void actionPerformed(ActionEvent e){
        
        //get the single instance of the Sec menu and call the method on it 
        //with the right border to set - passed in from the menu option
        JFrameSecretaryMenu holder = JFrameSecretaryMenu.getInstance();
        holder.setSouthBorderString(typeOfReport);
        System.out.println(typeOfReport);
    }
    

    
}

