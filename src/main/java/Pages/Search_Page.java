package Pages;

import Base.Page_Base;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;

public class Search_Page extends Page_Base {
    By Search_Field =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().className(\"android.widget.EditText\")");
    By Burger_In_Food =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().description(\"burger in Food\")");
    By Food_Tab =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().resourceId(\"tab_item_Food\")");
    By Burger_Result =
            AppiumBy.accessibilityId("burger");

    By Sort_By =
            AppiumBy.accessibilityId("Sort by");

    By Buffalo_Burger_Restaurant =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().descriptionContains(\"Buffalo Burger\")");
    By Burger_Search_Result =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().descriptionContains(\"Burger\")");
    By Fastest_Delivery =
            AppiumBy.accessibilityId("Fastest delivery");
    By Ratings =
            AppiumBy.accessibilityId("Ratings");

    By Apply_Button =
            AppiumBy.accessibilityId("Apply");

    By Top_Rated =
            AppiumBy.accessibilityId("Top rated");
    By Cuisine =
            AppiumBy.accessibilityId("Cuisine");
    By American =
            AppiumBy.accessibilityId("American");
    By Search_Cuisine_Field =
            AppiumBy.className("android.widget.EditText");
    By Apply_Cuisine =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().descriptionContains(\"Apply\")");



    public Search_Page(AndroidDriver driver) {
        super(driver);
    }


    public void Enter_Search_Text(String text) {

        Click_Button(Search_Field);
        Enter_Text(Search_Field, text);
    }

    public void Select_Burger_In_Food() {
        Click_Button(Burger_In_Food);
    }

    public void Select_Food_Tab() {
        Click_Button(Food_Tab);
    }

    public void Select_Burger_Result() {
        Click_Button(Burger_Result);
    }

    public String Get_Search_Text() {

        return Get_Text(Search_Field);
    }
    public boolean Is_Sort_By_Displayed() {

        return Is_Element_Displayed(Sort_By);
    }

    public void Click_Search_For(String searchText) {

        By Search_Result =
                AppiumBy.accessibilityId(
                        "Search for '" + searchText + "'");

        Click_Button(Search_Result);
    }
    public void Press_Search_Key() {
        driver.executeScript(
                "mobile: performEditorAction",
                java.util.Map.of("action", "search"));
    }

    public boolean Is_Buffalo_Burger_Displayed() {
        return Is_Element_Displayed(Buffalo_Burger_Restaurant);
    }

    public boolean Is_Burger_Search_Result_Displayed() {
        return Is_Element_Displayed(Burger_Search_Result);
    }

    public void Click_Sort_By() {
        Click_Button(Sort_By);
    }

    public void Select_Fastest_Delivery() {
        Click_Button(Fastest_Delivery);
    }

    public void Select_Ratings() {
        Click_Button(Ratings);
    }

    public void Click_Apply() {
        Click_Button(Apply_Button);
    }

    public void Click_Top_Rated() {
        Click_Button(Top_Rated);
    }
    public boolean Is_Fastest_Delivery_Displayed() {
        return Is_Element_Displayed(Fastest_Delivery);
    }

    public boolean Is_Select_Ratings() {
        return Is_Element_Displayed(Ratings);
    }

    public boolean Is_Top_Rated_Displayed() {
        return Is_Element_Displayed(Top_Rated);
    }


    private List<Double> Found_Ratings = new ArrayList<>();


    public List<WebElement> Get_Restaurant_Results() {

        By Restaurant_Results =
                AppiumBy.xpath(
                        "//android.view.View[contains(@content-desc,' stars,')]"
                );

        return driver.findElements(Restaurant_Results);
    }


    public boolean Are_Ratings_In_Descending_Order() {

        List<WebElement> restaurantResults =
                Get_Restaurant_Results();

        Found_Ratings.clear();

        for (WebElement restaurant : restaurantResults) {

            String contentDesc =
                    restaurant.getAttribute("content-desc");

            Pattern pattern =
                    Pattern.compile("(\\d\\.\\d) stars");

            Matcher matcher =
                    pattern.matcher(contentDesc);

            if (matcher.find()) {
                Found_Ratings.add(
                        Double.parseDouble(matcher.group(1))
                );
            }
        }

        System.out.println("Ratings found: " + Found_Ratings);

        for (int i = 0; i < Found_Ratings.size() - 1; i++) {

            if (Found_Ratings.get(i) < Found_Ratings.get(i + 1)) {
                return false;
            }
        }

        return true;
    }



    public List<Double> Get_Found_Ratings() {
        return Found_Ratings;
    }

    public void Swipe_To_Cuisine() {

        for (int i = 0; i < 3; i++) {

            if (Is_Cuisine_Displayed()) {
                return;
            }

            Swipe_Filter_Bar_Left();
        }
    }

    public void Click_Cuisine() {
        Click_Button(Cuisine);
    }
    public void Click_American(){
        Click_Button(American);
    }

    public boolean Is_Cuisine_Displayed() {
        return Is_Element_Displayed(Cuisine);
    }

    public void Click_Apply_Cuisine() {
        Click_Button(Apply_Cuisine);
    }

    public boolean Is_Cuisine_Selected() {

        waitUntilVisible(Cuisine);

        return driver.findElement(Cuisine).isSelected();
    }


    public void Enter_Cuisine_Search(String cuisine) {
        Enter_Text(Search_Cuisine_Field, cuisine);
    }
    public boolean Is_American_Displayed() {
        return Is_Element_Displayed(American);
    }









}