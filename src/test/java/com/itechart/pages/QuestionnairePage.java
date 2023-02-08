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

    private static final By ACTUAL_PRICE_LOCATOR = By.xpath("//span[text() ='Tarificación Real']");
    private static final String INPUT_LOCATOR = "//*[@name='%s']";
    private static final String DROPDOWN_LOCATOR = "(//*[contains(@class, 'slds-input slds-combobox__input slds-combobox__input-value')])[%s]";
    private static final String DROPDOWN_VALUE_LOCATOR = "(//*[contains(@class, 'slds-media slds-media_center slds-p-around_xx-small')][%s]";
    private static final String FRACCIONAMIENTO_VALUE_LOCATOR = "(//*[@name='%s']//option)[%s]";
    private static final String FALLECIMIENTO_VALUE_LOCATOR =  "//*[@name='%s']//span";
    private static final By INFO_TEXT_LOCATOR = By.xpath("//*[text()='Se está calculando el precio. Por favor, espere unos segundos.']");



    private static final By CALCULATE_BUTTON = By.xpath("//button[text()='Tarificar'])[1]");

    public QuestionnairePage openCase() {

        Selenide.open("https://bauerocp--staging.sandbox.lightning.force.com/lightning/r/Case/5001w00000AgKB0AAN/view");
        return this;
    }

    @Step("Check that the Page with options for insurance services is opened")
    public QuestionnairePage isQuestionnairePageOpened() {
        log.info("The page with options for insurance services is opened");
        $(ACTUAL_PRICE_LOCATOR).shouldBe(visible, Duration.ofSeconds(5));
        return this;
    }

    @Step("Entering '{value}' in {input} field")
    public QuestionnairePage setValue(String input, String value) {
        log.info("Entering '{value}' in {input} field");
        $(String.format(INPUT_LOCATOR, input)).setValue(value);
        return this;
    }

    @Step("Choosing value from dropdown list")
    public QuestionnairePage setDropdownValue(int fieldIndex, int dropdownValueIndex) {
        log.info("Choosing value from dropdown list");
        $(String.format(DROPDOWN_LOCATOR, fieldIndex)).click();
        $(String.format(DROPDOWN_VALUE_LOCATOR,dropdownValueIndex)).shouldBe(visible);
        $(String.format(DROPDOWN_VALUE_LOCATOR,dropdownValueIndex)).click();
        return this;
    }

    @Step("Choosing value from FraccionamientoDropdown field list")
    public QuestionnairePage setFraccionamientoDropdownValue(String dropDownTitle, int dropdownValueIndex) {
        log.info("Choosing value from Fraccionamiento dropdown list");
        $(String.format(INPUT_LOCATOR, dropDownTitle)).click();
        $(String.format(FRACCIONAMIENTO_VALUE_LOCATOR, dropdownValueIndex)).shouldBe(visible);
        $(String.format(FRACCIONAMIENTO_VALUE_LOCATOR, dropdownValueIndex)).click();
        return this;
    }

    @Step("Choosing value from FallecimientoDropdown field list")
    public QuestionnairePage setFallecimientoDropdownValue(String dropDownTitle) {
        log.info("Choosing value from Fallecimiento dropdown list");
        $(String.format(INPUT_LOCATOR, dropDownTitle)).click();
        $(String.format(FALLECIMIENTO_VALUE_LOCATOR, dropDownTitle)).shouldBe(visible);
        $(String.format(FALLECIMIENTO_VALUE_LOCATOR, dropDownTitle)).click();
        return this;
    }


    @Step("Clicking on Charge Price button")
    public QuestionnairePage clickChargePriceButton() {
        log.info("Clicking on Charge Price button");
        $(CALCULATE_BUTTON).click();
        return this;
    }
}
