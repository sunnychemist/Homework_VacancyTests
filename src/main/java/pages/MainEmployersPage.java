package pages;


import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;


public class MainEmployersPage extends BasePage {

    private final SelenideElement container = $(".container p-relative");
    private final SelenideElement title = $(".indent-large h2");
    private final SelenideElement searchInput = $("input.multiselect__input");
    private final SelenideElement searchButton = $(".search-form-x__submit button");

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

    @Step("Ищем резюме по запросу {query}")
    public EmployersSearchResultPage searchEmployees(String query) {
       return fillInQuery(query)
               .clickSearchButton();
    }

    @Step("Вводим поисковый запрос в поисковую строку")
    public MainEmployersPage fillInQuery(String query) {
        searchInput.val(query);
        return this;
    }

    @Step("Нажимаем на кнопку 'Поиск'")
    public EmployersSearchResultPage clickSearchButton() {
        searchButton.click();
        return new EmployersSearchResultPage();
    }
}
