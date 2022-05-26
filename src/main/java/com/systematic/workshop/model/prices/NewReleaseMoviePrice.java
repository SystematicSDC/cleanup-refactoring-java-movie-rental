package com.systematic.workshop.model.prices;

import com.systematic.workshop.model.type.RentalPrice;

public class NewReleaseMoviePrice implements RentalPrice {

    private static final double PER_DAY_RATE = 3.00D;

    @Override
    public double computeAmount(int daysRented) {
        return daysRented * PER_DAY_RATE;
    }

    @Override
    public int computeFrequentRenterPoints(int daysRented) {
        return daysRented > 1 ? 2 : 1;
    }
}
