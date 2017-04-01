
package pkg15070779drsappsystem;

import javax.swing.*;
//thsi object is to pad between a text box & button in a JTextfield
//because adding a border just extends the size of teh button, leaves no 
//gap
public class AddBoxPadUnderComp extends JPanel {
    
    //overloaded constructors - for different objects that are needed
    public AddBoxPadUnderComp(JTextField passedin){
        setLayout (new BoxLayout(this, BoxLayout.Y_AXIS));
        
        JTextField topTextField = passedin;
        add(topTextField);
        
        JLabel topLabel = new JLabel(" ");
        add(topLabel);
                        
    }
    
    public AddBoxPadUnderComp(JComboBox passedin){
        setLayout (new BoxLayout(this, BoxLayout.Y_AXIS));
        
        JComboBox topComboField = passedin;
        add(topComboField);
        
        JLabel topLabel = new JLabel(" ");
        add(topLabel);
        
        
        
    }
    
    public AddBoxPadUnderComp(JLabel passedin){
        setLayout (new BoxLayout(this, BoxLayout.Y_AXIS));
        
        JLabel topLabelField = passedin;
        add(topLabelField);
        
        JLabel topLabel = new JLabel(" ");
        add(topLabel);
        
        
        
    }
    
    
}
