package pkg15070779drsappsystem.Interfaces;
public abstract interface MainInterfaceSystemUsers {
    
    //all user classes must implement these in order to encapsualte properly to 
    //keep good design patterns... this doesn't matter so much in my program but
    //going forward it might when the program becomes larger... and a new type of user might want to be
    //created which uses different routines - i.e. nurses, physiotherapists etc.
    
    //getter methods
    String getUserName();
    String getFirstName();
    String getSurname();
    String getTitle();
    String getDOB();
    
    //no setters on here, because the project already presumes all users are registered...
    //going forward, setters woudl be added to here
    
    
            
}
