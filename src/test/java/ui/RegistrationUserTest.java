package ui;

import models.UserModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MainPage;

public class RegistrationUserTest extends BaseTest{

    @Test
    @DisplayName("Регистрация нового пользователя и создание резюме")
    public void createNewUserTest() {

        UserModel user = UserModel.build();

        new MainPage()
                .openPage()
                .shouldBeOpened()
                .clickResumeCreate()
                .shouldBeOpened()
                .fillInAllFields(user)
                .clickContinue()
                .shouldBeOpened()
                .createResume()
                .checkRegistrationPopup(user);
    }
}
