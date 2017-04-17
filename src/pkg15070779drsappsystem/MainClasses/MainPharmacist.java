package pkg15070779drsappsystem.MainClasses;

import pkg15070779drsappsystem.MainAbstractClasses.MainAbsSystemUserComponent;
import pkg15070779drsappsystem.Interfaces.MainInterfaceSystemUsers;

public class MainPharmacist extends MainAbsSystemUserComponent implements MainInterfaceSystemUsers {
    private String apptest;
    private String strTitle, strFirstName, strSurname, strDOB, strKeyUserName;
    
    
    public MainPharmacist(String fname, String sname, String title, String dob, String newer){
        strTitle = title;
        strFirstName = fname;
        strSurname = sname;
        strDOB = dob;
        strKeyUserName = setGenerateUsername(this.strFirstName, this.strSurname, this.strDOB);
        setPutInMap(this.strKeyUserName, this); //add the user object to the map
        
    }
    
//@@@@@@@@@@ interface getters @@@@@@@@@@
    public String getUserName(){
        return this.strKeyUserName;
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