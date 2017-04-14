
package pkg15070779drsappsystem.ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import pkg15070779drsappsystem.JPanels.JPanelAppAmendSecView;

public class ActListAmendAppointment implements ActionListener {
    
    //component variables hold components passe din from previous form(s)
    JComboBox cmbDayIn;
    JComboBox cmbMonthin;
    JComboBox cmbYearIn;
    JComboBox cmbTimeIn;
            
    JLabel patUserNameIn;
    JLabel AppKeyIn;
    JLabel drUserNameIn;
                    
    JCheckBox attendedIn;
    JCheckBox cancelledIn;
    JCheckBox missedIn;
    public ActListAmendAppointment(JLabel patusername, JLabel appid, JLabel dridin, JComboBox cmbdayin, JComboBox cmbmonthin, JComboBox cmbyearin, JComboBox cmbtimein, JTextField symptomsin, JCheckBox attendedin, JCheckBox cancelledin, JCheckBox missedin ){
    this.cmbDayIn = cmbdayin;
        
    this.cmbMonthin = cmbmonthin;
    this.cmbYearIn = cmbyearin;
    this.cmbTimeIn = cmbtimein;
            
   this.patUserNameIn = patusername;
    this.AppKeyIn = appid;
    this.drUserNameIn =dridin;
                    
    this.attendedIn =attendedin;
    this.cancelledIn = cancelledin;
    this.missedIn = missedin;
        System.out.println("I am here" + cmbdayin.getSelectedItem());
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.println("woo hoo" + cmbDayIn.getSelectedItem());
        System.out.println("woo hoohhh" + cmbTimeIn.getSelectedItem());
        JPanelAppAmendSecView amendAppFormInst = JPanelAppAmendSecView.getInstance();
        
        //if the form has been altered in any way, the variable will be set at true - which means all objects need updating
        //if false, just display a message sayign no updates found
        if (amendAppFormInst.getFormUpdated() == false){
            JOptionPane.showMessageDialog (null,
                "The form hasn't been updated. Please press 'Back' or make the changes to the appointment",
                "No Changes Made",
                JOptionPane.ERROR_MESSAGE);
        }
        
        //program needs updating
        else{
            
            
            
            
            //variable which checks whether the form has been updated or not set back to false
            amendAppFormInst.setFormUpdated(false);
        }
        
    }
    
}
