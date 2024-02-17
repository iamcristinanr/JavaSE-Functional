package com.platzi.functional._04_functional;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class CLIArgumentsUtils {

    static void showHelp(CLIArguments cliArguments){
        //Generic Interface work on a type of data in this case CLIArguments
        Consumer<CLIArguments> consumerHelper = cliArguments1 -> {
            if(cliArguments1.isHelp()){
                System.out.println("Manual solicitado");
            }
        };
        //Invocation
        consumerHelper.accept(cliArguments);
    }

    static CLIArguments generateCLI(){
        //Generic Interface generate a type of data
        Supplier<CLIArguments> generator = () -> new CLIArguments();

        return generator.get();

    }
}
