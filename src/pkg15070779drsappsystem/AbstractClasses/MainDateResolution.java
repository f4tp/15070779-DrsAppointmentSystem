
package pkg15070779drsappsystem.AbstractClasses;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public abstract class MainDateResolution {
    public static Date currentDate = new Date(); //gets today's date and time when the instruction is run
    
    public static String resolveDate(String datein) {
      
        LocalDate localDate = LocalDate.parse(datein);
       
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
    
}
