package pkg15070779drsappsystem.MainClasses;

import java.time.LocalDateTime;
import pkg15070779drsappsystem.MainAbstractClasses.MainAbsSystemUserComponent;
import java.util.*;
import javax.swing.JOptionPane;
import pkg15070779drsappsystem.MainAbstractClasses.MainAbsScheduling;
import pkg15070779drsappsystem.JPanels.JPanelReportsDrsApps;
import pkg15070779drsappsystem.JPanels.JPartPanelSelDrComboFlow;
import pkg15070779drsappsystem.MainAbstractClasses.MainAbsAppointmentComponent;
import pkg15070779drsappsystem.Interfaces.MainInterfaceSystemUsers;


public class MainDoctor extends MainAbsSystemUserComponent implements MainInterfaceSystemUsers  {
   //holds the current dr who is being searched for by any user
    public static MainDoctor currentDoctor;
    
    
    private String apptest;
    //private static Map<String, MainAbsSystemUserComponent> mapDoctors = new HashMap<>(); //holds all doctor system users
    private final String STRTITLE, STRFIRSTNAME, STRSURNAME, STRDOB, STRKEYUSERNAME;
    private static final List<String> LSTDOCTORS = new ArrayList <>();
    
    //holds all available appointment times - used for scheduling
    private List<LocalDateTime> lstDocsAvailAppointments = new ArrayList<>();
    //holds all taken appointment times - used for scheduling
    private List<LocalDateTime> lstDocsTakenAppointments = new ArrayList<>();
    //holds all appointment keys that this doctor has, will be used to generate reports
    //appointment keys are never deleted from here once in, as appointments aren;t deleted
    //they are amended or marked as cancelled or missed for example.
    private List<String> lstAppointmentKeys = new ArrayList<>();
    //private String strUniqueDrName;
    
    
//@@@@@@@@@@ Constructor @@@@@@@@@@     
    public MainDoctor(String fname, String sname, String title, String dob, String newer){
     
        this.STRTITLE = title;
        this.STRFIRSTNAME = fname;
        this.STRSURNAME = sname;
        this.STRDOB = dob;
        this.STRKEYUSERNAME = setGenerateUsername(this.STRFIRSTNAME, this.STRSURNAME, this.STRDOB);
        LSTDOCTORS.add(STRKEYUSERNAME);
        
        //generates a list with all available appointments on
        //when a patient generates an appointment, it will remove this from their list
        //if it can;t be found in the list in other routines, it means someone has already gotten that appointment
        this.lstDocsAvailAppointments = MainAbsScheduling.generateAvailableAppointments();
        
        //add the user object to the map
         setPutInMap(this.STRKEYUSERNAME, this); 
      }
 
    
    
//@@@@@@@@@@ More Complicated Setters @@@@@@@@@@     
    
    public  void addAppointmentToDrsList(LocalDateTime datein, String appkeyin){
        //sets the static varible to the doctor we are searching for
        //MainDoctor.currentDoctor = (MainDoctor) MainAbsSystemUserComponent.getSystemUserComponent(drkey);
        //adds the appointment time to the Drs taken appointment lists
        this.lstDocsTakenAppointments.add(datein);
        //deletes the time from their available appointments list
        this.lstDocsAvailAppointments.remove(datein);
        //adds the key to the doctors appointment list
        this.setAddAppKeyToList(appkeyin);
        //put the Dr back in the map after they have been edited
        MainAbsSystemUserComponent.setPutInMap(this.getUserName(), this);
    }
    
    
    
//@@@@@@@@@@Setters @@@@@@@@@@   
    
     //each dr has a list storing all of the keys to their appointments... this adds the keys
    //is private as called from another public routine
    private void setAddAppKeyToList(String keyin){
        this.lstAppointmentKeys.add(keyin);
    }
    
      //removes the given appointment time from the doctors taken appointment times  list
    public void setRemoveLDTFromAppTimesTakenList(LocalDateTime datetimetoremove){
        this.lstDocsTakenAppointments.remove(datetimetoremove);
        //doesn't need sorting as will still be in order
    }
    
      //removes the given appointment time from the doctors available appointment times  list
    public void setRemoveLDTFromAppTimesAvailableList(LocalDateTime datetimetoremove){
        this.lstDocsAvailAppointments.remove(datetimetoremove);
        //doesn't need sorting as will still be in order
    }
    
    //adds and appointment time to the doctors taken appointments list
     public void setAddLDTToAppTimesTakenList(LocalDateTime datetimetoadd){
        this.lstDocsTakenAppointments.add(datetimetoadd);
        //sort to put back in order
        Collections.sort(this.lstDocsTakenAppointments);
    }

     //adds an appointment time to the doctors appointments available list
     public void setAddLDTToAppTimesAvailableList(LocalDateTime datetimetoadd){
        this.lstDocsAvailAppointments.add(datetimetoadd);
        //sort to put back in order
        Collections.sort(this.lstDocsAvailAppointments);
            
    }
    
    
//@@@@@@@@@@ interface getters @@@@@@@@@@
    @Override
    public String getUserName(){
        return this.STRKEYUSERNAME;
    }
    
    @Override
    public String getTitle(){
        return this.STRTITLE;
    }
    @Override
    public String getFirstName(){
        return this.STRFIRSTNAME;
    }
    @Override
    public String getSurname(){
        return this.STRSURNAME;
    }

    @Override
    public String getDOB(){
        return this.STRDOB;
    }
    
    
//@@@@@@@@@@ More Complicated Getters @@@@@@@@@@
    
        //for reports
    public static List<LocalDateTime> getDocsMonthlySetAppointments(MainDoctor doctorin, LocalDateTime datefrom ){
        
       // gets the username of the dr selected in the combobox and pulls the correct Dr user into searchedForDoc
       //using this (it will be the key for it). converts it to a MainDoctor object

        List<LocalDateTime> lstMonthlyApps = new ArrayList<>();
        //adds one month onto the date set so 1 months' worht of appointments are generated
  
        //loop through the doctors set appointment list, check whether they are in this month, add them to the new list if they are
        
        for(LocalDateTime temp: doctorin.lstDocsTakenAppointments){
            if(temp.getMonth() == datefrom.getMonth() && temp.getYear() == datefrom.getYear()){
                lstMonthlyApps.add(temp);
            }
        }
        
        //return the appointments found list
        
        return lstMonthlyApps;
    }
    
    public static List<LocalDateTime> getDocsAvailableAppointments (MainDoctor doctorin, LocalDateTime datefrom, LocalDateTime dateto){
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

                 for (LocalDateTime temp : MainDoctor.currentDoctor.getDocsAvailableAppointments()){
                        if((temp.isAfter(datefrom)) && (temp.isBefore(dateto))){
                            foundAppointments.add(temp);
                            System.out.println(temp);
                        }

                }

           }
         return foundAppointments;
    }
    
//@@@@@@@@@@ Getters @@@@@@@@@@
    
    public List<LocalDateTime> getDocsAvailableAppointments(){
        return this.lstDocsAvailAppointments;
    }
   
    
    public List<String> getAppKeyList(){
        return this.lstAppointmentKeys;
    }
    
    
    public static List<String> getListAllDoctors(){
                       
        return LSTDOCTORS;
    }
    
}