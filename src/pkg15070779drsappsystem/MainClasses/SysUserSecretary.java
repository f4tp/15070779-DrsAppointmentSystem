package pkg15070779drsappsystem.MainClasses;

import pkg15070779drsappsystem.MainAbstractClasses.SystemUserComponent;
import pkg15070779drsappsystem.Interfaces.MainInterfaceSystemUsers;

public class SysUserSecretary extends SystemUserComponent implements MainInterfaceSystemUsers  {
   
    public static SysUserSecretary currentSecretary;

    private String strTitle, strFirstName, strSurname, strDOB, strKeyUserNamel;
    public SysUserSecretary(String fname, String sname, String title, String dob){
        strTitle = title;
        strFirstName = fname;
        strSurname = sname;
        strDOB = dob;
        strKeyUserNamel = getGenerateUsername(this.strFirstName, this.strSurname, this.strDOB);
        setPutInMap(this.strKeyUserNamel, this);
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