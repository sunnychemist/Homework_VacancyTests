package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.open;

public class BasePage {

    public BasePage openPage() {
        open("/");
        return this;
    }

    public BasePage openPage(String url) {
        open(String.format("/%s", url));
        return this;
    }

    public BasePage clearInput(SelenideElement element) {
        element.sendKeys(Keys.LEFT_CONTROL + "a");
        element.sendKeys(Keys.BACK_SPACE);
        return this;
    }

}
