package Tests;

import Base.Test_Base;
import Pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Valid_Search_Test extends Test_Base {

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
    public void Valid_Search_By_Restaurant_Name(){

        Search_Page searchPage =
                new Search_Page(driver);

        searchPage.Enter_Search_Text("buffalo burger");

        searchPage.Press_Search_Key();

        Assert.assertEquals(
                searchPage.Get_Search_Text(),
                "buffalo burger",
                "Search text is not correct");

        Assert.assertTrue(
                searchPage.Is_Buffalo_Burger_Displayed(),
                "Buffalo Burger restaurant was not displayed in search results");

    }

    @Test(priority = 2)
    public void Valid_Search_Food_Item() {

        Search_Page searchPage =
                new Search_Page(driver);

        searchPage.Enter_Search_Text("burger");

        //searchPage.Select_Burger_In_Food();

        searchPage.Select_Food_Tab();

        searchPage.Select_Burger_Result();

        Assert.assertEquals(
                searchPage.Get_Search_Text(),
                "burger",
                "Search text is not correct");

        Assert.assertTrue(
                searchPage.Is_Sort_By_Displayed(),
                "Sort by is not displayed in search results");

    }

    @Test(priority = 3)
    public void Search_By_Partial_Keyword() {

        Search_Page searchPage =
                new Search_Page(driver);

        searchPage.Enter_Search_Text("buffa");

        searchPage.Press_Search_Key();

        Assert.assertEquals(
                searchPage.Get_Search_Text(),
                "buffa",
                "Partial search text is not correct");

        Assert.assertTrue(
                searchPage.Is_Sort_By_Displayed(),
                "Search results were not displayed for the partial keyword");
    }

    @Test(priority = 4)
    public void Search_Using_Arabic() {

        Search_Page searchPage =
                new Search_Page(driver);

        searchPage.Enter_Search_Text("برجر");

        searchPage.Press_Search_Key();

        Assert.assertEquals(
                searchPage.Get_Search_Text(),
                "برجر",
                "Arabic search text is not correct");

        Assert.assertTrue(
                searchPage.Is_Burger_Search_Result_Displayed(),
                "No relevant Burger result was displayed for the Arabic keyword");
    }
    @Test(priority = 5)
    public void Search_Using_Filter_Cuisine() {

        Search_Page searchPage =
                new Search_Page(driver);

        searchPage.Enter_Search_Text("Burgers");
        searchPage.Press_Search_Key();
        searchPage.Select_Food_Tab();

        searchPage.Swipe_To_Cuisine();

        Assert.assertTrue(
                searchPage.Is_Cuisine_Displayed(),
                "Cuisine filter was not displayed after swipe");

        searchPage.Click_Cuisine();

        searchPage.Click_American();
        searchPage.Click_Apply_Cuisine();
        Assert.assertTrue(
                searchPage.Is_Cuisine_Selected(),
                "Cuisine filter was not applied successfully");
    }

    @Test(priority = 6)
    public void Search_Inside_Cuisine_Filter() {
        Search_Page searchPage =
                new Search_Page(driver);
        searchPage.Enter_Search_Text("Burgers");
        searchPage.Press_Search_Key();
        searchPage.Select_Food_Tab();

        searchPage.Swipe_To_Cuisine();

        Assert.assertTrue(
                searchPage.Is_Cuisine_Displayed(),
                "Cuisine filter was not displayed after swipe");

        searchPage.Click_Cuisine();
        searchPage.Enter_Cuisine_Search("Amer");
        Assert.assertTrue(
                searchPage.Is_American_Displayed(),
                "American cuisine was not displayed in cuisine search results");
        searchPage.Click_American();
        searchPage.Click_Apply_Cuisine();

        Assert.assertTrue(
                searchPage.Is_Cuisine_Selected(),
                "Cuisine filter was not applied successfully");

    }


    }


