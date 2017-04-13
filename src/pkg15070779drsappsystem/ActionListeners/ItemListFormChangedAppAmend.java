
package pkg15070779drsappsystem.ActionListeners;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import pkg15070779drsappsystem.JPanels.JPanelAppAmendSecView;


public class ItemListFormChangedAppAmend implements ItemListener {

    //the item listener will be added to all components that can be changed on teh amend appointment form
    //when teh button is clicked, if something has changed this variable will be true, and the form
    //will carry out all of the changes to all objects involved (patient, appointment, doctor, prescription if applicable)
    @Override
    public void itemStateChanged(ItemEvent ie) {
        JPanelAppAmendSecView refHolder = JPanelAppAmendSecView.getInstance();
        refHolder.setFormUpdated(true);
    }
    
}
