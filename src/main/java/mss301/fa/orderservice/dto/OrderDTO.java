package mss301.fa.orderservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderDTO {
    private Long accountID;
    private List<OrderDetailDTO> details;
    private String status;
}
