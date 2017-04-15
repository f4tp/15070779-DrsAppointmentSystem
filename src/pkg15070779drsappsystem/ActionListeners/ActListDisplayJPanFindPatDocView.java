/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg15070779drsappsystem.ActionListeners;

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
