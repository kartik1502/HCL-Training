package org.training.FunctionalInterface.Example3;

public class InterfaceDriver {

    public static void main(String[] args) {
        InterfaceTwo two = (message) -> System.out.println(message);
        two.say("Hello this is from functional interface extending non - functional interface");
    }
}
