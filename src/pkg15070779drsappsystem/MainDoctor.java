package pkg15070779drsappsystem;

import java.util.*;


public class MainDoctor extends MainAbsSystemUserComponent implements MainIntAbsUserComponent  {
    private String apptest;
    //private static Map<String, MainAbsSystemUserComponent> mapDoctors = new HashMap<>(); //holds all doctor system users
    private String strTitle, strFirstName, strSurname, strDOB, strKeyUserNamel;
    private static List<String> lstDoctors = new ArrayList <>();
    private String uniqueDrName;
    public MainDoctor(String fname, String sname, String title, String dob, String newer){
     
        strTitle = title;
        strFirstName = fname;
        strSurname = sname;
        strDOB = dob;
        strKeyUserNamel = setGenerateUsername(this.strFirstName, this.strSurname, this.strDOB);
        setPutInMap(this.strKeyUserNamel, this); //add the user object to the map
        
        this.uniqueDrName = this.setGenerateUniqueDrName();
        lstDoctors.add(setGenerateUniqueDrName());
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
    
    public String setGenerateUniqueDrName(){
        return this.getTitle() + " " + this.getFirstName()+ " " + this.getSurname(); //creates a unique dr name 
    }
    
    public static String setGenerateUniqueDrNameStatic(String userID){
        
        return "Change me";
    }
    
    public static List<String> getListAllDoctors(){
                       
        return lstDoctors;
    }
        
       
   
    
    //@Override
   //public String toString () {
        //return super.getTitle(this) + " " + super.getFirstName(this)+ " "+ super.getSurname(this); 
    //}
}