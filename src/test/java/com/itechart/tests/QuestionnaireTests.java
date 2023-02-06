package com.itechart.tests;

import com.itechart.base.BaseTest;
import org.testng.annotations.Test;

public class QuestionnaireTests extends BaseTest {

    @Test(description = "Creation of the Questionnaire")
    public void questionnaireTest() {

        questionnairePage.openCase();
        questionnairePage.isQuestionnairePageOpened();



    }
}
