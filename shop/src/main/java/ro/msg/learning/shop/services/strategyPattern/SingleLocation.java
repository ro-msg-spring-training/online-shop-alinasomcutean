package ro.msg.learning.shop.services.strategyPattern;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.exceptions.LocationNotFoundException;
import ro.msg.learning.shop.exceptions.ProductIdNotFoundException;
import ro.msg.learning.shop.exceptions.UnavailableStockException;
import ro.msg.learning.shop.model.Location;
import ro.msg.learning.shop.model.Product;
import ro.msg.learning.shop.model.Stock;
import ro.msg.learning.shop.repository.LocationRepo;
import ro.msg.learning.shop.repository.ProductRepo;
import ro.msg.learning.shop.repository.StockRepo;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class SingleLocation implements Strategy {

    private final LocationRepo locationRepo;
    private final StockRepo stockRepo;
    private final ProductRepo productRepo;

    @Transactional
    @Override
    public HashMap<Product, Stock> chooseStrategy(HashMap<Integer, Integer> orderedProducts) {
        // Find all the locations
        List<Location> locations = locationRepo.findAll();

        // Map with the product id and stock from where it is taken
        HashMap<Product, Stock> shippedFrom = new HashMap<>();

        // For each location
        for (Location l : locations) {
            // For each product that user wants to order
            for (Map.Entry<Integer, Integer> map : orderedProducts.entrySet()) {

                Product product = productRepo.findById(map.getKey()).orElseThrow(() -> new ProductIdNotFoundException("Product with id " + map.getKey() + "doesn't exists"));

                // Find the stock after a specific product id and location id
                Stock stock = stockRepo.findByProductIdAndLocationId(product.getId(), l.getId());

                // Check if the location has it
                if (stock != null) {
                    // Location has enough number of that product
                    if (stock.getQuantity() >= map.getValue()) {
                        shippedFrom.put(product, stock);
                    } else {
                        throw new UnavailableStockException("Product " + map.getKey() + " doesn't have in stock " + map.getValue() + " items");
                    }
                }
            }

            // This location has all the products needed and the order can be placed
            // Doesn't matter what other locations has
            if (shippedFrom.size() == orderedProducts.size()) {
                return shippedFrom;
            } else {
                shippedFrom.clear();
            }
        }

        throw new LocationNotFoundException("Unable to find all products at the same location");
    }
}
