import config.ConfigSetup;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.SearchResultsAfterNavigation;
import validator.ValidateSearchResultsAfterNavigation;

import java.util.List;

import static pages.SearchResultsAfterNavigation.getCountOfProducts;


public class WorkWithFilters implements ConfigSetup {

    @Test
    @DisplayName("Работа с фильтрами")
    @Description("Примененные для поиска фильтры отображаются на странице результатов поиска")
    public void workWithFilters() {
        String expectedTitle = "Ноутбуки и ультрабуки";
        String minPrice = "100 000";
        String maxPrice = "149 000";

        new HomePage()
                .clickButtonFilter()
                .hoverOnElectronic()
                .hoverAndClickOnLaptopAndPC()
                .clickOnLaptops()
                .checkTitleOfCatalog(expectedTitle);

        List<String> listOfResults = new SearchResultsAfterNavigation()
                .clickAllFilters()
                .setMinPrice(minPrice)
                .setMaxPrice(maxPrice, minPrice)
                .applyDeliveryTimeBeforeThreeDays()
                .applyBrandApple()
                .applyScreenDiagonal_13_3()
                .showResult();

        new ValidateSearchResultsAfterNavigation()
                .checkSelectedFiltersIsVisible()
                .checkCountOfProducts(getCountOfProducts())
                .checkSelectedFiltersOnPage(listOfResults)
                .checkButtonToResetFilterIsVisible();
    }
}