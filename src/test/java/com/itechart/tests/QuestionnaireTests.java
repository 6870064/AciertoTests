package com.itechart.tests;

import com.itechart.base.BaseTest;
import org.testng.annotations.Test;

public class QuestionnaireTests extends BaseTest {

    public String startOfInsurancePeriod = "01.03.2023";
    public String startOfInsuranceLocator = "Fecha_de_efecto";
    public String fraccioDropdownTitle = "Fraccionamiento";
    public String fralleciDropdownValue = "FrequencyOfPayment.Yearly";
    public String fallecimientoDropdownTitle = "Fraccionamiento";
    public String genderDropdownTitle = "SexoPolicyHolderInsured";
    public String genderValue = "Hombre";
    public String nameFieldTitle = "NombrePolicyHInsured";
    public String nameFieldValue = "Sebastian";
    public String surnameFieldTitle = "PrimerApellidoPolicyHInsured";
    public String surnameFieldValue = "Pereiro";
    public String secondSurnameFieldTitle = "SegundoApellidoPHInsured";
    public String secondSurnameFieldValue = "Huanito Chiburito";
    public String languageFieldTitle = "IdiomaDePreferenciaTomadorAsegurado";
    public String languageFieldValue = "English";
    public String docTypeDropdownTitle = "TipoDocumentoPolicyHInsured";
    public String docTypeDropdownValue = "NationalIdNumber";
    public String docNumberFieldTitle = "NumeroDocumentoPolicyHolderInsured";
    public String docNumberFieldValue = "18613301E";
    public String expirationDateFieldTitle = "FechaVencimientoDocPHolderInsured";
    public String expirationDateFieldValue = "30.09.2035";
    public String civilStatusDropdownTitle = "CivilStatusPolicyHolderInsured";
    public String civilStatusDropdownValue = "EstadoCivil.Married";
    public String childrenFieldTitle = "HijosPolicyHolderInsured2";
    public String childrenFieldValue = "No";
    public String regionOfBirthFieldTitle = "ProvinciaDeNacimientoTomadorAsegurado";
    public String regionOfBirthFieldValue = "Espana, Barcelona";
    public String placeOfBirthFieldTitle = "LocalidadDeNacimientoTomadorAsegurado";
    public String placeOfBirthFieldValue = "C. d'Arístides Maillol, 12, 08028";
    public String countryOfBirthFieldTitle = "";
    public String apartmentTypeFieldTitle = "AddressTypePolicyHolderInsured";
    public String apartmentTypeFieldValue = "TipoDeVia.Apartamento";
    public String streetNameFieldTitle = "StreetNamePolicyHInsured";
    public String streetNameFieldValue = "Bialoweska";
    public String streetNumberFieldTitle =  "StreetNumberPolicyHInsured";
    public String streetNumberFieldValue = "45";
    public String floorFieldTitle = "Piso_puerta_escalera_PolicyHolderInsured";
    public String florFieldValue = "3";
    public String populationFieldTitle = "CityPolicyHolderInsured";
    public String populationFieldValue = "35000";
    public String incomeFieldTitle = "Income";
    public String incomeFieldValue = "50000";
    public String contractReasonDropdownTitle = "Hiring_Policy_Reason";
    public String contractReasonDropdownValue = "ProteccionFamiliar";
    public String incomeType = "Neto";
    public String incomePeriodType = "Mensual";
    public String responsibilityCheckboxTitle = "Public_Responsibility1";
    public String incomeCheckboxValue = "YesResource";
    public String fundsSourceDropdownTitle = "Source_of_Funds";
    public String fundsSourceDropdownValue = "SalriosYRentasProfesionales";
    public String selfEmployedDropdownTitle = "Self_Employed";
    public String selfEmployedDropdownValue = "PorCuentaPropia";
    public String companyNameFieldTitle = "Company_Name";
    public String companyNameFieldValue = "Apple corporation";
    public String jobPositionFieldTitle = "Position_in_Company";
    public String jobPositionFieldValue = "Lead QA Engineer";
    public String workExperienceFieldTitle = "CompanySeniority";
    public String workExperienceFieldValue = "01.01.2020";
    public String selfEmploymentCheckboxTitle = "Es_trabajador_aut_nomo";
    public String otherInsuranceCheckboxTitle = "El_asegurado_tiene_otros_seguros_de_vida";
    public String setAsideCapitalCheckboxTitle = "CapitalDestinedMortgage";
    public String negativeAnswerCheckboxValue = "NoChoice";
    public String beneficiariesFieldValue = "Sergey Sergeevich Sergeev";


