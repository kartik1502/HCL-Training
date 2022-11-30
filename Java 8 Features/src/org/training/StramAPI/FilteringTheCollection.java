package org.training.StramAPI;

import java.util.List;
import java.util.stream.Collectors;

import static org.training.StramAPI.ProductList.getProductList;

public class FilteringTheCollection {
    public static void main(String[] args) {
        List<Product> products = getProductList();

        List<Float> priceList = products.stream()
                .filter(p -> p.price > 10000)
                .map(p -> p.price)
                .collect(Collectors.toList());
        priceList.forEach(p -> System.out.println(p));
        System.out.println(priceList);
    }
}
