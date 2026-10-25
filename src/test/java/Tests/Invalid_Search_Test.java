package Tests;

import Base.Test_Base;
import Pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Invalid_Search_Test extends Test_Base {
    @BeforeMethod
    public void Open_Home_Page() {

        Country_Page countryPage =
                new Country_Page(driver);

        countryPage.Select_Egypt();

        Login_Page loginPage =
                new Login_Page(driver);

        loginPage.Click_Continue_With_Google();



        loginPage.Select_Google_Account();

        System_Permission_Page permissionPage =
                new System_Permission_Page(driver);

        permissionPage.Allow_Notification_Permission();

        loginPage.Close_Travel_Popup_If_Displayed();

        Home_Page homePage =
                new Home_Page(driver);
        homePage.Click_Search_Bar();

        Delivery_Location_Page deliveryLocationPage =
                new Delivery_Location_Page(driver);

        deliveryLocationPage.Select_Saved_Address();

        homePage.Close_Popup_If_Displayed();

    }
    @Test(priority = 1)
    public void  Search_With_Non_Existing_Keyword()  {

        Search_Page searchPage =
                new Search_Page(driver);

        searchPage.Enter_Search_Text("hjgfsda123Test");

        searchPage.Click_Search_For("hjgfsda123Test");

        Assert.assertEquals(
                searchPage.Get_Search_Text(),
                "hjgfsda123Test",
                "Search text is not correct");

        Assert.assertTrue(
                searchPage.Is_Sort_By_Displayed(),
                "General restaurant suggestions were not displayed");
    }

    @Test(priority = 2)
    public void Search_With_Special_Characters(){

        Search_Page searchPage =
                new Search_Page(driver);

        searchPage.Enter_Search_Text("&@#$%^&^^");
        searchPage.Click_Search_For("&@#$%^&^^");

        Assert.assertEquals(
                searchPage.Get_Search_Text(),
                "&@#$%^&^^",
                "Special characters search text is not correct");

        Assert.assertTrue(
                searchPage.Is_Sort_By_Displayed(),
                "General search results were not displayed");
    }

    @Test(priority = 3)
    public void Empty_Search() {

        Search_Page searchPage =
                new Search_Page(driver);

        searchPage.Press_Search_Key();

        Assert.assertEquals(
                searchPage.Get_Search_Text(),
                "",
                "Search field is not empty");

        Assert.assertFalse(
                searchPage.Is_Sort_By_Displayed(),
                "Search operation was performed with an empty search field");

    }
}
