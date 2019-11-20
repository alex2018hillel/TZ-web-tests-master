package pages;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import enums.Tabs;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    private SelenideElement tabsForm = $(".b-head > ul");

    public MainPage open() {
        Selenide.open("");
        return this;
    }

    public <T extends MainPage> T navigateByClickingOnHeaderTab(T page, Tabs tabName) {
        tabsForm.find(Selectors.byText(tabName.getName())).click();
        return page;
    }
}
