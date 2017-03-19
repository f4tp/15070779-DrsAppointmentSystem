package pkg15070779drsappsystem;

import java.util.*;
public abstract class SystemUser {

    private static Map<String, SystemUser> mapSystemUsers = new HashMap<>();
    private String strFirstName, strSurname, strTitle, strUserName;
    private int yearOfBirth;
    
    
    public SystemUser(String fname, String sname, String title, int yob){
        setSystemUser(fname, sname, title, yob);//creates a new system user and adds it to the system user list
        //reportAllUsers(); //this code was used to test the report all users method, not needed
    }
    
    public void setSystemUser(String fname, String sname, String title, int yob){
        this.strFirstName = fname;
        this.strSurname = sname;
        this.strTitle = title;
        this.yearOfBirth = yob;
        this.strUserName = generateUserName(strFirstName, strSurname, yearOfBirth);
    }
     public String generateUserName(String fname, String sname, int yob){
        String yobAsString = Integer.toString(yob);
        return fname.toLowerCase() + "." + sname.toLowerCase() + "." + yobAsString;
    }
    public void setPutInMap(SystemUser passedIn){
        String uname = getUserName(this);
        mapSystemUsers.put(uname,passedIn);
    }
    
    public String getUserName(SystemUser uName){
        return uName.strUserName;
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
        
    @Override
    public String toString () {
        return "UserName: " + strUserName + ", Details: " + strTitle + " " + strFirstName + " " + strSurname + ", Year of Birth: " + Integer.toString(yearOfBirth);
    }
     
    //this can be deleted when it isn;t needed
     public void reportAllUsers(){
        for (SystemUser sysUser : mapSystemUsers.values ()) {                        // <4>
            System.out.println (sysUser);
        }
     }
    
     
     //need to add all other methods in here for patient, dr, sec, pharm
     
}
