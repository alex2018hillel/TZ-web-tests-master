package tests;

import enums.Tabs;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.SalariesPage;

public class CheckSalaryTest extends TestBase {

    private Object WebDriver;

    @BeforeMethod(alwaysRun = true)
    public void before() {
        createDriver();
    }

    @Test
    public void pmSalarySenior3year() {
        new MainPage().open()
                .navigateByClickingOnHeaderTab(new SalariesPage(), Tabs.SALARIES)
                .setCity("вся Украина")
                .setJobPosition("Senior Software Engineer")
                .setPeriod("июнь-июль 2019")
                .setLeftSliderButton(3)
                .setRightSliderButton(3)
                .shouldSeeSelectedCity("вся Украина")
                .shouldSeeSelectedJob("Senior Software Engineer")
                .shouldSeeSelectedPeriod("июнь-июль 2019")
                .shouldSeeThatSliderIsSetCorrectly("left: 30%; width: 0%;")
                .shouldSeeMaxSalary("4000");
    }

    @Test
    public void pmSalarySenior2to5year() {
        new MainPage().open()
                .navigateByClickingOnHeaderTab(new SalariesPage(), Tabs.SALARIES)
                .setCity("вся Украина")
                .setJobPosition("Senior Software Engineer")
                .setPeriod("июнь-июль 2019")
                .setLeftSliderButton(2)
                .setRightSliderButton(5)
                .shouldSeeSelectedCity("вся Украина")
                .shouldSeeSelectedJob("Senior Software Engineer")
                .shouldSeeSelectedPeriod("июнь-июль 2019")
                .shouldSeeThatSliderIsSetCorrectly("left: 20%; width: 30%;")
                .shouldSeeMedianSalary("3500");
    }

    @AfterMethod(alwaysRun = true)
    public void after() {
        removeDriver();
    }

}
