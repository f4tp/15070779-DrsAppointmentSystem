package pkg15070779drsappsystem.MainClasses;

import java.time.LocalDateTime;
import pkg15070779drsappsystem.AbstractClasses.MainAbsSystemUserComponent;
import pkg15070779drsappsystem.Interfaces.MainIntAbsUserComponent;
import java.util.*;
import pkg15070779drsappsystem.AbstractClasses.MainAppointmentSchedule;


public class MainDoctor extends MainAbsSystemUserComponent implements MainIntAbsUserComponent  {
   public static MainDoctor currentDoctor;
    
    
    private String apptest;
    //private static Map<String, MainAbsSystemUserComponent> mapDoctors = new HashMap<>(); //holds all doctor system users
    private String strTitle, strFirstName, strSurname, strDOB, strKeyUserName;
    private static List<String> lstDoctors = new ArrayList <>();
    private List<LocalDateTime> lstDocsAvailAppointments = new ArrayList<>();
    
    //private String strUniqueDrName;
    public MainDoctor(String fname, String sname, String title, String dob, String newer){
     
        this.strTitle = title;
        this.strFirstName = fname;
        this.strSurname = sname;
        this.strDOB = dob;
        this.strKeyUserName = setGenerateUsername(this.strFirstName, this.strSurname, this.strDOB);
      
        //this.strUniqueDrName = this.setGenerateUniqueDrName();
       // System.out.println(strUniqueDrName);
        lstDoctors.add(strKeyUserName);
        
        //generates a list with all available appointments on
        //when a patient generates an appointment, it will remove this from their list
        //if it can;t be found in teh list in other routines, it means someone has already gotten that appointment
        this.lstDocsAvailAppointments = MainAppointmentSchedule.generateAvailableAppointments();
        
        //add the user object to the map
         setPutInMap(this.strKeyUserName, this); 
        
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
    
    //public String setGenerateUniqueDrName(){
        //return this.getTitle() + " " + this.getFirstName()+ " " + this.getSurname(); //creates a unique dr name 
        
    //}
    
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