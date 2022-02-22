package ui;

import org.junit.jupiter.api.Test;
import pages.MainEmployersPage;

public class SearchEmployeesTest extends BaseTest{

    @Test
    public void searchEmployeesTest() {
        new MainEmployersPage()
                .openPage()
                .shouldBeOpened()
                .clickSearchButton()
                .shouldBeOpened()
                .resumeListShouldNotBeEmpty();
    }
}
