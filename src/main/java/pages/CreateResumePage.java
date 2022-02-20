package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CreateResumePage extends BasePage{
    private final SelenideElement container = $(".resume-form");
    private final SelenideElement countryInput = $(".resume-part-form-citizenship");
    private final ElementsCollection selectorValues = $$("li.list__tile_selectable");
    private final SelenideElement salaryInput = $(".resume-part-form-salary input");
    private final SelenideElement nonExperienceCheckbox = $(".resume-part-form-experience .input-group_selection-controls__ripple");
    private final SelenideElement educationInput = $(".resume-part-form-education-item .input-group__selections");
    private final SelenideElement saveButton = $("button.register-form__submit");

    @Step("Проверяем что страница открылась")
    public CreateResumePage shouldBeOpened() {
        container.shouldBe(visible);
        return this;
    }

    @Step("Создаем резюме")
    public MainPage createResume() {
        return selectCountry()
            .fillInSalary("100000")
            .clickNonExperienceCheckbox()
            .selectEducation()
            .clickSave();
    }

    @Step("Выбираем гражданство")
    public CreateResumePage selectCountry() {
        countryInput.click();
        selectorValues.filter(exactText("Россия"))
                .first()
                .click();
        return this;
    }

    @Step("Заполняем поле 'Зарплата'")
    public CreateResumePage fillInSalary(String salary) {
        salaryInput.val(salary);
        return this;
    }

    @Step("Включаем чекбокс 'Нет опыта'")
    public CreateResumePage clickNonExperienceCheckbox() {
        nonExperienceCheckbox.click();
        return this;
    }

    @Step("выбираем тип образования")
    public CreateResumePage selectEducation() {
        educationInput.click();
        selectorValues.filter(exactText("среднее"))
                .first()
                .click();
        return this;
    }

    @Step("сохраняем резюме")
    public MainPage clickSave() {
        saveButton.click();
        return new MainPage();
    }
}
