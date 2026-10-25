package Pages;

import Base.Page_Base;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class Login_Page extends Page_Base {

    By Continue_With_Google =
            AppiumBy.accessibilityId("Continue with Google");
    By Google_Account =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().text(\"basembahar94@gmail.com\")");
    By Not_Now =
            AppiumBy.accessibilityId("Not now");

    public Login_Page(AndroidDriver driver) {
        super(driver);
    }


    public void Click_Continue_With_Google() {
        Click_Button(Continue_With_Google);
    }

    public void Select_Google_Account() {
        Click_Button(Google_Account);
    }

    public void Close_Travel_Popup_If_Displayed() {
        if (Is_Element_Displayed(Not_Now)) {
            Click_Button(Not_Now);
        }
    }
}


