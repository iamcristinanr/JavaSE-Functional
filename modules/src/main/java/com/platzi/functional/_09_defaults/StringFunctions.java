package com.platzi.functional._09_defaults;

import java.sql.SQLOutput;


public class StringFunctions {
    @FunctionalInterface
    interface StringOperation{
        int getAmount();

        //default for function define by us
        //default: define a method inside interface
        default void operate(String text){
            int x = getAmount();
            while(x-- > 0){
                System.out.println(text);
            }
        }

    }

    @FunctionalInterface
    interface DoOperation {
        void take( String text);

        default void execute (int x, String text){
            while(x-- > 0){
                take(text);
            }

        }
    }

    public static void main(String[] args) {
        StringOperation six = () -> 6;
        six.operate("Alumno");

        DoOperation operateFive = text -> System.out.println(text);
        operateFive.execute(5, "Cris");

    }
}
