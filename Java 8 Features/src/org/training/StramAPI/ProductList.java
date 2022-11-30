package org.training.StramAPI;

import java.util.ArrayList;
import java.util.List;

public class ProductList {
    static List<Product> getProductList() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1,"Oppo Mobile",12500));
        products.add(new Product(2,"Hair Serum",195));
        products.add(new Product(3,"Almound Oil",195));
        products.add(new Product(4,"JBL Headphone",1800));
        products.add(new Product(5,"Ideal Pad",78500));
        return products;
    }
}
