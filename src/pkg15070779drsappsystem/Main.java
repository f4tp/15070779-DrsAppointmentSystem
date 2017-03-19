package pkg15070779drsappsystem;

public class Main {

    public static void main(String[] args) {
         
        Patient pat1 = new Patient("Alan", "Turing","Mr", 1900, "Test");
        Patient pat2 = new Patient("Donald", "Knuth","Mr", 1901, "Test");
        Patient pat3 = new Patient("Grace", "Hopper","Mrs", 1902, "Test");
        Patient pat4 = new Patient("Ada", "Lovelace","Miss", 1903, "Test");
        Patient pat5 = new Patient("Tim", "Berners-Lee","Mr", 1904, "Test");
        Patient pat6 = new Patient("Tony", "Hoare","Mr", 1905, "Test");
        Patient pat7 = new Patient("Claude", "Shannon","Mr", 1906, "Test");
        Patient pat8 = new Patient("Larry", "Page","Mr", 1907, "Test");
        Patient pat9 = new Patient("Hal", "Abeson","Mr", 1908, "Test");
        Patient pat10 = new Patient("Shafi", "Goldswasser","Mrs", 1909, "Test");
        
        Doctor dr1 = new Doctor("Gregory", "House","Dr", 1911, "Test");
        Doctor dr2 = new Doctor("Peter", "Venkman","Dr", 1912, "Test");
        Doctor dr3 = new Doctor("Egon", "Spengler","Dr", 1913, "Test");
        Doctor dr4 = new Doctor("Ray", "Stance","Dr", 1914, "Test");
        Doctor dr5 = new Doctor("Winstone", "Zeddermore","Dr", 1915, "Test");
        
        Secretary rec1 = new Secretary("Elizabeth", "Moore","Mrs", 1921, "Test");
        Secretary rec2 = new Secretary("Harry", "Doin","Mr", 1922, "Test");
        Secretary rec3 = new Secretary("Sarah", "Jessica","Miss", 1923, "Test");
        
        Pharmacist pharm1 = new Pharmacist("Pharm", "Asutical","Dr", 2001, "Test");
        Pharmacist pharm2 = new Pharmacist("Liam", "Foster","Dr", 2002, "Test");
        //above are the existing system users being put into the system
        
              
        LoginScreen mainLoginScreen = new LoginScreen ();
        mainLoginScreen.setVisible(true);
        
        
    }
    
}
