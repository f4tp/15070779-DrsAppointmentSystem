package pkg15070779drsappsystem;

import java.util.*;

public class AAAMain {
    
        public static void main(String[] args) {
         
        MainPatient pat1 = new MainPatient("Alan", "Turing","Mr", "01011900", "01234 567 890", "gregory.house.01011910");
        MainPatient pat2 = new MainPatient("Donald", "Knuth","Mr", "01011901", "01234 567 890","peter.venkman.01011911");
        MainPatient pat3 = new MainPatient("Grace", "Hopper","Mrs", "01011902", "01234 567 890","egon.spengler.01011912");
        MainPatient pat4 = new MainPatient("Ada", "Lovelace","Miss", "01011903", "01234 567 890","ray.stance.01011913");
        MainPatient pat5 = new MainPatient("Tim", "Berners-Lee","Mr", "01011904", "01234 567 890","winstone.zeddermore.01011914");
        MainPatient pat6 = new MainPatient("Tony", "Hoare","Mr", "01011905", "01234 567 890","winstone.zeddermore.01011914");
        MainPatient pat7 = new MainPatient("Claude", "Shannon","Mr", "01011906", "01234 567 890","winstone.zeddermore.01011914");
        MainPatient pat8 = new MainPatient("Larry", "Page","Mr", "01011907", "01234 567 890","winstone.zeddermore.01011914");
        MainPatient pat9 = new MainPatient("Hal", "Abeson","Mr", "01011908", "01234 567 890","winstone.zeddermore.01011914");
        MainPatient pat10 = new MainPatient("Shafi", "Goldswasser","Mrs", "01011909", "01234 567 890","winstone.zeddermore.01011914");
        
        MainDoctor dr1 = new MainDoctor("Gregory", "House","Dr", "01011910", "Test");
        MainDoctor dr2 = new MainDoctor("Peter", "Venkman","Dr", "01011911", "Test");
        MainDoctor dr3 = new MainDoctor("Egon", "Spengler","Dr", "01011912", "Test");
        MainDoctor dr4 = new MainDoctor("Ray", "Stance","Dr", "01011913", "Test");
        MainDoctor dr5 = new MainDoctor("Winstone", "Zeddermore","Dr", "01011914", "Test");
        
        MainSecretary rec1 = new MainSecretary("Elizabeth", "Moore","Mrs", "01011915", "Test");
        MainSecretary rec2 = new MainSecretary("Harry", "Doin","Mr", "01011916", "Test");
        MainSecretary rec3 = new MainSecretary("Sarah", "Jessica","Miss", "01011917", "Test");
        
        MainPharmacist pharm1 = new MainPharmacist("Pharm", "Asutical","Dr", "01011918", "Test");
        MainPharmacist pharm2 = new MainPharmacist("Liam", "Foster","Dr", "01011919", "Test");
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
               
        
 //Login screen - should be first thing to see
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrameLoginScreen mainLoginScreen = JFrameLoginScreen.getInstance();
                mainLoginScreen.setVisibility(true);
            } 
        });
                   
    }
    
}
