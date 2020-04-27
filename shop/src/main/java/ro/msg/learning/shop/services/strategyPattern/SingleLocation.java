package ro.msg.learning.shop.services.strategyPattern;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.dto.LocationDTO;
import ro.msg.learning.shop.dto.OrderDetailDTO;
import ro.msg.learning.shop.dto.ProductDTO;
import ro.msg.learning.shop.exceptions.LocationNotFoundException;
import ro.msg.learning.shop.exceptions.UnavailableStockException;
import ro.msg.learning.shop.model.Location;
import ro.msg.learning.shop.model.Product;
import ro.msg.learning.shop.model.Stock;
import ro.msg.learning.shop.repository.LocationRepo;
import ro.msg.learning.shop.repository.ProductRepo;
import ro.msg.learning.shop.repository.StockRepo;

import javax.transaction.Transactional;
import java.util.ArrayList;
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
    public List<OrderDetailDTO> chooseStrategy(HashMap<Integer, Integer> orderedProducts) {
        // Find all the locations
        List<Location> locations = locationRepo.findAll();

        // List with the order details of the user
        List<OrderDetailDTO> orderDetails = new ArrayList<>();

        // For each location
        for (Location l : locations) {
            // Find all of its stock
            List<Stock> stocks = l.getStock();

            // For each product that user wants to order
            for (Map.Entry map : orderedProducts.entrySet()) {

                // Find the stock after a specific product
                Stock product = stockRepo.findByProductIdAndLocationId((Integer) map.getKey(), l.getId());

                // Check if the location has it
                if (stocks.contains(product)) {
                    // Location has enough number of that product
                    if (product.getQuantity() >= (Integer) map.getValue()) {
                        // Create DTO for location
                        LocationDTO locationDTO = new LocationDTO(l);

                        // Create DTO for product
                        Product prod = productRepo.findById((Integer) map.getKey()).orElseThrow(RuntimeException::new);
                        ProductDTO productDTO = new ProductDTO(prod);

                        orderDetails.add(new OrderDetailDTO(locationDTO, productDTO, (Integer) map.getValue()));
                    } else {
                        throw new UnavailableStockException("Product " + (Integer) map.getKey() + " doesn't have in stock " + (Integer) map.getValue() + " items");
                    }
                }
            }

            // This location has all the products needed and the order can be placed
            // Doesn't matter what other locations has
            if (orderDetails.size() == orderedProducts.size()) {
                // If the order can be places, update the stock of products
                for (Map.Entry map : orderedProducts.entrySet()) {
                    Stock product = stockRepo.findByProductIdAndLocationId((Integer) map.getKey(), l.getId());
                    product.setQuantity(product.getQuantity() - (Integer)map.getValue());
                    stockRepo.save(product);
                }
                return orderDetails;
            } else {
                orderDetails.clear();
            }
        }

        throw new LocationNotFoundException("Unable to find a suitable set of locations");
    }
}
