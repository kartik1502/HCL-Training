package org.training.StramAPI;

import java.util.List;

import static org.training.StramAPI.ProductList.getProductList;

public class MaxMinStream {
    public static void main(String[] args) {
        List<Product> products = getProductList();
        System.out.println("Get Product with Highest Price");
        Product productA = products.stream()
                .max((product1,product2) -> product1.price > product2.price ? 1 : -1).get();
        System.out.println(productA);
        System.out.println("Get Product with Lowest Price");
        Product productB = products.stream()
                .min((product1,product2) -> product1.price > product2.price ? 1 : -1).get();
        System.out.println(productB);
    }
}
