package Base;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

public class Test_Base {

    protected AndroidDriver driver;

    @BeforeMethod
    public void before_test() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:automationName", "UiAutomator2");
        caps.setCapability("appium:deviceName", "Samsung A36");
        caps.setCapability("appium:udid", "RKCY80031HF");

        caps.setCapability("appium:appPackage", "com.talabat");
        caps.setCapability("appium:appActivity", ".MainActivityDefault");

        driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723"),
                caps
        );
    }

    @AfterMethod
    public void after_test() {

        if (driver != null) {
            driver.quit();
        }
    }
}
