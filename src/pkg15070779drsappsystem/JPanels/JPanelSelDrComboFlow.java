
package pkg15070779drsappsystem.JPanels;

import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import pkg15070779drsappsystem.MainClasses.MainDoctor;

public class JPanelSelDrComboFlow extends JPanel {
    public static JPanelSelDrComboFlow SelDrSingInst;
    
    JLabel lblSelDoc = new JLabel("Select a Doctor:     ");
    JComboBox cmbSelDoc = new JComboBox();
    
    private JPanelSelDrComboFlow(){
       
        add(lblSelDoc);
        add(cmbSelDoc);
        //updateComboBox();
    }
    
    //gets the most recent list of Doctors when called, and adds them to the combo box to display all Drs
    public static void updateComboBox(){
        getInstance().cmbSelDoc.removeAllItems();
        List <String> tempAppKeys= MainDoctor.getListAllDoctors();
        
         for (String temp : tempAppKeys ){
                  getInstance().cmbSelDoc.addItem(temp);
        }
    }
    
    //singleton DP
    public static JPanelSelDrComboFlow getInstance(){
        if(SelDrSingInst == null){
            SelDrSingInst = new JPanelSelDrComboFlow(); 
        }
        
        return SelDrSingInst;
    }
    
    public static String getDoctorString(){
        return SelDrSingInst.cmbSelDoc.getSelectedItem().toString();
    }
    
}
