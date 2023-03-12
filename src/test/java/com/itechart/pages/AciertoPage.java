package com.itechart.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.github.dzmitryrak.pages.BasePage;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class AciertoPage extends BasePage {
    private final String ACIERTO_URL = "https://stg.acierto.com/seguros-vida/comparador/";
    private static final String TEXT_INFO_LOCATOR = "//*[text()='%s']";
    private static final String INSURANCE_DETAILS_CHECKBOX_LOCATOR = "//span[text()='%s']/../..";
    private static final String DATA_GTM_LOCATOR = "[data-gtm=%s]";
    private static final String DATAGTM_LOCATOR = "[datagtm='%s']";
    private static final By SIGUIENTE_BUTTON = By.xpath("//button[@datagtm='continue']");
    private static final By CONFIRM_CHECKBOX = By.xpath("//input[@datagtm='auth-info-comercial']");
    private static final String DETAIL_BUTTON = "(//span[text()='Ver detalles']/ancestor::button)[%s]";
    private static final String IM_INTERESTED_BUTTON = "(//button[text()='Que me llamen'])[%s]";
    private static final String WE_CALL_YOU_FREE_BUTTON = "(//span[text() = 'Te llamamos gratis'])[%s]";
    private static final By LIFE_INSURANCE_LABEL = By.xpath("//*[text() ='Seguro de vida']");
    private static final By FINAL_MODAL_LOCATOR = By.xpath("//*[contains(@class, 'funnel-call-to-me-modal__user-number')]");
    private static final By FUNNEL_CALL_MODAL = By.xpath("//*[contains(@class, 'funnel-call-to-me-modal__content')]");
    private static final By CALL_ME_ON_THIS_PHONE_BUTTON = By.xpath("//button[contains(@data-gtm, 'call-me')]");
    private static final By THANKS_YOU_MODAL = By.xpath("//*[contains(@class, 'message-modal__text-title')]");
    private static final By CLOSE_BUTTON = By.xpath("//button//span[text()='Cerrar']");
    private static final By FUNNEL_CALL_PHONE = By.xpath("//form//input[@data-gtm='phone']");
    private static final By FUNNEL_CALL_AGREEMENT = By.xpath("//input[@data-gtm='auth-info-comercial']//ancestor::div[contains(@class,'checkbox')]");
    String checkbox = "(//label[@class='checkbox']//input)[%s]";
    String comparisonButton = "//span[contains(text(),'%s')]/ancestor::button";

    @Step("Open Acierto Main Page")
    public AciertoPage open() {
        log.info("Opening Acierto Main page");
        Selenide.open(ACIERTO_URL);
        return this;
    }

    @Step("Choose insurance details")
    public AciertoPage clickInsuranceDetailsCheckbox(String locator) {
        log.info(String.format("Choosing %s as data for filling for and clicking on it", locator));
        $(By.xpath(String.format(INSURANCE_DETAILS_CHECKBOX_LOCATOR, locator))).doubleClick();
       //;' Selenide.executeJavaScript("arguments[0].click();", $(By.xpath(String.format(INSURANCE_DETAILS_CHECKBOX_LOCATOR, locator))));
       // $(By.xpath(String.format(TEXT_INFO_LOCATOR, locator))).click(ClickOptions.usingJavaScript());
        return this;
    }

    @Step("Click continue button")
    public AciertoPage clickContinueButton() {
        log.info("Clicking on continue button");
        Selenide.executeJavaScript("arguments[0].click();", $(SIGUIENTE_BUTTON));
        return this;
    }

    @Step("Click confirm checkbox")
    public AciertoPage clickConfirmCheckbox() {
        log.info("Clicking on continue button");
        Selenide.executeJavaScript("arguments[0].click();", $(CONFIRM_CHECKBOX));
        return this;
    }

    @Step("Filling the field {locator} with data {data}")
    public AciertoPage setPersonData(String locator, String data) {
        log.info(String.format("Filling %s field with data %s", locator, data));
        $((String.format(DATA_GTM_LOCATOR, locator))).setValue(data);
        return this;
    }

    @Step("Filling the field {locator} with data {data}")
    public AciertoPage setPersonGtmLocatorData(String locator, String data) {
        log.info(String.format("Filling %s field with data %s", locator, data));
        $((String.format(DATAGTM_LOCATOR, locator))).setValue(data);
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
        $(By.xpath(String.format(TEXT_INFO_LOCATOR, data))).shouldBe(exist, Duration.ofSeconds(30));
        return this;
    }

    @Step("Click on [I'm Interested] button with the index {index}")
    public AciertoPage imInterestedButtonClick(int index) {
        $(By.xpath(String.format(IM_INTERESTED_BUTTON, 1))).shouldBe(visible, Duration.ofSeconds(30));
        Selenide.executeJavaScript("arguments[0].click();", $(By.xpath(String.format(IM_INTERESTED_BUTTON, index))));
        return this;
    }

    @Step("Click on [We call you fo free] button with the index {index}")
    public AciertoPage weCallYouForFreeButton(int index) {
        $(By.xpath(String.format(IM_INTERESTED_BUTTON, 1))).shouldBe(visible, Duration.ofSeconds(30));
        Selenide.executeJavaScript("arguments[0].click();", $(By.xpath(String.format(WE_CALL_YOU_FREE_BUTTON, index))));
        return this;
    }

    @Step("Click on the button [See details] bith the index {index}")
    public AciertoPage seeDetailsButtonClick(int index) {
        log.info("Click on I'm interested button with {} index", index);
        $(By.xpath(String.format(DETAIL_BUTTON, index))).shouldBe(visible, Duration.ofSeconds(30)).click();
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
    public AciertoPage callMeOnThisPhoneButtonClick() {
        log.info("Click on [Call Me On This Phone] button");
        $(CALL_ME_ON_THIS_PHONE_BUTTON).shouldBe(visible, Duration.ofSeconds(30)).click();
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
    public AciertoPage setPersonRecord(String amount, String period, String personalData, String dateOfBirth, String gender,
                                       String zipcode, String email, String phone) {
        log.info("Creation of an insurance record");
        open();
        clickInsuranceDetailsCheckbox(amount);
        clickInsuranceDetailsCheckbox(period);
        clickContinueButton();
        isPageOpened(personalData);
        setPersonData("birth-date", dateOfBirth);
        clickInsuranceDetailsCheckbox(gender);
        setPersonData("zip-code", zipcode);
        clickContinueButton();
        setPersonGtmLocatorData("email", email);
        setPersonGtmLocatorData("phone", phone);
        clickContinueButton();
        clickConfirmCheckbox();
        isLifeInsurancePageOpened();
        return this;
    }

    @Step
    public boolean isFunnelCallModalDisplayed() {
        return $(FUNNEL_CALL_MODAL).isDisplayed();
    }

    @Step
    public AciertoPage enterPhoneFunnelCall(String phone) {
        log.info("Enter phone: {}", phone);
        setPersonData("phone", phone);
        $(FUNNEL_CALL_AGREEMENT).click();
        return this;
    }

    @Step
    public AciertoPage fillPhoneFunnelCall(String phone) {
        log.info("Enter phone: {}", phone);
        $(FUNNEL_CALL_PHONE).setValue(phone);
        try {
            callMeOnThisPhoneButtonClick();
            closeButtonClick();
        } catch (Throwable e) {
            log.info("CallMe button is grey ");
            $(FUNNEL_CALL_PHONE).setValue(phone);
            callMeOnThisPhoneButtonClick();
            closeButtonClick();
        }
        return this;
    }

    @Step("Select {index} record")
    public AciertoPage selectProduct(int index) {
        $(By.xpath(String.format(checkbox, 1))).shouldBe(exist, Duration.ofSeconds(30));
        for (int i = 1; i <= index; i++) {
            SelenideElement ch = $(By.xpath(String.format(checkbox, i)));
            Selenide.executeJavaScript("arguments[0].click();", ch);
        }
        return this;
    }

    @Step("Click [Comparar] button")
    public AciertoPage comparisonButtonClick() {
        $(By.xpath(String.format(comparisonButton, "Comparar"))).click();
        return this;
    }
}
