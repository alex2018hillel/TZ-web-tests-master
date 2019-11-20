package tests;

import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

class TestBase {

    void createDriver() {
        Configuration.baseUrl = "https://dou.ua/";
        Configuration.browser = "chrome";
        Configuration.timeout = 6000;
        Configuration.startMaximized = true;
    }

    void removeDriver() {
        getWebDriver().quit();
    }
}
