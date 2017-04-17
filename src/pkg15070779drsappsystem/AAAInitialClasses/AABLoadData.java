
package pkg15070779drsappsystem.AAAInitialClasses;

//import java.text.ParseException;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;
import pkg15070779drsappsystem.MainClasses.MainDoctor;
import pkg15070779drsappsystem.MainClasses.MainPatient;
import pkg15070779drsappsystem.MainClasses.MainPharmacist;
import pkg15070779drsappsystem.MainClasses.MainSecretary;
import java.util.List;
import pkg15070779drsappsystem.MainAbstractClasses.MainAbsAppointmentComponent;
import pkg15070779drsappsystem.MainAbstractClasses.MainAbsScheduling;
import pkg15070779drsappsystem.MainAbstractClasses.MainAbsSystemUserComponent;
import pkg15070779drsappsystem.MainClasses.MainAppointment;

public abstract class AABLoadData {
    
    public AABLoadData(){
        
    }
    
    
    public static void LoadData() {
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
        
        //fill the list with all available appointments per doctor   
        MainAbsScheduling.generateAvailableAppointments();
        

     //   LocalDateTime tester = new LocalDateTime(LocalDateTime(MainAbsScheduling.getConvStringToDateTime("010220171450"));
        
        pat1.addNewAppointment(MainAbsScheduling.getConvStringToDateTime("20Apr20171445"), "gregory.house.01011910", "sore back");
        pat2.addNewAppointment(MainAbsScheduling.getConvStringToDateTime("21Apr20171500"), "peter.venkman.01011911", "back ache");
        pat3.addNewAppointment(MainAbsScheduling.getConvStringToDateTime("22Apr20171500"), "egon.spengler.01011912", "headaches");
       pat4.addNewAppointment(MainAbsScheduling.getConvStringToDateTime("24Apr20171500"), "ray.stance.01011913", "neck ache");
       pat5.addNewAppointment(MainAbsScheduling.getConvStringToDateTime("25Apr20171500"), "winstone.zeddermore.01011914", "arm hurts");
       pat6.addNewAppointment(MainAbsScheduling.getConvStringToDateTime("26Apr20171500"), "winstone.zeddermore.01011914", "tummy problems");
       pat7.addNewAppointment(MainAbsScheduling.getConvStringToDateTime("27Apr20171500"), "winstone.zeddermore.01011914", "headaches");
        pat8.addNewAppointment(MainAbsScheduling.getConvStringToDateTime("28Apr20171500"), "winstone.zeddermore.01011914", "neck ache");
        pat9.addNewAppointment(MainAbsScheduling.getConvStringToDateTime("01May20171500"), "winstone.zeddermore.01011914", "earache");
        pat10.addNewAppointment(MainAbsScheduling.getConvStringToDateTime("05May20171500"), "winstone.zeddermore.01011914", "foot problems");
       
        
        
        pat1.addNewAppointment(MainAbsScheduling.getConvStringToDateTime("03May20171445"), "gregory.house.01011910", "sore head");
        pat2.addNewAppointment(MainAbsScheduling.getConvStringToDateTime("04May20171500"), "peter.venkman.01011911", "head ache");
        pat3.addNewAppointment(MainAbsScheduling.getConvStringToDateTime("05May20171500"), "egon.spengler.01011912", "neck aches");
        pat4.addNewAppointment(MainAbsScheduling.getConvStringToDateTime("08May20171500"), "ray.stance.01011913", "head ache");
       pat5.addNewAppointment(MainAbsScheduling.getConvStringToDateTime("09May20171500"), "winstone.zeddermore.01011914", "leg hurts");
        pat6.addNewAppointment(MainAbsScheduling.getConvStringToDateTime("10May20171500"), "winstone.zeddermore.01011914", "foot problems");
        pat7.addNewAppointment(MainAbsScheduling.getConvStringToDateTime("11May20171500"), "winstone.zeddermore.01011914", "tooth ache");
        pat8.addNewAppointment(MainAbsScheduling.getConvStringToDateTime("12May20171500"), "winstone.zeddermore.01011914", "head ache");
        pat9.addNewAppointment(MainAbsScheduling.getConvStringToDateTime("15May20171500"), "winstone.zeddermore.01011914", " aremache");
       pat10.addNewAppointment(MainAbsScheduling.getConvStringToDateTime("16May20171500"), "winstone.zeddermore.01011914", "ear problems");
        
       
       //add Doctors to each patient
       pat1.addDrRegsWith("peter.venkman.01011911", pat1.getUserName());
        pat2.addDrRegsWith("gregory.house.01011910", pat2.getUserName());
        pat3.addDrRegsWith("gregory.house.01011910", pat3.getUserName());
        pat4.addDrRegsWith("gregory.house.01011910", pat4.getUserName());
        pat5.addDrRegsWith("gregory.house.01011910", pat5.getUserName());
        pat6.addDrRegsWith("gregory.house.01011910", pat6.getUserName());
        pat7.addDrRegsWith("gregory.house.01011910", pat7.getUserName());
        pat8.addDrRegsWith("gregory.house.01011910", pat8.getUserName());
        pat9.addDrRegsWith("gregory.house.01011910", pat9.getUserName());
        pat10.addDrRegsWith("gregory.house.01011910", pat10.getUserName());
        
        
        //amend some appointments with prescriptions
        MainAppointment app1 = (MainAppointment) MainAbsAppointmentComponent.getAppointment("Appointment1");
        app1.setAppAttend(true);
        app1.addPrescriptionForApp("Paracetemol", "24 X 500mg", "alan.turing.01011900", "gregory.house.01011910", "Appointment1");
        
        
        MainAppointment app2 = (MainAppointment) MainAbsAppointmentComponent.getAppointment("Appointment2");
        app1.setAppAttend(true);
        app2.addPrescriptionForApp("Ibuprofen", "24 X 250mg", "donald.knuth.01011902", "peter.venkman.01011911", "Appointment2");
        
        
        //amend some appointments without prescriptions - so they can be added later
        
         MainAppointment app3 = (MainAppointment) MainAbsAppointmentComponent.getAppointment("Appointment3");
        app3.setAppMissed(true);
        
        MainAppointment app4 = (MainAppointment) MainAbsAppointmentComponent.getAppointment("Appointment4");
        app2.setAppMissed(true);
        
        MainAppointment app5= (MainAppointment) MainAbsAppointmentComponent.getAppointment("Appointment5");
        
        
        MainDoctor currentDoctorInst = (MainDoctor) MainAbsSystemUserComponent.getSystemUserComponent("gregory.house.01011910");
        LocalDateTime currentLTDtoCancel = app5.getAPPDateAndTime();
        app5.setAppCancelled(true, currentDoctorInst, currentLTDtoCancel );
         
        

   
     }
}
