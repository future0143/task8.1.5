import config.ConfigSetup;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import validator.ValidatePickUpPoint;

public class CityChange implements ConfigSetup {

    @Test
    @DisplayName("Смена города")
    @Description("После смены города новый город отображается на главной странице")
    public void changeCity() {
        String cityForInput = "Санкт-Петербург";

        String firstAddress = new HomePage()
                .clickChangeCity()
                .inputCityInSearchLine(cityForInput)
                .chooseAddressFromListByIndex(0, cityForInput);

        new ValidatePickUpPoint()
                .checkInfoAboutPickUpPointIsVisible()
                .checkAddress(firstAddress)
                .choosePoint()
                .checkUrl()
                .checkCity(firstAddress);
    }
}