package com.systematic.workshop.model.service;

import com.systematic.workshop.model.Customer;
import com.systematic.workshop.model.Rental;
import com.systematic.workshop.model.type.Movie;

import java.util.Collection;

public class MoviePlaceService {

    public String printStatement(Customer customer) {
        String result = "Rental Record for " + customer.getName() + "\n";
        for (Rental rental : customer.getRentals()) {
            // show figures for this rental
            Movie movie = rental.getMovie();
            result += "\t" + movie.getTitle() +
                    "\t" + movie.getPriceCode().computeAmount(rental.getDaysRented()) + "\n";
        }
        // add footer lines
        result += "Amount owed is " + computeTotalAmount(customer.getRentals()) + "\n";
        result += "You earned " + computeTotalFrequentRenterPoints(customer.getRentals()) + " frequent renter points";
        return result;
    }

    private int computeTotalFrequentRenterPoints(Collection<Rental> rentals) {
        return rentals.stream().mapToInt(r -> r.getMovie().getPriceCode().computeFrequentRenterPoints(r.getDaysRented())).sum();
    }

    private double computeTotalAmount(Collection<Rental> rentals) {
        return rentals.stream().mapToDouble(r -> r.getMovie().getPriceCode().computeAmount(r.getDaysRented())).sum();
    }
}
