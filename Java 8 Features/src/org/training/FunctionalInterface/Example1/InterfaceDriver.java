package org.training.FunctionalInterface.Example1;

public class InterfaceDriver{

    public static void main(String[] args) {
        InterfaceOne one  = () -> System.out.println("This is no parameter Lambda Expression");
        one.say();
        InterfaceTwo two = (message) -> System.out.println("This is single parameter Lambda Expression: "+message);
        two.say("Karthik Kulkarni");
        InterfaceThree three = (a,b) -> {return(a+b); };
        System.out.println("This is multiple parameter Lambda Expression: "+three.sum(7,9));
    }
}
