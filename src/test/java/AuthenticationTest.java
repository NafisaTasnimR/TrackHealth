import org.example.AuthenticationService;
import org.example.CSVUserRepository;
import org.example.UserRepository;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AuthenticationTest {
    @Test
    public void testRegister01()
    {
        boolean expectedValue = true;
        UserRepository userRepository;
        AuthenticationService authentication01 = new AuthenticationService(new CSVUserRepository());
        boolean actualValue = authentication01.register("user01","Nafisa Tasnim",22,"Female",
                "nafisatasnim8855@gmail.com","password1234");
        assertEquals(expectedValue,actualValue);
    }

    @Test
    public void testRegister02()
    {
        boolean expectedValue = false;
        UserRepository userRepository;
        AuthenticationService authentication01 = new AuthenticationService(new CSVUserRepository());
        boolean actualValue = authentication01.register("user01","Nafisa Tasnim",22,"Female",
                "nafisatasnim8855@gmail.com","password1234");
        assertEquals(expectedValue,actualValue);
    }

}
