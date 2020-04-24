package ro.msg.learning.shop.services.strategyPattern;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import ro.msg.learning.shop.dto.LocationDTO;
import ro.msg.learning.shop.dto.OrderDetailDTO;
import ro.msg.learning.shop.dto.ProductDTO;
import ro.msg.learning.shop.model.Location;
import ro.msg.learning.shop.model.OrderDetail;
import ro.msg.learning.shop.model.Product;
import ro.msg.learning.shop.model.Stock;
import ro.msg.learning.shop.repository.LocationRepo;
import ro.msg.learning.shop.repository.ProductRepo;
import ro.msg.learning.shop.repository.StockRepo;
import sun.util.locale.LocaleSyntaxException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
public class SingleLocation implements Strategy {

    @Autowired
    private LocationRepo locationRepo;
    @Autowired
    private StockRepo stockRepo;
    @Autowired
    private ProductRepo productRepo;

    @Override
    public List<OrderDetailDTO> chooseStrategy(HashMap<Integer, Integer> orderedProducts) throws LocaleSyntaxException {
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
                    }
                }
            }

            // This location has all the products needed and the order can be placed
            // Doesn't matter what other locations has
            if (orderDetails.size() == orderedProducts.size()) {
                return orderDetails;
            } else {
                orderDetails.clear();
            }
        }

        throw new LocaleSyntaxException("Unable to find a suitable set of locations");
    }
}
