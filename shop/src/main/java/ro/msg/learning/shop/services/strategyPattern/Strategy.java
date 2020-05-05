package ro.msg.learning.shop.services.strategyPattern;

import ro.msg.learning.shop.model.Product;
import ro.msg.learning.shop.model.Stock;

import java.util.HashMap;

public interface Strategy {

    HashMap<Product, Stock> chooseStrategy(HashMap<Integer, Integer> orderedProducts);
}
