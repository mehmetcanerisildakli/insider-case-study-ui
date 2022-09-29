package pages;

import common.Action;
import org.openqa.selenium.By;

public class JobPage {

    Action action = new Action();
    String qaJobsPageTitle = "Insider quality assurance job opportunities";
    String filterLocation = "Istanbul, Turkey";
    String filterDepartment = "Quality Assurance";
    String titleOfTheFirstJob = "";
    String titleOfTheFirstJobOnNewTab = "";

    private final By seeAllQAJobsButton = By.xpath("//section[@id='page-head']//a[contains(.,'See all QA jobs')]");
    private final By filterForLocation = By.xpath("//select[@id='filter-by-location']");
    private final By filterForDepartment = By.xpath("//select[@id='filter-by-department']");
    private final By jobListBlock = By.xpath("//div[@id='jobs-list']");
    private final By jobTitles = By.xpath("//span[contains(@class,'position-department')]");
    private final By titleOfResults = By.xpath("//h3[@class='mb-0']");
    private final By jobLocations = By.xpath("//div[contains(@class,'position-location')]");
    private final By jobListBlocks = By.xpath("//div[@id='jobs-list']/div");
    private final By applyButtons = By.xpath("//div[@id='jobs-list']//div//a[1]");
    private final By firstApplyButton = By.xpath("(//div[@id='jobs-list']//div//a[1])[1]");
    private final By firstJobTitle = By.xpath("//p[normalize-space()='Software QA Tester- Insider Testinium Tech Hub']");
    private final By firstJobTitleOnNewTab = By.xpath("//h2[normalize-space()='Software QA Tester- Insider Testinium Tech Hub']");


    public void checkQAPageIsOpened() {
        action.checkTitle(qaJobsPageTitle);
    }

    public void clickSeeAllQAJobs() {

        action.waitUntil(5, seeAllQAJobsButton);
        action.clickElement(seeAllQAJobsButton);
    }

    public void selectLocationQA() {

        action.wait(1);
        action.selectFromList(filterForLocation, filterLocation);
    }

    public void selectDepartmentQA() {
        action.selectFromList(filterForDepartment, filterDepartment);
    }

    public void checkJobListArePresent() {
        action.checkElementIsVisible(jobListBlock);
    }

    public void checkJobPostContainsFilters() {

        action.scrollToElement(titleOfResults);
        action.wait(2);
        action.checkContainsText(jobTitles, filterDepartment);
        action.checkContainsText(jobLocations, filterLocation);
    }

    public void checkApplyButtonIsPresent() {
        action.checkEachBlockHasElement(jobListBlocks, applyButtons);
    }

    public void clickFirstApplyButton() {

        action.hoverOver(action.getFirstElement(jobListBlocks));
        titleOfTheFirstJob = action.getTextOfElement(firstJobTitle);
        action.clickElement(firstApplyButton);
    }

    public void checkNewTabIsOpened() {

        action.switchTab();
        titleOfTheFirstJobOnNewTab = action.getTextOfElement(firstJobTitleOnNewTab);
        action.checkEquals(titleOfTheFirstJob, titleOfTheFirstJobOnNewTab);

    }

}
