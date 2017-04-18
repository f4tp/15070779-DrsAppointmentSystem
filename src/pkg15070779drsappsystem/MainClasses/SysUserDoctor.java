package pkg15070779drsappsystem.MainClasses;

import java.time.LocalDateTime;
import pkg15070779drsappsystem.MainAbstractClasses.SystemUserComponent;
import java.util.*;
import javax.swing.JOptionPane;
import pkg15070779drsappsystem.MainAbstractClasses.SchedulingAbstract;
import pkg15070779drsappsystem.Interfaces.MainInterfaceSystemUsers;


public class SysUserDoctor extends SystemUserComponent implements MainInterfaceSystemUsers  {
   //holds the current dr who is being searched for by any user
    public static SysUserDoctor currentDoctor;
   
    //private static Map<String, SystemUserComponent> mapDoctors = new HashMap<>(); //holds all doctor system users
    private String strTitle, strFirstName, strSurname, strDOB, strKeyUserName;
    private static final List<String> strAllDoctorsList = new ArrayList <>();
    
    //holds all available appointment times - used for scheduling
    private List<LocalDateTime> ldtDocsAvailAppointmentsList = new ArrayList<>();
    //holds all taken appointment times - used for scheduling
    private List<LocalDateTime> ldtDocsTakenAppointmentsList = new ArrayList<>();
    //holds all appointment keys that this doctor has, will be used to generate reports
    //appointment keys are never deleted from here once in, as appointments aren;t deleted
    //they are amended or marked as cancelled or missed for example.
    private List<String> strAppointmentKeysList = new ArrayList<>();

    
    
//@@@@@@@@@@ Constructor @@@@@@@@@@     
    public SysUserDoctor(String fname, String sname, String title, String dob){
        this.strTitle = title;
        this.strFirstName = fname;
        this.strSurname = sname;
        this.strDOB = dob;
        this.strKeyUserName = getGenerateUsername(this.strFirstName, this.strSurname, this.strDOB);
        strAllDoctorsList.add(strKeyUserName);
        //generates a list with all available appointments on
        //when a patient generates an appointment, it will remove this from their list
        //if it can;t be found in the list in other routines, it means someone has already gotten that appointment
        this.ldtDocsAvailAppointmentsList = SchedulingAbstract.generateAvailableAppointments();
        
        //add the user object to the map
         setPutInMap(this.strKeyUserName, this); 
      }
 
    
    
//@@@@@@@@@@ More Complicated Setters @@@@@@@@@@     
    
    public  void addAppointmentToDrsList(LocalDateTime datein, String appkeyin){
        //sets the static varible to the doctor we are searching for
        //adds the appointment time to the Drs taken appointment lists
        this.ldtDocsTakenAppointmentsList.add(datein);
        //deletes the time from their available appointments list
        Collections.sort(this.ldtDocsTakenAppointmentsList);
        this.ldtDocsAvailAppointmentsList.remove(datein);
        //adds the key to the doctors appointment list
        this.setAddAppKeyToList(appkeyin);
        //put the Dr back in the map after they have been edited
        SystemUserComponent.setPutInMap(this.getUserName(), this);
    }
 
//@@@@@@@@@@Setters @@@@@@@@@@   
    
     //each dr has a list storing all of the keys to their appointments... this adds the keys
    //is private as called from another public routine
    private void setAddAppKeyToList(String keyin){
        this.strAppointmentKeysList.add(keyin);
        Collections.sort(this.strAppointmentKeysList);
    }
    
      //removes the given appointment time from the doctors taken appointment times  list
    public void setRemoveLDTFromAppTimesTakenList(LocalDateTime datetimetoremove){
        this.ldtDocsTakenAppointmentsList.remove(datetimetoremove);
        //doesn't need sorting as will still be in order
    }
    
      //removes the given appointment time from the doctors available appointment times  list
    public void setRemoveLDTFromAppTimesAvailableList(LocalDateTime datetimetoremove){
        this.ldtDocsAvailAppointmentsList.remove(datetimetoremove);
        //doesn't need sorting as will still be in order
    }
    
