import org.example.Authentication;
import org.example.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AuthenticationTest {
    @Test
    public void testRegister01()
    {
        boolean expectedValue = true;
        Authentication authentication01 = new Authentication();
        boolean actualValue = authentication01.register("user01","Nafisa Tasnim",22,"Female",
                "nafisatasnim8855@gmail.com","password1234");
        assertEquals(expectedValue,actualValue);
    }

}
