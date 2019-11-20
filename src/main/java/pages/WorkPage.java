package pages;

import com.codeborne.selenide.SelenideElement;
import enums.Tabs;

import static com.codeborne.selenide.Selenide.$;

public class WorkPage extends MainPage {

    private SelenideElement subheaderTabs = $(".b-sub-head-n .sub");

    public <T extends MainPage> T navigateByClickingOnSubheaderTab(T page, Tabs tabName) {
        subheaderTabs.$x(".//a[text()='" + tabName.getName() + "']").click();
        return page;
    }
}
