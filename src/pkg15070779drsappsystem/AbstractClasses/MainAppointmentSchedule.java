
package pkg15070779drsappsystem.AbstractClasses;


//import java.text.DateFormat;
//import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import pkg15070779drsappsystem.MainClasses.MainDoctor;

public abstract class MainAppointmentSchedule {
    
    //yearly available appointments
    
   
    
    //routine works out all available times that appointments can be taken, then feeds these into a collection which can modified
    //to work out which dates and appointments are left
    //saturdays and sundays are not in here
    //@@@@@@@@@@ , but Christmans day / boxing day etc are still in  - take these out
    public static List<LocalDateTime> generateAvailableAppointments(){
        
        LocalDateTime startDateIn = MainAppointmentSchedule.getConvStringToDateTime("01Jan20170900");
        LocalDateTime endDate = MainAppointmentSchedule.getConvStringToDateTime("31Dec20181700");
        List<LocalDateTime> lstAllAppointmentDates = new ArrayList<>(); 
                for (LocalDateTime startDateTime = startDateIn; startDateTime.isBefore(endDate); startDateTime = startDateTime.plusMinutes(15L)){
                startDateTime.plusMinutes(15);
                
                    if (startDateTime.getHour()>8 && startDateTime.getHour()<17 && startDateTime.getDayOfWeek() != DayOfWeek.SATURDAY && startDateTime.getDayOfWeek() != DayOfWeek.SUNDAY){
                       lstAllAppointmentDates.add(startDateTime);
                       //System.out.println(startDateTime);
                    }
                     
            
                 }
               
                return lstAllAppointmentDates;
    }
    
    
    
    //pass this routine a string with no spaces in like ddMMyyyyHHmm and it will create the Date & time object for you
    public static LocalDateTime getConvStringToDateTime(String datein) {
       
        //throws ParseException
        //example string
       // String str = "040520031230";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMMyyyyHHmm");
        LocalDateTime dateTime = LocalDateTime.parse(datein, formatter);
        
        
        
        
        
        
        return dateTime;

    }
    
    public static String getFormattedDate(String day, String month, String year, String time ){
        
        return day + month + year + time;
        
    }
    
     //returns current date;
    public static LocalDateTime getDateToday(){
        LocalDateTime currentDate = LocalDateTime.now();
           return currentDate;
    }
    

    
      public static void resolveTime(String timein){
        SimpleDateFormat timeFormatted = new SimpleDateFormat("KK:mm a");
    }
    
    
   
    
    
  
    
}
