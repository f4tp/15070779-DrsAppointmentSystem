package pkg15070779drsappsystem;

import java.util.*;

public class AAAMain {
    
        public static void main(String[] args) {
         
        MainPatient pat1 = new MainPatient("Mr", "Alan", "Turing", "01011900", "01234 567 890", "gregory.house.01011910");
        MainPatient pat2 = new MainPatient("Mr", "Donald", "Knuth", "01011901", "01234 567 890","peter.venkman.01011911");
        MainPatient pat3 = new MainPatient("Mrs", "Grace", "Hopper", "01011902", "01234 567 890","egon.spengler.01011912");
        MainPatient pat4 = new MainPatient("Miss", "Ada", "Lovelace", "01011903", "01234 567 890","ray.stance.01011913");
        MainPatient pat5 = new MainPatient("Mr", "Tim", "Berners-Lee", "01011904", "01234 567 890","winstone.zeddermore.01011914");
        MainPatient pat6 = new MainPatient("Mr", "Tony", "Hoare","01011905", "01234 567 890","winstone.zeddermore.01011914");
        MainPatient pat7 = new MainPatient("Mr","Claude", "Shannon","01011906", "01234 567 890","winstone.zeddermore.01011914");
        MainPatient pat8 = new MainPatient("Mr","Larry", "Page", "01011907", "01234 567 890","winstone.zeddermore.01011914");
        MainPatient pat9 = new MainPatient("Mr","Hal", "Abeson","01011908", "01234 567 890","winstone.zeddermore.01011914");
        MainPatient pat10 = new MainPatient("Mr","Shafi", "Goldswasser","01011909", "01234 567 890","winstone.zeddermore.01011914");
        
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
        
           
        
        
        pat1.addNewAppointment(new Date(1001001), 99200029, "gregory.house.01011911");
        pat2.addNewAppointment( new Date(1991001), 99449595, "peter.venkman.01011912");
        pat3.addNewAppointment(new Date(9022992), 67578584, "egon.spengler.01011913");
        pat4.addNewAppointment(new Date(45563667), 33883883, "ray.stance.01011914");
        pat5.addNewAppointment(new Date(33938837), 27728872, "winstone.zeddermore.01011915");
        
        //pat1.addDrRegsWith("peter.venkman.1912");
        //pat2.addDrRegsWith("gregory.house.1911");
        //pat3.addDrRegsWith("peter.venkman.1912");
        //pat4.addDrRegsWith("peter.venkman.1912");
        //pat5.addDrRegsWith("peter.venkman.1912");
        //pat1.addDrRegsWith("gregory.house.1911"); //a test to see if the validation is working - needs putting in the testing unit
               
        
 //Login screen - should be first thing to see
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrameLoginScreen mainLoginScreen = JFrameLoginScreen.getInstance();
                mainLoginScreen.setVisibility(true);
            } 
        });
                   
    }
    
}
