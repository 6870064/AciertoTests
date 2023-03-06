package com.itechart.tests;

import com.itechart.base.BaseTest;
import io.github.dzmitryrak.enums.SortOrder;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class AciertoCallMeTest extends BaseTest {
    String amount = "90.000€";
    String period = "Anual";
    String gender = "Hombre";
    String dateOfBirth = "11/10/1967";
    String zipcode = "28012";
    String personalDataPage = "Fecha de nacimiento";

    @Test(description = "Click Call Me on the 1st step of the web funnel form (product is not selected)")
    public void acietroCallMeFirstPage() {
        String phone = getRandomPhone();
        String expectedPhone = String.format("+34%s", phone);
        aciertoPage.open()
                .callMeOnThisPhoneButtonClick(1)
                .isFunnelCallModalDisplayed();
        aciertoPage.enterPhoneFunnelCall(phone)
                .callMeOnThisPhoneButtonClick(2)
                .closeButtonClick()
                .closeCurrentWindow();
        loginPage.open()
                .login(USERNAME, PASSWORD);
        String caseNumber = listView.open("Case")
                .clickSwitcher()
                .selectFilter(selectFilterValue)
                .table()
                .sortBy(columnTitle, SortOrder.DESC)
                .getTextFromCell(columnTitle, 1);
        listView.table().clickCell(columnTitle, 1);
        aciertoPage.isPageOpened("Detalles");
        detailsPage.validate("Caso", caseNumber);
        detailsPage.clickTab(tabName);
        Map<String, String> userDetailsData = new HashMap<>() {
            {
                put("Correo electrónico Web", "");
                put("Teléfono del cliente", expectedPhone);
                put("Origen del caso", "Phone");
                put("Origen de la Llamada", "CTC Header");
                put("Caso principal", "");
                put("Nombre de la cuenta", "");
            }
        };
        detailsPage.validate(userDetailsData);
    }

    @Test(description = "Click Call Me on the 2nd step of web funnel form (product is not selected)")
    public void acietroCallMeSecondPage() {
        String phone = getRandomPhone();
        String expectedPhone = String.format("+34%s", phone);
        aciertoPage.open()
                .insuranceDetailsClick(amount)
                .insuranceDetailsClick(period)
                .clickContinueButton()
                .callMeOnThisPhoneButtonClick(1)
                .isFunnelCallModalDisplayed();
        aciertoPage.enterPhoneFunnelCall(phone)
                .callMeOnThisPhoneButtonClick(2)
                .closeButtonClick()
                .closeCurrentWindow();
        loginPage.open()
                .login(USERNAME, PASSWORD);
        listView.open("Case")
                .clickSwitcher()
                .selectFilter(selectFilterValue)
                .table()
                .sortBy(columnTitle, SortOrder.DESC)
                .clickCell(columnTitle, 1);
        detailsPage.clickTab(tabName);
        Map<String, String> userDetailsData = new HashMap<>() {
            {
                put("Correo electrónico Web", "");
                put("Teléfono del cliente", expectedPhone);
                put("Origen del caso", "Phone");
                put("Origen de la Llamada", "CTC Header");
                put("Caso principal", "");
                put("Nombre de la cuenta", "");
            }
        };
        detailsPage.validate(userDetailsData);
    }

    @Test(description = "Click Call Me on the 3d step of web funnel form (product is not selected)")
    public void acietroCallMeThirdPage() {
        String phone = getRandomPhone();
        String expectedPhone = String.format("+34%s", phone);
        aciertoPage.open()
                .insuranceDetailsClick(amount)
                .insuranceDetailsClick(period)
                .clickContinueButton()
                .setPersonData("birth-date", dateOfBirth)
                .insuranceDetailsClick(gender)
                .setPersonData("zip-code", zipcode)
                .clickContinueButton()
                .callMeOnThisPhoneButtonClick(1)
                .isFunnelCallModalDisplayed();
        aciertoPage.fillPhoneFunnelCall(phone)
                .closeCurrentWindow();
        loginPage.open()
                .login(USERNAME, PASSWORD);
        listView.open("Case")
                .clickSwitcher()
                .selectFilter(selectFilterValue)
                .table()
                .sortBy(columnTitle, SortOrder.DESC)
                .clickCell(columnTitle, 1);
        detailsPage.clickTab(tabName);
        Map<String, String> userDetailsData = new HashMap<>() {
            {
                put("Correo electrónico Web", "");
                put("Teléfono del cliente", expectedPhone);
                put("Origen del caso", "Phone");
                put("Origen de la Llamada", "CTC Header");
                put("Caso principal", "");
                put("Nombre de la cuenta", "");
            }
        };
        detailsPage.validate(userDetailsData);
    }

    @Test(description = "Click Call Me on the 4th step of the web funnel (where a result list is present), when product is not selected")
    public void acietroCallMe4PageNotProduct() {
        String phone = getRandomPhone();
        String expectedPhone = String.format("+34%s", phone);
        String email = getRandomEmail();
        aciertoPage.setPersonRecord(amount, period, personalDataPage, dateOfBirth, gender, zipcode, email, phone)
                .isPageOpened("Fallecimiento");
        aciertoPage.callMeOnThisPhoneButtonClick(1)
                .isFunnelCallModalDisplayed();
        aciertoPage.callMeOnThisPhoneButtonClick(2)
                .closeButtonClick()
                .closeCurrentWindow();
        loginPage.open()
                .login(USERNAME, PASSWORD);
        String caseNumber = listView.open("Case")
                .clickSwitcher()
                .selectFilter(selectFilterValue)
                .table()
                .sortBy(columnTitle, SortOrder.DESC)
                .getTextFromCell(columnTitle, 2);
        listView.table().clickCell(columnTitle, 1);
        detailsPage.clickTab(tabName);
        Map<String, String> userDetailsData = new HashMap<>() {
            {
                put("Correo electrónico Web", "");
                put("Teléfono del cliente", expectedPhone);
                put("Origen del caso", "Phone");
                put("Origen de la Llamada", "CTC result list No price card");
                put("Caso principal", caseNumber);
                put("Nombre de la cuenta", "");
            }
        };
        detailsPage.validate(userDetailsData);
    }

    @Test(description = "Click Call Me on the 4th step of the web funnel (where a result list is present), when product is selected")
    public void acietroCallMe4PageProduct() {
        String phone = getRandomPhone();
        String expectedPhone = String.format("+34%s", phone);
        String email = getRandomEmail();
        aciertoPage.setPersonRecord(amount, period, personalDataPage, dateOfBirth, gender, zipcode, email, phone)
                .imInterestedButtonClick(1)
                .isFunnelCallModalDisplayed();
        aciertoPage.callMeOnThisPhoneButtonClick(2)
                .closeButtonClick()
                .callMeOnThisPhoneButtonClick(1)
                .isFunnelCallModalDisplayed();
        aciertoPage.callMeOnThisPhoneButtonClick(2)
                .closeButtonClick()
                .closeCurrentWindow();
        loginPage.open()
                .login(USERNAME, PASSWORD);
        String caseNumber = listView.open("Case")
                .clickSwitcher()
                .selectFilter(selectFilterValue)
                .table()
                .sortBy(columnTitle, SortOrder.DESC)
                .getTextFromCell(columnTitle, 2);
        listView.table().clickCell(columnTitle, 1);
        detailsPage.clickTab(tabName);
        Map<String, String> userDetailsData = new HashMap<>() {
            {
                put("Correo electrónico Web", "");
                put("Teléfono del cliente", expectedPhone);
                put("Origen del caso", "Phone");
                put("Origen de la Llamada", "CTC result list No price card");
                put("Caso principal", caseNumber);
                put("Nombre de la cuenta", "");
            }
        };
        detailsPage.validate(userDetailsData);
    }

    @Test(description = "Click Call Me on product detail page")
    public void acietroCallMeDetailPage() {
        String phone = getRandomPhone();
        String expectedPhone = String.format("+34%s", phone);
        String email = getRandomEmail();
        aciertoPage.setPersonRecord(amount, period, personalDataPage, dateOfBirth, gender, zipcode, email, phone)
                .seeDetailsButtonClick(1)
                .callMeOnThisPhoneButtonClick(1)
                .isFunnelCallModalDisplayed();
        aciertoPage.callMeOnThisPhoneButtonClick(2)
                .closeButtonClick()
                .closeCurrentWindow();
        loginPage.open()
                .login(USERNAME, PASSWORD);
        String caseNumber = listView.open("Case")
                .clickSwitcher()
                .selectFilter(selectFilterValue)
                .table()
                .sortBy(columnTitle, SortOrder.DESC)
                .getTextFromCell(columnTitle, 2);
        listView.table().clickCell(columnTitle, 1);
        detailsPage.clickTab(tabName);
        Map<String, String> userDetailsData = new HashMap<>() {
            {
                put("Correo electrónico Web", "");
                put("Teléfono del cliente", expectedPhone);
                put("Origen del caso", "Phone");
                put("Origen de la Llamada", "CTC result list No price card");
                put("Caso principal", caseNumber);
                put("Nombre de la cuenta", "");
            }
        };
        detailsPage.validate(userDetailsData);
    }

    @Test(description = "Click Call Me on comparison detail page")
    public void acietroCallMeComparisonPage() {
        String phone = getRandomPhone();
        String expectedPhone = String.format("+34%s", phone);
        String email = getRandomEmail();
        aciertoPage.setPersonRecord(amount, period, personalDataPage, dateOfBirth, gender, zipcode, email, phone)
                .selectProduct(2)
                .comparisonButtonClick()
                .callMeOnThisPhoneButtonClick(1)
                .isFunnelCallModalDisplayed();
        aciertoPage.callMeOnThisPhoneButtonClick(2)
                .closeButtonClick()
                .closeCurrentWindow();
        loginPage.open()
                .login(USERNAME, PASSWORD);
        String caseNumber = listView.open("Case")
                .clickSwitcher()
                .selectFilter(selectFilterValue)
                .table()
                .sortBy(columnTitle, SortOrder.DESC)
                .getTextFromCell(columnTitle, 2);
        listView.table().clickCell(columnTitle, 1);
        detailsPage.clickTab(tabName);
        Map<String, String> userDetailsData = new HashMap<>() {
            {
                put("Correo electrónico Web", "");
                put("Teléfono del cliente", expectedPhone);
                put("Origen del caso", "Phone");
                put("Origen de la Llamada", "CTC result list No price card");
                put("Caso principal", caseNumber);
                put("Nombre de la cuenta", "");
            }
        };
        detailsPage.validate(userDetailsData);
    }
}
