package pages;


import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import models.UserModel;
import models.VacancyModel;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class MainPage extends BasePage {
    private final SelenideElement container = $(".layout-rabota__body");
    private final SelenideElement searchFieldInput = $(".vacancy-search-form-smart__item_query input");
    private final SelenideElement locationFieldInput = $(".vacancy-search-form-smart_has-subway input");
    private final SelenideElement searchButton = $(".vacancy-search-form-smart__btn");
    private final SelenideElement addResumeButton = $("button[aria-label='Создать резюме']");
    private final ElementsCollection vacancies = $$("article.vacancy-preview-card");
    private final SelenideElement popupContainer = $(".r-email-confirm-reminder");
    private final SelenideElement popupTitle = popupContainer.$(".r-email-confirm-reminder__title");
    private final SelenideElement popupEmailSpan = popupContainer.$(".r-email-confirm-reminder__email");


    public MainPage openPage() {
        super.openPage();
        return this;
    }

    public MainPage shouldBeOpened() {
        container.shouldBe(visible);
        return this;
    }

    public MainPage searchVacancies(VacancyModel vacancyModel) {
        fillInSearchQueryField(vacancyModel.getSearchQuery());
        fillInLocationField(vacancyModel.getCity());
        clickSearchButton();
        return this;
    }

    public MainPage fillInSearchQueryField(String query) {
        searchFieldInput.clear();
        searchFieldInput.val(query);
        return this;
    }

    public MainPage fillInLocationField(String location) {
        clearInput(locationFieldInput);
        locationFieldInput.val(location);
        return this;
    }

    public MainPage clickSearchButton() {
        searchButton.click();
        return this;
    }

    public VacancyPage openVacancyByName(VacancyModel vacancyModel) {
        vacancies
                .shouldBe(CollectionCondition.sizeGreaterThan(0))
                .filter(matchText(vacancyModel.getTitle()))
                .shouldBe(CollectionCondition.sizeGreaterThan(0))
                .filter(matchText(vacancyModel.getCompanyName()))
                .first()
                .click();
        return new VacancyPage();
    }

    public PassportPage clickResumeCreate() {
        addResumeButton.click();
        return new PassportPage();
    }

    public MainPage checkRegistrationPopup(UserModel userModel) {
        popupContainer.shouldBe(visible);
        popupTitle.shouldHave(exactText("Подтвердите почту"));
        popupEmailSpan.shouldHave(exactText(userModel.getEmail()));
        return this;
    }
}
