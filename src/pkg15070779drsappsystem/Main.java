package pkg15070779drsappsystem;

public class Main {

    public static void main(String[] args) {
         
        SystemUser pat1 = new SystemUser("Alan", "Turing","Mr", 1901);
        SystemUser pat2 = new SystemUser("Donald", "Knuth","Mr", 1902);
        SystemUser pat3 = new SystemUser("Grace", "Hopper","Mrs", 1903);
        SystemUser pat4 = new SystemUser("Ada", "Lovelace","Miss", 1904);
        SystemUser pat5 = new SystemUser("Tim", "Berners-Lee","Mr", 19205);
        
        SystemUser dr1 = new SystemUser("Gregory", "House","Dr", 1911);
        SystemUser dr2 = new SystemUser("Peter", "Venkman","Dr", 1912);
        SystemUser dr3 = new SystemUser("Egon", "Spengler","Dr", 1913);
        SystemUser dr4 = new SystemUser("Ray", "Stance","Dr", 1914);
        SystemUser dr5 = new SystemUser("Winstone", "Zeddermore","Dr", 1915);
        
        SystemUser rec1 = new SystemUser("Elizabeth", "Moore","Mrs", 1921);
        SystemUser rec2 = new SystemUser("Harry", "Doin","Mr", 1922);
        SystemUser rec3 = new SystemUser("Sarah", "Jessica","Miss", 1923);
        
        SystemUser pharm1 = new SystemUser("Pharm", "Asutical","Dr", 2001);
        SystemUser pharm2 = new SystemUser("Liam", "Foster","Dr", 2002);
        //above are the existing system users being put into the system
        
        
        LoginScreen mainLoginScreen = new LoginScreen ();
        mainLoginScreen.setVisible(true);
    }
    
}
