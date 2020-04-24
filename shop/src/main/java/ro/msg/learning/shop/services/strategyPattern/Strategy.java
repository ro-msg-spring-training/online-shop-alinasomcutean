package ro.msg.learning.shop.services.strategyPattern;

import ro.msg.learning.shop.dto.OrderDetailDTO;
import ro.msg.learning.shop.model.OrderDetail;
import sun.util.locale.LocaleSyntaxException;

import java.util.HashMap;
import java.util.List;

public interface Strategy {

    List<OrderDetailDTO> chooseStrategy(HashMap<Integer, Integer> orderedProducts) throws LocaleSyntaxException;
}
