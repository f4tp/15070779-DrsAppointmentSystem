
package pkg15070779drsappsystem.ListenersAction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import pkg15070779drsappsystem.JPanels.JPanelPresDisplayFromTo;
import pkg15070779drsappsystem.JPanels.JPartPanelAppsSelDateFlow;
import pkg15070779drsappsystem.MainAbstractClasses.MainAbsScheduling;
import pkg15070779drsappsystem.MainClasses.MainPrescription;


public class ActListSearchPresPHARM implements ActionListener {
    private JPartPanelAppsSelDateFlow dateFromJPan;
    private JPartPanelAppsSelDateFlow dateToJPan;
    JComboBox cmbPresStatus;
    public static List <MainPrescription> lstFoundPrescriptions = new ArrayList<>();
     
    public ActListSearchPresPHARM(JPartPanelAppsSelDateFlow jpanfrom, JPartPanelAppsSelDateFlow jpanto, JComboBox cmbpresstatus){

        this.cmbPresStatus = cmbpresstatus;
        this.dateFromJPan = jpanfrom;
        this.dateToJPan = jpanto;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
         //get the from date selected by the user and construct it into a LocalDateTime object
        //time had to be set at 17:15 as this date is set the day before so this particular date can be included in 
        //the search, but it needs to search from the day before at a time when appointments 
        //are not available otherwise it will include these also
        
        
        LocalDateTime ldtFrom = MainAbsScheduling.getConvStringToDateTime(this.dateFromJPan.getDateDayString() + this.dateFromJPan.geDateMonthString() + this.dateFromJPan.getDateYearString() + "1715");
        System.out.println(ldtFrom);
        //get the to date selected by the user and construct it into a LocalDateTime object - time set at 0000
        LocalDateTime ldtTo = MainAbsScheduling.getConvStringToDateTime(this.dateToJPan.getDateDayString() + this.dateToJPan.geDateMonthString() + this.dateToJPan.getDateYearString() + "0000");
  
    
        Boolean statusAsBoo = false;
        
        if (cmbPresStatus.getSelectedItem().toString() == "Dispatched"){
            statusAsBoo = true;
        }
 
        
       List <String> lstMainPresToUpdateCombo = MainPrescription.getListPresWithDateAndStatus(ldtFrom, ldtTo, statusAsBoo);
       JPanelPresDisplayFromTo.updateFoundPrescriptions(lstMainPresToUpdateCombo);
       
       
    }
    
}
