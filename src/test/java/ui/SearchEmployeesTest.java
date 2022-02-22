package ui;

import org.junit.jupiter.api.Test;
import pages.MainEmployersPage;

public class SearchEmployeesTest extends BaseTest{

    private String query = "Тестировщик";

    @Test
    public void searchEmployeesTest() {
        new MainEmployersPage()
                .openPage()
                .shouldBeOpened()
                .searchEmployees(query)
                .shouldBeOpened(query)
                .resumeListShouldNotBeEmpty();
    }
}
