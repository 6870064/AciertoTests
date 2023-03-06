package com.itechart.tests;

import com.itechart.base.BaseTest;
import io.github.dzmitryrak.enums.SortOrder;
import org.testng.annotations.Test;
import java.util.Map;
import static org.testng.Assert.*;

public class AciertoRecurringDemandTest extends BaseTest {
    String amount = "90.000€";
    String period = "Anual";
    String gender = "Hombre";
    String dateOfBirth = "11/10/1967";
    String zipcode = "28012";
    String personalDataPage = "Fecha de nacimiento";
    String tableName = "Casos de un mismo cliente";

    private void aciertoCaseCreated(String email, String phone) {
        aciertoPage.setPersonRecord(amount, period, personalDataPage, dateOfBirth, gender, zipcode, email, phone)
                .seeDetailsButtonClick(1)
                .callMeOnThisPhoneButtonClick(1)
                .isFunnelCallModalDisplayed();
        aciertoPage.callMeOnThisPhoneButtonClick(2)
                .closeButtonClick()
                .closeCurrentWindow();
    }

    //https://app.qase.io/case/ACIERTO-172
    @Test(description = "Recurring demand: Choosing from grouped cases")
    public void aciertoParentCase() {
        String phone = getRandomPhone();
        String email = getRandomEmail();
        aciertoCaseCreated(email, phone);
        aciertoCaseCreated(email, phone);
        Integer rowIndex = 1;
        loginPage.open().login(USERNAME, PASSWORD);
        String caseNumber = listView.open("Case")
                .clickSwitcher()
                .selectFilter(selectFilterValue)
                .table()
                .sortBy(columnTitle, SortOrder.DESC)
                .getTextFromCell(columnTitle, rowIndex);
        listView.table().clickCell(columnTitle, rowIndex);
        caseDetailsPage.waitTillOpened("Detalles");
        detailsPage.table(tableName).clickCell("Número de caso", rowIndex);
        detailsPage.table(tableName).selectCell(rowIndex);
        caseDetailsPage.clickOnButton("Asignar caso y cerrar el resto");
        caseDetailsPage.waitAlertDialog("Success");
        Map<String, String> inProgressStatusRow = detailsPage.table(tableName).getRecordData("Estado", "En curso");
        Map<String, String> caseNumberRow = detailsPage.table(tableName).getRecordData("Número de caso", caseNumber);
        assertEquals(inProgressStatusRow, caseNumberRow);
        Map<String, String> closedStatusRow = detailsPage.table(tableName).getRecordData("Estado", "Cerrado");
        assertFalse(closedStatusRow.isEmpty());
    }
}
