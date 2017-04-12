
package pkg15070779drsappsystem.JPanels;

import javax.swing.*;
//thsi object is to pad between a text box & button in a JTextfield
//because adding a border just extends the size of the button, leaves no 
//gap
public class JPartPanelPadding extends JPanel {
    
    //overloaded constructors - for different objects that are needed
    public JPartPanelPadding(JTextField passedin){
        setLayout (new BoxLayout(this, BoxLayout.Y_AXIS));
        
        JTextField topTextField = passedin;
        add(topTextField);
        
        JLabel topLabel = new JLabel(" ");
        add(topLabel);
                        
    }
    
    public JPartPanelPadding(JComboBox passedin){
        setLayout (new BoxLayout(this, BoxLayout.Y_AXIS));
        
        JComboBox topComboField = passedin;
        add(topComboField);
        
        JLabel topLabel = new JLabel(" ");
        add(topLabel);
        
        
        
    }
    
    public JPartPanelPadding(JLabel passedin){
        setLayout (new BoxLayout(this, BoxLayout.Y_AXIS));
        
        JLabel topLabelField = passedin;
        add(topLabelField);
        
        JLabel topLabel = new JLabel(" ");
        add(topLabel);
        
        
        
    }
    
    
    public JPartPanelPadding(JPanel passedin){
        setLayout (new BoxLayout(this, BoxLayout.Y_AXIS));
        
        JPanel topLabelField = passedin;
        add(topLabelField);
        
        JLabel topLabel = new JLabel(" ");
        add(topLabel);
        
        
        
    }
    
    
}
