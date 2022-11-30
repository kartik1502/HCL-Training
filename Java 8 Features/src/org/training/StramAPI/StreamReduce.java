package org.training.StramAPI;

import java.util.List;

import static org.training.StramAPI.ProductList.getProductList;

public class StreamReduce {
    public static void main(String[] args) {
        List<Product> products = getProductList();
        Float totalPrice = products.stream()
                .filter(p -> p.price < 10000)
                .map(p -> p.price)
                .reduce(0.0f,(sum,price) -> sum + price);
        System.out.println(totalPrice);
        System.out.println("Using method reference");
        Float totalPrice2 = products.stream()
                .filter(p -> p.price < 10000)
                .map(p -> p.price)
                .reduce(0.0f,Float::sum);
        System.out.println(totalPrice2);
    }
}
