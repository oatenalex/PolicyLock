import com.example.policylock.loginUI;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLogin {
    @Test
    public void JUNIT_Test(){
        loginUI test = new loginUI();
        assertEquals( (double) 4, 4, 0);
        assertEquals(3, test.dumbTest(), 0);
    }

}
