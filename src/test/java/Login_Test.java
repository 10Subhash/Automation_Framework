import com.automation.DriverSetup.DriverSetup;
import com.automation.Pages.Login;
import com.automation.Utilities.ReadPropertiesFile;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class Login_Test extends DriverSetup {

    public Login login;
    public ReadPropertiesFile readPropertiesFile;

    @BeforeClass(alwaysRun = true)
    public void pageObject(){
        login = new Login();
        readPropertiesFile = new ReadPropertiesFile();
    }

    @Test(priority = 1,description = "")
    @Parameters({"username","password"})
    public void verifyUserCredentials(String username,String password) throws InterruptedException, IOException {
        login.addUser(username);
        login.addPass(password);
        login.clickSubmitButton();
        Thread.sleep(5000);
        Assert.assertEquals(login.verifyHeader(),readPropertiesFile.getPropertyValue("data.properties","header"));
        login.clickLogoutButton();
    }
}
