package pages;

import config.ConfigSetup;
import elements.SearchLine;
import org.openqa.selenium.By;
import validator.ValidateSearchResultsAfterInput;

import static com.codeborne.selenide.Selenide.$;

public class HomePage implements ConfigSetup {

    private static final By buttonFiltersCssSelector = By.cssSelector(".j-menu-burger-btn");
    private static final By buttonBasket = By.cssSelector("div.navbar-pc__item.j-item-basket");
    private static final By cssSelectorForCity = By.cssSelector(".j-geocity-wrap");

    private final SearchLine searchLine;


    public HomePage() {
        this.searchLine = new SearchLine();
    }

    public SiteNavigation clickButtonFilter() {
        $(buttonFiltersCssSelector).click();

        return new SiteNavigation();
    }

    public City clickChangeCity() {
        $(cssSelectorForCity).click();

        return new City();
    }

    public String getCity() {
        return $(cssSelectorForCity).getText();
    }

    public ValidateSearchResultsAfterInput inputTextInSearchBar(String text) {
        searchLine.inputTextInSearchLine(text);


        return new ValidateSearchResultsAfterInput();
    }
}
