package Pages;

import Base.Page_Base;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class Home_Page extends Page_Base {

    By Close_Popup =
            AppiumBy.accessibilityId("Close");
    By Search_Bar =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().resourceId(\"HomeScreen.searchbar\")");

    public Home_Page(AndroidDriver driver) {
        super(driver);

    }


    public void Close_Popup_If_Displayed() {

        if (Is_Element_Displayed(Close_Popup)) {
            Click_Button(Close_Popup);
        }
    }


    public void Click_Search_Bar(){
        Click_Button(Search_Bar);

    }
}