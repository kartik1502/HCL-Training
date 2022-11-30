package org.training.FunctionalInterface.Example3;

public interface InterfaceOne {

    default void Print(){
        System.out.println("Hello");
    }
}
