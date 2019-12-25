package pageobject.booking;

import common.AbstractPage;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookingCalendarPanel extends AbstractPage {

    public BookingCalendarPanel(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//div[@data-bui-ref='calendar-prev']")
    private WebElement nextMonthButton;

    @FindBy(xpath = "//div[@class='bui-calendar__month']")
    private WebElement calendarMonth;

    public void selectTravelDate(String day, String monthYear){
        selectTravelMonthAndYear(monthYear);
    }


    private void selectTravelDay(){

    }


    private void selectTravelMonthAndYear(String monthYear){
        String monthNameLocator = ".//div[@class='bui-calendar__month'])[1]";
        boolean isMonthFound = false;
        while (isMonthFound) {
            WebElement month = calendarMonth.findElement(By.xpath(monthNameLocator));
            if(StringUtils.equals(month.getText(), monthYear)){
                isMonthFound = true;
            }
            else{
                nextMonthButton.click();
            }
        }
    }

}
