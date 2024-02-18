package com.platzi.functional._06_reference_operator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class NombreUtils {

    public static void main(String[] args) {
        List<String> profesores = getList("Nicolas", "Juan", "Zulema");

        //Consumer called print, receive a text and print it
        Consumer<String> printer = text -> System.out.println(text);
        //ForEach requires a consumer
        profesores.forEach(printer);

        //This is redundant, so we can use operator for functions that are already included in a class
        System.out.println("//////////");
        //:: search a function defined in this object
        profesores.forEach(System.out::println);

        //To be able to use the method "System.out::println" on "forEach" must have same quantity and parameters
    }
    static <T> List<T> getList (T... elements){
        return Arrays.asList(elements);
    }
}
