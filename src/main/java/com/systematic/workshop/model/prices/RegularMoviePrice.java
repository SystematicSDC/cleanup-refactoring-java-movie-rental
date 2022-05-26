package com.systematic.workshop.model.prices;

import com.systematic.workshop.model.type.RentalPrice;

public class RegularMoviePrice implements RentalPrice {
    public static final double OVERTIME_RATE = 1.5d;
    public static final double STARTING_RATE = 2.0d;
    @Override
    public double computeAmount(int daysRented) {
        return daysRented <= 2 ? STARTING_RATE : STARTING_RATE + (daysRented - 2) * OVERTIME_RATE;
    }

    @Override
    public int computeFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
