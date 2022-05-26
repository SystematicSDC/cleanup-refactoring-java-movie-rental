package com.systematic.workshop.model.type;

import com.systematic.workshop.model.prices.ChildrensMoviePrice;
import com.systematic.workshop.model.prices.NewReleaseMoviePrice;
import com.systematic.workshop.model.prices.RegularMoviePrice;

import java.util.Map;

public class Movie {

    private static final Map<MovieType, RentalPrice> priceByMovieType = Map.of(
            MovieType.REGULAR, new RegularMoviePrice(),
            MovieType.CHILDRENS, new ChildrensMoviePrice(),
            MovieType.NEW_RELEASE, new NewReleaseMoviePrice());

    String title;
    RentalPrice priceCode;
    MovieType movieType;

    public Movie(String title, MovieType movieType) {
        this.title = title;
        this.movieType = movieType;
        this.priceCode = priceByMovieType.get(movieType);
    }

    public String getTitle() {
        return title;
    }

    public MovieType getMovieType() {
        return this.movieType;
    }

    public RentalPrice getPriceCode() {
        return priceCode;
    }

    public void changePriceCode(MovieType newMovieType) {
        this.priceCode = priceByMovieType.get(newMovieType);
        this.movieType = newMovieType;
    }
}
