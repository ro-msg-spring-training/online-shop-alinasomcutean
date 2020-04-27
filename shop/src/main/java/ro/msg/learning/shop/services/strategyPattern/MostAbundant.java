package ro.msg.learning.shop.services.strategyPattern;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.dto.LocationDTO;
import ro.msg.learning.shop.dto.OrderDetailDTO;
import ro.msg.learning.shop.dto.ProductDTO;
import ro.msg.learning.shop.exceptions.LocationNotFoundException;
import ro.msg.learning.shop.exceptions.UnavailableStockException;
import ro.msg.learning.shop.model.Stock;
import ro.msg.learning.shop.repository.StockRepo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class MostAbundant implements Strategy {

    private final StockRepo stockRepo;

    @Override
    public List<OrderDetailDTO> chooseStrategy(HashMap<Integer, Integer> orderedProducts) {
        List<OrderDetailDTO> orderDetails = new ArrayList<>();

        // For each product that user wants to order
        for (Map.Entry map : orderedProducts.entrySet()) {

            // Find all locations which has a specific product
            List<Stock> stocks = stockRepo.findByProductIdOrderByQuantityDesc((Integer) map.getKey());

            // If the product is in stock
            if (stocks.get(0).getQuantity() >= (Integer) map.getValue()) {
                // Create DTO for location
                LocationDTO locationDTO = new LocationDTO(stocks.get(0).getLocation());

                // Create DTO for product
                ProductDTO productDTO = new ProductDTO(stocks.get(0).getProduct());

                orderDetails.add(new OrderDetailDTO(locationDTO, productDTO, (Integer) map.getValue()));
            } else{
                throw new UnavailableStockException("Product " + (Integer) map.getKey() + " doesn't have in stock " + (Integer) map.getValue() + " items");
            }
        }

        if (orderDetails.size() != orderedProducts.size()) {
            throw new LocationNotFoundException("Unable to find a suitable set of locations");
        } else {
            // If order can be placed, update the stock
            for(OrderDetailDTO o : orderDetails) {
                Stock stock = stockRepo.findByProductIdAndLocationId(o.getProduct().getId(), o.getLocation().getId());
                stock.setQuantity(stock.getQuantity() - o.getQuantity());
                stockRepo.save(stock);
            }
            return orderDetails;
        }
    }
}
