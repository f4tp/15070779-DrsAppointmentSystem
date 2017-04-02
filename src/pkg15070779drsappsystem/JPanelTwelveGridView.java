
package pkg15070779drsappsystem;

import java.awt.GridLayout;
import javax.swing.*;


public class JPanelTwelveGridView extends JPanel{
    public JPanelTwelveGridView(JLabel LabOne, JTextField TextTwo, JLabel LabThree, JTextField TextFour, JLabel LabFive, JTextField TextSix, JLabel LabSeven, JTextField TextEight, JLabel LabNine, JTextField TextTen, JButton ButEleven, JButton ButTweleve ){
       setLayout(new GridLayout(5,2));
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
       add(ButEleven);
       add(ButTweleve);
     
    }
}
