package tests;

import common.Driver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CareersPage;
import pages.JobPage;
import pages.MainPage;

public class Insider {

    Driver driver = new Driver();
    MainPage mainPage = new MainPage();
    CareersPage careersPage = new CareersPage();
    JobPage jobs = new JobPage();


    @BeforeTest
    public void setUp() {
        driver.driverSet();
    }

    @Test
    public void insiderCaseStudy() {
        mainPage.goToHomePage();
        mainPage.checkMainPageIsOpened();
        mainPage.clickMoreButton();
        mainPage.checkDropDownMenuIsOpened();
        mainPage.clickCareersMenuButton();
        careersPage.checkCareersPageIsOpened();
        careersPage.checkLifeAtInsiderBlockIsPresent();
        careersPage.checkOurLocationsBlockIsPresent();
        careersPage.checkFindYourCallingBlockIsPresent();
        careersPage.clickSeeAllTeamsButton();
        careersPage.clickQAJobsButton();
        jobs.checkQAPageIsOpened();
        jobs.clickSeeAllQAJobs();
        jobs.selectLocationQA();
        jobs.selectDepartmentQA();
        jobs.checkJobListArePresent();
        jobs.checkJobPostContainsFilters();
        jobs.checkApplyButtonIsPresent();
        jobs.clickFirstApplyButton();
        jobs.checkNewTabIsOpened();
    }

    @AfterTest
    public void driverDown() {
        driver.driverTearDown();
    }
}
