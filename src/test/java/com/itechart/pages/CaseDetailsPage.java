package com.itechart.pages;

import com.codeborne.selenide.ClickOptions;
import io.github.dzmitryrak.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CaseDetailsPage extends BasePage {
    private final String BUTTON_LOCATOR = ACTIVE_TAB_LOCATOR + "//button[@title='%s']";

    //TO DO: Delete when detailPage.waitTillOpened is fixed
    @Step("Check that Details page was opened")
    public void waitTillOpened(String tabTitle) {
        $(By.xpath(String.format("//*[contains(@class,'windowViewMode') and contains(@class,'active')]//a[@data-label='%s']", tabTitle))).shouldBe(visible, Duration.ofSeconds(20L));
    }

    public void clickOnButton(String buttonName) {
        $(By.xpath(String.format(BUTTON_LOCATOR, buttonName))).shouldBe(interactable, Duration.ofSeconds(20L)).click(ClickOptions.usingJavaScript());
    }

    public void waitAlertDialog(String text) {
        $(By.xpath(String.format("//div[@role='alertdialog']//div[contains(text(),'%s')]", text))).shouldBe(visible, Duration.ofSeconds(20L));
    }
}
