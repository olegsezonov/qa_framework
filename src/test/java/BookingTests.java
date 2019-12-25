import common.BaseTest;
import common.PropertyHelper;
import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;


import pageobject.booking.BookingCalendarPanel;
import pageobject.booking.BookingMainPage;
import pageobject.booking.BookingResultsPage;


public class BookingTests extends BaseTest {
    private PropertyHelper propertiesHelper = new PropertyHelper();

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
