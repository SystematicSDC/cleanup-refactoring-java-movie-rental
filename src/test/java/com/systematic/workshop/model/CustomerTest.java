package com.systematic.workshop.model;

import com.systematic.workshop.model.service.MoviePlaceService;
import com.systematic.workshop.model.type.Movie;
import com.systematic.workshop.model.type.MovieType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CustomerTest {

    private final MoviePlaceService service = new MoviePlaceService();

    private Customer customer;

    @BeforeEach
    public void setUpTest() {
        this.customer = new Customer("John");
    }

    @Test
    @DisplayName("John gets printStatement for three-day regular movie rental.")
    void statementForRentedRegularMovieForThreeDays() {
        // Arrange
        Movie movie = new Movie("Lord of the Rings", MovieType.REGULAR);
        Rental regularRent = new Rental(movie, 3);
        this.customer.addRental(regularRent);

        // Act
        String result = service.printStatement(this.customer);

        // Assert
        assertThat(result).isEqualTo(
                "Rental Record for John\n" +
                        "\tLord of the Rings\t3.5\n" +
                        "Amount owed is 3.5\n" +
                        "You earned 1 frequent renter points");
    }

    @Test
    @DisplayName("John rents three different movies with different price codes.")
    void statementForMultipleMovies() {
        // Arrange
        Movie regularMovie = new Movie("Back to the future", MovieType.REGULAR);
        Movie newReleaseMovie = new Movie("Spider-Man: No Way Home", MovieType.NEW_RELEASE);
        Movie childrensMovie = new Movie("Cinderella", MovieType.CHILDRENS);

        Rental regularRental = new Rental(regularMovie, 2);
        Rental newReleaseRental = new Rental(newReleaseMovie, 4);
        Rental childrensMovieRental = new Rental(childrensMovie, 10);

        customer.addRental(regularRental);
        customer.addRental(newReleaseRental);
        customer.addRental(childrensMovieRental);

        // Act
        String result = service.printStatement(customer);

        // Assert
        assertThat(result).isEqualTo(
                "Rental Record for John\n" +
                        "\tBack to the future\t2.0\n" +
                        "\tSpider-Man: No Way Home\t12.0\n" +
                        "\tCinderella\t12.0\n" +
                        "Amount owed is 26.0\n" +
                        "You earned 4 frequent renter points");
    }

    @Test
    @DisplayName("John rents a movie that changes price code for 1 day and childrens movie less than 3 days.")
    void statementForChangingPriceCode() {
        // Arrange
        Movie newReleaseMovieThatBecomesRegular = new Movie("Avengers: End Game", MovieType.NEW_RELEASE);
        Movie childrensMovie = new Movie("Encanto", MovieType.CHILDRENS);

        Rental avengersRental = new Rental(newReleaseMovieThatBecomesRegular, 1);
        Rental encantoRental = new Rental(childrensMovie, 2);

        customer.addRental(avengersRental);
        customer.addRental(encantoRental);

        newReleaseMovieThatBecomesRegular.changePriceCode(MovieType.REGULAR);

        // Act
        String result = service.printStatement(customer);

        // Assert
        assertThat(result).isEqualTo(
                "Rental Record for John\n" +
                        "\tAvengers: End Game\t2.0\n" +
                        "\tEncanto\t1.5\n" +
                        "Amount owed is 3.5\n" +
                        "You earned 2 frequent renter points");
    }
}
