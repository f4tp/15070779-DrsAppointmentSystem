
package pkg15070779drsappsystem.AbstractClasses;


//import java.text.DateFormat;
//import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public abstract class MainAppointmentSchedule {
    
    
    
    
    //pass this routine a string with no spaces in like ddMMyyyyHHmm and it will create the Date & time object for you
    public static LocalDateTime getConvStringToDateTime(String datein) {
       
        //throws ParseException
        //example string
       // String str = "040520031230";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyyHHmm");
        LocalDateTime dateTime = LocalDateTime.parse(datein, formatter);
        return dateTime;

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
