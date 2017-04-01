
package pkg15070779drsappsystem;

import javax.swing.*;
//thsi object is to pad between a text box & button in a JTextfield
//because adding a border just extends the size of teh button, leaves no 
//gap
public class JPanelAddBoxPadUnderComp extends JPanel {
    
    //overloaded constructors - for different objects that are needed
    public JPanelAddBoxPadUnderComp(JTextField passedin){
        setLayout (new BoxLayout(this, BoxLayout.Y_AXIS));
        
        JTextField topTextField = passedin;
        add(topTextField);
        
        JLabel topLabel = new JLabel(" ");
        add(topLabel);
                        
    }
    
    public JPanelAddBoxPadUnderComp(JComboBox passedin){
        setLayout (new BoxLayout(this, BoxLayout.Y_AXIS));
        
        JComboBox topComboField = passedin;
        add(topComboField);
        
        JLabel topLabel = new JLabel(" ");
        add(topLabel);
        
        
        
    }
    
    public JPanelAddBoxPadUnderComp(JLabel passedin){
        setLayout (new BoxLayout(this, BoxLayout.Y_AXIS));
        
        JLabel topLabelField = passedin;
        add(topLabelField);
        
        JLabel topLabel = new JLabel(" ");
        add(topLabel);
        
        
        
    }
    
    
    public JPanelAddBoxPadUnderComp(JPanel passedin){
        setLayout (new BoxLayout(this, BoxLayout.Y_AXIS));
        
        JPanel topLabelField = passedin;
        add(topLabelField);
        
        JLabel topLabel = new JLabel(" ");
        add(topLabel);
        
        
        
    }
    
    
}
