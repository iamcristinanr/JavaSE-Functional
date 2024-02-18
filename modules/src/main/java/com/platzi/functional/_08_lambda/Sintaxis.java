package com.platzi.functional._08_lambda;

import com.platzi.functional._06_reference_operator.NombreUtils;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class Sintaxis {
    public static void main(String[] args) {
        List<String> cursos = NombreUtils.getList("Java", "Functional");

        //Lambda, no name, short code, simple logic.
        cursos.forEach(curso -> System.out.println(curso));

        //Bifunction When use lambda o bifunction?
        BiFunction<Integer, Integer, Integer> s = (x, y ) ->  x * y;

        //lambda without arguments
        usarZero(() ->2);

        //lambda predicate with 1 argument. No definen type recieve and type return
        usarPredicado(text -> text.isEmpty());

        //lambda more 1 parameter
        usarBiFunction((x, y) -> x * y);

        // lambda to do two things with {} complex requires return
        usarBiFunction((x, y) -> {
            System.out.println("X: " + x + ", Y :" + y);
            return x - y;
        });

        //It is common to omit the types
        //functions are interfaces and we can not use type data primitives (int) only object (Integer)
        //usarBiFunction((int x, int y) -> x * y);

        usarBiFunction((Integer x, Integer y) ->  x * y);


        //syntaxs to not recieve any data and not return any data
        usarNada(() -> {
            System.out.println("Hola Alumno");

        });

    }

    static void usarZero(ZeroArgumentos zeroArgumentos) {
    }
    static void usarPredicado(Predicate <String> predicado){

    }

    static void usarBiFunction(BiFunction<Integer, Integer, Integer> operacion){

    }

    static void usarNada(OperarNada operarNada){

    }

    @FunctionalInterface
    interface ZeroArgumentos {
        int get();
    }

    @FunctionalInterface
    interface OperarNada {
        void  nada();
    }
}
