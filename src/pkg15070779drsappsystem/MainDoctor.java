package pkg15070779drsappsystem;

import java.util.*;


public class MainDoctor extends MainAbsSystemUserComponent {
    private String apptest;
    //private static Map<String, MainAbsSystemUserComponent> mapDoctors = new HashMap<>(); //holds all doctor system users
    private static List<String> lstDoctors = new ArrayList <>();
    private String uniqueDrName;
    public MainDoctor(String fname, String sname, String title, String dob, String newer){
        //needs to be in subclasses when abstract
        super(fname, sname, title, dob);
        //this.apptest = newer;
        this.uniqueDrName = this.setGenerateUniqueDrName();
        setAddDoctorToMaps(this.uniqueDrName,this);
        lstDoctors.add(setGenerateUniqueDrName());
    }
    
    public String setGenerateUniqueDrName(){
        return super.getTitle(this) + " " + super.getFirstName(this)+ " " + super.getSurname(this); //creates a unique dr name 
    }
    
    public static String setGenerateUniqueDrNameStatic(String userID){
        
        return "Change me";
    }
    
    public static List<String> getListAllDoctors(){
                       
        return lstDoctors;
    }
        
    private void setAddDoctorToMaps(String uniqDrName, MainDoctor doc){
        //mapDoctors.put(uniqDrName,this); //add to Dr composite (Map) - sub composite of system user Map
        //lstDoctors.add(apptest)
        setPutInMap(this); //add to System user composite (Map)
        
    }
    
   
    
    //@Override
   //public String toString () {
        //return super.getTitle(this) + " " + super.getFirstName(this)+ " "+ super.getSurname(this); 
    //}
}