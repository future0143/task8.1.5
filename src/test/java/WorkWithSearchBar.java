import config.ConfigSetup;
import elements.SearchLine;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.SearchResultsAfterInput;
import validator.ValidateSearchResultsAfterInput;


public class WorkWithSearchBar implements ConfigSetup {

    @Test
    @DisplayName("Работа с поисковой строкой")
    @Description("На странице результатов поиска отображается информация в соответствии с Введенным товаром. " +
            "При нажатии на крестик поисковая строка становится пустой")
    public void workWithSearchBar() {
        String keys = "iphone 13";
        String expectedTextOfSorterFilter = "По популярности";
        String expectedBrand = "Apple";

        new HomePage()
                .inputTextInSearchBar(keys)
                .checkListOfProductIsVisible();

        new ValidateSearchResultsAfterInput()
                .checkTextOnPage(keys)
                .checkTextOfSorterFilter(expectedTextOfSorterFilter)
                .checkTextOfFirstFilter(keys)
                .checkBrandOfFirstProduct(expectedBrand);

        new SearchResultsAfterInput()
                .clearSearchBar();

        new SearchLine()
                .checkSearchLineIsEmpty();
    }
}