/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg15070779drsappsystem.ListenersAction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import pkg15070779drsappsystem.JPanels.JPanelAppAmendSecView;

/**
 *
 * @author Quad
 */
public class ActListAmendAppFormChangedDateNotAffected implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent ae) {
          //sets a variable on the JPanel to say that the form has been changed, the amend button will know to update 
        //all relative objects and data appropriately when this is set to true
        //when amendments have taken place, the variable must be set back to false
        System.out.println("Action listener triggered");
        JPanelAppAmendSecView refHolder = JPanelAppAmendSecView.getInstance();
        refHolder.setFormUpdatedNotDateTime(true);
        System.out.println(JPanelAppAmendSecView.getInstance().getFormUpdatedNotDateTime());
    }
    
}
