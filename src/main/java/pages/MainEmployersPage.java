package pages;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


public class MainEmployersPage extends BasePage {

    private final SelenideElement container = $(".hr-search_left");
    private final SelenideElement title = $(".indent-large h2");
    private final SelenideElement searchInput = $("input.multiselect__input");
    private final SelenideElement searchButton = $(".search-form-x__submit button");
    private final ElementsCollection professions = $$(".multiselect__element");


    @Step("Открываем главную страницу работодателей")
    public MainEmployersPage openPage() {
        super.openPage("hr/");
        return this;
    }

    @Step("Проверяем что главная страница работодателей открылась")
    public MainEmployersPage shouldBeOpened() {
        container.shouldBe(visible);
        title.shouldHave(exactText("Найдите сотрудника\n" +
                "на вашу вакансию"));
        return this;
    }

    @Step("Нажимаем на кнопку 'Поиск'")
    public EmployeesSearchResultPage clickSearchButton() {
        searchButton.click();
        return new EmployeesSearchResultPage();
    }
}
