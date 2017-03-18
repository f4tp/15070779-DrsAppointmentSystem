package pkg15070779drsappsystem;


import java.util.*;
public class SystemUser {


    private static ArrayList<SystemUser> lstSystemUsers = new ArrayList<SystemUser>();
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
        
        lstSystemUsers.add(this);
    }
      
      
    public String generateUserName(String fname, String sname, int yob){
        String yobAsString = Integer.toString(yob);
        return fname.toLowerCase() + "." + sname.toLowerCase() + "." + yobAsString;
    }
    
     public static void checkLoggedIn(String userNamePassed) {
         System.out.println(userNamePassed);
         
             if (lstSystemUsers.contains(userNamePassed)){
                 System.out.println("I found it");
                 
             }
        
    }
    
}
