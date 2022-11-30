package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import pages.MainPage;
import pages.SubjectPage;

public class TestBase {
    MainPage mainPage = new MainPage();
    SubjectPage subjectPage = new SubjectPage();


    @BeforeAll
    static void beforeAll() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
    }
}
