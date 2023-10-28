import config.ConfigSetup;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.AirTickets;
import pages.HomePage;
import validator.ValidateAirTickets;


public class SearchForFlights implements ConfigSetup {

    @Test
    @DisplayName("Поиск авиабилетов")
    @Description("После ввода данных в форму для авиабилетов отображаются результаты поиска")
    public void searchTickets() {
        ValidateAirTickets validateAirTickets = new ValidateAirTickets();

        new HomePage()
                .clickButtonFilter()
                .hoverOnTrips()
                .clickOnAirTickets();

        validateAirTickets.checkUrl();

        String from = "Домодедово";
        String where = "Пулково";

        new AirTickets()
                .enterFromCity(from)
                .enterWhereCity(where)
                .chooseDates()
                .clickChoosePassengers()
                .chooseAdultsPassengers()
                .clickSearchAviaTickets()
                .checkVisibleListTickets()
                .checkResultsOfTicketsSearch();
    }
}