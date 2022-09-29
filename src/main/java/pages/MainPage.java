package pages;

import common.Action;
import org.openqa.selenium.By;

public class MainPage {

    Action action = new Action();
    String mainPageTitle = "Insider personalization engine for seamless customer experiences";

    private final By moreMenuButton = By.xpath("//a[@id='mega-menu-1' and contains(.,'More')]");
    private final By dropdownMenu = By.xpath("//div[@class='dropdown-menu show']");
    private final By careersMenuButton = By.xpath("//h5[contains(text(),'Careers')]");
    private final By acceptAllCookie = By.linkText("Accept All");


    public void goToHomePage() {
        action.goToHomePage();
    }

    public void checkMainPageIsOpened() {
        action.checkTitle(mainPageTitle);
    }

    public void clickMoreButton() {

        action.clickElement(acceptAllCookie);
        action.clickElement(moreMenuButton);
    }

    public void checkDropDownMenuIsOpened() {
        action.checkElementIsVisible(dropdownMenu);
    }

    public void clickCareersMenuButton() {
        action.clickElement(careersMenuButton);
    }
}
