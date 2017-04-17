
package pkg15070779drsappsystem.ListenersItem;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import pkg15070779drsappsystem.JPanels.JPanelAppAmendSecView;


public class ItemListAmendAppFormChangedDateAffected implements ItemListener {

    //the item listener will be added to all components that can be changed on the amend appointment form
    //when teh button is clicked, if something has changed this variable will be true, and the form
    //will carry out all of the changes to all objects involved (patient, appointment, doctor, prescription if applicable)
    String listenerCalledFrom;
    public ItemListAmendAppFormChangedDateAffected(String calledfrom){
        this.listenerCalledFrom = calledfrom;
    }
    @Override
    public void itemStateChanged(ItemEvent ie) {
        
        if (listenerCalledFrom == "Sec"){
            JPanelAppAmendSecView refHolder = JPanelAppAmendSecView.getInstance();
            refHolder.setFormUpdatedDateTime(true);
        }
        
        //NTD
       if (listenerCalledFrom == "Doc"){
            JPanelAppAmendSecView refHolder = JPanelAppAmendSecView.getInstance();
            refHolder.setFormUpdatedDateTime(true);
        }
        
        
    }
    
}
