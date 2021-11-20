package UserUnitTests;
import org.junit.jupiter.api.*;
import controller.loginController;
import model.loginModel;
public class LoginUnitTestStudent {
    static loginController loginObj;
    loginModel actualValue;
    @BeforeAll
    public static void CreateLogin()
    {
        loginObj=new loginController();
    }
    @BeforeEach
    public void AssignValues()
    {
        actualValue=loginObj.addUtype("2001", "12345", "Student");
    }
    @Test
    public void TestLogin()
    {
        Assertions.assertNotNull(actualValue);
    }
    @AfterEach
    public void CleanValues()
    {
        actualValue=null;
    }
    @AfterAll
    public static void DeleteLogin()
    {
        loginObj=null;
    }
    
    
}
