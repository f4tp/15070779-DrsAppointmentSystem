
package pkg15070779drsappsystem.JPanels;

import javax.swing.JPanel;

public class JPanelShowAvailApps extends JPanel {
    public static JPanelShowAvailApps JPanShowAvailAppsSingInst;
    
    
    
    private JPanelShowAvailApps(){
        
    }
    
    //singleton DP
    public JPanelShowAvailApps getInstance(){
        if (JPanShowAvailAppsSingInst == null){
            JPanShowAvailAppsSingInst = new JPanelShowAvailApps();
        }
        
        return JPanShowAvailAppsSingInst;
    }
}
