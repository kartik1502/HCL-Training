package org.training.StramAPI;

import java.util.List;

import static org.training.StramAPI.ProductList.getProductList;

public class Count {
    public static void main(String[] args) {
        List<Product> products = getProductList();
        Long count = products.stream()
                        .filter(p -> p.price > 5000)
                                .count();
        System.out.println(count);
    }
}
