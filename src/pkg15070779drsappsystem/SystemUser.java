package pkg15070779drsappsystem;

import java.util.*;
public class SystemUser {

    private static Map<String, SystemUser> mapSystemUsers = new HashMap<>();
    private String strFirstName;
    private String strSurname;
    private String strTitle;
    private String strUserName;
    private int yearOfBirth;
    
    public SystemUser(String fname, String sname, String title, int yob){
        //creates a new system user and adds it to the system user list
               
        this.strFirstName = fname;
        this.strSurname = sname;
        this.strTitle = title;
        this.yearOfBirth = yob;
        this.strUserName = generateUserName(strFirstName, strSurname, yearOfBirth);
        
        mapSystemUsers.put(strUserName,this);
        //reportAllUsers();
        //the above code was used to test the report all users method, not needed
    }
            
    public String generateUserName(String fname, String sname, int yob){
        String yobAsString = Integer.toString(yob);
        return fname.toLowerCase() + "." + sname.toLowerCase() + "." + yobAsString;
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
     
     public void reportAllUsers(){
        for (SystemUser sysUser : mapSystemUsers.values ()) {                        // <4>
            System.out.println (sysUser);
        }
     }
    
}
