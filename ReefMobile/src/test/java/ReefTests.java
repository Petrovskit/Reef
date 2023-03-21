import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class ReefTests {

    @BeforeClass
    public void setup() {
        Setup.setup();
    }

    @Test(description = "Open the application through Play Store", priority = -2)
    public void startTheApplication() throws InterruptedException {
        Setup.startTheApplication();
    }

    @Test(description = "Verify that all elements are present on the Login screen", priority = -1)
    public void verifyAllElementsArePresent() {
        Assert.assertTrue(Setup.verifyAllElementsArePresent());
    }

    @Test(description = "Login to the application with password and username", priority = 1, enabled = false)
    public void loginToTheApp() {
        Setup.loginToTheApp();
    }

    @Test(description = "Verify that all elements are present on the Home screen", priority = 2, enabled = false)
    public void verifyAllElementsArePresentHomePage() {
        Assert.assertTrue(Setup.verifyAllElementsArePresentHomePage());
    }

    @Test(description = "Click on explore then click on GtCaffe card", priority = 3, enabled = false)
    public void verifyThatTheUserIsOnDesiredVenue() {
        Assert.assertEquals(Setup.clickOnGtCaffeCard(), "GT Caffe");
    }

    @Test(description = "Verify that all elements are present on venue card", priority = 4, enabled = false)
    public void verifyAllElementsArePresentVenueCard() {
        Assert.assertTrue(Setup.verifyAllElementsArePresentOnVenueCard());
    }

    @Test(description = "On GtCaffe card choose the date and time and book a seat", priority = 5, enabled = false)
    public void bookAVenue() {
        Setup.bookAPlace();
    }

    @Test(description = "Verify that a card is displayed saying Thank you for booking", priority = 6, enabled = false)
    public void verifyBookingIsSuccessful() {
        Assert.assertEquals(Setup.verifyBookingIsSuccessful(), "Thank you for booking");
    }

    @Test(description = "Verify that the booked place is displayed in Bookings page", priority = 7, enabled = false)
    public void verifyBookedPlaceIsDisplayed() {
        Assert.assertTrue(Setup.verifyBookingIsDisplayedAtBookingPage());
    }

    @Test(description = "Verify that the user can successfully cancel the booking", priority = 8, enabled = false)
    public void cancelTheBooking() {
        Setup.verifyBookingIsCanceled();
    }

    @Test(description = "Verify that the favourite place is displayed in Favourites page", priority = 9, enabled = false)
    public void verifyFavouritePlaceIsDisplayed() {
        Assert.assertTrue(Setup.verifyFavouritePlaceIsDisplayed());
    }

    @Test(description = "Verify that the user has signed out successfully", priority = 10, enabled = false)
    public void verifySignOutSuccessful() {
        Assert.assertTrue(Setup.signOut());
    }

    @Test(description = "Verify that all elements are present on Create your account page", priority = 11)
    public void verifyAllElementsPresentOnCreateAccountPage() {
        Assert.assertTrue(Setup.createAccPage());
    }

    @AfterClass
    public void quit() {
        Setup.quit();
    }
}
