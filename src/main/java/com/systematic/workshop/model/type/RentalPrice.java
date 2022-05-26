package com.systematic.workshop.model.type;

public interface RentalPrice {
    double computeAmount(int daysRented);
    int computeFrequentRenterPoints(int daysRented);
}
