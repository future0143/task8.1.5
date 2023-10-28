import config.ConfigSetup;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.SearchResultsAfterNavigation;
import validator.ValidateSearchResultsAfterNavigation;

import java.util.ArrayList;


public class AddingProductToBasket implements ConfigSetup {

    @Test
    @DisplayName("Добавление товара в корзину")
    @Description("Добавленный товар присутсвует в корзине")
    public void addProductToBasket() {
        String expectedTitle = "Пылесосы и пароочистители";
        ValidateSearchResultsAfterNavigation validateSearchResults = new ValidateSearchResultsAfterNavigation();
        SearchResultsAfterNavigation searchResults = new SearchResultsAfterNavigation();


        new HomePage()
                .clickButtonFilter()
                .hoverOnAppliances()
                .hoverAndClickOnHomeAppliances()
                .clickOnVacuumAndSteamCleaners()
                .checkTitleOfCatalog(expectedTitle)
                .checkPathOfFilters();

        ArrayList<String> dataAboutProduct = new SearchResultsAfterNavigation()
                .hoverOnProductsFromList(0)
                .getDataAboutOneProduct();

        searchResults
                .addToBasket();

        validateSearchResults.checkCountOfProductsInBasket(1);

        searchResults
                .goToBasket()
                .checkDataAboutProduct(dataAboutProduct)
                .checkTotalSum()
                .checkButtonToOrderIsEnabled();
    }
}