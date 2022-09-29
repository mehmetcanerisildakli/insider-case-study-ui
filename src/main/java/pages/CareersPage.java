package pages;

import common.Action;
import org.openqa.selenium.By;

public class CareersPage {

    Action action = new Action();
    String careersPageTitle = "Insider Careers";

    private final By ourLocationsBlock = By.xpath("//section[@id='career-our-location']");
    private final By lifeAtInsiderBlock = By.xpath("//h2[normalize-space()='Life at Insider']");
    private final By findYourCallingBlock = By.xpath("//section[@id='career-find-our-calling']");
    private final By seeAllTeamsButton = By.xpath("//section[@id='career-find-our-calling']//a[contains(.,'See all teams')]");
    private final By qaJobsButton = By.xpath("//section[@id='career-find-our-calling']//h3[contains(.,'Quality Assurance')]");
    private final By biJobsButton = By.xpath("//section[@id='career-find-our-calling']//h3[contains(.,'Business Intelligence')]");
    private final By productAndEngineering = By.xpath("//section[@id='career-find-our-calling']//h3[contains(.,'Product & Engineering')]");

    public void checkCareersPageIsOpened() {
        action.checkTitle(careersPageTitle);
    }

    public void checkOurLocationsBlockIsPresent() {

        action.scrollToElement(ourLocationsBlock);
        action.wait(1);
        action.checkElementIsVisible(ourLocationsBlock);
    }

    public void checkLifeAtInsiderBlockIsPresent() {

        action.waitUntil(5, lifeAtInsiderBlock);
        action.scrollToElement(lifeAtInsiderBlock);
        action.wait(1);
        action.checkElementIsVisible(lifeAtInsiderBlock);
    }

    public void checkFindYourCallingBlockIsPresent() {

        action.scrollToElement(findYourCallingBlock);
        action.wait(1);
        action.checkElementIsVisible(findYourCallingBlock);
    }

    public void clickSeeAllTeamsButton() {

        action.scrollToElement(productAndEngineering);
        action.wait(3);
        action.clickElement(seeAllTeamsButton);
        action.wait(2);
    }

    public void clickQAJobsButton() {

        action.wait(3);
        action.scrollToElement(biJobsButton);
        action.wait(3);
        action.clickElement(qaJobsButton);
    }
}
