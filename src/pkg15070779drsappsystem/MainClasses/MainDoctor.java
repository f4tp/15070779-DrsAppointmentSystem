package pkg15070779drsappsystem.MainClasses;

import java.time.LocalDateTime;
import pkg15070779drsappsystem.AbstractClasses.MainAbsSystemUserComponent;
import pkg15070779drsappsystem.Interfaces.MainIntAbsUserComponent;
import java.util.*;
import javax.swing.JOptionPane;
import pkg15070779drsappsystem.AbstractClasses.MainAbsScheduling;
import pkg15070779drsappsystem.JPanels.JPartPanelSelDrComboFlow;


public class MainDoctor extends MainAbsSystemUserComponent implements MainIntAbsUserComponent  {
   //holds the current dr who is being searched for by any user
    public static MainDoctor currentDoctor;
    
    
    private String apptest;
    //private static Map<String, MainAbsSystemUserComponent> mapDoctors = new HashMap<>(); //holds all doctor system users
    private final String STRTITLE, STRFIRSTNAME, STRSURNAME, STRDOB, STRKEYUSERNAME;
    private static final List<String> LSTDOCTORS = new ArrayList <>();
    private List<LocalDateTime> lstDocsAvailAppointments = new ArrayList<>();
    
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
    
    
    public static List<LocalDateTime> getDocAvailableAppointmentsWithDates (MainDoctor doctorin, LocalDateTime datefrom, LocalDateTime dateto){
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