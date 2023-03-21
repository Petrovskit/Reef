import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Setup {

    private static String date = "22, Wednesday, March 22, 2023";
    private static String dateConf = "Mar 22, 2023\n";

    private static AndroidDriver driver;

    public static void setup() {

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("platformName", "Android");
        caps.setCapability("deviceName", "Teo's Xiaomi 11T Pro");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("platformVersion", "12");
        caps.setCapability("udId", "adb-638445c0-mhsXKU._adb-tls-connect._tcp");
        try {
            driver = new AndroidDriver(new URL("http://127.0.1.1:4723/wd/hub"), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static void quit() {
        driver.quit();
    }

    public static void startTheApplication() {

        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Play Store\")").click();
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Search for apps & games\")").click();
        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Search for apps & games\")").sendKeys("Reef");
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        driver.findElementByAccessibilityId("""
                Reef
                Unlimited Coders
                Food & Drink
                Installed
                """).click();
        driver.findElementByAccessibilityId("Open").click();


    }

    public static boolean verifyAllElementsArePresent() {
        MobileElement username = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]"));
        MobileElement password = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]"));
        MobileElement loginBtn = (MobileElement) driver.findElementByAccessibilityId("LOGIN");
        MobileElement createNewAccBtn = (MobileElement) driver.findElementByAccessibilityId("CREATE YOUR ACCOUNT");

        return username.isDisplayed() || password.isDisplayed() || loginBtn.isDisplayed() || createNewAccBtn.isDisplayed();
    }

    public static void loginToTheApp() {
        MobileElement username = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]"));
        MobileElement password = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]"));
        MobileElement loginBtn = (MobileElement) driver.findElementByAccessibilityId("LOGIN");


        username.click();
        driver.getKeyboard().sendKeys("Stefan");
        driver.hideKeyboard();
        password.click();
        driver.getKeyboard().sendKeys("test123456");
        loginBtn.click();
    }

    public static boolean verifyAllElementsArePresentHomePage() {
        MobileElement mapWidget = (MobileElement) driver.findElementByClassName("android.widget.RelativeLayout");
        MobileElement exploreBtn = (MobileElement) driver.findElementByAccessibilityId("Explore");
        MobileElement bookingsBtn = (MobileElement) driver.findElementByAccessibilityId("Bookings");
        MobileElement spacesBtn = (MobileElement) driver.findElementByAccessibilityId("Spaces");
        MobileElement perksBtn = (MobileElement) driver.findElementByAccessibilityId("Perks");
        MobileElement moreBtn = (MobileElement) driver.findElementByAccessibilityId("More");

        return mapWidget.isDisplayed() || exploreBtn.isDisplayed() || bookingsBtn.isDisplayed() || spacesBtn.isDisplayed() || perksBtn.isDisplayed() || moreBtn.isDisplayed();
    }

    public static String clickOnGtCaffeCard() {

        driver.findElementByAccessibilityId("Explore").click();
        driver.findElement(By.xpath("""
                //android.view.View[@content-desc="GT Caffe
                Distance\s
                0.00 mi"]""")).click();
        driver.findElementByAccessibilityId("Favourite").click();
        return driver.findElementByAccessibilityId("GT Caffe").getAttribute("content-desc");
    }

    public static boolean verifyAllElementsArePresentOnVenueCard() {
        MobileElement venueName = (MobileElement) driver.findElementByAccessibilityId("GT Caffe");
        MobileElement venueStreet = (MobileElement) driver.findElementByAccessibilityId("55 Shirok Sokak,  Bitola");
        MobileElement reefHrsCard = (MobileElement) driver.findElementByAccessibilityId("REEF HOURS");
        MobileElement socialHrsCard = (MobileElement) driver.findElementByAccessibilityId("SOCIAL HOURS");
        MobileElement amenities = (MobileElement) driver.findElementByAccessibilityId("AMENITIES");
        MobileElement bookPlaceBtn = (MobileElement) driver.findElementByAccessibilityId("BOOK MY REEF SPACE");

        return venueName.isDisplayed() || venueStreet.isDisplayed() || reefHrsCard.isDisplayed() || socialHrsCard.isDisplayed() || amenities.isDisplayed() || bookPlaceBtn.isDisplayed();
    }

    public static void bookAPlace() {
        driver.findElementByAccessibilityId("BOOK MY REEF SPACE").click();
        driver.findElementByAccessibilityId("DD/MM/YYYY").click();
        driver.findElementByAccessibilityId(date).click();
        driver.findElement(By.xpath("(//android.view.View[@content-desc=\"00-00\"])[1]")).click();
        driver.findElementByAccessibilityId("From: 08:30").click();
        driver.findElement(By.xpath("//android.view.View[@content-desc=\"00-00\"]")).click();
        driver.findElementByAccessibilityId("To: 09:30").click();
        driver.findElementByAccessibilityId("CONTINUE").click();
        driver.findElementByAccessibilityId("CONFIRM").click();
    }

    public static String verifyBookingIsSuccessful() {
        return driver.findElementByAccessibilityId("Thank you for booking").getAttribute("content-desc\n");
    }

    public static boolean verifyBookingIsDisplayedAtBookingPage() {
        driver.findElementByAccessibilityId("Bookings").click();
        return driver.findElementByAccessibilityId("GT Caffe\n" +
                dateConf +
                "08:30 - 09:30").isDisplayed();
    }

    public static void verifyBookingIsCanceled() {
        driver.findElementByAccessibilityId("Cancel").click();
        driver.findElement(By.xpath("//android.view.View[@content-desc=\"Yes\"]")).click();
    }

    public static boolean verifyFavouritePlaceIsDisplayed() {
        driver.findElementByAccessibilityId("More").click();
        driver.findElementByAccessibilityId("Favourites").click();
        MobileElement gtCaffeCard = (MobileElement) driver.findElementByAccessibilityId("GT Caffe\n" +
                "Bitola");
        return gtCaffeCard.isDisplayed();
    }

    public static boolean signOut() {
        driver.findElementByAccessibilityId("GT Caffe\n" +
                "Bitola").click();
        driver.findElementByAccessibilityId("Favourite").click();
        driver.navigate().back();
        driver.findElementByAccessibilityId("More").click();
        driver.findElementByAccessibilityId("Sign out").click();
        driver.findElementByAccessibilityId("Yes").click();
        MobileElement homePage = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View"));
        return homePage.isDisplayed();
    }

    public static boolean createAccPage() {
        driver.findElementByAccessibilityId("CREATE YOUR ACCOUNT").click();
        MobileElement companyNameInputField = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[1]"));
        MobileElement firstNameInputField = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[2]"));
        MobileElement surnameInputField = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[3]"));
        MobileElement emailInputField = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[4]"));
        MobileElement confEmailInputField = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[5]"));
        MobileElement passwordInputField = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[6]"));
        MobileElement confPassInputField = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[7]"));
        MobileElement countryDropDownBtn = (MobileElement) driver.findElementByAccessibilityId("Choose your country");
        MobileElement hearAboutUsDropDown = (MobileElement) driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Email\"]"));
        MobileElement termsAndPrivacyCheckbox = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[9]"));
        MobileElement optionalCheckbox = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[11]"));
        //MobileElement signUpBtn = (MobileElement) driver.findElement(By.xpath("//android.view.View[@content-desc=\"Sign Up\"]"));

        return companyNameInputField.isDisplayed() || firstNameInputField.isDisplayed() || surnameInputField.isDisplayed() || emailInputField.isDisplayed() || confEmailInputField.isDisplayed()
                || passwordInputField.isDisplayed() || confPassInputField.isDisplayed() || countryDropDownBtn.isDisplayed() || hearAboutUsDropDown.isDisplayed() || termsAndPrivacyCheckbox.isDisplayed() ||
                optionalCheckbox.isDisplayed();


    }
}
