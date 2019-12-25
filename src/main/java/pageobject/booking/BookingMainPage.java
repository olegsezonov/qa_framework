package pageobject.booking;

import common.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookingMainPage extends AbstractPage {


    @FindBy(xpath = "//input[@id='ss']")
    private WebElement searchInput;
}
