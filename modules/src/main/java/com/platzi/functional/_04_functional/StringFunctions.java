package com.platzi.functional._04_functional;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class StringFunctions {
    public static void main(String[] args) {
        //UnaryOperator: Function, where the input and output are of the same type.
        UnaryOperator<String> quote = text -> "\"" + text + "\"";
        UnaryOperator<String> addMark = text ->  text + "!" ;

        System.out.println(quote.apply("Hola Estudiante"));
        System.out.println(addMark.apply("Hola"));

        //BiFunction: Type of Function that receives 2 parameters instead of 1.
        BiFunction<Integer, Integer, Integer> multiplication =
                (x, y) -> x * y;
        System.out.println(multiplication.apply(2,2));


        //BinaryOperator: BiFunction where the parameters and output are of the same type.
        BinaryOperator<Integer> multiplication2 =
                (x, y) -> x * y;
        System.out.println(multiplication2.apply(2,5));


        multiplication2.apply(5,4);

        //Add spaces to a string. famous left pad function.
        //We take a string, integers that will be the number of spaces and as a result we will generate a new string.
        BiFunction<String, Integer, String> leftPad =
                //We will generate a text, number of spaces
                //we use java string.format: generates a new string formatted with the parameters that we give it
                // number: quantity of spaces
                //spaces is definite by "s"
                (text, number) -> String.format("%" + number + "s", text);

        // if our text is bigger spaces quantity no add spaces, return the same text
        System.out.println(leftPad.apply("java", 10));


    }
}
