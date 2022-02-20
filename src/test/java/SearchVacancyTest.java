import models.UserModel;
import models.VacancyModel;
import org.junit.jupiter.api.Test;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.sleep;

public class SearchVacancyTest extends BaseTest {

    @Test
    public void searchQAVacanciesOnMoscow() {

        var vacancy = VacancyModel.build();

        new MainPage()
                .openPage()
                .shouldBeOpened()
                .searchVacancies(vacancy)
                .openVacancyByName(vacancy)
                .shouldBeOpened(vacancy);
    }

    @Test
    public void createNewUserTest() {

        var user = UserModel.build();

        new MainPage()
                .openPage()
                .shouldBeOpened()
                .clickResumeCreate()
                .shouldBeOpened()
                .fillInAllFields(user);
    }

}
