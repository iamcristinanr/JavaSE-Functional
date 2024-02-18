package com.platzi.functional._10_chaining;


//Chaining: chain the result of an execution with respect to another execution
public class ChainingEj {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Hola")
                //again call method append
                .append("alumno")
                .append("de")
                .append("platzi");

        Chainer chainer = new Chainer();

        Chainer chainer2 = chainer.sayHi();
        Chainer chainer3 = chainer2.sayBye();
        chainer.sayHi().sayBye();
    }

    //understand how the append method works inside
    static class Chainer {
        public Chainer sayHi(){
            System.out.println("Hola");
            return this;
        }

        public Chainer sayBye()  {
            System.out.println("Bye");
            return this;
        }


    }
}
