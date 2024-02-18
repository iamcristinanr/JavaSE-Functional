package com.platzi.functional._14_optionals;

import org.graalvm.compiler.nodes.calc.IntegerDivRemNode;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Optionalsej {

    public static void main(String[] args) {
        List<String> names = getNames();
        if(names != null){
            //Operate with names

        }

        //Operate with a date when is present or not is present
        Optional<List<String>> optionalNames = getOptionalNames();
        if(optionalNames.isPresent()){

        }

        optionalNames.ifPresent(namesValue -> namesValue.forEach(System.out::println));

        Optional<String> valuablePlayer = optionalValuablePlayer();

        String valuablePlayerName = valuablePlayer.orElseGet(() -> "No player");

    }

    static List<String> getNames() {
        List<String> list = new LinkedList<>();

        //return Collection.emptyList();
    }

    static String mostValuablePlayer(){
        return null;
        }

    static int mostExpensiveItem(){
        return -1;
        }

    static Optional<List<String>> getOptionalNames(){
        List<String> namesList = new LinkedList<>();
        //Get names
        return Optional.of(namesList);


    }

    static Optional<String> optionalValuablePlayer(){
        //return Optional. ofNullable()
        try{
            //Access
            return Optional.of("Sinuhe");
        }catch (Exception e){
            e.printStackTrace();
        }
        return Optional.empty();
    }
    }

