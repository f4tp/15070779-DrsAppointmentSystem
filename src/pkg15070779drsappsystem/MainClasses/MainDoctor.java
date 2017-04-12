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
        this.lstDocsAvailAppointments = MainAbsScheduling.generateAvailableAppointments();
        
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
    
    public List<LocalDateTime> getDocsAvailableAppointments(){
        return this.lstDocsAvailAppointments;
    }
    
    
    public static List<LocalDateTime> getDocAvailableAppointmentsWithDates (LocalDateTime datefrom, LocalDateTime dateto){
            List <LocalDateTime> foundAppointments = new ArrayList<>();

            //sets the main doctor to the selected Dr in the combo box - this is a static variable used to hold any
           //doctor that is searched for
           MainDoctor.currentDoctor = (MainDoctor) MainAbsSystemUserComponent.getSystemUserComponent(JPartPanelSelDrComboFlow.getInstance().getDoctorString());

           //temporarily stores the list of all the doctor's available appointments
           List docsAvailApps =   MainDoctor.currentDoctor.getDocsAvailableAppointments();
       
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
                       
        return lstDoctors;
    }
    
        
    
    //@Override
   //public String toString () {
        //return super.getTitle(this) + " " + super.getFirstName(this)+ " "+ super.getSurname(this); 
    //}
}