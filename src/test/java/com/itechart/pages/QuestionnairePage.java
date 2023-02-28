package com.itechart.pages;

import com.codeborne.selenide.Selenide;
import io.github.dzmitryrak.pages.BasePage;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class QuestionnairePage extends BasePage {

    private static final String INPUT_LOCATOR = "//*[@name='%s']";
    private static final String DROPDOWN_LOCATOR = "//*[.//label[text()='%s']][@class='field-element']//input";
    private static final String DROPDOWN_VALUE_LOCATOR = "//*[.//label[text()='%s']][@class='field-element']//div[text()='%s']";
    private static final String OPTION_VALUE_LOCATOR = "//*[@name='%s']//option[@value='%s']";
    private static final String TEXT_LOCATOR = "//*[text()='%s']";
    private static final By NEXT_BUTTON = By.xpath("//button[text()='Siguiente']"); //Siguiente button
    private static final By NEXT_CHARTER_BUTTON = By.xpath("//button[text()='Next']");
    private static final By CALCULATE_BUTTON = By.xpath("//button[text()='Tarificar']");
    private static final String CHECKBOX_VALUE = "//*[text()='%s']";
    private static final String CHECKBOX_VALUE_LOCATOR = "//*[@name='%s' and @value='%s']";
    private static final String CHECKBOX_LOCATOR = "//*[text()= '%s']/ancestor::fieldset//input[@value='%s']";
    private static final By SAVE_DATA_BUTTON = By.xpath("//button[text()='GUARDAR DATOS']");
    private static final By BENEFICIARIES_FIELD_LOCATOR = By.xpath("//*[contains(@class, 'slds-textarea')]");
    private static final By RECALCULATE_BUTTON = By.xpath("//button[text()='Recalculate']");

    public QuestionnairePage openCase() {

        Selenide.open("https://bauerocp--staging.sandbox.lightning.force.com/lightning/r/Case/5001w00000AgKB0AAN/view");
        return this;
    }

    @Step("Entering {value} in {input} field")
    public QuestionnairePage setValue(String input, String value) {
        log.info("Entering {} in {} field", value, input);
        $(By.xpath(String.format(INPUT_LOCATOR, input))).setValue(value);
        return this;
    }

    @Step("Choosing {dropdownValue} from {fieldTitle")
    public QuestionnairePage clickDropdownValue(String dropdownTitle, String dropdownValue) {
        log.info("Click on {} dropdown", dropdownTitle);
        $(By.xpath(String.format(DROPDOWN_LOCATOR, dropdownTitle))).doubleClick();
        log.info("Click on {} dropdown value {}", dropdownTitle, dropdownValue);
        $(By.xpath(String.format(DROPDOWN_VALUE_LOCATOR, dropdownTitle, dropdownValue))).doubleClick();
        return this;
    }

    @Step("Choosing value from OptionDropdown list")
    public QuestionnairePage setOptionDropdownValue(String dropDownTitle, String dropdownValue) {
        log.info("Clicking on {} dropdown", dropDownTitle);
        $(By.xpath(String.format(INPUT_LOCATOR, dropDownTitle))).doubleClick();
        log.info("Clicking on {} dropdown value:", dropDownTitle);
        $(By.xpath(String.format(OPTION_VALUE_LOCATOR, dropDownTitle, dropdownValue))).doubleClick();
        return this;
    }

    @Step("Clicking on Charge Price button")
    public QuestionnairePage clickTarificarButton() {
        log.info("Clicking on Charge Price button");
        clickJS(CALCULATE_BUTTON);
        return this;
    }

    @Step("Clicking on Next button 'Siguiente'")
    public QuestionnairePage clickSiguienteButton() {
        log.info("Clicking on Next button 'Siguiente'");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clickJS(NEXT_BUTTON);
        return this;
    }

    @Step("Check thar Next button 'Siguiente' is displayed")
    public boolean isNextButtonDisplayed() {
        log.info("Check thar Next button 'Siguiente' is displayed");
        return $(NEXT_BUTTON).isDisplayed();
    }

    @Step("Clicking on Next Charter button")
    public QuestionnairePage clickNextButton() {
        log.info("Clicking on Next Charter button");
        clickJS(NEXT_CHARTER_BUTTON);
        return this;
    }

    @Step("Wait till price is calculating message is displaying")
    public QuestionnairePage isTextDisplayed(String text) {
        log.info("Wait till price is calculating message is displaying");
        $(By.xpath(String.format(TEXT_LOCATOR, text))).shouldBe(visible, Duration.ofSeconds(20));
        return this;
    }

    @Step("Clicking on checkbox with value {checkboxValue}")
    public QuestionnairePage clickCheckboxValue(String checkboxValue) {
        log.info("Clicking on checkbox with value {checkboxValue}");
        $(String.format(CHECKBOX_VALUE, checkboxValue)).click();
        return this;
    }

    @Step("Clicking on checkbox with name {checkboxName} and value {checkboxValue}")
    public QuestionnairePage clickCheckboxWithNameAndValue(String checkboxName, String checkboxValue) {
        log.info("Clicking on checkbox with name {checkboxName} and value {checkboxValue}");
        $(String.format(CHECKBOX_VALUE_LOCATOR, checkboxName, checkboxValue)).click();
        return this;
    }

    @Step("Clicking on checkbox with name {checkboxName} and value {checkboxValue}")
    public QuestionnairePage clickCheckbox(String checkboxName, String checkboxValue) {
        log.info("Clicking on checkbox with name {checkboxName} and value {checkboxValue}");
        $(String.format(CHECKBOX_LOCATOR, checkboxName, checkboxValue)).click();
        return this;
    }

    @Step("Check that SAVE DATA button [GUARDAR DATOS] is displayed")
    public boolean isSafeDataButtonDisplayed() {
        log.info("Check that SAVE DATA button [GUARDAR DATOS] is displayed");
        return $(SAVE_DATA_BUTTON).isDisplayed();
    }

    @Step("Entering '{value}' in 'Beneficiaries' field")
    public QuestionnairePage setBeneficiariesValue(String value) {
        log.info("Entering '{value}' in 'Beneficiaries' field");
        $(BENEFICIARIES_FIELD_LOCATOR).setValue(value);
        return this;
    }

    @Step("Clicking on SAVE DATA button [GUARDAR DATOS]")
    public QuestionnairePage clickSaveDataButton() {
        log.info("Clicking on SAVE DATA button [GUARDAR DATOS]");
        $(SAVE_DATA_BUTTON).click();
        return this;
    }

    @Step("Wait till [Recalculate] button is displayed")
    public QuestionnairePage isRecalculateButtonDisplayed() {
        log.info("Wait till [Recalculate] button is displayed");
        $(RECALCULATE_BUTTON).shouldBe(visible, Duration.ofSeconds(15));
        return this;
    }

    @Step("Clicking on [Recalculate] button")
    public QuestionnairePage clickRecalculateButton() {
        log.info("Clicking on [Recalculate] button");
        $(RECALCULATE_BUTTON).click();
        return this;
    }
}
