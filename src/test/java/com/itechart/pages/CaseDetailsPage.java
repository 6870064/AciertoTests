package com.itechart.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.github.dzmitryrak.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.time.Duration;

public class CaseDetailsPage extends BasePage {

    //TO DO: Delete when detailPage.waitTillOpened is fixed
    @Step("Check that Details page was opened")
    public static void waitTillOpened(String tabTitle) {
        Selenide.$(By.xpath(String.format("//*[contains(@class,'windowViewMode') and contains(@class,'active')]//a[@data-label='%s']", tabTitle))).shouldBe(Condition.visible, Duration.ofSeconds(20L));
    }
}
