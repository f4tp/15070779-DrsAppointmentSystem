
package pkg15070779drsappsystem.AAAInitialClasses;

//import java.text.ParseException;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;
import pkg15070779drsappsystem.MainClasses.SysUserDoctor;
import pkg15070779drsappsystem.MainClasses.SysUserPatient;
import pkg15070779drsappsystem.MainClasses.SysUserPharmacist;
import pkg15070779drsappsystem.MainClasses.SysUserSecretary;
import java.util.List;
import pkg15070779drsappsystem.MainAbstractClasses.AppointmentComponent;
import pkg15070779drsappsystem.MainAbstractClasses.SchedulingAbstract;
import pkg15070779drsappsystem.MainAbstractClasses.SystemUserComponent;
import pkg15070779drsappsystem.MainClasses.Appointment;

public abstract class AABLoadData {
    
    public AABLoadData(){
        
    }
    
    
    public static void LoadData() {
        SysUserPatient pat1 = new SysUserPatient("Mr", "Alan", "Turing", "01011900", "01234 567 890", "gregory.house.01011910");
        SysUserPatient pat2 = new SysUserPatient("Mr", "Donald", "Knuth", "01011901", "01234 567 890","peter.venkman.01011911");
        SysUserPatient pat3 = new SysUserPatient("Mrs", "Grace", "Hopper", "01011902", "01234 567 890","egon.spengler.01011912");
        SysUserPatient pat4 = new SysUserPatient("Miss", "Ada", "Lovelace", "01011903", "01234 567 890","ray.stance.01011913");
        SysUserPatient pat5 = new SysUserPatient("Mr", "Tim", "Berners-Lee", "01011904", "01234 567 890","winstone.zeddermore.01011914");
        SysUserPatient pat6 = new SysUserPatient("Mr", "Tony", "Hoare","01011905", "01234 567 890","winstone.zeddermore.01011914");
        SysUserPatient pat7 = new SysUserPatient("Mr","Claude", "Shannon","01011906", "01234 567 890","winstone.zeddermore.01011914");
        SysUserPatient pat8 = new SysUserPatient("Mr","Larry", "Page", "01011907", "01234 567 890","winstone.zeddermore.01011914");
        SysUserPatient pat9 = new SysUserPatient("Mr","Hal", "Abeson","01011908", "01234 567 890","winstone.zeddermore.01011914");
        SysUserPatient pat10 = new SysUserPatient("Mr","Shafi", "Goldswasser","01011909", "01234 567 890","winstone.zeddermore.01011914");

        
        SysUserDoctor dr1 = new SysUserDoctor("Gregory", "House","Dr", "01011910");
        SysUserDoctor dr2 = new SysUserDoctor("Peter", "Venkman","Dr", "01011911");
        SysUserDoctor dr3 = new SysUserDoctor("Egon", "Spengler","Dr", "01011912");
        SysUserDoctor dr4 = new SysUserDoctor("Ray", "Stance","Dr", "01011913");
        SysUserDoctor dr5 = new SysUserDoctor("Winstone", "Zeddermore","Dr", "01011914");
        
        SysUserSecretary rec1 = new SysUserSecretary("Elizabeth", "Moore","Mrs", "01011915");
        SysUserSecretary rec2 = new SysUserSecretary("Harry", "Doin","Mr", "01011916");
        SysUserSecretary rec3 = new SysUserSecretary("Sarah", "Jessica","Miss", "01011917");
        
        SysUserPharmacist pharm1 = new SysUserPharmacist("Pharm", "Asutical","Dr", "01011918");
        SysUserPharmacist pharm2 = new SysUserPharmacist("Liam", "Foster","Dr", "01011919");
        //above are the existing system users being put into the system
        
        //fill the list with all available appointments per doctor   
        SchedulingAbstract.generateAvailableAppointments();
        

     //   LocalDateTime tester = new LocalDateTime(LocalDateTime(SchedulingAbstract.getConvStringToDateTime("010220171450"));
        
        pat1.addNewAppointment(SchedulingAbstract.getConvStringToDateTime("20Apr20171445"), "gregory.house.01011910", "sore back");
        pat2.addNewAppointment(SchedulingAbstract.getConvStringToDateTime("21Apr20171500"), "peter.venkman.01011911", "back ache");
        pat3.addNewAppointment(SchedulingAbstract.getConvStringToDateTime("22Apr20171500"), "egon.spengler.01011912", "headaches");
       pat4.addNewAppointment(SchedulingAbstract.getConvStringToDateTime("24Apr20171500"), "ray.stance.01011913", "neck ache");
       pat5.addNewAppointment(SchedulingAbstract.getConvStringToDateTime("25Apr20171500"), "winstone.zeddermore.01011914", "arm hurts");
       pat6.addNewAppointment(SchedulingAbstract.getConvStringToDateTime("26Apr20171500"), "winstone.zeddermore.01011914", "tummy problems");
       pat7.addNewAppointment(SchedulingAbstract.getConvStringToDateTime("27Apr20171500"), "winstone.zeddermore.01011914", "headaches");
        pat8.addNewAppointment(SchedulingAbstract.getConvStringToDateTime("28Apr20171500"), "winstone.zeddermore.01011914", "neck ache");
        pat9.addNewAppointment(SchedulingAbstract.getConvStringToDateTime("01May20171500"), "winstone.zeddermore.01011914", "earache");
        pat10.addNewAppointment(SchedulingAbstract.getConvStringToDateTime("05May20171500"), "winstone.zeddermore.01011914", "foot problems");
       
        
        
        pat1.addNewAppointment(SchedulingAbstract.getConvStringToDateTime("03May20171445"), "gregory.house.01011910", "sore head");
        pat2.addNewAppointment(SchedulingAbstract.getConvStringToDateTime("04May20171500"), "peter.venkman.01011911", "head ache");
        pat3.addNewAppointment(SchedulingAbstract.getConvStringToDateTime("05May20171500"), "egon.spengler.01011912", "neck aches");
        pat4.addNewAppointment(SchedulingAbstract.getConvStringToDateTime("08May20171500"), "ray.stance.01011913", "head ache");
       pat5.addNewAppointment(SchedulingAbstract.getConvStringToDateTime("09May20171500"), "winstone.zeddermore.01011914", "leg hurts");
        pat6.addNewAppointment(SchedulingAbstract.getConvStringToDateTime("10May20171500"), "winstone.zeddermore.01011914", "foot problems");
        pat7.addNewAppointment(SchedulingAbstract.getConvStringToDateTime("11May20171500"), "winstone.zeddermore.01011914", "tooth ache");
        pat8.addNewAppointment(SchedulingAbstract.getConvStringToDateTime("12May20171500"), "winstone.zeddermore.01011914", "head ache");
        pat9.addNewAppointment(SchedulingAbstract.getConvStringToDateTime("15May20171500"), "winstone.zeddermore.01011914", " aremache");
       pat10.addNewAppointment(SchedulingAbstract.getConvStringToDateTime("16May20171500"), "winstone.zeddermore.01011914", "ear problems");
        
       
       //add Doctors to each patient
       pat1.addDrKeyRegsWith("peter.venkman.01011911", pat1.getUserName());
        pat2.addDrKeyRegsWith("gregory.house.01011910", pat2.getUserName());
        pat3.addDrKeyRegsWith("gregory.house.01011910", pat3.getUserName());
        pat4.addDrKeyRegsWith("gregory.house.01011910", pat4.getUserName());
        pat5.addDrKeyRegsWith("gregory.house.01011910", pat5.getUserName());
        pat6.addDrKeyRegsWith("gregory.house.01011910", pat6.getUserName());
        pat7.addDrKeyRegsWith("gregory.house.01011910", pat7.getUserName());
        pat8.addDrKeyRegsWith("gregory.house.01011910", pat8.getUserName());
        pat9.addDrKeyRegsWith("gregory.house.01011910", pat9.getUserName());
        pat10.addDrKeyRegsWith("gregory.house.01011910", pat10.getUserName());
        
        
        //amend some appointments with prescriptions
        Appointment app1 = (Appointment) AppointmentComponent.getAppointment("Appointment1");
        app1.setAppAttend(true);
        app1.addPrescriptionForApp("Paracetemol", "24 X 500mg", "alan.turing.01011900", "gregory.house.01011910", "Appointment1");
        
        
        Appointment app2 = (Appointment) AppointmentComponent.getAppointment("Appointment2");
        app1.setAppAttend(true);
        app2.addPrescriptionForApp("Ibuprofen", "24 X 250mg", "donald.knuth.01011902", "peter.venkman.01011911", "Appointment2");
        
        
        //amend some appointments without prescriptions - so they can be added later
        
         Appointment app3 = (Appointment) AppointmentComponent.getAppointment("Appointment3");
        app3.setAppMissed(true);
        
        Appointment app4 = (Appointment) AppointmentComponent.getAppointment("Appointment4");
        app2.setAppMissed(true);
        
        Appointment app5= (Appointment) AppointmentComponent.getAppointment("Appointment5");
        
        
        SysUserDoctor currentDoctorInst = (SysUserDoctor) SystemUserComponent.getSystemUserComponent("gregory.house.01011910");
        LocalDateTime currentLTDtoCancel = app5.getAPPDateAndTime();
        app5.setAppCancelled(true, currentDoctorInst, currentLTDtoCancel );
         
        

   
     }
}
