package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    private final SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genterWrapperInput = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapperInput = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            StateInput = $("#react-select-3-input"),
            CityInput = $("#react-select-4-input"),
            submitClosed = $("#submit");

    CalendarComponent calendarComponent = new CalendarComponent();

    public RegistrationPage openPage() {
        open("/automation-practice-form");

        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName (String value) {
        firstNameInput.setValue(value);

        return this;
    }
    public RegistrationPage setLastName (String value) {
        lastNameInput.setValue(value);

        return this;
    }
    public RegistrationPage setEmail (String value) {
        userEmailInput.setValue(value);

        return this;
    }
    public RegistrationPage setGender (String value) {
        genterWrapperInput.$(byText(value)).click();

        return this;
    }
    public RegistrationPage setUserNumber (String value) {
        userNumberInput.setValue(value);

        return this;
    }
    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }
    public RegistrationPage setSubjects (String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }
    public RegistrationPage setHobbiesWrapper (String value) {
        hobbiesWrapperInput.$(byText(value)).click();

        return this;
    }
    public RegistrationPage uploadFile (String path) {
        uploadPicture.uploadFromClasspath(path);

        return this;
    }
    public RegistrationPage setCurrentAddress (String value) {
        currentAddressInput.setValue(value);

        return this;
    }
    public RegistrationPage setState (String value) {
        StateInput.setValue(value).pressEnter();

        return this;
    }
    public RegistrationPage setCity (String value) {
        CityInput.setValue(value).pressEnter();

        return this;
    }
    public RegistrationPage clickSubmit () {
        submitClosed.click();

        return this;
    }

}