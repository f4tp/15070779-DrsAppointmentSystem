
package pkg15070779drsappsystem.JFrames;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public abstract class JFrameAbsBorLayFillScreen extends JFrame {
    
    
    public static void applyLayout(JFrame pushedin){
        pushedin.setLayout (new BorderLayout ());
         //code below sets the menu to the screen size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        pushedin.pack();
        pushedin.setBounds(0,0,screenSize.width, screenSize.height-40); //minus 40 for the task bar (which we want present)
        pushedin.setVisible(true);
    }
    
}
