package pkg15070779drsappsystem;

public class Pharmacist extends SystemUser {
    private String apptest;
    
    public Pharmacist(String fname, String sname, String title, int yob, String newer){
        //needs to be in subclasses when abstract
        super(fname, sname, title, yob);
        this.apptest = newer;
        setPutInMap(this);
    }
}