    @Test(description = "Filling the Questionnaire")
    public void questionnaireTest() {
        //TODO добавить часть теста на заполнение асиерто
        questionnairePage.openCase();
        questionnairePage.isQuestionnairePageOpened();
        questionnairePage.setValue(startOfInsuranceLocator, startOfInsurancePeriod);
        questionnairePage.setDropdownValue(1, 10);
        questionnairePage.setDropdownValue(2, 3);
        questionnairePage.setOptionDropdownValue(fraccioDropdownTitle, fralleciDropdownValue);
        questionnairePage.setFallecimientoDropdownValue(fallecimientoDropdownTitle);
        questionnairePage.clickChargePriceButton();
        questionnairePage.isPriceCalculatingMessageDisplayed();
        //TODO ожидание в 20 секунд
        questionnairePage.clickNextButton();
        questionnairePage.clickNextCharterButton();
        //вторая страница
        questionnairePage.setOptionDropdownValue(genderDropdownTitle,genderValue); //Sexo dropdown
        questionnairePage.setValue(nameFieldTitle, nameFieldValue); //Nombre field
        questionnairePage.setValue(surnameFieldTitle, surnameFieldValue); //Primer apellido field
        questionnairePage.setValue(secondSurnameFieldTitle, secondSurnameFieldValue); //Segundo apellido field
        questionnairePage.setValue(languageFieldTitle, languageFieldValue); //Idioma de preferencia field
        questionnairePage.setOptionDropdownValue(docTypeDropdownTitle, docTypeDropdownValue); // Tipo Documento dropdown
        questionnairePage.setValue(docNumberFieldTitle, docNumberFieldValue); // Num. documento (sin espacios) field
        questionnairePage.setValue(expirationDateFieldTitle, expirationDateFieldValue); // Fecha vencimiento field
        questionnairePage.setOptionDropdownValue(civilStatusDropdownTitle, civilStatusDropdownValue); //Estado civil dropdown
        // fields Último trabajo (solo para desempleados) and Motivo (solo para pensionistas) fields are skipped
        questionnairePage.setValue(childrenFieldTitle, childrenFieldValue); //Hijos field
        questionnairePage.setValue(regionOfBirthFieldTitle, regionOfBirthFieldValue); //Provincia de nacimiento field
        questionnairePage.setValue(placeOfBirthFieldTitle, placeOfBirthFieldValue); //Localidad de nacimiento field
        //TODO País de nacimiento dropdown
        //TODO checkbox No
        questionnairePage.setOptionDropdownValue(apartmentTypeFieldTitle, apartmentTypeFieldValue); //Tipo de via dropdown
        questionnairePage.setValue(streetNameFieldTitle, streetNameFieldValue); //Nombre de la calle field
        questionnairePage.setValue(streetNumberFieldTitle, streetNumberFieldValue); //Número field
        questionnairePage.setValue(floorFieldTitle, florFieldValue); //Piso, puerta, escalera
        questionnairePage.setValue(populationFieldTitle, populationFieldValue); //Población field
        //TODO Población dropdown
        questionnairePage.clickNextButton();
        // Третья вкладка
        questionnairePage.isBlanqueroDeCapitalesScreenOpened(); // "Blanqueo de capitales" is opened
        questionnairePage.setValue(incomeFieldTitle,incomeFieldValue); //Nivel ingresos/facturación field
        questionnairePage.clickCheckboxValue(incomeType); //Tipo de ingresos/facturación checkbox
        questionnairePage.clickCheckboxValue(incomePeriodType); //¿Ingreso anual o mensual? checkbox
        questionnairePage.setOptionDropdownValue(contractReasonDropdownTitle, contractReasonDropdownValue); //Motivo contratación de la póliza dropdown
        questionnairePage.clickCheckboxWithNameAndValue(responsibilityCheckboxTitle, incomeCheckboxValue); // *¿Es o ha sido usted, o algunos de sus familiares una persona de responsabilidad publica? checkbox
        questionnairePage.setOptionDropdownValue(fundsSourceDropdownTitle, fundsSourceDropdownValue); //Origen de los fondos dropdown
        questionnairePage.setOptionDropdownValue(selfEmployedDropdownTitle, selfEmployedDropdownValue); // ¿Trabaja por cuenta propia o ajena? dropdown
        questionnairePage.setValue(companyNameFieldTitle, companyNameFieldValue); // Nombre de la empresa en la que trabaja field
        questionnairePage.setValue(jobPositionFieldTitle, jobPositionFieldValue); //Cargo en la empresa field
        questionnairePage.setValue(workExperienceFieldTitle, workExperienceFieldValue); //Antigüedad en la empresa field
        //TODO País de residencia fiscal* dropdown
        questionnairePage.clickCheckboxWithNameAndValue(selfEmploymentCheckboxTitle,incomeCheckboxValue); // ¿Es trabajador autónomo? checkbox
        questionnairePage.clickNextButton();
        // Четвертая вкладка
        questionnairePage.isSafeDataButtonDisplayed();
        questionnairePage.clickCheckboxWithNameAndValue(otherInsuranceCheckboxTitle, negativeAnswerCheckboxValue); // ¿El asegurado tiene otros seguros de vida en vigor? checkbox
        questionnairePage.clickCheckboxWithNameAndValue(setAsideCapitalCheckboxTitle, negativeAnswerCheckboxValue); // ¿Querría destinar el capital para reembolsar una hipoteca o préstamo? checkbox
        questionnairePage.setBeneficiariesValue(beneficiariesFieldValue); //Beneficiarios field
        questionnairePage.clickSaveDataButton();





        //TODO Третья страница и погнал дальше





    }
}
