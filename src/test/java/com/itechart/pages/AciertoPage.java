package com.itechart.pages;

import com.codeborne.selenide.Selenide;
import io.github.dzmitryrak.pages.BasePage;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.Random;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

@Log4j2
public class AciertoPage extends BasePage {

    private final String ACIERTO_URL = "https://stg.acierto.com/seguros-vida/comparador/";
    private static final String TEXT_INFO_LOCATOR = "//*[text()='%s']";
    private static final String DATA_LOCATOR = "[data-gtm=%s]";
    private static final String IM_INTERESTED_BUTTON = "(//*[contains(@class, 'it-btn it-btn--block it-btn--button-44 it-btn--primary large-card__button')])[%s]";
    private static final String WE_CALL_YOU_FREE_BUTTON = "(//*[contains(@class, 'it-btn it-btn--button-44 it-btn--primary mb-3')])[%s]";
    private static final By LIFE_INSURANCE_LABEL = By.xpath("//*[text() ='Seguro de vida']");
    private static final By FINAL_MODAL_LOCATOR = By.xpath("//*[contains(@class, 'funnel-call-to-me-modal__user-number')]");
    private static final By FUNNEL_CALL_MODAL = By.xpath("//*[contains(@class, 'funnel-call-to-me-modal__content')]");
    private static final String CALL_ME_ON_THIS_PHONE_BUTTON = "(//button[contains(@data-gtm, 'call-me')])[%s]";
    private static final By THANKS_YOU_MODAL = By.xpath("//*[contains(@class, 'message-modal__text-title')]");
    private static final By CLOSE_BUTTON = By.xpath("//button//span[text()='Cerrar']");
    private static final By FUNNEL_CALL_PHONE = By.xpath("//input[@data-gtm='phone']");
    private static By FUNNEL_CALL_AGREEMENT = By.xpath("//input[@data-gtm='auth-info-comercial']//ancestor::div[contains(@class,'checkbox')]");

    @Step("Open Acierto Main Page")
    public AciertoPage open() {
        log.info("Opening Acierto Main page");
        Selenide.open(ACIERTO_URL);
        return this;
    }

    @Step("Choose insurance details")
    public AciertoPage insuranceDetailsClick(String locator){
        log.info(String.format("Choosing %s as data for filling for and clicking on it", locator));
        $(By.xpath(String.format(TEXT_INFO_LOCATOR, locator))).click();
        return this;
    }

    @Step("Click continue button")
    public AciertoPage clickContinueButton() {
        log.info("Clicking on continue button");
        Selenide.executeJavaScript("arguments[0].click();", $((String.format(DATA_LOCATOR, "continue"))));
        return this;
    }

    @Step("Filling the field {locator} with data {data}")
    public AciertoPage setPersonData(String locator, String data) {
        log.info(String.format("Filling %s field with data %s", locator, data));
        $((String.format(DATA_LOCATOR, locator))).setValue(data);
        return this;
    }

    @Step("Check that the Page with options for insurance services is opened")
    public AciertoPage isLifeInsurancePageOpened() {
        log.info("The page with options for insurance services is opened");
        $(LIFE_INSURANCE_LABEL).shouldBe(visible, Duration.ofSeconds(30));
        return this;
    }

    @Step("Check that the page with the text {data} is opened")
    public AciertoPage isPageOpened(String data) {
      log.info("Checking that personal data page is opened");
        $(By.xpath(String.format(TEXT_INFO_LOCATOR, data))).shouldBe(visible, Duration.ofSeconds(10));
        return this;
    }

    @Step("Click on [I'm Interested] button with the index {index}")
    public AciertoPage imInterestedButtonClick(int index) {
        $(By.xpath(String.format(IM_INTERESTED_BUTTON, 1))).shouldBe(visible, Duration.ofSeconds(30));
        Selenide.executeJavaScript("arguments[0].click();",$(By.xpath(String.format(IM_INTERESTED_BUTTON, index))));
        return this;
    }

    @Step("Click on [We call you fo free] button with the index {index}")
    public AciertoPage weCallYouForFreeButton(int index) {
        $(By.xpath(String.format(IM_INTERESTED_BUTTON, 1))).shouldBe(visible, Duration.ofSeconds(30));
        Selenide.executeJavaScript("arguments[0].click();",$(By.xpath(String.format(WE_CALL_YOU_FREE_BUTTON, index))));
        return this;
    }

    @Step("Closing window acierto to avoid displaying pop up 'Leave the page'")
    public AciertoPage closeCurrentWindow() {
        log.info("Closing window acierto to avoid displaying pop up 'Leave the page'");
        Selenide.closeWindow();
        return this;
    }

    @Step
    public boolean isFinalModalDisplayed() {
        return $(FINAL_MODAL_LOCATOR).isDisplayed();
    }

    @Step
    public AciertoPage callMeOnThisPhoneButtonClick(int indexButton) {
        log.info("Click on [Call Me On This Phone] button");
        $(By.xpath(String.format(CALL_ME_ON_THIS_PHONE_BUTTON,indexButton))).click();
        return this;
    }

    @Step("Check that grateful Modal is displayed")
    public boolean isGratitudeModalDisplayed() {
        log.info("Gratitude Modal is displayed");
        return $(THANKS_YOU_MODAL).isDisplayed();
    }

    @Step("Click on [Close] button on Grateful modal")
    public AciertoPage closeButtonClick() {
        log.info("Click on [Close] button on Grateful modal");
        $(CLOSE_BUTTON).click();
        return this;
    }

    @Step("Setting person's data for creation the record")
    public AciertoPage setPersonRecord(String amount, String period, String personalData, String dateOfBirth,String gender,
                                       String zipcode, String email, String phone) {
        log.info("Creation of an insurance record");
        open();
        insuranceDetailsClick(amount);
        insuranceDetailsClick(period);
        clickContinueButton();
        isPageOpened(personalData);
        setPersonData("birth-date",dateOfBirth);
        insuranceDetailsClick(gender);
        setPersonData("zip-code", zipcode);
        clickContinueButton();
        setPersonData("email", email);
        setPersonData("phone", phone);
        clickContinueButton();
        isLifeInsurancePageOpened();
        return this;
    }

    @Step
    public boolean isFunnelCallModalDisplayed() {
        return $(FUNNEL_CALL_MODAL).isDisplayed();
    }

    @Step
    public AciertoPage enterPhoneFunnelCall(String phone){
        $(FUNNEL_CALL_PHONE).setValue(phone);
        $(FUNNEL_CALL_AGREEMENT).click();
        return this;
    }
}
