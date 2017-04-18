
package pkg15070779drsappsystem.MainAbstractClasses;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public abstract class SchedulingAbstract {
    
    //used to pupulate combo boxes for user forms, for appointment dates and times etc
   private static String arrDays [] = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27",
        "28", "29", "30", "31"};
   private static     String arrMonths [] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
   private static  String arrYears[] = {"2017", "2018"};
   
   private static  String arrTimes[] = {"0900", "0915", "0930", "0945", "1000", "1015", "1030", "1045", "1100", "1115", "1130", "1145", 
            "1200", "1215", "1230", "1245", "1300", "1315", "1330", "1345", "1400", "1415", "1430", "1445", "1500", "1515", "1530", "1545",
            "1600", "1615", "1630", "1645"};
   
    //routine works out all available times that appointments can be taken, then feeds these into a collection which can modified
    //to work out which dates and appointments are left
    //saturdays and sundays are not in here
    //NTD -  but Christmans day / boxing day etc are still in  - take these out
    public static List<LocalDateTime> generateAvailableAppointments(){
        
        LocalDateTime startDateIn = SchedulingAbstract.getConvStringToDateTime("01Jan20170900");
        LocalDateTime endDate = SchedulingAbstract.getConvStringToDateTime("31Dec20181700");
        List<LocalDateTime> lstAllAppointmentDates = new ArrayList<>(); 
                for (LocalDateTime startDateTime = startDateIn; startDateTime.isBefore(endDate); startDateTime = startDateTime.plusMinutes(15L)){
                startDateTime.plusMinutes(15);
                       if (startDateTime.getHour()>8 && startDateTime.getHour()<17 && startDateTime.getDayOfWeek() != DayOfWeek.SATURDAY && startDateTime.getDayOfWeek() != DayOfWeek.SUNDAY){
                       lstAllAppointmentDates.add(startDateTime);
                       }
        
                 }
                    return lstAllAppointmentDates;
    }
    
    public static String[] getDaysArr(){
                return arrDays;
    }
    
     public static String[] getMonthsArr(){
                return arrMonths;
    }
     
      public static String[] getYearArr(){
                return arrYears;
    }
      
       public static String[] getTimesArr(){
                return arrTimes;
    }
      
      
    
    //when called, it returns a list of LocalDateTime objects from the current date to 1 year in the future
    //used to populate the select dates to and from for a combobox
       //only used in redundant methods, so keep around and delete if needed to
    public static List<LocalDateTime> generateSelectDates(){
        LocalDateTime startDateIn = getDateToday();
        LocalDateTime endDate = getDateToday().plusYears(1);
        List<LocalDateTime> lstAllAppointmentDatesInRange = new ArrayList<>(); 
        
                 for (LocalDateTime startDateTime = startDateIn; startDateTime.isBefore(endDate); startDateTime = startDateTime.plusDays(1L)){
                startDateTime.plusMinutes(15);
                
                        if (startDateTime.getDayOfWeek() != DayOfWeek.SATURDAY && startDateTime.getDayOfWeek() != DayOfWeek.SUNDAY){
                           lstAllAppointmentDatesInRange.add(startDateTime);
                           System.out.println(startDateTime);
                        }
                     
            
                }
        
        return lstAllAppointmentDatesInRange;
 }
    
    //pass this routine a string with no spaces in like ddMMyyyyHHmm and it will create the Date & time object for you
    public static LocalDateTime getConvStringToDateTime(String datein) {
        //example string to pass
       // String str = "04May20031230";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMMyyyyHHmm");
        LocalDateTime ldtDateTime = LocalDateTime.parse(datein, formatter);
        return ldtDateTime;

    }
    
    //pass it a date and it will pass back a string of the day in a consistent format (relative to theprogram)
     public static String getConvDateTimeToStringDay(LocalDateTime datein) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMMyyyyHHmm");
        //LocalDateTime ldtDateTime = LocalDateTime.parse(datein, formatter);
        String dayOfDate = datein.format(formatter);
        String returnDay = dayOfDate.substring(0,2);
        return returnDay;
    }
     
     public static String getConvDateTimeToStringMonth(LocalDateTime datein) {
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMMyyyyHHmm");
         String dmonthOfDate = datein.format(formatter);
         String returnMonth = dmonthOfDate.substring(2,5);
        return returnMonth;
     }
     
     public static String getConvDateTimeToStringYear(LocalDateTime datein) {
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMMyyyyHHmm");
         String dmonthOfDate = datein.format(formatter);
         String returnMonth = dmonthOfDate.substring(5,9);
        return returnMonth;
     }
     
      public static String getConvDateTimeToStringHour(LocalDateTime datein) {
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMMyyyyHHmm");
         String dmonthOfDate = datein.format(formatter);
         String returnMonth = dmonthOfDate.substring(9,11);
        return returnMonth;
     }
      
      public static String getConvDateTimeToStringMinute(LocalDateTime datein) {
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMMyyyyHHmm");
         String dmonthOfDate = datein.format(formatter);
         String returnMonth = dmonthOfDate.substring(11,13);
        return returnMonth;
     }
      
      public static String getConvDateTimeToStringHourAndMin(LocalDateTime datein) {
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMMyyyyHHmm");
         String dmonthOfDate = datein.format(formatter);
         String returnMonth = dmonthOfDate.substring(9);
        return returnMonth;
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
