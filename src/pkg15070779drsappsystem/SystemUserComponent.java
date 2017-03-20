package pkg15070779drsappsystem;

import java.util.*;
public abstract class SystemUserComponent {

    private static Map<String, SystemUserComponent> mapSystemUsers = new HashMap<>();
    private String strFirstName, strSurname, strTitle, strUserName;
    private int yearOfBirth;
    
    
    public SystemUserComponent(String fname, String sname, String title, int yob){
        setCreateSystemUser(fname, sname, title, yob);//creates a new system user and adds it to the system user list
        //reportAllUsers(); //this code was used to test the report all users method, not needed
    }
    
    //when you output the object, it will run it like this instead:
    @Override
    public String toString () {
        return "UserName: " + strUserName + ", Details: " + strTitle + " " + strFirstName + " " + strSurname + ", Year of Birth: " + Integer.toString(yearOfBirth);
    }
    
    public void setCreateSystemUser(String fname, String sname, String title, int yob){
        this.strFirstName = fname;
        this.strSurname = sname;
        this.strTitle = title;
        this.yearOfBirth = yob;
        this.strUserName = setGenerateUsername(this.strFirstName, this.strSurname, this.yearOfBirth);
    }
     public String setGenerateUsername(String fname, String sname, int yob){
        String yobAsString = Integer.toString(yob);
        return fname.toLowerCase() + "." + sname.toLowerCase() + "." + yobAsString;
    }
    public void setPutInMap(SystemUserComponent passedIn){
        String uname = getUserName(this);
        mapSystemUsers.put(uname,passedIn);
    }
    
    public String getUserName(SystemUserComponent sysUseObj){
        return sysUseObj.strUserName;
    }
    
    public String getFirstName(SystemUserComponent uName){
        return uName.strFirstName;
    }
    
    public String getSurname(SystemUserComponent uName){
        return uName.strSurname;
    }
    
     public String getTitle(SystemUserComponent uName){
        return uName.strTitle;
    }
     
   
    public static Boolean checkLogin(String userNamePassed) {
         System.out.println(userNamePassed);
         if (mapSystemUsers.containsKey(userNamePassed)){
            return true;
         }
         else {
             return false;
         }
    }
        
    
     
    //this can be deleted when it isn;t needed
     public void reportAllUsers(){
        for (SystemUserComponent sysUser : mapSystemUsers.values ()) {                        // <4>
            System.out.println (sysUser);
        }
     }
    
     
     //need to add all other methods in here for patient, dr, sec, pharm
     
}
