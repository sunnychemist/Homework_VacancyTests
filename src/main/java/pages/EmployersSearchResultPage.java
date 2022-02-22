package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class EmployersSearchResultPage extends BasePage{
    private final SelenideElement container = $("#js-search-results-wrapper");
    private final SelenideElement searchQueryResultTitle = $(".b-center__header");
    private final ElementsCollection resumes = $$("#resume-search-list .search_title-txt");

    @Step("Проверяем что страница поисковой выдачи открылась")
    public EmployersSearchResultPage shouldBeOpened(String query) {
        container.shouldBe(visible);
        searchQueryResultTitle.shouldHave(exactText(query));
        return this;
    }

    @Step("Проверяем что в выдаче есть резюме")
    public EmployersSearchResultPage resumeListShouldNotBeEmpty() {
        resumes.shouldHave(sizeGreaterThan(0));
        return this;
    }
}
