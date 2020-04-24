package ro.msg.learning.shop.services.strategyPattern;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ro.msg.learning.shop.dto.OrderDetailDTO;
import sun.util.locale.LocaleSyntaxException;

import java.util.HashMap;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class Context {

    private Strategy strategy;

    public List<OrderDetailDTO> executeStrategy(HashMap<Integer, Integer> orderedProducts) throws LocaleSyntaxException {
        return strategy.chooseStrategy(orderedProducts);
    }
}
