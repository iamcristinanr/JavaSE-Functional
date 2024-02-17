package com.platzi.functional._05_sam;

//calculate age from date birth

import java.time.LocalDate;
import java.time.Period;
import java.util.Locale;
import java.util.function.Function;


public class AgeUtils {
    public static void main(String[] args) {

        //Resolve the problem: months and years must content a 0 (two digits) in number less than 10.
        Function<Integer, String> addCeros = x-> x< 10 ? "0" + x : String.valueOf(x);

        //Calculate a date.
        // Localdate: represent object like a date in java
        // Function convert 3 data in a date.
        TriFunction<Integer, Integer, Integer, LocalDate> parseDate =
                (day, month, year) -> LocalDate.parse(year + "-" +
                        addCeros.apply(month) + "-" + addCeros.apply(day));

        //Period.between calculate period between actual date and birth date.
        //birth date before now date (start, end)
        TriFunction<Integer, Integer, Integer, Integer> calculateAge =
                (day, month, year) -> Period.between(
                        parseDate.apply(day, month, year), LocalDate.now()
                        ).getYears();

        System.out.println(calculateAge.apply(10,10,1992));
    }

    //SAM Single Abstract Method
    // With this function we can define our own functions
    @FunctionalInterface
    interface TriFunction<T, U, V, R>{
        R apply(T t, U u, V v);
    }

}
