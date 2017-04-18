package pkg15070779drsappsystem.MainClasses;

import pkg15070779drsappsystem.MainAbstractClasses.SystemUserComponent;
import pkg15070779drsappsystem.Interfaces.MainInterfaceSystemUsers;

public class SysUserPharmacist extends SystemUserComponent implements MainInterfaceSystemUsers {
    private String strTitle, strFirstName, strSurname, strDOB, strKeyUserName;
    
    
    public SysUserPharmacist(String fname, String sname, String title, String dob){
        strTitle = title;
        strFirstName = fname;
        strSurname = sname;
        strDOB = dob;
        strKeyUserName = getGenerateUsername(this.strFirstName, this.strSurname, this.strDOB);
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