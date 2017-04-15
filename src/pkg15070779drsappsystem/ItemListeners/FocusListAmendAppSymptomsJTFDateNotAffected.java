
package pkg15070779drsappsystem.ItemListeners;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import pkg15070779drsappsystem.JPanels.JPanelAppAmendDocView;
import pkg15070779drsappsystem.JPanels.JPanelAppAmendSecView;

public class FocusListAmendAppSymptomsJTFDateNotAffected implements FocusListener {
    
   
            String calledFrom;
            
            public FocusListAmendAppSymptomsJTFDateNotAffected(String calledfrom){
                this.calledFrom = calledfrom;
            }

    @Override
    public void focusGained(FocusEvent fe) {
        
        if(this.calledFrom == "Sec"){
         System.out.println("item listener triggered");
        JPanelAppAmendSecView refHolder = JPanelAppAmendSecView.getInstance();
        refHolder.setFormUpdatedNotDateTime(true);
        System.out.println(JPanelAppAmendSecView.getInstance().getFormUpdatedNotDateTime());
        }
        else if(this.calledFrom == "Doc"){
        JPanelAppAmendDocView refHolder = JPanelAppAmendDocView.getInstance();
        refHolder.setFormUpdatedNotDateTime(true);
        System.out.println(JPanelAppAmendDocView.getInstance().getFormUpdatedNotDateTime());
        }
        
       
    
    }

    @Override
    public void focusLost(FocusEvent fe) {
     if(this.calledFrom == "Sec"){
         System.out.println("item listener triggered");
        JPanelAppAmendSecView refHolder = JPanelAppAmendSecView.getInstance();
        refHolder.setFormUpdatedNotDateTime(true);
        System.out.println(JPanelAppAmendSecView.getInstance().getFormUpdatedNotDateTime());
        }
        else if(this.calledFrom == "Doc"){
        JPanelAppAmendDocView refHolder = JPanelAppAmendDocView.getInstance();
        refHolder.setFormUpdatedNotDateTime(true);
        System.out.println(JPanelAppAmendDocView.getInstance().getFormUpdatedNotDateTime());
        }
    }
    
}
