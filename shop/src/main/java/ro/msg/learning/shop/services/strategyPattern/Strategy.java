package ro.msg.learning.shop.services.strategyPattern;

import ro.msg.learning.shop.dto.OrderDetailDTO;

import java.util.HashMap;
import java.util.List;

public interface Strategy {

    List<OrderDetailDTO> chooseStrategy(HashMap<Integer, Integer> orderedProducts);
}
