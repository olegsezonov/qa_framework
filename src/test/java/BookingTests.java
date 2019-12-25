import common.BaseTest;
import helper.PropertiesHelper;
import org.junit.Assert;
import org.junit.Test;
import pageobject.booking.BookingCalendarPanel;
import pageobject.booking.BookingMainPage;
import pageobject.booking.BookingResultsPage;

import java.io.IOException;


public class BookingTests extends BaseTest {
    private PropertiesHelper propertiesHelper = new PropertiesHelper();

    public BookingTests() throws IOException {
    }

    @Test
    public void verifySearchWorksAsExpectedTest() {
        String navigationUrl = this.propertiesHelper.readProperty("booking.main.page.url");
        this.getWebDriver().get(navigationUrl);
        BookingMainPage bookingMainPage = new BookingMainPage(this.getWebDriver());
        bookingMainPage.typeTravelPlace("Milan");
        BookingCalendarPanel calendar = bookingMainPage.openTravelingCalendar();
        calendar.selectTravelDate("20", "March 2020");
        BookingResultsPage bookingResultsPage = bookingMainPage.performSearch();
        String firstHotel = bookingResultsPage.getFirstAvailableHotelDestination();
        Assert.assertEquals("There is incorrect first destination displayed!", "Milan", firstHotel);
    }
}
