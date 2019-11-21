package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.*;
import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;

public class SalariesPage extends MainPage {

    public SalariesPage open() {
        Selenide.open("/salaries");
        return this;
    }

    private SelenideElement salariesForm = $(".salarydec");
    private SelenideElement citySelect = $("[name='city']");
    private SelenideElement jobSelect = $("[name='title']");
    private SelenideElement programmingLanguageSelect = $("[name='language']");
    private SelenideElement periodSelect = $("[name='period']");
    private SelenideElement slider = salariesForm.$(".ui-slider-range");
    private SelenideElement sliderButton = $x("//div[@class='salarydec-slider-wrap']//a[@class='ui-slider-handle ui-state-default ui-corner-all'][1]");
    private SelenideElement rightSlider = $x("//div[@class='salarydec-slider-wrap']//a[@class='ui-slider-handle ui-state-default ui-corner-all'][last()]");

    public SalariesPage shouldSeeThatSliderIsSetCorrectly(String expectedValue) {
        slider.shouldHave(Condition.attribute("style", expectedValue));
        return this;
    }

    public SalariesPage setCity(String city) {
        citySelect.selectOption(city);
        return this;
    }

    public SalariesPage setJobPosition(String jobPosition) {
        jobSelect.selectOption(jobPosition);
        return this;
    }

    public SalariesPage setProgrammingLanguage(String language) {
        programmingLanguageSelect.selectOption(language);
        return this;
    }

    public SalariesPage setPeriod(String period) {
        periodSelect.selectOption(period);
        return this;
    }

    public SalariesPage shouldSeeSelectedCity(String city) {
        assertEquals(city, citySelect.getSelectedText());
        return this;
    }

    public SalariesPage shouldSeeSelectedJob(String job) {
        assertEquals(job, jobSelect.getSelectedText());
        return this;
    }

    public SalariesPage shouldSeeSelectedPeriod(String period) {
        assertEquals(period, periodSelect.getSelectedText());
        return this;
    }

    public SalariesPage shouldSeeSelectedLanguage(String language) {
        assertEquals(language, programmingLanguageSelect.getSelectedText());
        return this;
    }

    public SalariesPage shouldSeeMaxSalary(String salary) {
        $(".salarydec-results-max .num").shouldHave(Condition.exactText(salary));
        return this;
    }
    public SalariesPage shouldSeeMedianSalary(String salary) {
        $(".salarydec-results-median .num").shouldHave(Condition.exactText(salary));
        return this;
    }

    public void setSlider123(String value) {
        JavascriptExecutor js = (JavascriptExecutor) sliderButton;
        js.executeScript("arguments[0].setAttribute('style', 'left: 30%;')", sliderButton);
    }

    public SalariesPage setLeftSliderButton(int timeValue) {
        for (int i = 1; i <= timeValue ; i++) {
            sliderButton.sendKeys(Keys.ARROW_RIGHT);
            sliderButton.sendKeys(Keys.ENTER);
        }
        return this;
    }
    public SalariesPage setRightSliderButton(int timeValueLast) {
        int countRight = 10 - timeValueLast ;
        for (int i = 1; i <= countRight ; i++) {
            sliderButton.sendKeys(Keys.ENTER);
            sliderButton.sendKeys(Keys.ARROW_LEFT);
        }
        return this;
    }
}

