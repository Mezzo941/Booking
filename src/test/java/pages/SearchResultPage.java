package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage extends BasePage<Boolean> {

    private static final By FIRST_SEARCH_RESULT = By.xpath("//div[@data-component='plank-sorters-bar']//ancestor::div[@id='ajaxsrwrap']//div[@data-testid='title']");
    private static final By FIRST_SEARCH_RATING = By.xpath("//div[@data-component='plank-sorters-bar']//ancestor::div[@id='ajaxsrwrap']//div[@aria-label]");
    private static final By SORTER_BAR = By.cssSelector("[data-capla-component='b-search-web-searchresults/SortersBar']");

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public String getFirstResultAfterSearch() {
        return driver.findElement(FIRST_SEARCH_RESULT).getText();
    }

    public String getFirstRatingAfterSearch() {
        return driver.findElement(FIRST_SEARCH_RATING).getText();
    }

    @Override
    public Boolean findTitle() {
        return driver.findElement(SORTER_BAR).isDisplayed();
    }
}
