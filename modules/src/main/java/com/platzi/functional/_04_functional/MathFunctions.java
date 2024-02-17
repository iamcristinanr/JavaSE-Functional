package com.platzi.functional._04_functional;

import java.util.function.Function;
import java.util.function.Predicate;

public class MathFunctions {
    public static void main(String[] args) {
        Function<Integer, Integer> squareFunction = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer x) {
                return x * x;
            }
        };
        System.out.println(squareFunction.apply(5));

        Function<Integer, Boolean> isOdd = x -> x % 2 == 1;

        System.out.println(isOdd.apply(5)); //25

        // Predicate: Function work on a type and generate a boolean
        // Function on Integer

        Predicate<Integer> isEven = x -> x % 2 == 0;

        isEven.test(4); //true

        Predicate<Student> isAproved = student -> student.getCalification() >= 6.0;

        Student sinuhe = new Student(5.9);
        System.out.println(isAproved.test(sinuhe)); //false


    }

    static class Student {

        private double calification;

        public Student(double calification){
            this.calification = calification;
        }
        public double getCalification() {
            return calification;
        }



    }


}

