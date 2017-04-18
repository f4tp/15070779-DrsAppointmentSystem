
package pkg15070779drsappsystem.JPanels;

import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import pkg15070779drsappsystem.MainClasses.SysUserDoctor;

public class JPartPanelSelDrComboFlow extends JPanel {
    public static JPartPanelSelDrComboFlow SelDrSingInst;
    
    JLabel lblSelDoc = new JLabel("Select a Doctor:     ");
    JComboBox cmbSelDoc = new JComboBox();
    
    private JPartPanelSelDrComboFlow(){
       
        add(lblSelDoc);
        add(cmbSelDoc);
        
    }
    
    //gets the most recent list of Doctors when called, and adds them to the combo box to display all Drs
    public static void setDrComboBox(){
        getInstance().cmbSelDoc.removeAllItems();
        List <String> tempAppKeys= SysUserDoctor.getListAllDoctors();
        
        tempAppKeys.stream().forEach((temp) -> {
            getInstance().cmbSelDoc.addItem(temp);
        });
    }
    
    //singleton DP
    public static JPartPanelSelDrComboFlow getInstance(){
        if(SelDrSingInst == null){
            SelDrSingInst = new JPartPanelSelDrComboFlow(); 
        }
        
        return SelDrSingInst;
    }
    
    public static String getDoctorString(){
        return SelDrSingInst.cmbSelDoc.getSelectedItem().toString();
    }
    
}
