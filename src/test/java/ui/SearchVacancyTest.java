package ui;

import models.VacancyModel;
import org.junit.jupiter.api.Test;
import pages.MainPage;

public class SearchVacancyTest extends BaseTest {

    @Test
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
