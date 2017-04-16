package pkg15070779drsappsystem.ListenersAction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import pkg15070779drsappsystem.JFrames.JFrameDoctorMenu;


public class ActListDisplayJPanFindPatDocView implements ActionListener{
    private String typeOfSecJPanToSet;
    
    public ActListDisplayJPanFindPatDocView(String typeofjpantoset){
        
        this.typeOfSecJPanToSet = typeofjpantoset;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        //JFrameDoctorMenu instHolder = getInstance();
        JFrameDoctorMenu instHolder = JFrameDoctorMenu.getInstance();
         instHolder.setDocSouthBorderString(this.typeOfSecJPanToSet);
    }
    
}
