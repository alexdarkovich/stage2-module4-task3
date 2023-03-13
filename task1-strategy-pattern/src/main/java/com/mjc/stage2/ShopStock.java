package com.mjc.stage2;

import com.mjc.stage2.impl.ManufactureFilteringStrategy;
import com.mjc.stage2.impl.MaxPriceFilteringStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ShopStock {
    private final List<Product> productList;

    public ShopStock(List<Product> productList) {
        this.productList = productList;
    }

    List executeFilteringStrategy(FilteringStrategy filteringStrategy) {

        List<Product> list = new ArrayList<>();
        for (Product product : productList) {
            if (filteringStrategy.filter(product)) {
                list.add(product);
            }
        }
        return list;

    }
}
