package pkg15070779drsappsystem;

public class MainSecretary extends MainAbsSystemUserComponent {
    private String apptest;
    
    public MainSecretary(String fname, String sname, String title, String dob, String newer){
        //needs to be in subclasses when abstract
        super(fname, sname, title, dob);
        this.apptest = newer;
        setPutInMap(this);
    }
}