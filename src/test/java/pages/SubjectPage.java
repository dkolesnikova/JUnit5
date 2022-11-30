package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SubjectPage {
    public static SubjectPage checkChoosingOfSubject(String subject) {
        $x(".//*[contains(text(),'" + subject + "')]").text().equals(subject);
        return null;
    }
public static SubjectPage checkSubject (String result){
    $x(".//span[contains(text(),'" + result + "')]").text().equals(result);
    return null;

    }
}
