package pages;

import com.codeborne.selenide.SelenideElement;
import models.UserModel;

import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class PassportPage {
    private final SelenideElement container = $("article.split-wrapper__article");
    private final SelenideElement continueButton = $("button[aria-label='Продолжить']");
    private final SelenideElement fullNameInput = $("[name='full_name']");
    private final SelenideElement birthdayYearInput = $("[name='birth_year_at']");
    private final SelenideElement positionInput = $("[aria-label='Желаемая должность']");
    private final SelenideElement loginInput = $("[name='login']");

    public PassportPage shouldBeOpened() {
        container.shouldBe(visible);
        return this;
    }

    public PassportPage fillInAllFields(UserModel userModel) {
        return fillInFullName(String.format("%s %s", userModel.getFirstName(), userModel.getLastName()))
                .fillInBirthday((userModel.getBirthday().format(DateTimeFormatter.ofPattern("Y"))))
                .fillInPosition(userModel.getPosition())
                .fillInEmail(userModel.getEmail());
    }

    public PassportPage fillInFullName(String fullName) {
        fullNameInput.val(fullName);
        return this;
    }

    public PassportPage fillInBirthday(String data) {
        birthdayYearInput.val(data);
        return this;
    }

    public PassportPage fillInPosition(String position) {
        positionInput.val(position);
        return this;
    }

    public PassportPage fillInEmail(String email) {
        loginInput.val(email);
        return this;
    }

    public CreateResumePage clickContinue() {
        continueButton.click();
        return new CreateResumePage();
    }
}
