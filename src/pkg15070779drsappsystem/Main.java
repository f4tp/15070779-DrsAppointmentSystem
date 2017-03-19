package pkg15070779drsappsystem;

public class Main {

    public static void main(String[] args) {
         
        SystemUser pat1 = new Patient("Alan", "Turing","Mr", 1900, "Test");
        SystemUser pat2 = new Patient("Donald", "Knuth","Mr", 1901, "Test");
        SystemUser pat3 = new Patient("Grace", "Hopper","Mrs", 1902, "Test");
        SystemUser pat4 = new Patient("Ada", "Lovelace","Miss", 1903, "Test");
        SystemUser pat5 = new Patient("Tim", "Berners-Lee","Mr", 1904, "Test");
        SystemUser pat6 = new Patient("Tony", "Hoare","Mr", 1905, "Test");
        SystemUser pat7 = new Patient("Claude", "Shannon","Mr", 1906, "Test");
        SystemUser pat8 = new Patient("Larry", "Page","Mr", 1907, "Test");
        SystemUser pat9 = new Patient("Hal", "Abeson","Mr", 1908, "Test");
        SystemUser pat10 = new Patient("Shafi", "Goldswasser","Mrs", 1909, "Test");
        
        SystemUser dr1 = new Doctor("Gregory", "House","Dr", 1911, "Test");
        SystemUser dr2 = new Doctor("Peter", "Venkman","Dr", 1912, "Test");
        SystemUser dr3 = new Doctor("Egon", "Spengler","Dr", 1913, "Test");
        SystemUser dr4 = new Doctor("Ray", "Stance","Dr", 1914, "Test");
        SystemUser dr5 = new Doctor("Winstone", "Zeddermore","Dr", 1915, "Test");
        
        SystemUser rec1 = new Secretary("Elizabeth", "Moore","Mrs", 1921, "Test");
        SystemUser rec2 = new Secretary("Harry", "Doin","Mr", 1922, "Test");
        SystemUser rec3 = new Secretary("Sarah", "Jessica","Miss", 1923, "Test");
        
        SystemUser pharm1 = new Pharmacist("Pharm", "Asutical","Dr", 2001, "Test");
        SystemUser pharm2 = new Pharmacist("Liam", "Foster","Dr", 2002, "Test");
        //above are the existing system users being put into the system
        
              
        LoginScreen mainLoginScreen = new LoginScreen ();
        mainLoginScreen.setVisible(true);
    }
    
}
