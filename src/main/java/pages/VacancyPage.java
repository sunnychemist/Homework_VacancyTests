package pages;

import com.codeborne.selenide.SelenideElement;
import models.VacancyModel;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class VacancyPage extends BasePage {
    private final SelenideElement title = $("h1");
    private final SelenideElement companyNameTitle = $("div.vacancy-company-stats__name");
    private final SelenideElement addToFavoriteButton = $(".vacancy-actions__action-favorite button");

    public VacancyPage shouldBeOpened(VacancyModel vacancyModel) {
        title.shouldBe(visible);
        title.shouldHave(matchText(vacancyModel.getTitle()));
        companyNameTitle.shouldHave(exactText(vacancyModel.getCompanyName()));
        return this;
    }

    public VacancyPage addToFavorite() {
        addToFavoriteButton.click();
        addToFavoriteButton.shouldHave(text("В избранном"));
        return this;
    }

}
