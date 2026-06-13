package re.edu.orderservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import re.edu.orderservice.dto.request.OrderCreateDTO;
import re.edu.orderservice.dto.request.OrderUpdateDTO;
import re.edu.orderservice.dto.response.OrderResponseDTO;
import re.edu.orderservice.entity.Order;
import re.edu.orderservice.exception.ResourceNotFoundException;
import re.edu.orderservice.repository.OrderRepository;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public String getHealthCheckMessage() {
        return "Order Service is Up";
    }

    public OrderResponseDTO getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy đơn hàng với id: " + id));

        return OrderResponseDTO.builder()
                .id(order.getId())
                .customerName(order.getCustomerName())
                .totalAmount(order.getTotalAmount())
                .status(order.getStatus())
                .build();
    }
}