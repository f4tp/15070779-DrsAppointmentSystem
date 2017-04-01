package pkg15070779drsappsystem;

import java.util.*;


public class Doctor extends SystemUserComponent {
    private String apptest;
    //private static Map<String, SystemUserComponent> mapDoctors = new HashMap<>(); //holds all doctor system users
    private static List<String> lstDoctors = new ArrayList <>();
    private String uniqueDrName;
    public Doctor(String fname, String sname, String title, String dob, String newer){
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
    

        
    private void setAddDoctorToMaps(String uniqDrName, Doctor doc){
        //mapDoctors.put(uniqDrName,this); //add to Dr composite (Map) - sub composite of system user Map
        //lstDoctors.add(apptest)
        setPutInMap(this); //add to System user composite (Map)
        
    }
    
    public static List<String> getListAllDoctors(){
                       
        return lstDoctors;
    }
    
    //@Override
   //public String toString () {
        //return super.getTitle(this) + " " + super.getFirstName(this)+ " "+ super.getSurname(this); 
    //}
}