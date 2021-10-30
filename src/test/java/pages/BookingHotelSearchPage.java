package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class BookingHotelSearchPage extends BasePage<String> {

    private static final By HOTEL_PAGE_TITLE = By.cssSelector(".sb-searchbox__title-text");
    private static final By SEARCH_INPUT = By.cssSelector("#ss");

    public BookingHotelSearchPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://www.booking.com/hotel/index.ru.html");
    }

    public void useSearch(String text) {
        WebElement input = driver.findElement(SEARCH_INPUT);
        input.sendKeys(text);
        input.submit();
    }

    @Override
    public String findTitle() {
        return driver.findElement(HOTEL_PAGE_TITLE).getText();
    }
}
