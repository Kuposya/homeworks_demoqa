package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.ResultTableComponent;
import utils.FakerTestData;


public class TestDemoqaPageWithFakerTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    ResultTableComponent resultTableComponent = new ResultTableComponent();
    FakerTestData fakerTestData = new FakerTestData();

    //Заполнение всех полей
    @Test
    public void fillFormTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName(fakerTestData.firstName)
                .setLastName(fakerTestData.lastName)
                .setEmail(fakerTestData.email)
                .setGender(fakerTestData.gender)
                .setUserNumber(fakerTestData.phoneNumber)
                .setDateOfBirth(fakerTestData.dayOfBirth, fakerTestData.monthOfBirth, fakerTestData.yearOfBirth)
                .setSubjects(fakerTestData.subjects)
                .setHobbiesWrapper(fakerTestData.hobbies)
                .uploadFile(fakerTestData.picture)
                .setCurrentAddress(fakerTestData.city)
                .setState(fakerTestData.state)
                .setCity(fakerTestData.city)
                .clickSubmit();

        resultTableComponent.addCheck("Student Name", fakerTestData.firstName + " " + fakerTestData.lastName)
                .addCheck("Student Email", fakerTestData.email)
                .addCheck("Gender", fakerTestData.gender)
                .addCheck("Mobile", fakerTestData.phoneNumber)
                .addCheck("Date of Birth", fakerTestData.dayOfBirth + " " + fakerTestData.monthOfBirth + ","
                        + fakerTestData.yearOfBirth)
                .addCheck("Subjects", fakerTestData.subjects)
                .addCheck("Hobbies", fakerTestData.hobbies)
                .addCheck("Address", fakerTestData.currentAddress)
                .addCheck("State and City", fakerTestData.state + " " + fakerTestData.city);
    }

    //Заполнение обязательных полей
    @Test
    public void minFillFormTest() {
        registrationPage.openPage()
                .setFirstName(fakerTestData.firstName)
                .setLastName(fakerTestData.lastName)
                .setGender(fakerTestData.gender)
                .setUserNumber(fakerTestData.phoneNumber)
                .clickSubmit();

        resultTableComponent.addCheck("Student Name", fakerTestData.firstName + " " + fakerTestData.lastName)
                .addCheck("Gender", fakerTestData.gender)
                .addCheck("Mobile", fakerTestData.phoneNumber);
    }

    //Нет номера телефона
    @Test
    public void noNumberFillFormTest() {
        registrationPage.openPage()
                .setFirstName(fakerTestData.firstName)
                .setLastName(fakerTestData.lastName)
                .setGender(fakerTestData.gender)
                .clickSubmit();

        resultTableComponent.isNotSubmitted();
    }
}
