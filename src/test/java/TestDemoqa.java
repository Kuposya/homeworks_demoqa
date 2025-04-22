import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestDemoqa {

    @BeforeAll
    static void ConfigurateBrowser() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");

        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Татьяна");
        $("#lastName").setValue("Волковинская");
        $("#userEmail").setValue("kup@mail.ru");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("9998887766");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").$(byText("May")).click();
        $(".react-datepicker__year-select").$(byText("1998")).click();
        $(".react-datepicker__day--010").click();
        $("#subjectsInput").setValue("Ma") .pressEnter() ;
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("img.png");
        $("#currentAddress").setValue("Москва");
        $("#react-select-3-input").setValue("NCR") .pressEnter();
        $("#react-select-4-input").setValue("Delhi") .pressEnter();

        $("#submit").click();

        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Татьяна Волковинская"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("kup@mail.ru"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Female"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("9998887766"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("10 May,1998"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Maths"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Sports"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("img.png"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Москва"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("NCR Delhi"));
    }
}
