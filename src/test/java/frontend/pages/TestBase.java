package frontend.pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import frontend.helper.ApplicationManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager();

    @BeforeClass(groups = {"ThirdTest"})
    public void startUpForGroups() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
        Configuration.startMaximized = true;
        Configuration.timeout = 5000;
        open("https://www.wildberries.ru");
    }

    @AfterClass(groups = {"ThirdTest"})
    public void tearDownForGroups() {
        closeWebDriver();
    }

    @BeforeMethod
    public void startUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
        Configuration.startMaximized = true;
        Configuration.timeout = 5000;
        open("https://www.wildberries.ru");
    }

    @AfterMethod
    public void tearDown() {
        closeWebDriver();
    }
}
