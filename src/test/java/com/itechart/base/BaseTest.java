package com.itechart.base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import com.itechart.pages.AciertoPage;
import com.itechart.pages.CaseDetailsPage;
import com.itechart.pages.QuestionnairePage;
import com.itechart.utils.PropertyReader;
import io.github.dzmitryrak.pages.*;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Log4j2
@Listeners(TestListener.class)
public abstract class BaseTest {
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected DetailsPage detailsPage;
    protected ListView listView;
    protected NewObjectModal newObjectModal;
    protected AciertoPage aciertoPage;
    protected CaseDetailsPage caseDetailsPage;
    protected QuestionnairePage questionnairePage;
    protected PropertyReader propertyReader = new PropertyReader("src/test/resources/configuration.properties");
    protected final String USERNAME = System.getProperty("username", propertyReader.getPropertyValueByKey("username"));
    protected final String PASSWORD = System.getProperty("password", propertyReader.getPropertyValueByKey("password"));
    public String tabName = "Detalles";
    public String selectFilterValue = "Cases Created Today";
    public String columnTitle = "Número del caso";

    @BeforeMethod(description = "Open browser")
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .includeSelenideSteps(false)
                .savePageSource(false));
        Configuration.baseUrl = propertyReader.getPropertyValueByKey("base.url");
        Configuration.timeout = 7000;
        Configuration.browser = "chrome";
        BasePage.timeout = Duration.ofSeconds(30L);
        Configuration.pageLoadTimeout = 4000000;

        var options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        if (propertyReader.getPropertyValueByKey("headless").equals("true")) {
            options.addArguments("--headless");
        }

        Configuration.browserCapabilities = options;
        open();
        getWebDriver().manage().window().maximize();

        loginPage = new LoginPage();
        homePage = new HomePage();
        detailsPage = new DetailsPage();
        listView = new ListView();
        newObjectModal = new NewObjectModal();
        aciertoPage = new AciertoPage();
        caseDetailsPage = new CaseDetailsPage();
        questionnairePage = new QuestionnairePage();

    }

    @AfterMethod(alwaysRun = true, description = "Close browser")
    public void tearDown() {
        try {
            getWebDriver().quit();
        } catch (IllegalStateException ex) {
            log.warn("Unable to close WebDriver. Make sure that driver is initialized");
            log.warn(ex.getMessage());
            log.debug(ex.getStackTrace());
        }
    }

    public String getRandomPhone() {
        String phone = String.format("92%03d%04d",
                (int) Math.floor(999 * Math.random()),
                (int) Math.floor(9999 * Math.random()));
        return phone;
    }

    public String getRandomEmail() {
        String email = new Faker().internet().emailAddress();
        return email;
    }
}
