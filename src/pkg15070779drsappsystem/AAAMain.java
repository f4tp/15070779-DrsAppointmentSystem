package pkg15070779drsappsystem;

import java.util.*;

public class AAAMain {
    
        public static void main(String[] args) {
         
        Patient pat1 = new Patient("Alan", "Turing","Mr", 1900, "01234 567 890", "gregory.house.01011911");
        Patient pat2 = new Patient("Donald", "Knuth","Mr", 1901, "01234 567 890","peter.venkman.01011912");
        Patient pat3 = new Patient("Grace", "Hopper","Mrs", 1902, "01234 567 890","egon.spengler.01011913");
        Patient pat4 = new Patient("Ada", "Lovelace","Miss", 1903, "01234 567 890","ray.stance.01011914");
        Patient pat5 = new Patient("Tim", "Berners-Lee","Mr", 1904, "01234 567 890","winstone.zeddermore.01011915");
        Patient pat6 = new Patient("Tony", "Hoare","Mr", 1905, "01234 567 890","winstone.zeddermore.01011915");
        Patient pat7 = new Patient("Claude", "Shannon","Mr", 1906, "01234 567 890","winstone.zeddermore.01011915");
        Patient pat8 = new Patient("Larry", "Page","Mr", 1907, "01234 567 890","winstone.zeddermore.01011915");
        Patient pat9 = new Patient("Hal", "Abeson","Mr", 1908, "01234 567 890","winstone.zeddermore.01011915");
        Patient pat10 = new Patient("Shafi", "Goldswasser","Mrs", 1909, "01234 567 890","winstone.zeddermore.01011915");
        
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
        
           
        
        
        pat1.setAddNewAppointment(pat1.getFullName(), new Date(1001001), 99200029, "gregory.house.01011911");
        pat2.setAddNewAppointment(pat2.getFullName(), new Date(1991001), 99449595, "peter.venkman.01011912");
        pat3.setAddNewAppointment(pat3.getFullName(), new Date(9022992), 67578584, "egon.spengler.01011913");
        pat4.setAddNewAppointment(pat4.getFullName(), new Date(45563667), 33883883, "ray.stance.01011914");
        pat5.setAddNewAppointment(pat5.getFullName(), new Date(33938837), 27728872, "winstone.zeddermore.01011915");
        
        //pat1.setAddDrRegsWith("peter.venkman.1912");
        //pat2.setAddDrRegsWith("gregory.house.1911");
        //pat3.setAddDrRegsWith("peter.venkman.1912");
        //pat4.setAddDrRegsWith("peter.venkman.1912");
        //pat5.setAddDrRegsWith("peter.venkman.1912");
        //pat1.setAddDrRegsWith("gregory.house.1911"); //a test to see if the validation is working - needs putting in the testing unit
               
        /*
 //Login screen - should be first thing to see
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrameLoginScreen mainLoginScreen = new JFrameLoginScreen ();
                mainLoginScreen.setVisible(true);
            } 
        });
       */
        
        
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrameSecretaryMenu SecMenuMain = JFrameSecretaryMenu.getInstance();
                SecMenuMain.setVisible(true);
           } 
        });
           
        

        
        
        /*
         javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JPanelReportsAbstract tester2 = new JPanelReportsAbstract("hello");
                tester2.setVisible(true);
           } 
        });
        */
        
        /*
          javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JPanelReportsAppAtt run = new JPanelReportsAppAtt();
                run.setVisible(true);
           } 
        });
        */
        
        /*
           javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrameReportsDrsApps run = new JFrameReportsDrsApps();
                run.setVisible(true);
           } 
        });
*/
                
    }
    
}
