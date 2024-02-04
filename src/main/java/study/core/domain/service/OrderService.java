package study.core.domain.service;

import study.core.domain.entity.Order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
