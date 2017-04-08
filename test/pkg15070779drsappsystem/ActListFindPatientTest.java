
package pkg15070779drsappsystem;
import javax.swing.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class ActListFindPatientTest {
    
    @Test
    public void testsetAndCheckPatient(){
    
    //will need to simulate a button click to fire this though
    //check that a doctor user object fails (assert null)
    //check that a pharmacist user object fails (assert null)
    //check that a patient object  assert not null
               
               
        MainAbsSystemUserComponent testPatient = new MainPatient("alan", "turing", "Mr", "01011900", "01234 567 890", "More data");
        
        JTextField fname = new JTextField("alan");
        JTextField sname = new JTextField("turing");
        JTextField dob = new JTextField("01011900");
        String username = "alan.turing.01011900";
        ActListFindPatient testAct1 = new ActListFindPatient(fname,sname,dob);
        
        assertNotNull(testAct1);
   
    } 
    
}