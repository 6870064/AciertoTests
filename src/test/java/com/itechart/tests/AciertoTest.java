package com.itechart.tests;

import com.itechart.base.BaseTest;
import io.github.dzmitryrak.enums.SortOrder;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class AciertoTest extends BaseTest {

    @Test(description = "Creation of the insurance record")
    public void aciertoTest() {
        String email = getRandomEmail();
        String phone = getRandomPhone();
        aciertoPage.setPersonRecord(insuranceAmount, insurancePeriod, personalDataPage, DateOfBirth, personGender, zipcode, email, phone)
                .imInterestedButtonClick(1)
                .isFinalModalDisplayed();
        aciertoPage.callMeOnThisPhoneButtonClick(2)
                .isGratitudeModalDisplayed();
        aciertoPage.closeButtonClick()
                .isLifeInsurancePageOpened();
        aciertoPage.closeCurrentWindow();
    }

    @Test(description = "Creation of the insurance record")
    public void aciertoWeCallYouFreeTest() {
        String email = getRandomEmail();
        String phone = getRandomPhone();
        aciertoPage.setPersonRecord(insuranceAmount, insurancePeriod, personalDataPage, DateOfBirth, personGender, zipcode, email, phone)
                .weCallYouForFreeButton(1)
                .isFinalModalDisplayed();
        aciertoPage.callMeOnThisPhoneButtonClick(2)
                .isGratitudeModalDisplayed();
        aciertoPage.closeButtonClick()
                .isLifeInsurancePageOpened();
        aciertoPage.closeCurrentWindow();
    }

    @Test(description = "Creation of the insurance record with provider AsisaVida and validation it in Salesforce")
    public void aciertoTestAxaVidaProtecValidation() {
        String email = getRandomEmail();
        String phone = getRandomPhone();
        String expectedPhone = String.format("+34%s", phone);
        aciertoPage.setPersonRecord(insuranceAmount, insurancePeriod, personalDataPage, DateOfBirth, personGender, zipcode, email, phone)
                .imInterestedButtonClick(1)
                .isFinalModalDisplayed();
        aciertoPage.callMeOnThisPhoneButtonClick(2)
                .isGratitudeModalDisplayed();
        aciertoPage.closeButtonClick()
                .isLifeInsurancePageOpened();
        aciertoPage.closeCurrentWindow();
        loginPage.open();
        loginPage.login(USERNAME, PASSWORD);
        homePage.isPageOpened();
        listView.open("Case")
                .clickSwitcher()
                .selectFilter(selectFilterValue)
                .table()
                .sortBy(columnTitle, SortOrder.DESC)
                .clickCell(columnNameOwner, 1);
        detailsPage.clickTab(tabName);
        caseDetailsPage.waitTillOpened(tabName);
        Map<String, String> userDetailsData = new HashMap<>() {
            {
                put("Correo electrónico Web", email);
                put("Teléfono del cliente", expectedPhone);
            }
        };
        //TODO раскомментировать после фикса методов валидиции полей
//        detailsPage.validate(userDetailsData);
//        Map<String, String> userProductData = new HashMap<>() {
//            {
//                put("Pago de frecuencia", NEW_INSURANCE_PERIOD);
//                put("Cantidad de capital", NEW_INSURANCE_AMOUNT);
//                put("Nombre del producto", companiesArray[0]);
//            }
//        };
//        detailsPage.panels().panel("Detalle de Cuenta").validate("Teléfono", expectedPhone);
//        detailsPage.panels().panel("Oportunidad y Producto").validate(userProductData);
    }

    @Test(description = "Creation of the insurance record with provider 'Axa Vida Protec' and validation it in Salesforce")
    public void aciertoTestAsisaVidaValidation() {
        String email = getRandomEmail();
        String phone = getRandomPhone();
        String expectedPhone = String.format("+34%s", phone);
        aciertoPage.setPersonRecord(insuranceAmount, insurancePeriod, personalDataPage, DateOfBirth, personGender, zipcode, email, phone)
                .imInterestedButtonClick(2)
                .isFinalModalDisplayed();
        aciertoPage.callMeOnThisPhoneButtonClick(2)
                .isGratitudeModalDisplayed();
        aciertoPage.closeButtonClick()
                .isLifeInsurancePageOpened();
        aciertoPage.closeCurrentWindow();
        loginPage.open();
        loginPage.login(USERNAME, PASSWORD);
        homePage.isPageOpened();
        listView.open("Case")
                .clickSwitcher()
                .selectFilter(selectFilterValue)
                .table()
                .sortBy(columnTitle, SortOrder.DESC)
                .clickCell(columnNameOwner, 1);
        detailsPage.clickTab(tabName);
        caseDetailsPage.waitTillOpened(tabName);
        Map<String, String> userDetailsData = new HashMap<>() {
            {
                put("Correo electrónico Web", email);
                put("Teléfono del cliente", expectedPhone);
            }
        };
        //TODO раскомментировать после фикса методов валидиции полей
//        detailsPage.validate(userDetailsData);
//        Map<String, String> userProductData = new HashMap<>() {
//            {
//                put("Pago de frecuencia", NEW_INSURANCE_PERIOD);
//                put("Cantidad de capital", NEW_INSURANCE_AMOUNT);
//                put("Nombre del producto", companiesArray[1]);
//            }
//        };
//        detailsPage.panels().panel("Detalle de Cuenta").validate("Teléfono", expectedPhone);
//        detailsPage.panels().panel("Oportunidad y Producto").validate(userProductData);
    }

    @Test(description = "Creation of the insurance record with provider 'Santalucía Vida' and validation it in Salesforce")
    public void aciertoTestCreditAndorraLifeVidaValidation() {
        String email = getRandomEmail();
        String phone = getRandomPhone();
        String expectedPhone = String.format("+34%s", phone);
        aciertoPage.setPersonRecord(insuranceAmount, insurancePeriod, personalDataPage, DateOfBirth, personGender, zipcode, email, phone)
                .imInterestedButtonClick(3)
                .isFinalModalDisplayed();
        aciertoPage.callMeOnThisPhoneButtonClick(2)
                .isGratitudeModalDisplayed();
        aciertoPage.closeButtonClick()
                .isLifeInsurancePageOpened();
        aciertoPage.closeCurrentWindow();
        loginPage.open();
        loginPage.login(USERNAME, PASSWORD);
        homePage.isPageOpened();
        listView.open("Case")
                .clickSwitcher()
                .selectFilter(selectFilterValue)
                .table()
                .sortBy(columnTitle, SortOrder.DESC)
                .clickCell(columnNameOwner, 1);
        detailsPage.clickTab(tabName);
        caseDetailsPage.waitTillOpened(tabName);
        Map<String, String> userDetailsData = new HashMap<>() {
            {
                put("Correo electrónico Web", email);
                put("Teléfono del cliente", expectedPhone);
            }
        };
        //TODO раскомментировать после фикса методов валидиции полей
//        detailsPage.validate(userDetailsData);
//        Map<String, String> userProductData = new HashMap<>() {
//            {
//                put("Pago de frecuencia", NEW_INSURANCE_PERIOD);
//                put("Cantidad de capital", NEW_INSURANCE_AMOUNT);
//                put("Nombre del producto", companiesArray[2]);
//            }
//        };
//        detailsPage.panels().panel("Detalle de Cuenta").validate("Teléfono", expectedPhone);
//        detailsPage.panels().panel("Oportunidad y Producto").validate(userProductData);
    }

    @Test(description = "Creation of the insurance record with provider 'FIATC Vida' and validation it in Salesforce")
    public void aciertoTestZurichVidaValidation() {
        String email = getRandomEmail();
        String phone = getRandomPhone();
        String expectedPhone = String.format("+34%s", phone);
        aciertoPage.setPersonRecord(insuranceAmount, insurancePeriod, personalDataPage, DateOfBirth, personGender, zipcode, email, phone)
                .imInterestedButtonClick(4)
                .isFinalModalDisplayed();
        aciertoPage.callMeOnThisPhoneButtonClick(2)
                .isGratitudeModalDisplayed();
        aciertoPage.closeButtonClick()
                .isLifeInsurancePageOpened();
        aciertoPage.closeCurrentWindow();
        loginPage.open();
        loginPage.login(USERNAME, PASSWORD);
        homePage.isPageOpened();
        listView.open("Case")
                .clickSwitcher()
                .selectFilter(selectFilterValue)
                .table()
                .sortBy(columnTitle, SortOrder.DESC)
                .clickCell(columnNameOwner, 1);
        detailsPage.clickTab(tabName);
        caseDetailsPage.waitTillOpened(tabName);
        Map<String, String> userDetailsData = new HashMap<>() {
            {
                put("Correo electrónico Web", email);
                put("Teléfono del cliente", expectedPhone);
            }
        };
        //TODO раскомментировать после фикса методов валидиции полей
//        detailsPage.validate(userDetailsData);
//        Map<String, String> userProductData = new HashMap<>() {
//            {
//                put("Pago de frecuencia", NEW_INSURANCE_PERIOD);
//                put("Cantidad de capital", NEW_INSURANCE_AMOUNT);
//                put("Nombre del producto", companiesArray[3]);
//            }
//        };
//        detailsPage.panels().panel("Detalle de Cuenta").validate("Teléfono", expectedPhone);
//        detailsPage.panels().panel("Oportunidad y Producto").validate(userProductData);
    }

    @Test(description = "Creation of the insurance record with provider 'Credit Andorra Life' and validation it in Salesforce")
    public void aciertoTestFIATCVidaValidation() {
        String email = getRandomEmail();
        String phone = getRandomPhone();
        String expectedPhone = String.format("+34%s", phone);
        aciertoPage.setPersonRecord(insuranceAmount, insurancePeriod, personalDataPage, DateOfBirth, personGender, zipcode, email, phone)
                .imInterestedButtonClick(5)
                .isFinalModalDisplayed();
        aciertoPage.callMeOnThisPhoneButtonClick(2)
                .isGratitudeModalDisplayed();
        aciertoPage.closeButtonClick()
                .isLifeInsurancePageOpened();
        aciertoPage.closeCurrentWindow();
        loginPage.open();
        loginPage.login(USERNAME, PASSWORD);
        homePage.isPageOpened();
        listView.open("Case")
                .clickSwitcher()
                .selectFilter(selectFilterValue)
                .table()
                .sortBy(columnTitle, SortOrder.DESC)
                .clickCell(columnNameOwner, 1);
        detailsPage.clickTab(tabName);
        caseDetailsPage.waitTillOpened(tabName);
        Map<String, String> userDetailsData = new HashMap<>() {
            {
                put("Correo electrónico Web", email);
                put("Teléfono del cliente", expectedPhone);
            }
        };
        //TODO раскомментировать после фикса методов валидиции полей
//        detailsPage.validate(userDetailsData);
//        Map<String, String> userProductData = new HashMap<>() {
//            {
//                put("Pago de frecuencia", NEW_INSURANCE_PERIOD);
//                put("Cantidad de capital", NEW_INSURANCE_AMOUNT);
//                put("Nombre del producto", companiesArray[4]);
//            }
//        };
//        detailsPage.panels().panel("Detalle de Cuenta").validate("Teléfono", expectedPhone);
//        detailsPage.panels().panel("Oportunidad y Producto").validate(userProductData);
    }

    @Test(description = "Creation of the insurance record with provider 'Zurich Vida' and validation it in Salesforce")
    public void aciertoTestPrevisVidaValidation() {
        String email = getRandomEmail();
        String phone = getRandomPhone();
        String expectedPhone = String.format("+34%s", phone);
        aciertoPage.setPersonRecord(insuranceAmount, insurancePeriod, personalDataPage, DateOfBirth, personGender, zipcode, email, phone)
                .imInterestedButtonClick(6)
                .isFinalModalDisplayed();
        aciertoPage.callMeOnThisPhoneButtonClick(2)
                .isGratitudeModalDisplayed();
        aciertoPage.closeButtonClick()
                .isLifeInsurancePageOpened();
        aciertoPage.closeCurrentWindow();
        loginPage.open();
        loginPage.login(USERNAME, PASSWORD);
        homePage.isPageOpened();
        listView.open("Case")
                .clickSwitcher()
                .selectFilter(selectFilterValue)
                .table()
                .sortBy(columnTitle, SortOrder.DESC)
                .clickCell(columnNameOwner, 1);
        detailsPage.clickTab(tabName);
        caseDetailsPage.waitTillOpened(tabName);
        Map<String, String> userDetailsData = new HashMap<>() {
            {
                put("Correo electrónico Web", email);
                put("Teléfono del cliente", expectedPhone);
            }
        };
        //TODO раскомментировать после фикса методов валидиции полей
//        detailsPage.validate(userDetailsData);
//        Map<String, String> userProductData = new HashMap<>() {
//            {
//                put("Pago de frecuencia", NEW_INSURANCE_PERIOD);
//                put("Cantidad de capital", NEW_INSURANCE_AMOUNT);
//                put("Nombre del producto", companiesArray[5]);
//            }
//        };
//        detailsPage.panels().panel("Detalle de Cuenta").validate("Teléfono", expectedPhone);
//        detailsPage.panels().panel("Oportunidad y Producto").validate(userProductData);
    }

    @Test(description = "Creation of the insurance record with provider 'Previs Vida' and validation it in Salesforce")
    public void aciertoTestAllianzVidaRiesgoValidation() {
        String email = getRandomEmail();
        String phone = getRandomPhone();
        String expectedPhone = String.format("+34%s", phone);
        aciertoPage.setPersonRecord(insuranceAmount, insurancePeriod, personalDataPage, DateOfBirth, personGender, zipcode, email, phone)
                .imInterestedButtonClick(7)
                .isFinalModalDisplayed();
        aciertoPage.callMeOnThisPhoneButtonClick(2)
                .isGratitudeModalDisplayed();
        aciertoPage.closeButtonClick()
                .isLifeInsurancePageOpened();
        aciertoPage.closeCurrentWindow();
        loginPage.open();
        loginPage.login(USERNAME, PASSWORD);
        homePage.isPageOpened();
        listView.open("Case")
                .clickSwitcher()
                .selectFilter(selectFilterValue)
                .table()
                .sortBy(columnTitle, SortOrder.DESC)
                .clickCell(columnNameOwner, 1);
        detailsPage.clickTab(tabName);
        caseDetailsPage.waitTillOpened(tabName);
        Map<String, String> userDetailsData = new HashMap<>() {
            {
                put("Correo electrónico Web", email);
                put("Teléfono del cliente", expectedPhone);
            }
        };
        //TODO раскомментировать после фикса методов валидиции полей
//        detailsPage.validate(userDetailsData);
//        Map<String, String> userProductData = new HashMap<>() {
//            {
//                put("Pago de frecuencia", NEW_INSURANCE_PERIOD);
//                put("Cantidad de capital", NEW_INSURANCE_AMOUNT);
//                put("Nombre del producto", companiesArray[6]);
//            }
//        };
//        detailsPage.panels().panel("Detalle de Cuenta").validate("Teléfono", expectedPhone);
//        detailsPage.panels().panel("Oportunidad y Producto").validate(userProductData);
    }

    @Test(description = "Creation of the insurance record with provider 'Allianz Vida Riesgo' and validation it in Salesforce")
    public void aciertoTestSantalucíaVidaValidation() {
        String email = getRandomEmail();
        String phone = getRandomPhone();
        String expectedPhone = String.format("+34%s", phone);
        aciertoPage.setPersonRecord(insuranceAmount, insurancePeriod, personalDataPage, DateOfBirth, personGender, zipcode, email, phone)
                .weCallYouForFreeButton(1)
                .isFinalModalDisplayed();
        aciertoPage.callMeOnThisPhoneButtonClick(2)
                .isGratitudeModalDisplayed();
        aciertoPage.closeButtonClick()
                .isLifeInsurancePageOpened();
        aciertoPage.closeCurrentWindow();
        loginPage.open();
        loginPage.login(USERNAME, PASSWORD);
        homePage.isPageOpened();
        listView.open("Case")
                .clickSwitcher()
                .selectFilter(selectFilterValue)
                .table()
                .sortBy(columnTitle, SortOrder.DESC)
                .clickCell(columnNameOwner, 1);
        detailsPage.clickTab(tabName);
        caseDetailsPage.waitTillOpened(tabName);
        Map<String, String> userDetailsData = new HashMap<>() {
            {
                put("Correo electrónico Web", email);
                put("Teléfono del cliente", expectedPhone);
            }
        };
        //TODO раскомментировать после фикса методов валидиции полей
//        detailsPage.validate(userDetailsData);
//        Map<String, String> userProductData = new HashMap<>() {
//            {
//                put("Pago de frecuencia", NEW_INSURANCE_PERIOD);
//                put("Cantidad de capital", NEW_INSURANCE_AMOUNT);
//                put("Nombre del producto", companiesArray[7]);
//            }
//        };
//        detailsPage.panels().panel("Detalle de Cuenta").validate("Teléfono", expectedPhone);
//        detailsPage.panels().panel("Oportunidad y Producto").validate(userProductData);
    }
}