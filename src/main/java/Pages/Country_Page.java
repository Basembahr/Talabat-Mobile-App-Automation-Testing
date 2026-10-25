package Pages;

import Base.Page_Base;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class Country_Page extends Page_Base {

    By Egypt = AppiumBy.accessibilityId("Egypt");

    public Country_Page(AndroidDriver driver) {
        super(driver);
    }


    public void Select_Egypt() {
        Click_Button(Egypt);
    }
}
