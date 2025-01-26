import org.example.AuthenticationService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AuthenticationTest {
    @Test
    public void testRegister01()
    {
        boolean expectedValue = true;
        AuthenticationService authentication01 = new AuthenticationService();
        boolean actualValue = authentication01.register("user01","Nafisa Tasnim",22,"Female",
                "nafisatasnim8855@gmail.com","password1234");
        assertEquals(expectedValue,actualValue);
    }

}
