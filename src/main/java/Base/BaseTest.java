package Base;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    private static AppiumDriver driver;




    // INITIALINING THE APPIUMDRIVER
    public void setup(){
        System.out.println("Setting up Appium driver");
        if(driver == null){
            try {
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setCapability("platformName","Android");
                caps.setCapability("deviceName",ConfigManager.getProperty("devicename"));
                caps.setCapability("app",ConfigManager.getProperty("appPath"));
                caps.setCapability("automationName","UIAutomator2");
                caps.setCapability("noReset","true");
                driver = new AppiumDriver(new URL("http://127.0.0.1:4723"),caps);
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                System.out.println("Appium driver initialized successfullly");

            }
            catch (Exception e){
                e.printStackTrace();
                throw new RuntimeException("Failed to initialize appium driver");
            }
        }
    }



    //CLOSING THE APPIUMDRIVER
    public void tearDown()
    {
        System.out.println("Qutting Appium driver..");
        if(driver != null);
        driver.quit();
        System.out.println("Appium driver quit successfully");
    }

    public static AppiumDriver getDriver()
    {
        System.out.println("returning appium driver instance");

        return driver;
    }
}
