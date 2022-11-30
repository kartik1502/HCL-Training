package org.training.StramAPI;

import java.util.List;
import java.util.stream.Collectors;

import static org.training.StramAPI.ProductList.getProductList;

public class SumUsingCollectors {
    public static void main(String[] args) {
        List<Product> products = getProductList();
        Double totalPrice = products.stream()
                .filter(p -> p.price > 10000)
                .collect(Collectors.summingDouble(p -> p.price));
        System.out.println(totalPrice);
    }
}
