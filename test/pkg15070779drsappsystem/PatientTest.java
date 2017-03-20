package pkg15070779drsappsystem;

import org.junit.Test;
import static org.junit.Assert.*;


public class PatientTest {
    
        Patient pat1 = new Patient("Alan", "Turing","Mr", 1900, "gregory.house.1911");
        Patient pat2 = new Patient("Donald", "Knuth","Mr", 1901, "peter.venkman.1912");
        Patient pat3 = new Patient("Grace", "Hopper","Mrs", 1902, "egon.spengler.1913");
        Patient pat4 = new Patient("Ada", "Lovelace","Miss", 1903, "ray.stance.1914");
        Patient pat5 = new Patient("Tim", "Berners-Lee","Mr", 1904, "winstone.zeddermore.1915");
        Patient pat6 = new Patient("Tony", "Hoare","Mr", 1905, "winstone.zeddermore.1915");
        Patient pat7 = new Patient("Claude", "Shannon","Mr", 1906, "winstone.zeddermore.1915");
        Patient pat8 = new Patient("Larry", "Page","Mr", 1907, "winstone.zeddermore.1915");
        Patient pat9 = new Patient("Hal", "Abeson","Mr", 1908, "winstone.zeddermore.1915");
        Patient pat10 = new Patient("Shafi", "Goldswasser","Mrs", 1909, "winstone.zeddermore.1915");
        
        Doctor dr1 = new Doctor("Gregory", "House","Dr", 1911, "Test");
        Doctor dr2 = new Doctor("Peter", "Venkman","Dr", 1912, "Test");
        Doctor dr3 = new Doctor("Egon", "Spengler","Dr", 1913, "Test");
        Doctor dr4 = new Doctor("Ray", "Stance","Dr", 1914, "Test");
        Doctor dr5 = new Doctor("Winstone", "Zeddermore","Dr", 1915, "Test");
    
        
        //test needs looking at
    /*
    @Test
    public void testSetAddDrRegsWith(){
        pat1.setAddDrRegsWith("peter.venkman.1912");
        String datatoTest = pat1.getDrsRegWith();
          
        assertEquals(true, datatoTest.contains("peter.venkman.1912"));
    } 
    */
    
    
    
    
   //@indirectly called through testAddDrRegsWith - test not needed
    @Test
    //@@@@@ this needs looking at@@@@@
    public void testGetDrsRegWith(){
        Patient testUser = new Patient("Paul", "Treadwell", "Mr", 1983, "More data");
        //testUser.setAddDrRegsWith("Dr Peter Venkman");
        //assertEquals("Dr Peter Venkman", testUser.getDrsRegWith());
        
        Patient testUser2 = new Patient("Paul", "Treadwell", "Mr", 1983, "More data");
        //testUser2.setAddDrRegsWith("Dr Peter Venkman");
        //testUser2.setAddDrRegsWith("Dr Egon Spengler");
        //testUser2.setAddDrRegsWith("Dr Sarah Thompson");
        //assertEquals("Dr Peter Venkman, Dr Egon Spengler, Dr Sarah Thompson", testUser2.getDrsRegWith());
    } 
 
            
    
}
