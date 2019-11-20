package tests;

import enums.Tabs;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CompaniesPage;
import pages.MainPage;
import pages.SalariesPage;
import pages.WorkPage;

public class DouTest extends TestBase {


    @Test
    public void pmSalaryOnDecember2011() {
        new MainPage().open()
                .navigateByClickingOnHeaderTab(new SalariesPage(), Tabs.SALARIES)
                .setCity("Киев")
                .setJobPosition("Project manager")
                .setPeriod("декабрь 2011")
                .shouldSeeSelectedCity("Киев")
                .shouldSeeSelectedJob("Project manager")
                .shouldSeeSelectedPeriod("декабрь 2011")
                .shouldSeeMaxSalary("$3000");
    }

    @Test
    public void cloudBeesCompanyLinkRedirectsToProperWebSite() {
        new MainPage().open()
                .navigateByClickingOnHeaderTab(new WorkPage(), Tabs.WORK)
                .navigateByClickingOnSubheaderTab(new CompaniesPage(), Tabs.COMPANIES)
                .searchCompany("CloudBees")
                .openCompanyPage("CloudBees")
                .clickOnCompanyWebsiteAndVerifyTitle("CloudBees | Enterprise Jenkins and DevOps");

    }

    @BeforeMethod(alwaysRun = true)
    public void before() {
        createDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void after() {
        removeDriver();
    }
}
