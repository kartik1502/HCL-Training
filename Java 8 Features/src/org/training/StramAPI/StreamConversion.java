package org.training.StramAPI;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static org.training.StramAPI.ProductList.getProductList;

public class StreamConversion {
    public static void main(String[] args) {
        List<Product> products = getProductList();
        System.out.println("Converting into Map");
        Map<Integer, String> map = products.stream()
                .collect(Collectors.toMap(p->p.id,p -> p.productName));
        System.out.println(map);
        System.out.println("Converting into Set");
        Set<Float> prices = products.stream()
                .map(p -> p.price)
                .collect(Collectors.toSet());
        System.out.println(prices);
    }
}
