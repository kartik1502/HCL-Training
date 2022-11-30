package org.training.StramAPI;

import java.util.List;

import static org.training.StramAPI.ProductList.getProductList;

public class FilterAndIterate {
    public static void main(String[] args) {
        List<Product> products = getProductList();
        products.stream()
                .filter(p -> p.price < 10000)
                .forEach(p -> System.out.println(p.price));
    }


}
