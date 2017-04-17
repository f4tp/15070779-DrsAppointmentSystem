package pkg15070779drsappsystem.MainClasses;

import pkg15070779drsappsystem.MainAbstractClasses.MainAbsSystemUserComponent;
import pkg15070779drsappsystem.Interfaces.MainInterfaceSystemUsers;

public class MainSecretary extends MainAbsSystemUserComponent implements MainInterfaceSystemUsers  {
   
    public static MainSecretary currentSecretary;
    
    private String apptest;
    private String strTitle, strFirstName, strSurname, strDOB, strKeyUserNamel;
    public MainSecretary(String fname, String sname, String title, String dob, String newer){
        strTitle = title;
        strFirstName = fname;
        strSurname = sname;
        strDOB = dob;
        this.apptest = newer;
        strKeyUserNamel = setGenerateUsername(this.strFirstName, this.strSurname, this.strDOB);
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