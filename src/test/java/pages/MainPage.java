package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.remote.tracing.EventAttribute.setValue;

public class MainPage {
    public static MainPage chooseSubject(String subject) {
        if ($(".v-confirm-city").is(Condition.visible)) {
            $(".base-ui-button-v2__text").click();
        }
        $x(".//a[contains(text(),'" + subject + "')]").click();;
        return null;
    }

}
