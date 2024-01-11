package com.softsignatureslab.ecommerce.services.order;

import com.softsignatureslab.ecommerce.dto.order.OrderRequest;
import com.softsignatureslab.ecommerce.dto.order.OrderResponse;

import java.util.List;

public interface OrderService {
   OrderResponse createOrder(OrderRequest orderRequest);
   List<OrderResponse> getOrders();
   OrderResponse getOrder(int orderId);
}
