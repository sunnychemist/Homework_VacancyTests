package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class EmployeesSearchResultPage extends BasePage{
    private final SelenideElement container = $("#js-search-results-wrapper");
    private final ElementsCollection resumes = $$("#resume-search-list .search_title-txt");

    @Step("Проверяем что страница поисковой выдачи открылась")
    public EmployeesSearchResultPage shouldBeOpened() {
        container.shouldBe(visible);
        return this;
    }

    @Step("Проверяем что в выдаче есть резюме")
    public EmployeesSearchResultPage resumeListShouldNotBeEmpty() {
        resumes.shouldHave(sizeGreaterThan(0));
        return this;
    }
}
