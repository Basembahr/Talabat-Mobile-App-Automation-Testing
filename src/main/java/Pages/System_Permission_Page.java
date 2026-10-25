package Pages;

import Base.Page_Base;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class System_Permission_Page extends Page_Base {
    By Allow_Notification =
            AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button");

    public System_Permission_Page(AndroidDriver driver) {
        super(driver);
    }


    public void Allow_Notification_Permission() {
        Click_Button(Allow_Notification);
    }

}

