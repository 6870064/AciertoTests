package com.itechart.tests;

import com.itechart.base.BaseTest;
import org.testng.annotations.Test;

public class QuestionnaireTests extends BaseTest {

    public String startOfInsurancePeriod = "01.03.2023";
    public String startOfInsuranceLocator = "Fecha_de_efecto";


    @Test(description = "Creation of the Questionnaire")
    public void questionnaireTest() {

        questionnairePage.openCase();
        questionnairePage.isQuestionnairePageOpened();
        questionnairePage.setValue(startOfInsuranceLocator, startOfInsurancePeriod);




        questionnairePage.clickChargePriceButton();




    }
}
