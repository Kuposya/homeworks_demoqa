package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.ResultTableComponent;


public class TestDemoqaPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    ResultTableComponent resultTableComponent = new ResultTableComponent();

    //Заполнение всех полей
    @Test
    public void fillFormTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName("Татьяна")
                .setLastName("Волковинская")
                .setEmail("kup@mail.ru")
                .setGender("Female")
                .setUserNumber("9998887766")
                .setDateOfBirth("10", "May", "1998")
                .setSubjects("Maths")
                .setHobbiesWrapper("Sports")
                .uploadFile("img.png")
                .setCurrentAddress("Москва")
                .setState("NCR")
                .setCity("Delhi")
                .clickSubmit();

        resultTableComponent.addCheck("Student Name", "Татьяна Волковинская")
                .addCheck("Student Email", "kup@mail.ru")
                .addCheck("Gender", "Female")
                .addCheck("Mobile", "9998887766")
                .addCheck("Date of Birth", "10 May,1998")
                .addCheck("Subjects", "Maths")
                .addCheck("Hobbies", "Sports")
                .addCheck("Address", "Москва")
                .addCheck("State and City", "NCR Delhi");
    }

    //Заполнение обязательных полей
    @Test
    public void minFillFormTest() {
        registrationPage.openPage()
                .setFirstName("Татьяна")
                .setLastName("Волковинская")
                .setGender("Female")
                .setUserNumber("9998887766")
                .clickSubmit();
        resultTableComponent.addCheck("Student Name", "Татьяна Волковинская")
                .addCheck("Gender", "Female")
                .addCheck("Mobile", "9998887766");
    }

    //Нет номера телефона
    @Test
    public void noNumberFillFormTest() {
        registrationPage.openPage()
                .setFirstName("Татьяна")
                .setLastName("Волковинская")
                .setGender("Female")
                .clickSubmit();

        resultTableComponent.isNotSubmitted();
    }
}
