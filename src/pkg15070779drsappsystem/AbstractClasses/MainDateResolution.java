
package pkg15070779drsappsystem.AbstractClasses;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public abstract class MainDateResolution {
    public static Date currentDate = new Date(); //gets today's date and time when the instruction is run
    
    
    
    //pass this routine a string with no spaces in like ddMMyyyyHHmm and it will create the Date & time object for you
    public static LocalDateTime convStringToDateAndTime(String datein) throws ParseException{
       
        //example string
       // String str = "040520031230";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyyHHmm");
        LocalDateTime dateTime = LocalDateTime.parse(datein, formatter);
        return dateTime;

    }
    
      public static void resolveTime(String timein){
        SimpleDateFormat timeFormatted = new SimpleDateFormat("KK:mm a");
    }
    
    
    //returns current date;
    public static Date getDate(){
           return currentDate;
    }
    
    
    //pass this 
    public static Date setDate(String toSetTo){
        Date date = new Date();
        return date;
    }
    
    
    
    public static String oldResolveDateMethod(String datein) {
      
        LocalDate localDate = LocalDate.parse(datein);
        
         /*
        String str = "09041995 12:30";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy HHmm");
        //LocalDateTime dateTime = LocalDateTime.parse(datein, formatter);
        */
        
        /*
        SimpleDateFormat originalFormatted = new SimpleDateFormat("ddMMyyyy hh:mm");
        
        Date date1;
        Date emptyDate = new Date();
        try {
            date1 = originalFormatted.parse(datein);
            //System.out.println(date1);
           // System.out.println(originalFormatted.format(date1));
            return date1;
        } 
        
        catch (ParseException e) {
            e.printStackTrace();
        }
        
        //will return Jan 01 1970 if it cannot convert the date (although thsi will be unlikely, but can handle the error 
        //using this
        return emptyDate;
    */
       
        /*
        //old way
        
        SimpleDateFormat originalFormatted = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date date1 = originalFormatted.parse(datein);
            System.out.println(date1);
            System.out.println(originalFormatted.format(date1));
        } 
        
        catch (ParseException e) {
            e.printStackTrace();
        }
         */
       
         return datein;
     
    }
    
    
  
    
}
