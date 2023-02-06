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
    //input[@name='Fecha_de_efecto']

    public QuestionnairePage openCase() {

        Selenide.open("https://bauerocp--staging.sandbox.lightning.force.com/lightning/r/Case/5001w00000Ag8AsAAJ/view");
        return this;
    }

    @Step("Check that the Page with options for insurance services is opened")
    public QuestionnairePage isQuestionnairePageOpened() {
        log.info("The page with options for insurance services is opened");
        $(ACTUAL_PRICE_LOCATOR).shouldBe(visible, Duration.ofSeconds(5));
        return this;
    }
}
