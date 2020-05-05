package ro.msg.learning.shop.services.strategyPattern;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.exceptions.LocationNotFoundException;
import ro.msg.learning.shop.exceptions.ProductIdNotFoundException;
import ro.msg.learning.shop.exceptions.UnavailableStockException;
import ro.msg.learning.shop.model.Product;
import ro.msg.learning.shop.model.Stock;
import ro.msg.learning.shop.repository.ProductRepo;
import ro.msg.learning.shop.repository.StockRepo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class MostAbundant implements Strategy {

    private final StockRepo stockRepo;
    private final ProductRepo productRepo;

    @Override
    public HashMap<Product, Stock> chooseStrategy(HashMap<Integer, Integer> orderedProducts) {
        // Map with the product id and stock from where it is taken
        HashMap<Product, Stock> shippedFrom = new HashMap<>();

        // For each product that user wants to order
        for (Map.Entry<Integer, Integer> map : orderedProducts.entrySet()) {

            Product product = productRepo.findById(map.getKey()).orElseThrow(() -> new ProductIdNotFoundException("Product with id " + map.getKey() + "doesn't exists"));

            // Find all locations which has a specific product
            List<Stock> stocks = stockRepo.findByProductIdOrderByQuantityDesc(map.getKey());

            // If at least a location has the product
            if (!stocks.isEmpty()) {
                // If the product is in stock
                if (stocks.get(0).getQuantity() >= map.getValue()) {
                    shippedFrom.put(product, stocks.get(0));
                } else {
                    throw new UnavailableStockException("Product " + map.getKey() + " doesn't have in stock " + map.getValue() + " items");
                }
            } else {
                throw new LocationNotFoundException("Unable to find a location which the product with id " + map.getKey());
            }
        }

        return shippedFrom;
    }
}
