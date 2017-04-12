
package pkg15070779drsappsystem.JPanels;

import java.awt.GridLayout;
import javax.swing.*;


public class JPartPanelTemplateTwelveGridView extends JPanel{
    public JPartPanelTemplateTwelveGridView(JLabel LabOne, JTextField TextTwo, JLabel LabThree, JTextField TextFour, JLabel LabFive, JTextField TextSix, JLabel LabSeven, JTextField TextEight, JLabel LabNine, JTextField TextTen, JLabel LabEleven, JTextField TextTwelve){
       setLayout(new GridLayout(6,2));
       add(LabOne);
       add(TextTwo);
       add(LabThree);
       add(TextFour);
       add(LabFive);
       add(TextSix);
       add(LabSeven);
       add(TextEight);
       add(LabNine);
       add(TextTen);
       add(LabEleven);
       add(TextTwelve);
       //add(LabNine);
       //add(TextTen);
       //add(ButThirteen);
       //add(ButFourteen);
     
    }
    
   
}
