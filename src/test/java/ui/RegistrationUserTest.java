package ui;

import models.UserModel;
import org.junit.jupiter.api.Test;
import pages.MainPage;

public class RegistrationUserTest extends BaseTest{

    @Test
    public void createNewUserTest() {

        var user = UserModel.build();

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
