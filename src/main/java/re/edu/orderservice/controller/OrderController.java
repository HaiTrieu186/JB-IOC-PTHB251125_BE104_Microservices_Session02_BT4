package re.edu.orderservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import re.edu.orderservice.dto.request.OrderCreateDTO;
import re.edu.orderservice.dto.request.OrderUpdateDTO;
import re.edu.orderservice.dto.response.ApiResponse;
import re.edu.orderservice.dto.response.OrderResponseDTO;
import re.edu.orderservice.service.OrderService;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/health-check")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok(orderService.getHealthCheckMessage());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<OrderResponseDTO>> getOrderById(@PathVariable Long id) {
        ApiResponse<OrderResponseDTO> response = ApiResponse.success("Lấy đơn hàng thành công", orderService.getOrderById(id));

        return ResponseEntity.ok(response);
    }
}
