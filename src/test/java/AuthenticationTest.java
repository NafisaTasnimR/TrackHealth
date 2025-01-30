import org.example.AuthenticationService;
import org.example.CSVUserRepository;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AuthenticationTest {
    @Test
    public void testRegister01()
    {
        boolean expectedValue = true;
        AuthenticationService authentication01 = new AuthenticationService(new CSVUserRepository());
        boolean actualValue = authentication01.register("user01","Nafisa Tasnim",22,"Female",
                "nafisatasnim8855@gmail.com","password1234");
        assertEquals(expectedValue,actualValue);
    }

    @Test
    public void testRegister02()
    {
        boolean expectedValue = false;
        AuthenticationService authentication01 = new AuthenticationService(new CSVUserRepository());
        boolean actualValue = authentication01.register("user01","Nafisa Tasnim",22,"Female",
                "nafisatasnim8855@gmail.com","password1234");
        assertEquals(expectedValue,actualValue);
    }

    @Test
    public void testLogin01()
    {
        boolean expectedValue = true;
        AuthenticationService authenticationService = new AuthenticationService(new CSVUserRepository());
        boolean actualValue = authenticationService.login("nafisatasnim8855@gmail.com","password1234");
        assertEquals(expectedValue,actualValue);
    }

    @Test
    public void testLogin02()
    {
        boolean expectedValue = false;
        AuthenticationService authenticationService = new AuthenticationService(new CSVUserRepository());
        boolean actualValue = authenticationService.login("nafisatasnim22@gmail.com","password1234");
        assertEquals(expectedValue,actualValue);
    }

    @Test
    public void testLogin03()
    {
        boolean expectedValue = false;
        AuthenticationService authenticationService = new AuthenticationService(new CSVUserRepository());
        boolean actualValue = authenticationService.login("nafisatasnim8855@gmail.com","password12345");
        assertEquals(expectedValue,actualValue);
    }
}
