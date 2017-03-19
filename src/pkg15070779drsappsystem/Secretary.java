package pkg15070779drsappsystem;

public class Secretary extends SystemUser {
    private String apptest;
    
    public Secretary(String fname, String sname, String title, int yob, String newer){
        //needs to be in subclasses when abstract
        super(fname, sname, title, yob);
        this.apptest = newer;
        setPutInMap(this);
    }
}