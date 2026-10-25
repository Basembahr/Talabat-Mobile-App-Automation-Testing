package Pages;

import Base.Page_Base;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class Delivery_Location_Page extends Page_Base {

    public Delivery_Location_Page(AndroidDriver driver) {
        super(driver);
    }

    By Saved_Address =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().descriptionContains(\"Heliopolis - El Horreya\")"
            );

    public void Select_Saved_Address() {
        Click_Button(Saved_Address);
    }
}
