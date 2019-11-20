package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
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
        assertEquals(job, citySelect.getSelectedText());
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


}
