package pkg15070779drsappsystem.Interfaces;
public abstract interface MainIntAbsUserComponent {
    
    //all user classes must implement these in order to encapsualte properly to 
    //keep good design patterns... this doesn't matter so much in my program but
    //going forward it might when the program becomes larger
    String getUserName();
    String getFirstName();
    String getSurname();
    String getTitle();
    String getDOB();
    
    
            
}
