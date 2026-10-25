package Tests;

import Base.Test_Base;
import Pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Search_Regression_Test extends Test_Base {

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
    @Test(
            priority = 1,
            description = "BUG_01 - Fastest Delivery may display restaurants unrelated to the searched keyword. " +
                    "Result relevance is verified manually because restaurant results vary by location, time, and availability."
    )
    public void Fastest_Delivery_Sorting_Bug(){

        Search_Page searchPage =
                new Search_Page(driver);

        searchPage.Enter_Search_Text("Pizza");

        searchPage.Press_Search_Key();

        searchPage.Select_Food_Tab();
        searchPage.Click_Sort_By();
        searchPage.Select_Fastest_Delivery();

        searchPage.Click_Apply();

// BUG_01:
// The automation verifies that "Fastest Delivery" sorting is successfully applied.
// Search-result relevance is not asserted here because restaurant results are dynamic
// and may vary depending on location, time, and restaurant availability.
// See BUG_01 in the Bug Report for manual test evidence and screenshot.

        Assert.assertTrue(
                searchPage.Is_Fastest_Delivery_Displayed(),
                "Fastest Delivery sorting was not applied");
    }

    @Test(
            priority = 2,
            description = "BUG_02 - Ratings sorting may display restaurants unrelated to the searched keyword. " +
                    "Result relevance is verified manually because restaurant results vary by location, time, and availability."
    )
    public void Ratings_Sorting_Bug(){

        Search_Page searchPage =
                new Search_Page(driver);

        searchPage.Enter_Search_Text("Pizza");

        searchPage.Press_Search_Key();

        searchPage.Select_Food_Tab();
        searchPage.Click_Sort_By();
        searchPage.Select_Ratings();
        searchPage.Click_Apply();

 // BUG_02 :
// The automation verifies that "Ratings" sorting is successfully applied.
// Search-result relevance is not asserted here because restaurant results are dynamic
// and may vary depending on location, time, and restaurant availability.
// See BUG_02 in the Bug Report for manual test evidence and screenshot.

        Assert.assertTrue(
                searchPage.Is_Select_Ratings(),
                "Ratings sorting was not applied");
    }

    @Test(priority = 3)
    public void Top_Rated_Filter_Bug() {

        Search_Page searchPage =
                new Search_Page(driver);

        searchPage.Enter_Search_Text("Pizza");

        searchPage.Press_Search_Key();

        searchPage.Select_Food_Tab();

        searchPage.Click_Top_Rated();

        // Verify that the Top Rated filter is applied
        Assert.assertTrue(
                searchPage.Is_Top_Rated_Displayed(),
                "Top Rated filter was not applied");

        // Check the actual restaurant ratings order
        boolean ratingsSorted =
                searchPage.Are_Ratings_In_Descending_Order();

        // Verify that ratings are sorted from highest to lowest
        Assert.assertTrue(
                ratingsSorted,
                "Restaurant ratings are not sorted in descending order. " +
                        "Actual ratings: " + searchPage.Get_Found_Ratings());
    }

    }

