package com.platzi.functional._07_inference;

import com.platzi.functional._06_reference_operator.NombreUtils;

import java.util.List;
import java.util.function.Function;

// At compile time, Java validates that the data we are passing is of the corresponding type.
public class Inferencia {
    public static void main(String[] args) {
        Function<Integer, String> funcionConvertidora =
                integer -> "Al doble: " + (integer * 2);

        List<String> alumnos = NombreUtils.getList("Hugo", "Paco", "Luis");
        alumnos.forEach((String name) -> System.out.println(name));
        //It is not necessary to indicate the type, we can leave it as name
        alumnos.forEach(name -> System.out.println(name));





    }
}
