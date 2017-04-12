
package pkg15070779drsappsystem.JPanels;

import javax.swing.*;
import java.awt.*;

public class JPartPanelTemplateSixGridView extends JPanel {
    
    
    public JPartPanelTemplateSixGridView(JLabel LabOne, JTextField TextTwo, JLabel LabThree, JTextField TextFour, JLabel LabFive, JTextField TextSix ){
       setLayout(new GridLayout(3,2));
       add(LabOne);
       add(TextTwo);
       add(LabThree);
       add(TextFour);
       add(LabFive);
       add(TextSix);
    }
    
    
    
}
