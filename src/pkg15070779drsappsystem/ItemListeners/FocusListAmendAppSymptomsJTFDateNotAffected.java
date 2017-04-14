
package pkg15070779drsappsystem.ItemListeners;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import pkg15070779drsappsystem.JPanels.JPanelAppAmendSecView;

public class FocusListAmendAppSymptomsJTFDateNotAffected implements FocusListener {

    @Override
    public void focusGained(FocusEvent fe) {
        System.out.println("item listener triggered");
        JPanelAppAmendSecView refHolder = JPanelAppAmendSecView.getInstance();
        refHolder.setFormUpdatedNotDateTime(true);
        System.out.println(JPanelAppAmendSecView.getInstance().getFormUpdatedNotDateTime());
    
    }

    @Override
    public void focusLost(FocusEvent fe) {
        System.out.println("item listener triggered");
        JPanelAppAmendSecView refHolder = JPanelAppAmendSecView.getInstance();
        refHolder.setFormUpdatedNotDateTime(true);
        System.out.println(JPanelAppAmendSecView.getInstance().getFormUpdatedNotDateTime());
    }
    
}
