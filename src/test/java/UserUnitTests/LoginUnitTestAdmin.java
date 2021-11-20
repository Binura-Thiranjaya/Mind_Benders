package UserUnitTests;
import org.junit.jupiter.api.*;
import controller.loginController;
import model.loginModel;
public class LoginUnitTestAdmin {
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
        actualValue=loginObj.addUtype("2000", "12345", "Admin");
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
