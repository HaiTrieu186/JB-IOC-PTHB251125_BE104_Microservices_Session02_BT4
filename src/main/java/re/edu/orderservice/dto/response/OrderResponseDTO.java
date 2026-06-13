package re.edu.orderservice.dto.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class OrderResponseDTO {
    private Long id;
    private String customerName;
    private BigDecimal totalAmount;
    private String status;
}