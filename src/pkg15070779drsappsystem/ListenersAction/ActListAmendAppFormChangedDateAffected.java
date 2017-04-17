
package pkg15070779drsappsystem.ListenersAction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import pkg15070779drsappsystem.JPanels.JPanelAppAmendSecView;

//used for the app cancelled checkbox only, as this will affect dates
public class ActListAmendAppFormChangedDateAffected implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent ae) {
        JPanelAppAmendSecView refHolder = JPanelAppAmendSecView.getInstance();
        refHolder.setFormUpdatedDateTime(true);
    }
    
    
}
