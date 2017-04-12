package pkg15070779drsappsystem.MainClasses;

import pkg15070779drsappsystem.MainAbstractClasses.MainAbsSystemUserComponent;
import pkg15070779drsappsystem.Interfaces.MainIntAbsUserComponent;

public class MainPharmacist extends MainAbsSystemUserComponent implements MainIntAbsUserComponent {
    private String apptest;
    private String strTitle, strFirstName, strSurname, strDOB, strKeyUserNamel;
    
    
    public MainPharmacist(String fname, String sname, String title, String dob, String newer){
        strTitle = title;
        strFirstName = fname;
        strSurname = sname;
        strDOB = dob;
        strKeyUserNamel = setGenerateUsername(this.strFirstName, this.strSurname, this.strDOB);
        setPutInMap(this.strKeyUserNamel, this); //add the user object to the map
        
    }
    
     //@@@@@@@@@@ interface getters @@@@@@@@@@
    public String getUserName(){
        return this.strKeyUserNamel;
    }
    
    public String getTitle(){
        return this.strTitle;
    }
    public String getFirstName(){
        return this.strFirstName;
    }
    public String getSurname(){
        return this.strSurname;
    }

    public String getDOB(){
        return this.strDOB;
    }
    
}