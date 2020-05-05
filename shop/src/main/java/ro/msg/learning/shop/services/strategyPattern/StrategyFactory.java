package ro.msg.learning.shop.services.strategyPattern;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.msg.learning.shop.repository.LocationRepo;
import ro.msg.learning.shop.repository.ProductRepo;
import ro.msg.learning.shop.repository.StockRepo;

@RequiredArgsConstructor
@Configuration
public class StrategyFactory {

    private final LocationRepo locationRepo;
    private final StockRepo stockRepo;
    private final ProductRepo productRepo;

    @Value("${chosen_strategy}")
    private String chosenStrategy;

    @Bean
    public Strategy strategy() {
        switch (chosenStrategy) {
            case "single_location" :
                return new SingleLocation(locationRepo, stockRepo, productRepo);
            case "most_abundant" :
                return new MostAbundant(stockRepo, productRepo);
        }
        return null;
    }
}
