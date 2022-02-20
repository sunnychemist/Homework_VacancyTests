package ui;

import models.VacancyModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MainPage;

public class SearchVacancyTest extends BaseTest {

    @Test
    @DisplayName("Поиск вакансии тестировщика в Москве")
    public void searchQAVacanciesOnMoscow() {

        VacancyModel vacancy = VacancyModel.build();

        new MainPage()
                .openPage()
                .shouldBeOpened()
                .searchVacancies(vacancy)
                .openVacancyByName(vacancy)
                .shouldBeOpened(vacancy);
    }

}
