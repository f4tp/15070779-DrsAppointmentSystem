
package pkg15070779drsappsystem;
import javax.swing.*;


public class JPanelReportsNorthLayout extends JPanel {
    
    public JPanelReportsNorthLayout(String paneltitle){
        setLayout (new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel lblMessage = new JLabel (paneltitle);
        JLabel lblMessage2 = new JLabel ("Select the month you wish to run the report for:");  
       
        add(lblMessage);
        add(lblMessage2);
    }

}