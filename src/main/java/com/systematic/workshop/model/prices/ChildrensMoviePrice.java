package com.systematic.workshop.model.prices;

import com.systematic.workshop.model.type.RentalPrice;

public class ChildrensMoviePrice implements RentalPrice {

    public static final double RENT_RATE = 1.5d;

    @Override
    public double computeAmount(int daysRented) {
        return daysRented <= 3 ? RENT_RATE : RENT_RATE + (daysRented - 3) * RENT_RATE;
    }

    @Override
    public int computeFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
