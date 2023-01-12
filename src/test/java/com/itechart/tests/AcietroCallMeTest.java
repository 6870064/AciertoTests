package com.itechart.tests;

import com.itechart.base.BaseTest;
import io.github.dzmitryrak.enums.SortOrder;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;

public class AcietroCallMeTest extends BaseTest {
    private final String columnNameOwner = "Alias del propietario del caso";
    private final String columnEmail = "Correo electrónico Web";

    @Test(description = "Creation of the insurance record")
    public void acietroCallMeFirstPage() {

        String randomStr = String.valueOf((int) (Math.random() * 10));
        String phone = String.format("92%s10%s02%s", randomStr,randomStr,randomStr);
        aciertoPage.open()
                .callMeOnThisPhoneButtonClick(1)
                .isFunnelCallModalDisplayed();
        aciertoPage.enterPhoneFunnelCall(phone)
                .callMeOnThisPhoneButtonClick(2)
                .closeButtonClick()
                .closeCurrentWindow();
        loginPage.open()
                .login(USERNAME, PASSWORD)
                .isPageOpened();
        String ownerName = listView.open("Case")
                .clickSwitcher()
                .selectFilter(selectFilterValue)
                .table()
                .sortBy(columnTitle, SortOrder.DESC)
                .getTextFromCell(columnNameOwner, 1);
        assertEquals(ownerName, "Acierto Life Insurance - Front Office");
        String ownerEmail = listView.table().getTextFromCell(columnEmail, 1);
        assertEquals(ownerEmail, "");
        listView.table().clickCell(columnTitle, 1);
        detailsPage.clickTab(tabName);
        Map<String, String> userDetailsData = new HashMap<>() {
            {
                put("Correo electrónico Web", "");
                put("Teléfono del cliente", phone);
                put("Origen del caso", "Phone");
                put("Origen de la Llamada", "CTC Header");
                put("Caso principal", "");
                put("Nombre de la cuenta", "");
            }
        };
        detailsPage.validate(userDetailsData);
    }
}
