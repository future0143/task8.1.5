package pages;

import elements.FormForAirTickets;
import validator.ValidateSearchResultsOfAirTickets;

public class AirTickets {

    private final FormForAirTickets formForAirTickets;
    private final SearchResultsOfAviaTickets searchResultsOfAviaTickets;

    public AirTickets() {
        this.formForAirTickets = new FormForAirTickets();
        this.searchResultsOfAviaTickets = new SearchResultsOfAviaTickets();
    }

    public AirTickets enterFromCity(String cityFrom) {
        formForAirTickets.enterCityFrom(cityFrom);

        return this;
    }

    public AirTickets enterWhereCity(String cityWHere) {
        formForAirTickets.enterCityWhere(cityWHere);

        return this;
    }

    public AirTickets chooseDates() {
        formForAirTickets.chooseDateInField();

        return this;
    }

    public AirTickets clickChoosePassengers() {
        formForAirTickets.clickPassengers();

        return this;
    }

    public AirTickets chooseAdultsPassengers() {
        formForAirTickets.chooseAdults();

        return this;
    }

    public ValidateSearchResultsOfAirTickets clickSearchAviaTickets() {
        formForAirTickets.clickSearchTickets();

        return new ValidateSearchResultsOfAirTickets();
    }
}