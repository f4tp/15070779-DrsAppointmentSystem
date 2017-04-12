package pkg15070779drsappsystem.MainClasses;

import java.time.LocalDateTime;
import pkg15070779drsappsystem.MainAbstractClasses.MainAbsSystemUserComponent;
import pkg15070779drsappsystem.Interfaces.MainIntAbsUserComponent;
import java.util.*;
import javax.swing.JOptionPane;
import pkg15070779drsappsystem.MainAbstractClasses.MainAbsScheduling;
import pkg15070779drsappsystem.JPanels.JPanelReportsDrsApps;
import pkg15070779drsappsystem.JPanels.JPartPanelSelDrComboFlow;
import pkg15070779drsappsystem.MainAbstractClasses.MainAbsAppointmentComponent;


public class MainDoctor extends MainAbsSystemUserComponent implements MainIntAbsUserComponent  {
   //holds the current dr who is being searched for by any user
    public static MainDoctor currentDoctor;
    
    
    private String apptest;
    //private static Map<String, MainAbsSystemUserComponent> mapDoctors = new HashMap<>(); //holds all doctor system users
    private final String STRTITLE, STRFIRSTNAME, STRSURNAME, STRDOB, STRKEYUSERNAME;
    private static final List<String> LSTDOCTORS = new ArrayList <>();
    
    //holds all available appointments 
    private List<LocalDateTime> lstDocsAvailAppointments = new ArrayList<>();
    private List<LocalDateTime> lstDocsSetAppointments = new ArrayList<>();
    //private String strUniqueDrName;
    public MainDoctor(String fname, String sname, String title, String dob, String newer){
     
        this.STRTITLE = title;
        this.STRFIRSTNAME = fname;
        this.STRSURNAME = sname;
        this.STRDOB = dob;
        this.STRKEYUSERNAME = setGenerateUsername(this.STRFIRSTNAME, this.STRSURNAME, this.STRDOB);
      
        //this.strUniqueDrName = this.setGenerateUniqueDrName();
       // System.out.println(strUniqueDrName);
        LSTDOCTORS.add(STRKEYUSERNAME);
        
        //generates a list with all available appointments on
        //when a patient generates an appointment, it will remove this from their list
        //if it can;t be found in the list in other routines, it means someone has already gotten that appointment
        this.lstDocsAvailAppointments = MainAbsScheduling.generateAvailableAppointments();
        
        //add the user object to the map
         setPutInMap(this.STRKEYUSERNAME, this); 
        
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
    
    public List<LocalDateTime> getDocsAvailableAppointments(){
        return this.lstDocsAvailAppointments;
    }
    
    public static void addAppointmentToDrsList(String drkey, LocalDateTime datein){
        
        //sets the static varible to the doctor we are searching for
        MainDoctor.currentDoctor = (MainDoctor) MainAbsSystemUserComponent.getSystemUserComponent(drkey);
        //adds the appointment time to the Drs taken appointment lists
        MainDoctor.currentDoctor.lstDocsSetAppointments.add(datein);
        
        //deletes the time from their available appointments list
        MainDoctor.currentDoctor.lstDocsAvailAppointments.remove(datein);
        
        //put the Dr back in the map after they have been edited
        MainAbsSystemUserComponent.setPutInMap(drkey, MainDoctor.currentDoctor);
    }
    
    
    //for reports
    public static List<LocalDateTime> getDocsMonthlySetAppointments(MainDoctor doctorin, LocalDateTime datefrom ){
        
       // gets the username of the dr selected in the combobox and pulls the correct Dr user into searchedForDoc
       //using this (it will be the key for it). converts it to a MainDoctor object

        List<LocalDateTime> lstMonthlyApps = new ArrayList<>();
        //adds one month onto the date set so 1 months' worht of appointments are generated
  
        //loop through the doctors set appointment list, check whether they are in this month, add them to the new list if they are
        
        for(LocalDateTime temp: doctorin.lstDocsSetAppointments){
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
    
    //public String setGenerateUniqueDrName(){
        //return this.getTitle() + " " + this.getFirstName()+ " " + this.getSurname(); //creates a unique dr name 
        
    //}
    
    public static String setGenerateUniqueDrNameStatic(String userID){
        
        return "Change me";
    }
    
    public static List<String> getListAllDoctors(){
                       
        return LSTDOCTORS;
    }
    
        
    
    //@Override
   //public String toString () {
        //return super.getTitle(this) + " " + super.getFirstName(this)+ " "+ super.getSurname(this); 
    //}
}