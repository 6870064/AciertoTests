package com.itechart.tests;

import com.itechart.base.BaseTest;
import org.testng.annotations.Test;

public class QuestionnaireTests extends BaseTest {

    public String startOfInsurancePeriod = "01.03.2023";
    public String startOfInsuranceLocator = "Fecha_de_efecto";
    public String dropdownFraccioTitle = "Fraccionamiento";
    public String dropdownFalleciTitle = "Fallecimiento";
    public String infoMessage = " Se está calculando el precio. Por favor, espere unos segundos.";


    @Test(description = "Creation of the Questionnaire")
    public void questionnaireTest() {

        questionnairePage.openCase();
        questionnairePage.isQuestionnairePageOpened();
        questionnairePage.setValue(startOfInsuranceLocator, startOfInsurancePeriod);
        questionnairePage.setDropdownValue(1, 10);
        questionnairePage.setDropdownValue(2, 3);
        questionnairePage.setFraccionamientoDropdownValue(dropdownFraccioTitle, 1);
        questionnairePage.setFallecimientoDropdownValue(dropdownFalleciTitle);
        questionnairePage.clickChargePriceButton();


        Se está calculando el precio. Por favor, espere unos segundos.

    }
}
