package org.training.FunctionalInterface.Example2;

public class InterfaceDriver {

    public static void main(String[] args) {
        InterfaceOne one = (message) -> System.out.println("This is from interface which has declared Object class methods "+message);
        one.say("Karthik Kulkarni");
    }

}
