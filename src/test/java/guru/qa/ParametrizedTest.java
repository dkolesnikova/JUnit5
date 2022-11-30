package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import pages.MainPage;
import pages.SubjectPage;


import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.*;


public class ParametrizedTest {
    @BeforeEach
    void setUp() {
        Configuration.holdBrowserOpen = true;
        open("https://www.dns-shop.ru/");
    }

    @CsvSource({
            "Бытовая техника, Встраиваемая техника",
            "Сетевое оборудование, Wi-Fi роутеры и оборудование для малых сетей"
    })

    @ParameterizedTest(name = "Проверка отображения соответсвуюшего товара {1}" +
            "при поиске основного {0}")
    @Tags({@Tag("BLOCKER"), @Tag("Critical")})
    void CsvTest(String subject, String result) {
        MainPage.chooseSubject(subject);
        SubjectPage.checkSubject(result);
    }

    static Stream<Arguments> subjectChooseTest() {
        return Stream.of(
                Arguments.of("Бытовая техника"),
                Arguments.of("Красота и здоровье"),
                Arguments.of("Смартфоны и фототехника"),
                Arguments.of("ТВ, консоли и аудио")
        );
    }

    @MethodSource
    @ParameterizedTest(name = "Проверка перехода на тему {0} сайта dns-shop.ru")
    @Tag("BLOCKER")
    void subjectChooseTest(String subject) {
        MainPage.chooseSubject(subject);
        SubjectPage.checkChoosingOfSubject(subject);

    }

    @ValueSource(strings = {
            "Бытовая техника",
            "Красота и здоровье",
            "Смартфоны и фототехника",
            "ТВ, консоли и аудио"})
    @ParameterizedTest(name = "Проверка перехода на тему {0} сайта dns-shop.ru")
    void subjectChooseTes1t(String subject) {
            MainPage.chooseSubject(subject);
            SubjectPage.checkChoosingOfSubject(subject);

        }

    }

