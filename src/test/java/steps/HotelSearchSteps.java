package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import pages.BookingHotelSearchPage;
import pages.SearchResultPage;

import java.util.concurrent.TimeUnit;

public class HotelSearchSteps {

    private WebDriver driver;
    private BookingHotelSearchPage hotelPage;
    private SearchResultPage searchPage;

    @Before
    public void setUp() {
        try {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(new ChromeOptions().addArguments("start-maximized"));
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            hotelPage = new BookingHotelSearchPage(driver);
            searchPage = new SearchResultPage(driver);
        } catch (Exception exception) {
            System.out.println("Драйвер = NULL");
        }

    }

    @After()
    public void end() {
        try {
            driver.quit();
        } catch (Exception exception) {
            System.out.println("Driver is null, find why");
        }
    }

    @Given("User is on the search hotel page")
    public void userIsOnTheSearchPage() {
        hotelPage.open();
        Assert.assertEquals(hotelPage.findTitle(), "Найдите идеальный отель на Booking.com");
    }

    @When("User is searching for the {string}")
    public void userIsSearchingForThe(String hotel) {
        hotelPage.useSearch(hotel);
    }

    @Then("User goes to the result page")
    public void userGoesToTheResultPage() {
        Assert.assertTrue(searchPage.findTitle());
    }

    @Then("{string} exists on the page at the top")
    public void existsOnThePage(String hotel) {
        String result = searchPage.getFirstResultAfterSearch();
        Assert.assertEquals(result, "DoubleTree by Hilton Минск");
    }

    @And("rating of first result is {string}")
    public void resultIs(String rating) {
        String result = searchPage.getFirstRatingAfterSearch();
        Assert.assertEquals(result, rating);
    }


}