    //adds and appointment time to the doctors taken appointments list
     public void setAddLDTToAppTimesTakenList(LocalDateTime datetimetoadd){
        this.ldtDocsTakenAppointmentsList.add(datetimetoadd);
        //sort to put back in order
        Collections.sort(this.ldtDocsTakenAppointmentsList);
    }

     //adds an appointment time to the doctors appointments available list
     public void setAddLDTToAppTimesAvailableList(LocalDateTime datetimetoadd){
        this.ldtDocsAvailAppointmentsList.add(datetimetoadd);
        //sort to put back in order
        Collections.sort(this.ldtDocsAvailAppointmentsList);
            
    }
    
    
//@@@@@@@@@@ interface getters @@@@@@@@@@
    @Override
    public String getUserName(){
        return this.strKeyUserName;
    }
    
    @Override
    public String getTitle(){
        return this.strTitle;
    }
    @Override
    public String getFirstName(){
        return this.strFirstName;
    }
    @Override
    public String getSurname(){
        return this.strSurname;
    }

    @Override
    public String getDOB(){
        return this.strDOB;
    }
    
    
//@@@@@@@@@@ More Complicated Getters @@@@@@@@@@
    
        //for reports
    public static List<LocalDateTime> getDocsMonthlySetAppointments(SysUserDoctor doctorin, LocalDateTime datefrom ){
        
       // gets the username of the dr selected in the combobox and pulls the correct Dr user into searchedForDoc
       //using this (it will be the key for it). converts it to a SysUserDoctor object

        List<LocalDateTime> lstMonthlyApps = new ArrayList<>();
        //adds one month onto the date set so 1 months' worht of appointments are generated
  
        //loop through the doctors set appointment list, check whether they are in this month, add them to the new list if they are
        
        for(LocalDateTime temp: doctorin.ldtDocsTakenAppointmentsList){
            if(temp.getMonth() == datefrom.getMonth() && temp.getYear() == datefrom.getYear()){
                lstMonthlyApps.add(temp);
            }
        }
        
        //return the appointments found list
        Collections.sort(lstMonthlyApps);
        return lstMonthlyApps;
    }
    
    public static List<LocalDateTime> getDocsAvailableAppointments (SysUserDoctor doctorin, LocalDateTime datefrom, LocalDateTime dateto){
            List <LocalDateTime> foundAppointments = new ArrayList<>();

           //temporarily stores the list of all the doctor's available appointments
           List docsAvailApps =   doctorin.getDocsAvailableAppointments();
       
           //checks to see if the dates entered are valid
           //@@@@@ NTD - does not work if the date from and to are on the same day - fix
            if (dateto.isBefore(datefrom)){
                JOptionPane.showMessageDialog (null,
                     "The date to is before the date FROM. Please check your dates and try again",
                     "Check Dates",
                     JOptionPane.ERROR_MESSAGE);

            }
            else{

                 //takes a day off because the routine checks for days between from and to, and we want to include those days in the search
                  datefrom = datefrom.minusDays(1L);

                  //same for the to days, but adds one on...
                  dateto = dateto.plusDays(1L);
                 //need display only appointments in the given from and to dates, 

                 for (LocalDateTime temp : SysUserDoctor.currentDoctor.getDocsAvailableAppointments()){
                        if((temp.isAfter(datefrom)) && (temp.isBefore(dateto))){
                            foundAppointments.add(temp);
                        }

                }

           }
            Collections.sort(foundAppointments);
         return foundAppointments;
    }
    
//@@@@@@@@@@ Getters @@@@@@@@@@
    
    public List<LocalDateTime> getDocsAvailableAppointments(){
        return this.ldtDocsAvailAppointmentsList;
    }
   
    
    public List<String> getAppKeyList(){
        return this.strAppointmentKeysList;
    }
    
    
    public static List<String> getListAllDoctors(){
                       
        return strAllDoctorsList;
    }
    
}